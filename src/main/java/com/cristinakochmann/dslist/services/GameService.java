package com.cristinakochmann.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cristinakochmann.dslist.dto.GameDTO;
import com.cristinakochmann.dslist.dto.GameMinDTO;
import com.cristinakochmann.dslist.entities.Game;
import com.cristinakochmann.dslist.repositories.GameRepository;



@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	
	// anotacao @Transactional abaixo para ficar conforme ACID
	//Atomica, Consistente, Isolada, Duravel == ACID
	
	//buscar game por id, retorno tipo DTO
	
	@Transactional(readOnly = true)// somente para leitura, nao haverá escrita = mais rapido
	public GameDTO findById(Long id) {
		Game result = gameRepository.findById(id).get();
		GameDTO dto = new GameDTO(result);
		return dto;
		//ou somente return new GameDTO(result), omitindo as duas linhas anteriores
	}
	
	//retorna uma lista de games mas com informacoes reduzidas
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll(){
		List<Game> result = gameRepository.findAll();
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
	}
	
	
		
	
}
