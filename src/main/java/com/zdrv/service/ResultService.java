package com.zdrv.service;


import java.util.List;

import com.zdrv.domain.Result;

public interface ResultService {

	//全ての試合結果を取得
	List<Result> getAllTeams();
	
	//1試合分を取得
	Result getResultById(Integer id);
	
	//試合結果を追加
	void insertResult(Result result);
	
	//試合結果を削除
	void deleteResult(Integer id);
	
	//試合結果を編集
	void editResult(Result result);
}
