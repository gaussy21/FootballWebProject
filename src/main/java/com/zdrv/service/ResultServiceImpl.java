package com.zdrv.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zdrv.domain.Ranking;
import com.zdrv.domain.Result;
import com.zdrv.mapper.RankingMapper;
import com.zdrv.mapper.ResultMapper;

@Service
@Transactional
public class ResultServiceImpl implements ResultService {

	@Autowired
	private ResultMapper resultMapper;
	
	@Autowired
	private RankingMapper rankingMapper;
	
	
	@Override
	public Result getResultById(Integer id) {
		// 1試合分の結果を取得
		return resultMapper.selectById(id);
	}

	@Override
	public void insertResult(Result result) {
		// resultテーブルにデータを追加
		resultMapper.insert(result);
		
		// ホームチームの勝敗結果や勝ち点等を計算
		Ranking rank1 = new Ranking();
		rank1.setTeamId(result.getHomeTeamId());
		if(result.getHomeScore() > result.getAwayScore()) {
			// 勝ち
			rank1.setWin(1);
			rank1.setDraw(0);
			rank1.setLose(0);
			rank1.setPoint(3);
		}
		else if(result.getHomeScore() < result.getAwayScore()) {
			// 負け
			rank1.setWin(0);
			rank1.setDraw(0);
			rank1.setLose(1);
			rank1.setPoint(0);
		}
		else {
			//引き分け
			rank1.setWin(0);
			rank1.setDraw(1);
			rank1.setLose(0);
			rank1.setPoint(1);
		}
		//得点と失点
		rank1.setPlus(result.getHomeScore());
		rank1.setMinus(result.getAwayScore());
		
		
		
		// アウェイチーム
		Ranking rank2 = new Ranking();
		rank2.setTeamId(result.getAwayTeamId());
		if(result.getAwayScore() > result.getHomeScore()) {
			//勝ち
			rank2.setWin(1);
			rank2.setDraw(0);
			rank2.setLose(0);
			rank2.setPoint(3);
		}
		else if(result.getAwayScore() < result.getHomeScore()) {
			//負け
			rank2.setWin(0);
			rank2.setDraw(0);
			rank2.setLose(1);
			rank2.setPoint(0);
		}
		else {
			//引き分け
			rank2.setWin(0);
			rank2.setDraw(1);
			rank2.setLose(0);
			rank2.setPoint(1);
		}
		//得点と失点
		rank2.setPlus(result.getAwayScore());
		rank2.setMinus(result.getHomeScore());
		
		// rankingテーブルを更新
		rankingMapper.update(rank1);
		rankingMapper.update(rank2);
	}

	@Override
	public void deleteResult(Integer id) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void editResult(Result result) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public List<Result> getAllTeams() {
		// 全試合を取得
		
		return resultMapper.selectAll();
	}

}
