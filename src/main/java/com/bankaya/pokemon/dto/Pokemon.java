package com.bankaya.pokemon.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pokemon {

	private List<Abilities> abilities;
	@JsonProperty("base_experience")
	private Long baseExperience;
	@JsonProperty("held_items")
	private List<HeldItems> heldItems;
	private Long id;
	private String name;
	@JsonProperty("location_area_encounters")
	private String locationAreaEncounters;
	
}
