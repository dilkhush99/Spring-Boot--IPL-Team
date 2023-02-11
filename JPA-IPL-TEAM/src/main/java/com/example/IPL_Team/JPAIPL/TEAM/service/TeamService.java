package com.example.IPL_Team.JPAIPL.TEAM.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.IPL_Team.JPAIPL.TEAM.entity.Team;
import com.example.IPL_Team.JPAIPL.TEAM.repository.TeamRepository;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public List<Team> listAll() {
        return teamRepository.findAll();
    }

    public void save(Team team) {
        teamRepository.save(team);
    }

    public Team get(Long id) {
        return teamRepository.findById(id).get();
    }

    public void delete(Long id) {
        teamRepository.deleteById(id);
    }

    public Team max(Team team)
    {
        return teamRepository.maxTitle();
    }

    public Team min(Team team)
    {
        return teamRepository.minTitle();
    }

}
