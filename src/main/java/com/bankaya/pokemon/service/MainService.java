package com.bankaya.pokemon.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bankaya.pokemon.dao.Peticion;
import com.bankaya.pokemon.dto.Abilities;
import com.bankaya.pokemon.dto.HeldItems;
import com.bankaya.pokemon.dto.Pokemon;
import com.bankaya.pokemon.repository.PeticionRepository;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class MainService {
	
	private RestTemplate restTemplate;
	private PeticionRepository repository;
	private HttpServletRequest servletRequest;
	
	public MainService(RestTemplate restTemplate, PeticionRepository repository, HttpServletRequest servletRequest) {
		this.restTemplate = restTemplate;
		this.repository = repository;
		this.servletRequest = servletRequest;
	}
	
	public Pokemon getPokemon(String name) {
		Pokemon res = restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/" + name, Pokemon.class);
		return res;
	}
	
	public List<Abilities> getAbilities(String name){
		savePeticion("abilities");
		return restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/" + name, Pokemon.class).getAbilities();
	}
	
	public Long getBaseExperience(String name) {
		savePeticion("base_experience");
		return restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/" + name, Pokemon.class).getBaseExperience();
	}
	
	public List<HeldItems> getHeldItems(String name){
		savePeticion("held_items");
		return restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/" + name, Pokemon.class).getHeldItems();
	}
	
	public Long getId(String name) {
		savePeticion("id");
		return restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/" + name, Pokemon.class).getId();
	}
	
	public String getName(String name) {
		savePeticion("name");
		return restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/" + name, Pokemon.class).getName();
	}
	
	public String getLocationAreaEncounters(String name) {
		savePeticion("location_area_encounters");
		return restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/" + name, Pokemon.class).getLocationAreaEncounters();
	}
	
	private void savePeticion(String metodo) {
		repository.save(Peticion.builder()
				.ipOrigen(servletRequest.getRemoteAddr())
				.fechaRequest(LocalDate.now())
				.metodo(servletRequest.getMethod() + " - " + metodo)
				.build());
	}

}
