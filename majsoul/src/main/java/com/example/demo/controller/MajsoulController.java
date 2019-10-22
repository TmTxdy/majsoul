package com.example.demo.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.MajsoulService;

@RestController
public class MajsoulController {

	@Autowired
	private MajsoulService majsoulService;
	
	@RequestMapping("/query")
	public Map<String, Integer> query() {
		return majsoulService.query();
	}
}
