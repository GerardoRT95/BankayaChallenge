package com.bankaya.pokemon.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bankaya.pokemon.dao.Peticion;
import com.bankaya.pokemon.dto.Abilities;
import com.bankaya.pokemon.dto.HeldItems;
import com.bankaya.pokemon.dto.Pokemon;
import com.bankaya.pokemon.repository.PeticionRepository;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class MainServiceImpl implements MainService{
	
	@Value("${pokemon.rest.service.url}")
	private String restServiceUrl;
	
	//Objeto para realizar peticiones rest hacia la api de pokemon
	private RestTemplate restTemplate;
	//Interfaz para interactuar con la base de datos h2
	private PeticionRepository repository;
	//Objeto para obtener meta datos de la peticion
	private HttpServletRequest servletRequest;
	
	public MainServiceImpl(RestTemplate restTemplate, PeticionRepository repository, HttpServletRequest servletRequest) {
		this.restTemplate = restTemplate;
		this.repository = repository;
		this.servletRequest = servletRequest;
	}
	
	//Metodos para obtener la informacion del pokemon
	public List<Abilities> getAbilities(String name) {
		//Se guarda la peticion en la base de datos
		savePeticion("abilities");
		//Se realiza una peticion rest a la api de pokemon y se retornan unicamente los datos solicitados
		return restTemplate.getForObject(restServiceUrl + name, Pokemon.class).getAbilities();
	}
	
	public Long getBaseExperience(String name) {
		savePeticion("base_experience");
		return restTemplate.getForObject(restServiceUrl + name, Pokemon.class).getBaseExperience();
	}
	
	public List<HeldItems> getHeldItems(String name) {
		savePeticion("held_items");
		return restTemplate.getForObject(restServiceUrl + name, Pokemon.class).getHeldItems();
	}
	
	public Long getId(String name) {
		savePeticion("id");
		return restTemplate.getForObject(restServiceUrl + name, Pokemon.class).getId();
	}
	
	public String getName(String name) {
		savePeticion("name");
		return restTemplate.getForObject(restServiceUrl + name, Pokemon.class).getName();
	}
	
	public String getLocationAreaEncounters(String name) {
		savePeticion("location_area_encounters");
		return restTemplate.getForObject(restServiceUrl + name, Pokemon.class).getLocationAreaEncounters();
	}
	
	//Metodo para guardar en base de datos
	private void savePeticion(String metodo) {
		//Se realiza una operacion de guardado en la base de datos creando un objeto con los datos de la peticion
		repository.save(Peticion.builder()
				.ipOrigen(servletRequest.getRemoteAddr())
				.fechaRequest(LocalDate.now())
				.metodo(servletRequest.getMethod() + " - " + metodo)
				.build());
	}

}
