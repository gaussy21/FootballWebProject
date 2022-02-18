package com.zdrv.domain;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.PastOrPresent;

import lombok.Data;

@Data
public class Result {

	
	private int id;
	private Integer homeTeamId;
	private String homeTeamName;
	private Integer awayTeamId;
	private String awayTeamName;
	@Min(0)
	private Integer homeScore;
	@Min(0)
	private Integer awayScore;
	@PastOrPresent(message="今日以前にしてください")
	private Date date;
	
}
