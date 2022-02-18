package com.zdrv.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zdrv.domain.Result;

@Mapper
public interface ResultMapper {

	//全試合を取得
	List<Result> selectAll();
	
	//１試合分を取得
	Result selectById(int id);
	
	//追加
	void insert(Result result);
	
	//削除
	void delete(int id);
	
	//編集
	void edit(Result result);
	
}
