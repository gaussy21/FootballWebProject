package com.zdrv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.zdrv.service.RankingService;

@Controller
public class RankingController {

	@Autowired
	private RankingService rankingService;
	
	@GetMapping("/rank")
	public String rank(Model model) {
		model.addAttribute("ranks", rankingService.getAllRanking());
		return "rank";
	}
	
	
}
