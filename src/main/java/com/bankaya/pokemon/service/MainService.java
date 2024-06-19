package com.bankaya.pokemon.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bankaya.pokemon.dto.Pokemon;

@Service
public class MainService {
	
	private RestTemplate restTemplate;
	
	public MainService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public Pokemon getPokemon(String name) {
		return restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/" + name, Pokemon.class);
	}

}
