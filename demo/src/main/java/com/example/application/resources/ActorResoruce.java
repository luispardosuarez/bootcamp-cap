package com.example.application.resources;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domains.contracts.services.ActorService;
import com.example.domains.entities.models.ActorShort;

@RestController
@RequestMapping("/api/actores/v1")
public class ActorResoruce {
	private ActorService srv;
	
	public ActorResoruce(ActorService srv) {
		this.srv= srv;
	}
	
	@GetMapping
	public List<ActorShort> getAll() {
		return srv.getByProjection(ActorShort.class);
	}
	
	@GetMapping(path= "/{id}")
	public List<ActorShort> getOne(@PathVariable int id) {
		return srv.getByProjection(ActorShort.class);
	}
	
 }
