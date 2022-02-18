package com.zdrv.service;

import java.util.List;

import com.zdrv.domain.Team;

public interface TeamService {
	
	//全チーム名を取得
	List<Team> getAllTeams();
	
	//１チーム分のチーム名を取得
	Team getTeamById(int id);

}
