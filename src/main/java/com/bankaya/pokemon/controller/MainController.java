package com.bankaya.pokemon.controller;

import java.util.List;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.bankaya.pokemon.dto.Abilities;
import com.bankaya.pokemon.dto.HeldItems;
import com.bankaya.pokemon.service.MainService;
import com.bankaya.pokemon.utilities.ObjectMapper;

import https.github_com.gerardort95.AbilitiesRequest;
import https.github_com.gerardort95.AbilitiesResponse;
import https.github_com.gerardort95.BaseExperienceRequest;
import https.github_com.gerardort95.BaseExperienceResponse;
import https.github_com.gerardort95.HeldItemsRequest;
import https.github_com.gerardort95.HeldItemsResponse;
import https.github_com.gerardort95.IdRequest;
import https.github_com.gerardort95.IdResponse;
import https.github_com.gerardort95.LocationAreaEncountersRequest;
import https.github_com.gerardort95.LocationAreaEncountersResponse;
import https.github_com.gerardort95.NameRequest;
import https.github_com.gerardort95.NameResponse;

@Endpoint
public class MainController {
	
	private static final String NAMESPACE_URI = "https://github.com/GerardoRT95";
	
	//Objeto del servicio para realizar la logica de la aplicacion
	private MainService service;
	//Objeto para mappear entre pojos internos y los generados para la respuesta del servicio
	private ObjectMapper mapper;
	
	
	public MainController(MainService service, ObjectMapper mapper) {
		this.service = service;
		this.mapper = mapper;
	}
	
	//Metodos para cada endpoint
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "abilitiesRequest")
	@ResponsePayload
	public AbilitiesResponse getPokemon(@RequestPayload AbilitiesRequest request) {
		//Se llama al servio para que devuelva el objeto requerido
		List<Abilities> abilities = service.getAbilities(request.getName());
		//Se crea un objeto para la respuesta
		AbilitiesResponse response = new AbilitiesResponse();
		//Se mapea el pojo interno hacia el objeto requrido para la respuesta
		List<https.github_com.gerardort95.Abilities> resAbilities = mapper.mapListAbilities(abilities);
		//Se copia la lista
		response.getAbilities().addAll(resAbilities);
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "base_experienceRequest")
	@ResponsePayload
	public BaseExperienceResponse getPokemon(@RequestPayload BaseExperienceRequest request) {
		Long res = service.getBaseExperience(request.getName());
		BaseExperienceResponse response = new BaseExperienceResponse();
		response.setBaseExperience(res);
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "held_itemsRequest")
	@ResponsePayload
	public HeldItemsResponse getHeldItems(@RequestPayload HeldItemsRequest request) {
		List<HeldItems> heldItems = service.getHeldItems(request.getName());
		HeldItemsResponse response = new HeldItemsResponse();
		List<https.github_com.gerardort95.HeldItems> resHeldItems = mapper.mapListHeldItems(heldItems);
		response.getHeldItems().addAll(resHeldItems);
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "idRequest")
	@ResponsePayload
	public IdResponse getId(@RequestPayload IdRequest request) {
		Long res = service.getId(request.getName());
		IdResponse response = new IdResponse();
		response.setId(res);
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "nameRequest")
	@ResponsePayload
	public NameResponse getId(@RequestPayload NameRequest request) {
		String res = service.getName(request.getName());
		NameResponse response = new NameResponse();
		response.setName(res);
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "location_area_encountersRequest")
	@ResponsePayload
	public LocationAreaEncountersResponse getId(@RequestPayload LocationAreaEncountersRequest request) {
		String res = service.getLocationAreaEncounters(request.getName());
		LocationAreaEncountersResponse response = new LocationAreaEncountersResponse();
		response.setLocationAreaEncounters(res);
		return response;
	}
	
}
