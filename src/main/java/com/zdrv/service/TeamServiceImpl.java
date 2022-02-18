package com.zdrv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zdrv.domain.Team;
import com.zdrv.mapper.TeamMapper;

@Service
@Transactional
public class TeamServiceImpl implements TeamService {

	@Autowired
	private TeamMapper teamMapper;
	
	@Override
	public List<Team> getAllTeams() {
		// 全チーム名を取得
		return teamMapper.selectAll();
	}

	@Override
	public Team getTeamById(int id) {
		// １チーム分
		return teamMapper.selectById(id);
	}

}
