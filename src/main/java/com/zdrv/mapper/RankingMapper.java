package com.zdrv.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zdrv.domain.Ranking;

@Mapper
public interface RankingMapper {
	
	// ランキングを取得
	List<Ranking> selectAll();
	
	// ランキングを更新
	void update(Ranking ranking);

}
