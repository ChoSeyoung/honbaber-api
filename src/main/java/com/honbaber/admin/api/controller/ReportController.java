package com.honbaber.admin.api.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/api/${API_VERSION}")
public class ReportController {

	@GetMapping("/report")
	public List<Map<String, Object>> showReport(){
		return null;
	}
	@PutMapping("/report")
	public List<Map<String, Object>> modifyReport(){
		return null;
	}
}
