package com.devs.superior.dslist.dto;

import com.devs.superior.dslist.entities.GameList;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GameListDTO {

	private Long id;
	private String name;

	public GameListDTO(GameList entity) {

		id = entity.getId();
		name = entity.getName();
	}

}
