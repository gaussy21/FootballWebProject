package com.zdrv.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

import com.zdrv.domain.Result;
import com.zdrv.domain.Team;
import com.zdrv.service.ResultService;
import com.zdrv.service.TeamService;

@Controller
public class HomeController {

	@Autowired
	private ResultService resultService;
	
	@Autowired
	private TeamService teamService;
	
	@InitBinder
	public void initBinderForm(WebDataBinder binder) {
		var sdf = new SimpleDateFormat("y-MM-dd");
		binder.registerCustomEditor(Date.class, "date", new CustomDateEditor(sdf, true));
	}

	
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("teams", teamService.getAllTeams());
		Result result = new Result();
		result.setHomeScore(0);
		result.setAwayScore(0);
		result.setDate(new Date());
		model.addAttribute("result", result);
		return "home";
	}
	
	@PostMapping("/home")
	public String homePost(@Valid Result result, Errors errors, Model model) {
		if(errors.hasErrors()) {
			for(var e : errors.getAllErrors()) {
				System.out.println(e);
			}
			return "home";
		}
		model.addAttribute("date", new Date());
		resultService.insertResult(result);

		Team homeTeam = teamService.getTeamById(result.getHomeTeamId());
		Team awayTeam = teamService.getTeamById(result.getAwayTeamId());
		model.addAttribute("homeName", homeTeam.getName());
		model.addAttribute("awayName", awayTeam.getName());
		
		return "addDone";
	}
	
	
}
