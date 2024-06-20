package com.bankaya.pokemon.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Abilities {

	private Ability ability;
	@JsonProperty("is_hidden")
	private String isHidden;
	private int slot;
	
}
