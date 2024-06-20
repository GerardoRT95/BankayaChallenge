package com.bankaya.pokemon.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bankaya.pokemon.dto.Abilities;
import com.bankaya.pokemon.dto.HeldItems;
import com.bankaya.pokemon.dto.Pokemon;

@Service
public class MainService {
	
	private RestTemplate restTemplate;
	
	public MainService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public Pokemon getPokemon(String name) {
		Pokemon res = restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/" + name, Pokemon.class);
		return res;
	}
	
	public List<Abilities> getAbilities(String name){
		return restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/" + name, Pokemon.class).getAbilities();
	}
	
	public Long getBaseExperience(String name) {
		return restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/" + name, Pokemon.class).getBaseExperience();
	}
	
	public List<HeldItems> getHeldItems(String name){
		return restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/" + name, Pokemon.class).getHeldItems();
	}
	
	public Long getId(String name) {
		return restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/" + name, Pokemon.class).getId();
	}
	
	public String getName(String name) {
		return restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/" + name, Pokemon.class).getName();
	}
	
	public String getLocationAreaEncounters(String name) {
		return restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/" + name, Pokemon.class).getLocationAreaEncounters();
	}

}
