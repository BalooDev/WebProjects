package com.service.jersey;

import java.util.ArrayList;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.banque.beans.Personne;
import com.banque.jdbc.ConnexionBD;


@Path("/personne")
public class PersonneServices 
{
	
	
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public Personne getPersonne( @PathParam("id") int id )
	{
    	ConnexionBD cbd = new ConnexionBD();
    	Personne p = cbd.getPersonne(id);
    	return p;		
	}
    
    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
	public ArrayList getAllPersonne( @PathParam("id") int id )
	{
    	ConnexionBD cbd = new ConnexionBD();
    	ArrayList p = new ArrayList();
    	p = cbd.getAllPersonne();
    	return p;		
	}
    
	@GET
    @Path("/{id}/comptes")
    @Produces(MediaType.APPLICATION_JSON)
	public ArrayList getCompteOfPersonne( @PathParam("id") int id )
	{
		ConnexionBD cbd = new ConnexionBD();
		ArrayList listCompte = new ArrayList();
		listCompte = cbd.getCompteOfPersonne(id);
		return listCompte;
	}
	
	@GET
    @Path("/{id}/credits")
    @Produces(MediaType.APPLICATION_JSON)
	public ArrayList getCreditOfPersonne( @PathParam("id") int id )
	{
		ConnexionBD cbd = new ConnexionBD();
		ArrayList listCompte = new ArrayList();
		listCompte = cbd.getCreditOfPersonne(id);
		return listCompte;
	}
    

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_XML)
	public String deletePersonne( @PathParam("id") int id) throws ClassNotFoundException
	{
    	ConnexionBD cbd = new ConnexionBD();
    	String rep = cbd.deletePersonne(id);
    	return rep;		
	}
    
    @PUT
    @Path("/id={id}&prenom={prenom}&nom={nom}&datenaissance={daten}")
    @Produces(MediaType.APPLICATION_XML)
	public String addPersonne(@PathParam("id") int id, @PathParam("prenom") String prenom, @PathParam("nom") String nom, @PathParam("daten") String daten) throws ClassNotFoundException
	{
    	ConnexionBD cbd = new ConnexionBD();
    	String rep = cbd.addPersonne(id, nom, prenom, daten);
    	return rep;		
	}
	
}
