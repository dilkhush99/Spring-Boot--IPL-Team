package com.example.IPL_Team.JPAIPL.TEAM.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.IPL_Team.JPAIPL.TEAM.entity.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    @Query(value = "select t from Team t where t.teamTitlesWin = (Select max(mt.teamTitlesWin) from Team mt)")
    public Team maxTitle();

    @Query(value = "select t from Team t where t.teamTitlesWin = (Select min(mt.teamTitlesWin) from Team mt)")
    public Team minTitle();

}
