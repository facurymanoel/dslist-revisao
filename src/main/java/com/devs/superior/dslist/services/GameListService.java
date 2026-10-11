package com.devs.superior.dslist.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devs.superior.dslist.dto.GameListDTO;
import com.devs.superior.dslist.entities.GameList;
import com.devs.superior.dslist.projections.GameMinProjection;
import com.devs.superior.dslist.repositories.GameListRepository;
import com.devs.superior.dslist.repositories.GameRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GameListService {
	
	private GameListRepository gameListRepository;
	
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO>findAll(){
		List<GameList> result = gameListRepository.findAll();
		List<GameListDTO> dto = result.stream()
				                      .map(x -> new GameListDTO(x))
				                      .toList();
		return dto;
		
	}
	
	@Transactional
	public void move(Long listId, int sourceIndex, int destinationIndex) {
		
		List<GameMinProjection> list = gameRepository.searchByList(listId);
		GameMinProjection obj = list.remove(sourceIndex);
		list.add(destinationIndex, obj);
		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
		
		for(int i = min; i < max; i++ ) {
			 gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}
		
	}

}
