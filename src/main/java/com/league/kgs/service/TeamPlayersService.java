package com.league.kgs.service;

import com.league.kgs.entity.Player;
import com.league.kgs.entity.Team;
import com.league.kgs.entity.TeamPlayers;
import com.league.kgs.repositories.TeamPlayersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamPlayersService {

    private final TeamPlayersRepository teamPlayersRepository;

    @Autowired
    public TeamPlayersService(TeamPlayersRepository teamPlayersRepository) {
        this.teamPlayersRepository = teamPlayersRepository;
    }

    public void addPlayerToTeam(Team team, Player player) {
        TeamPlayers teamPlayers = new TeamPlayers(player, team);
        teamPlayersRepository.save(teamPlayers);
    }
}
