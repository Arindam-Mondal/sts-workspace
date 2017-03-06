package io.javabrains.springbootstarter.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import io.javabrains.springbootstarter.model.Ninja;

@Service
public class NinjaService {
	
	private List<Ninja> ninjas = new ArrayList<>(Arrays.asList(
			new Ninja("Yoshi","Black"),
			new Ninja("Ryu","Red"),
			new Ninja("Crystal","Purple")
			));
	
	public List<Ninja> getAllNinjas(){
		return ninjas;
	}

	public void addNinjas(Ninja ninja) {
		ninjas.add(ninja);
		
	}

}
