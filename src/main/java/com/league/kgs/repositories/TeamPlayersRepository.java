package com.league.kgs.repositories;

import com.league.kgs.entity.TeamPlayers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamPlayersRepository extends CrudRepository<TeamPlayers, Long> {
}
