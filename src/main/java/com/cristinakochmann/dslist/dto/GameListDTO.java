package com.cristinakochmann.dslist.dto;

import org.springframework.beans.BeanUtils;

import com.cristinakochmann.dslist.entities.GameList;

public class GameListDTO {

	private Long id;
	private String name;
	
	public GameListDTO() {
	}

	public GameListDTO(GameList entity) {
		
		/*Usa propriedade do framework que já copia todos os atributos da entidade principal
		BeanUtils.copyProperties(entity, this);
		Ou, como são poucos atributos, fazemos a mão mesmo, até para deixar como modelo
		E como não usou o BeanUtils, pode implementar soments getters*/
		id = entity.getId();
		name = entity.getName();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
}
