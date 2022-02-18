package com.zdrv.domain;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class Team {
	
	private Integer id;
	@NotBlank
	private String name;

}
