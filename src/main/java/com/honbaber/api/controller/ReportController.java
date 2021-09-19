package com.honbaber.api.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/${API_VERSION}")
public class ReportController {

	@PostMapping("/report")
	public List<Map<String, String>> saveReport(){
		return null;
	}
}
