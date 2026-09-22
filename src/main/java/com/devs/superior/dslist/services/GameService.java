package com.devs.superior.dslist.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devs.superior.dslist.dto.GameDTO;
import com.devs.superior.dslist.dto.GameMinDTO;
import com.devs.superior.dslist.entities.Game;
import com.devs.superior.dslist.repositories.GameRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GameService {
	
	private final GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		Game result = gameRepository.findById(id).get();
		GameDTO dto = new GameDTO(result);
		return dto;
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll(){
		List<Game> result = gameRepository.findAll();
		List<GameMinDTO> dto = result.stream()
				            .map(x -> new GameMinDTO(x)).toList();
		return dto;
	}
	
	

}
