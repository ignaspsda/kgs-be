package com.league.kgs.repositories;

import com.league.kgs.entity.Team;
import com.league.kgs.entity.Tournament;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TournamentRepository extends CrudRepository<Tournament, Long> {
    List<Tournament> findAll();

/*    @Query("SELECT CASE WHEN COUNT(t) > 0 THEN true ELSE false END FROM Tournament tr JOIN tr.teamsList t WHERE t.id = :teamId")
    boolean ifTeamExists(@Param("teamId") Long teamId);*/

}
