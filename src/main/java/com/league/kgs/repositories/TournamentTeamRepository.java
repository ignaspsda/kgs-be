package com.league.kgs.repositories;

import com.league.kgs.entity.TournamentTeams;
import com.league.kgs.entity.Team;
import com.league.kgs.entity.Tournament;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TournamentTeamRepository extends CrudRepository<TournamentTeams, Long> {

    @Query("SELECT CASE WHEN COUNT(tt) > 0 THEN true ELSE false END FROM TournamentTeams tt WHERE tt.team = :team AND tt.tournament = :tournament")
    boolean ifExists(@Param("team") Team team, @Param("tournament") Tournament tournament);

}
