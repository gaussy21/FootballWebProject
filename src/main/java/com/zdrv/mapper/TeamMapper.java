package com.zdrv.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zdrv.domain.Team;

@Mapper
public interface TeamMapper {
	//全チーム情報を取得
    List<Team> selectAll();
    
    //1チーム分のチーム名を取得
    Team selectById(int id);
}
