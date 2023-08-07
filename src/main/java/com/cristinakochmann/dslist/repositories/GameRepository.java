package com.cristinakochmann.dslist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cristinakochmann.dslist.entities.Game;
import com.cristinakochmann.dslist.projections.GameMinProjection;

public interface GameRepository extends JpaRepository<Game, Long>{
	/*consultas SQL extras devem ser colocadas aqui no repository
	 * 
	 * CONSULTAS CUSTOMIZADAS: para funcionar a consulta com SQL, deve colocar a annotation
	 * nativeQuery = true, como está abaixo.
	 * 
	 */
	@Query(nativeQuery = true, value = """
			SELECT tb_game.id, tb_game.title, tb_game.game_year AS `year`, tb_game.img_url AS imgUrl,
			tb_game.short_description AS shortDescription, tb_belonging.position
			FROM tb_game
			INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
			WHERE tb_belonging.list_id = :listId 
			ORDER BY tb_belonging.position
				""")
	
/*CONSULTAS CUSTOMIZADAS no SPRING DATA JPA (BANCO RELACIONAL)
 * Assinar o método, colocando de parâmetro o que vc precisar para sua consulta
 * o parâmetro que passar para o método que vai casar com o :parametro acima. Por exemplo,
 * na linha 22 acima.
 */
	List<GameMinProjection> searchByList(Long listId);
//resultado da consulta deve ser uma interface, aqui chamada de projection

}
