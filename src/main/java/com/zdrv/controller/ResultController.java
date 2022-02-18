package com.zdrv.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;

import com.zdrv.domain.Result;
import com.zdrv.service.ResultService;




@Controller
public class ResultController {

	
	@Autowired
	private ResultService resultService;
	
	@InitBinder
	public void initBinderForm(WebDataBinder binder) {
		var sdf = new SimpleDateFormat("y-MM-dd");
		binder.registerCustomEditor(Date.class, "date", new CustomDateEditor(sdf, true));
	}
	
	@GetMapping("/result")
	private String add(Model model) {
		model.addAttribute("result", new Result());
		model.addAttribute("results", resultService.getAllTeams());
		model.addAttribute("date", new Date());
		return "result";
	}
	
}
