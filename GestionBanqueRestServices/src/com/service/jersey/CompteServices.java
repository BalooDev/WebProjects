package com.service.jersey;

import java.util.ArrayList;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.banque.beans.Compte;
import com.banque.beans.Personne;
import com.banque.jdbc.ConnexionBD;

@Path("/compte")
public class CompteServices 
{
	@GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
	public ArrayList getAllCompte( )
	{
		ConnexionBD cbd = new ConnexionBD();
		ArrayList listCompte = new ArrayList();
		listCompte = cbd.getAllCompte();
		return listCompte;
	}
	
	@GET
    @Path("/{num}")
    @Produces(MediaType.APPLICATION_JSON)
	public Compte getCompte( @PathParam("num") int num )
	{
		ConnexionBD cbd = new ConnexionBD();
		Compte c = new Compte();
		c = cbd.getCompte(num);
		return c;
	}
	
	@GET
    @Path("/{num}/interet")
    @Produces(MediaType.APPLICATION_JSON)
	public String getInteret( @PathParam("num") int num )
	{
		ConnexionBD cbd = new ConnexionBD();
		String rep;
		rep = cbd.getInteret(num);
		return rep;
	}
	
	@GET
    @Path("/{num}/etat")
    @Produces(MediaType.APPLICATION_JSON)
	public String getEtat( @PathParam("num") int num ) throws ClassNotFoundException
	{
		ConnexionBD cbd = new ConnexionBD();
		String rep;
		rep = cbd.etatCompteCheque(num);
		return rep;
	}
	
	@GET
    @Path("/{num}/credits")
    @Produces(MediaType.APPLICATION_JSON)
	public ArrayList getCreditCompte( @PathParam("num") int num )
	{
		ConnexionBD cbd = new ConnexionBD();
		ArrayList c = new ArrayList();
		c = cbd.getCreditOfCompte(num);
		return c;
	}
	
    @DELETE
    @Path("/{num}")
    @Produces(MediaType.APPLICATION_XML)
	public String deletePersonne( @PathParam("num") int num) throws ClassNotFoundException
	{
    	ConnexionBD cbd = new ConnexionBD();
    	String rep = cbd.deleteCompte(num);
    	return rep;		
	}
	@POST
    @Path("/{num}/retirer{retrait}")
    @Produces(MediaType.APPLICATION_XML)
	public String retirerFromCompte( @PathParam("num") int num, @PathParam("retrait") float retrait) throws ClassNotFoundException
	{
    	ConnexionBD cbd = new ConnexionBD();
    	String rep = cbd.retraitCompte(num,retrait);
    	return rep;		
	}
	
	@POST
    @Path("/{num}/deposer{depot}")
    @Produces(MediaType.APPLICATION_XML)
	public String deposerInCompte( @PathParam("num") int num, @PathParam("depot") float depot) throws ClassNotFoundException
	{
    	ConnexionBD cbd = new ConnexionBD();
    	String rep = cbd.depotCompte(num,depot);
    	return rep;		
	}
    
    @PUT
    @Path("/num={num}&persoid={p_id}&somme={somme}&decouvert={decouvert}")
    @Produces(MediaType.APPLICATION_XML)
	public String addCompteCheque(@PathParam("num") int num, @PathParam("p_id") int p_id, @PathParam("somme") float somme, @PathParam("decouvert") float decouvert) throws ClassNotFoundException
	{
    	ConnexionBD cbd = new ConnexionBD();
    	String rep = cbd.addCompteCheque(num, p_id, somme, decouvert);
    	return rep;		
	}
    
    @PUT
    @Path("/num={num}&persoid={p_id}&somme={somme}&taux={taux}&plafond={plafond}")
    @Produces(MediaType.APPLICATION_XML)
	public String addCompteEpargne(@PathParam("num") int num, @PathParam("p_id") int p_id, @PathParam("somme") float somme, @PathParam("taux") float taux, @PathParam("plafond") float plafond) throws ClassNotFoundException
	{
    	ConnexionBD cbd = new ConnexionBD();
    	String rep = cbd.addCompteEpargne(num, p_id, somme, taux, plafond);
    	return rep;		
	}
}
