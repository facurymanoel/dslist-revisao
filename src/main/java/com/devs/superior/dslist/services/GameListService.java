package com.devs.superior.dslist.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devs.superior.dslist.dto.GameListDTO;
import com.devs.superior.dslist.entities.GameList;
import com.devs.superior.dslist.repositories.GameListRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GameListService {
	
	private GameListRepository gameListRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO>findAll(){
		List<GameList> result = gameListRepository.findAll();
		List<GameListDTO> dto = result.stream()
				                      .map(x -> new GameListDTO(x))
				                      .toList();
		return dto;
		
	}

}
