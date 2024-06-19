package com.bankaya.pokemon.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankaya.pokemon.dto.Pokemon;
import com.bankaya.pokemon.service.MainService;

@RestController
@RequestMapping("/pokemon")
public class MainController {
	
	private MainService service;
	
	public MainController(MainService service) {
		this.service = service;
	}
	
	@GetMapping("/{name}")
	@ResponseBody
	public Pokemon getPokemon(@PathVariable String name) {
		return service.getPokemon(name);
	}

}
