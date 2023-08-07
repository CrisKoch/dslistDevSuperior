package com.cristinakochmann.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cristinakochmann.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{

}
