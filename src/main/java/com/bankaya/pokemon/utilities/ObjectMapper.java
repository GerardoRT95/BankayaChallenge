package com.bankaya.pokemon.utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import https.github_com.gerardort95.Abilities;
import https.github_com.gerardort95.Ability;
import https.github_com.gerardort95.HeldItems;
import https.github_com.gerardort95.Item;

@Component
public class ObjectMapper {
	
	public List<Abilities> mapListAbilities(List<com.bankaya.pokemon.dto.Abilities> abilities) {
		
		List<Abilities> res = new ArrayList<>();
		res = abilities.stream().map(a -> mapAbilities(a)).collect(Collectors.toList());
		return res;
	}
	
	public Abilities mapAbilities(com.bankaya.pokemon.dto.Abilities abilities) {
		Abilities res = new Abilities();
		res.setAbility(mapAbility(abilities.getAbility()));
		res.setIsHidden(abilities.getIsHidden());
		res.setSlot(abilities.getSlot());
		return res;
	}
	
	public Ability mapAbility(com.bankaya.pokemon.dto.Ability ability) {
		Ability res = new Ability();
		res.setName(ability.getName());
		res.setUrl(ability.getUrl());
		return res;
	}
	
	public List<HeldItems> mapListHeldItems(List<com.bankaya.pokemon.dto.HeldItems> heldItems) {
		List<HeldItems> res = new ArrayList<>();
		res = heldItems.stream().map(hi -> mapHeldItems(hi)).collect(Collectors.toList());
		return res;
	}
	
	public HeldItems mapHeldItems(com.bankaya.pokemon.dto.HeldItems heldItems) {
		HeldItems res = new HeldItems();
		res.setItem(mapItem(heldItems.getItem()));
		return res;
	}
	
	public Item mapItem(com.bankaya.pokemon.dto.Item item) {
		Item res = new Item();
		res.setName(item.getName());
		res.setUrl(item.getUrl());
		return res;
	}

}
