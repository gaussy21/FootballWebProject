package com.zdrv.domain;

import lombok.Data;

@Data
public class Ranking {

	private Integer teamId;
	private String name; //チーム名
	private Integer game;
	private Integer win;
	private Integer draw;
	private Integer lose;
	private Integer plus;
	private Integer minus;
	private Integer diff;
	private Integer point;
}
