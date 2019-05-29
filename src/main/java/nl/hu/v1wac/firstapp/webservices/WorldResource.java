package nl.hu.v1wac.firstapp.webservices;

import javax.json.*;
import javax.ws.rs.*;

@Path("/countries")
public class WorldResource {
	
	@GET
	@Produces("application/json")
	public String getWorld() {
		WorldService ws = ServiceProvider.getWorldService();
		JsonArrayBuilder jab = Json.createArrayBuilder();
		
		for (Country c : ws.getAllCountries()) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("name", c.getName());
			job.add("code", c.getCode());
			
			jab.add(job);
		}
		
		JsonArray ja = jab.build();
		return ja.toString();
	}
	
	@GET
	@Path("{code}")
	@Produces("application/json")
	public String getCountryByCode(@PathParam("code") String code) {
		WorldService ws = ServiceProvider.getWorldService();
		Country c = ws.getCountryByCode(code);
		
		JsonObjectBuilder job = Json.createObjectBuilder();
		job.add("code",			c.getCode());
		job.add("iso3",			c.getIso3());
		job.add("name", 		c.getName());
		job.add("capital",		c.getCapital());
		job.add("continent",	c.getContinent());
		job.add("region", 		c.getRegion());
		job.add("surface",		c.getSurface());
		job.add("population",	c.getPopulation());
		job.add("government",	c.getGovernment());
		job.add("latitude",	 	c.getLatitude());
		job.add("longitude",	c.getLongitude());
		
		return job.build().toString();
	}
	
	@GET
	@Path("/largestsurfaces")
	@Produces("application/json")
	public String get10LargestBySurface() {
		WorldService ws = ServiceProvider.getWorldService();
		JsonArrayBuilder jab = Json.createArrayBuilder();
		
		for (Country c : ws.get10LargestSurfaces()) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("name", c.getName());
			job.add("code", c.getCode());
			
			jab.add(job);
		}
		
		JsonArray ja = jab.build();
		return ja.toString();
	}
	
	@GET
	@Path("/largestpopulations")
	@Produces("application/json")
	public String get10LargestByPopulation() {
		WorldService ws = ServiceProvider.getWorldService();
		JsonArrayBuilder jab = Json.createArrayBuilder();
		
		for (Country c : ws.get10LargestPopulations()) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("name", c.getName());
			job.add("code", c.getCode());
			
			jab.add(job);
		}
		
		JsonArray ja = jab.build();
		return ja.toString();
	}
}

