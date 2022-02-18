package com.zdrv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zdrv.domain.Ranking;
import com.zdrv.mapper.RankingMapper;

@Service
@Transactional
public class RankingServiceImpl implements RankingService {

	@Autowired
	private RankingMapper rankingMapper;
	
	@Override
	public List<Ranking> getAllRanking() {
		// 全順位表を取得
		return rankingMapper.selectAll();
	}
}
