package com.cristinakochmann.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cristinakochmann.dslist.dto.GameListDTO;
import com.cristinakochmann.dslist.entities.GameList;
import com.cristinakochmann.dslist.repositories.GameListRepository;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository gameListRepository;
	
	// anotacao @Transactional abaixo para ficar conforme ACID
	//Atomica, Consistente, Isolada, Duravel == ACID
	
	//retorna uma lista de games mas com informacoes reduzidas
	@Transactional(readOnly = true)// somente para leitura, nao haverá escrita = mais rapido
	public List<GameListDTO> findAll(){
		List<GameList> result = gameListRepository.findAll();
		List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
		return dto;
	}
	
	
		
	
}
