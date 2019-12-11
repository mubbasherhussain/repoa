package com.adnic.jerseyRestAPI;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("aliens")
public class AlienResource {
	AlienRepository repo = new AlienRepository();
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<Alien> getAliens()
	{
		System.out.println("Called...");
		return repo.getAliens();
	}
	@Path("alien/{id}")
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Alien getAliensById(@PathParam("id") int id) {
		return repo.getAliensById(id);
	}
	

	@Path("alien")
	@POST
	public Alien createAlien(Alien a) {
		System.out.println("Alien Object "+a);
		repo.createAlien(a);
		return a;
	}
}
