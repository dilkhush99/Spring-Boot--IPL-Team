package com.example.IPL_Team.JPAIPL.TEAM.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "Team_Name", uniqueConstraints = {
        @UniqueConstraint(name = "teamNameAndteamCityName", columnNames = { "Team_City", "Team_Name" })
})
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Team_Name")
    private String teamName;

    @Column(name = "Captain_Name")
    private String captainName;

    // @Column(name = "Winning_Titles")
    private int teamTitlesWin;

    @Column(name = "Team_City")
    private String teamCityName;

}
