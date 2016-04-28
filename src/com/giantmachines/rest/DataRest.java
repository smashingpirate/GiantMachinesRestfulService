package com.giantmachines.rest;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.inject.Guice;
import com.google.inject.Injector;

import DataAccessLayer.ConnectionModule;
import DataAccessLayer.DataProvider;
import Objects.City;
import Objects.Country;
import Objects.CountryLanguage;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/data")
public class DataRest<T> {
	
	public enum Table {
	    City, Country, CountryLanguage
	}
	
	private final String BASEQUERY = "Select * from b1tj0tfe4jfdirv1.";

	@SuppressWarnings("unchecked")
	@GET
	@Path("/{parameter}") 
	@Produces(MediaType.APPLICATION_JSON)
	public Response responseMsg(@PathParam("parameter") String parameter) {
		Injector injector = Guice.createInjector(new ConnectionModule());
		DataProvider dp = injector.getInstance(DataProvider.class);
		ArrayList<T> res;
		
		if(parameter.equalsIgnoreCase("city"))
			res = (ArrayList<T>) dp.getData(BASEQUERY + Table.City, new City.CityFactory());
		
		else if(parameter.equalsIgnoreCase("country"))
			res = (ArrayList<T>) dp.getData(BASEQUERY + Table.Country, new Country.CountryFactory());
		
		else if(parameter.equalsIgnoreCase("countrylanguage"))
			res = (ArrayList<T>) dp.getData(BASEQUERY + Table.CountryLanguage, new CountryLanguage.CountryLanguageFactory());
		
		else
			res = new ArrayList<T>();
		
		ObjectMapper om = new ObjectMapper();
		try {
			return Response.status(200).entity(om.writeValueAsString(res)).build();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return Response.status(504).build();
		}
	}
}