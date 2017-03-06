package io.javabrains.springbootstarter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootstarter.model.Ninja;
import io.javabrains.springbootstarter.service.NinjaService;

//@CrossOrigin("http://localhost:4200")
@CrossOrigin
@RestController
public class NinjaController {
	
	@Autowired
	NinjaService ninjaService;
	
	@RequestMapping("/ninjas")
	public List<Ninja> getAllNinjas(){
		return ninjaService.getAllNinjas();
	}
	
	
	@RequestMapping(method=RequestMethod.POST,value="/ninjas")
	public void addNinjas(@RequestBody Ninja ninja){
		ninjaService.addNinjas(ninja);
	}

}
