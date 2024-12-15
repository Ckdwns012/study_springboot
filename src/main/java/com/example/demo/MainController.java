package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MainController {
	
	@Autowired
    private ApiService apiService;
	
	
	@GetMapping("/sbb")
	@ResponseBody
	public String index() {
		return apiService.getApiResponse();
	}
	
	@GetMapping("/")
	public String root() {
		return "redirect:/question/list";
	}
}
