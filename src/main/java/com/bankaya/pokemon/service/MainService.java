package com.bankaya.pokemon.service;

import java.util.List;

import com.bankaya.pokemon.dto.Abilities;
import com.bankaya.pokemon.dto.HeldItems;

public interface MainService {
	
	public List<Abilities> getAbilities(String name);
	
	public Long getBaseExperience(String name);
	
	public List<HeldItems> getHeldItems(String name);
	
	public Long getId(String name);
	
	public String getName(String name);
	
	public String getLocationAreaEncounters(String name);

}
