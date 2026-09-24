package com.devs.superior.dslist.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devs.superior.dslist.dto.GameListDTO;
import com.devs.superior.dslist.services.GameListService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/lists")
@AllArgsConstructor
public class GameListController {

	private GameListService gameListService;

	@GetMapping
	public List<GameListDTO> findAll() {

		List<GameListDTO> result = gameListService.findAll();
		return result;

	}

}
