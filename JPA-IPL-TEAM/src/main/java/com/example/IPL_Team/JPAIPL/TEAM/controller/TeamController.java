package com.example.IPL_Team.JPAIPL.TEAM.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.IPL_Team.JPAIPL.TEAM.entity.Team;
import com.example.IPL_Team.JPAIPL.TEAM.service.TeamService;

@RestController
@RequestMapping("/Team")
public class TeamController {
    
    @Autowired
    private TeamService teamService;

    @GetMapping("/getall")
    public List<Team> list()
    {
        return teamService.listAll();
    }

@PostMapping("/add")
    public String addinformation(@RequestBody Team team)
    {
        teamService.save(team);
        return "New Team Info Added";
    }

@GetMapping("/{id}")
    public ResponseEntity<Team> getTeam(@PathVariable Long id)
    {
        try {
            Team team = teamService.get(id);
            return new ResponseEntity<Team>(team,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


@PutMapping("/{id}")
    public ResponseEntity<Team> Update(@RequestBody Team team, @PathVariable Long id)
    {
        try {
            teamService.save(team);
            return new ResponseEntity<Team>(HttpStatus.OK);
            
        } catch (Exception e) {
            return new ResponseEntity<Team>(HttpStatus.NOT_FOUND);
        }
    }

@DeleteMapping("/{id}")
    public String deleteInformation(@PathVariable Long id)
    {
        teamService.delete(id);
        return "Team Id is Deleted! "+id;
    }

@GetMapping("/min")
    public Team minimum(Team team)
    {
        return teamService.min(team);
    }


    @GetMapping("/max")
    public Team maximum(Team team)
    {
        return teamService.max(team);
    }

}
