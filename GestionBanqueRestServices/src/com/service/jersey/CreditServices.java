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

import com.banque.beans.Compte;
import com.banque.jdbc.ConnexionBD;

@Path("/credit")
public class CreditServices 
{

	@GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
	public ArrayList getAllCredit( )
	{
		ConnexionBD cbd = new ConnexionBD();
		ArrayList listCredit = new ArrayList();
		listCredit = cbd.getAllCredit();
		return listCredit;
	}
	
	@GET
    @Path("/{num}")
    @Produces(MediaType.APPLICATION_JSON)
	public ArrayList getCredit( @PathParam("num") int num )
	{
		ConnexionBD cbd = new ConnexionBD();
		ArrayList c = new ArrayList();
		c = cbd.getCredit(num);
		return c;
	}
	
	@POST
    @Path("/{num}/payermensualite")
    @Produces(MediaType.APPLICATION_XML)
	public String payerMensualiteCredit( @PathParam("num") int num) throws ClassNotFoundException
	{
    	ConnexionBD cbd = new ConnexionBD();
    	String rep = cbd.payerMensualiteCredit(num);
    	return rep;		
	}
	
	@POST
    @Path("/{num}/payeranticipation{somme}")
    @Produces(MediaType.APPLICATION_XML)
	public String payerMensualiteCredit( @PathParam("num") int num, @PathParam("somme") float somme) throws ClassNotFoundException
	{
    	ConnexionBD cbd = new ConnexionBD();
    	String rep = cbd.payerAnticipationCredit(num,somme);
    	return rep;		
	}
		
	@DELETE
    @Path("/{num}")
    @Produces(MediaType.APPLICATION_XML)
	public String deletePersonne( @PathParam("num") int num) throws ClassNotFoundException
	{
    	ConnexionBD cbd = new ConnexionBD();
    	String rep = cbd.deleteCredit(num);
    	return rep;		
	}
		
	@PUT
	@Path("/num={num}&comptenum={comptenum}&somme={somme}&taux={taux}&dureemois={dureemois}")
    @Produces(MediaType.APPLICATION_XML)
	public String addCompteCheque(@PathParam("num") int num, @PathParam("comptenum") int comptenum, @PathParam("somme") float somme, @PathParam("taux") float taux, @PathParam("dureemois") int dureemois) throws ClassNotFoundException
	{
    	ConnexionBD cbd = new ConnexionBD();
    	String rep = cbd.addCredit(num, comptenum, somme, taux, dureemois);
    	return rep;		
    }
	    

	
}
