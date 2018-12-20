package com.banque.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;

import com.banque.beans.Compte;
import com.banque.beans.CompteCheque;
import com.banque.beans.CompteEpargne;
import com.banque.beans.Credit;
import com.banque.beans.Personne;

public class ConnexionBD extends HttpServlet
{
	String url = "jdbc:postgresql://localhost:5432/BANQUE";
    String user = "postgres";
    String passwd = "nourou";
    String forName = "org.postgresql.Driver";
    
    public String ajoutDB(String r) throws ClassNotFoundException 
    {
    	String updt="OK";
    	int maj=0;
    	try 
	    {
	    	Class.forName("org.postgresql.Driver");
		    Connection conn = DriverManager.getConnection(this.url, this.user, this.passwd);
		    Statement state = conn.createStatement();
		    maj = state.executeUpdate(r);
		    if (maj==0)
		    	updt="Echec de l'ajout";
	    } 
    	catch (SQLException e) 
    	{
    		updt=e.getMessage();
	    	e.printStackTrace();
	    } 
    	return updt;
    }

    public String update(String r) throws ClassNotFoundException 
    {
    	String updt="OK";
    	int maj=0;
    	try 
	    {
	    	Class.forName(forName);
		    Connection conn = DriverManager.getConnection(this.url, this.user, this.passwd);
		    Statement state = conn.createStatement();
		    maj = state.executeUpdate(r);
		    if (maj==0)
		    	updt="Echec de l'ajout";
	    } 
    	catch (SQLException e) 
    	{
    		updt=e.getMessage();
	    	e.printStackTrace();
	    } 
    	return updt;
    }
    
    public int envoieRequete(String r)
	{
	    try 
	    {
	    	Class.forName(forName);
		    Connection conn = DriverManager.getConnection(this.url, this.user, this.passwd);
		    //Création d'un objet Statement
		    Statement state = conn.createStatement();
			//L'objet ResultSet contient le résultat de la requête SQL
			try
			{
			    	  ResultSet res = state.executeQuery(r);
			    	  ResultSetMetaData data = res.getMetaData();
				      System.out.println("\n");
				      //On affiche le nom des colonnes
				      for(int i = 1; i <= data.getColumnCount(); i++)
				        System.out.print("\t\t" + data.getColumnName(i).toUpperCase() + "\t\t*");
				         
				      System.out.println("\n");
				         
			          while(res.next())
			          {         
			              for(int i = 1; i <= data.getColumnCount(); i++)
			              {
			            	  if (res.getObject(i)==null)
			            	  {
			            		  System.out.println("\t\tnull\t\t|");
			            		  continue;
			            	  }
			            	  System.out.print("\t\t" + res.getObject(i).toString() + "\t\t |");
			              }
			                
			                  
			              System.out.println("\n");
			          }
			      }
			      catch(SQLException e)
			      {
			    	  System.out.println(e.getMessage());
			      }
		    
			      return 0;
		    }
		    catch (Exception e) 
		   	{
		    	e.printStackTrace();
		    	return -1;
	    	} 
		}
		
    public float recupfloat(String r)
	{
		    float result = -1;
		    try 
		    {
			      Class.forName(forName);
			      Connection conn = DriverManager.getConnection(this.url, this.user, this.passwd);
			      Statement state = conn.createStatement();
			      try
			      {
			    	  ResultSet res = state.executeQuery(r);
			    	  ResultSetMetaData data = res.getMetaData();
				      System.out.println("\n");
			    	  int i=1;
			    	  while (res.next()) 
			    	  {
			    		  result=res.getFloat(i);
			    	  }
			      }
			      catch(SQLException e)
			      {
			    	  System.out.println(e.getMessage());
			      }
			      return result;
		    }
		    catch (Exception e) 
		   	{
		    	e.printStackTrace();
		    	return result;
	    	} 
		}
    
    public String delete(String r) throws ClassNotFoundException 
    {
    	String updt="OK";
    	int maj=0;
    	try 
	    {
	    	Class.forName(forName);
		    Connection conn = DriverManager.getConnection(this.url, this.user, this.passwd);
		    Statement state = conn.createStatement();
		    maj = state.executeUpdate(r);
		    if (maj==0)
		    	updt="Echec de la suppresion";
	    } 
    	catch (SQLException e) 
    	{
    		updt=e.getMessage();
	    	e.printStackTrace();
	    } 
    	return updt;
    }
    
    public int recupint(String r)
	{
		    int result = -1;
		    try 
		    {
			      Class.forName(forName);
			      Connection conn = DriverManager.getConnection(this.url, this.user, this.passwd);
			      Statement state = conn.createStatement();
			      try
			      {
			    	  ResultSet res = state.executeQuery(r);
			    	  ResultSetMetaData data = res.getMetaData();
			    	  int i=1;
			    	  while (res.next()) 
			    	  {
			    		  result=res.getInt(i);
			    	  }
			      }
			      catch(SQLException e)
			      {
			    	  System.out.println(e.getMessage());
			      }
			      return result;
		    }
		    catch (Exception e) 
		   	{
		    	e.printStackTrace();
		    	return result;
	    	} 
		}
    
    public String recupString(String r)
    {
    	String result ="";
	    try 
	    {
		      Class.forName(forName);
		      Connection conn = DriverManager.getConnection(this.url, this.user, this.passwd);
		      Statement state = conn.createStatement();		      
		      try
		      {
		    	  ResultSet res = state.executeQuery(r);
		    	  ResultSetMetaData data = res.getMetaData();
		    	  int i=1;
		    	  while (res.next()) 
		    	  {
		    		  result=res.getString(i);
		    	  }
		      }
		      catch(SQLException e)
		      {
		    	  System.out.println(e.getMessage());
		      }
		      return result;
	    }
	    catch (Exception e) 
	   	{
	    	e.printStackTrace();
	    	return result;
    	} 
    }

    public Personne getPersonne(int id)
    {
    	
    	String r = "select nom from personne where id="+id;
    	String nom,prenom,daten; 
    	nom = recupString(r);
    	r="select prenom from personne where id="+id;
    	prenom=recupString(r);
    	r="select personne.datenaissance from personne where id="+id;
    	daten=recupString(r);
    	r="select nbcompte from personne where id="+id;
    	Personne p = new Personne(id,prenom,nom,daten);
    	p.setNbCompte(recupint(r));
    	return p;
    }

    public String deletePersonne(int id) throws ClassNotFoundException
    {
    	String r ="delete from personne where id="+id;
    	String rep = delete(r);
    	return rep;
    }

    public String addPersonne(int id, String nom, String prenom, String daten) throws ClassNotFoundException
    {
    	String r ="insert into personne (id, prenom, nom, datenaissance, nbcompte) values ("+id+",'"+prenom+"','"+nom+"','"+daten+"',"+0+")";
    	String rep = ajoutDB(r);
    	return rep;
    }

    public ArrayList getCompteOfPersonne(int id_personne)
    {
    	ArrayList c = new ArrayList();
    	String r = "SELECT * FROM compte WHERE persoid="+id_personne;
	    try 
	    {
		      Class.forName(forName);
		      Connection conn = DriverManager.getConnection(this.url, this.user, this.passwd);
		      Statement state = conn.createStatement();		      
		      try
		      {
		    	  ResultSet res = state.executeQuery(r);
		    	  ResultSetMetaData data = res.getMetaData();
		    	  int i=1;
		    	  while (res.next()) 
		    	  {
		    		  int num = res.getInt("num");
		    		  int persoid = res.getInt("persoid");
		    		  Personne p = getPersonne(persoid);
		    		  float somme = res.getFloat("somme");
		    		  String info =res.getString("typecompte");
		    		  if(info.contains("cheque"))
		    		  {
		    			  int numcarte = res.getInt("numcarte");
		    			  float decouvert = res.getFloat("decouvert");
		    			  CompteCheque cc = new CompteCheque(num,p, somme,numcarte,decouvert);
		    			  c.add(cc);
		    		  }
		    		  else
		    		  {
		    			  float plafond = res.getFloat("plafond");
		    			  float taux = res.getFloat("taux");
		    			  CompteEpargne ce = new CompteEpargne(num, p, somme, plafond, taux);
		    			  c.add(ce);
		    		  }
		    			  
		    	  }
		      }
		      catch(SQLException e)
		      {
		    	  System.out.println(e.getMessage());
		      }
		      return c;
	    }
	    catch (Exception e) 
	   	{
	    	e.printStackTrace();
	    	return c;
    	} 
    	
    }

    public ArrayList getCreditOfPersonne(int id_personne)
    {
    	ArrayList c = new ArrayList();
    	String r = "SELECT credit.* FROM credit, personne, compte WHERE compte.persoid=personne.id and credit.comptenum=compte.num and compte.persoid="+id_personne;
	    try 
	    {
		      Class.forName(forName);
		      Connection conn = DriverManager.getConnection(this.url, this.user, this.passwd);
		      Statement state = conn.createStatement();		      
		      try
		      {
		    	  ResultSet res = state.executeQuery(r);
		    	  ResultSetMetaData data = res.getMetaData();
		    	  int i=1;
		    	  while (res.next()) 
		    	  {
		    		  int num = res.getInt("num");
		    		  int comptenum = res.getInt("comptenum");
		    		  CompteCheque cc = (CompteCheque) getCompte(comptenum);
		    		  float somme = res.getFloat("somme");
		    		  float taux = res.getFloat("taux");
		    		  int dureemois = res.getInt("dureemois");
		    		  float mensualite = res.getFloat("mensualite");
		    		  float sommerestante = res.getFloat("sommerestante");
		    		  Credit cr = new Credit(num, cc, somme, taux, dureemois, sommerestante, mensualite);
		    		  c.add(cr);
		    	  }
		      }
		      catch(SQLException e)
		      {
		    	  System.out.println(e.getMessage());
		      }
		      return c;
	    }
	    catch (Exception e) 
	   	{
	    	e.printStackTrace();
	    	return c;
    	} 
    }
    
    public ArrayList getCreditOfCompte(int num_compte)
    {
    	ArrayList c = new ArrayList();
    	String r = "SELECT credit.* FROM credit, compte WHERE credit.comptenum=compte.num and compte.num="+num_compte;
	    try 
	    {
		      Class.forName(forName);
		      Connection conn = DriverManager.getConnection(this.url, this.user, this.passwd);
		      Statement state = conn.createStatement();		      
		      try
		      {
		    	  ResultSet res = state.executeQuery(r);
		    	  ResultSetMetaData data = res.getMetaData();
		    	  int i=1;
		    	  while (res.next()) 
		    	  {
		    		  int num = res.getInt("num");
		    		  int comptenum = res.getInt("comptenum");
		    		  CompteCheque cc = (CompteCheque) getCompte(comptenum);
		    		  float somme = res.getFloat("somme");
		    		  float taux = res.getFloat("taux");
		    		  int dureemois = res.getInt("dureemois");
		    		  float mensualite = res.getFloat("mensualite");
		    		  float sommerestante = res.getFloat("sommerestante");
		    		  Credit cr = new Credit(num, cc, somme, taux, dureemois, sommerestante, mensualite);
		    		  c.add(cr);
		    	  }
		      }
		      catch(SQLException e)
		      {
		    	  System.out.println(e.getMessage());
		      }
		      return c;
	    }
	    catch (Exception e) 
	   	{
	    	e.printStackTrace();
	    	return c;
    	} 
    }
    
    public Compte getCompte(int numero)
    {
    	Compte c = new Compte();
    	String r = "SELECT * FROM compte WHERE num="+numero;
	    try 
	    {
		      Class.forName(forName);
		      Connection conn = DriverManager.getConnection(this.url, this.user, this.passwd);
		      Statement state = conn.createStatement();		      
		      try
		      {
		    	  ResultSet res = state.executeQuery(r);
		    	  ResultSetMetaData data = res.getMetaData();
		    	  int i=1;
		    	  while (res.next()) 
		    	  {
		    		  int num = res.getInt("num");
		    		  int persoid = res.getInt("persoid");
		    		  Personne p = getPersonne(persoid);
		    		  float somme = res.getFloat("somme");
		    		  String info =res.getString("typecompte");
		    		  if(info.contains("que"))
		    		  {
		    			  int numcarte = res.getInt("numcarte");
		    			  float decouvert = res.getFloat("decouvert");
		    			  CompteCheque cc = new CompteCheque(num,p, somme,numcarte,decouvert);
		    			  c = cc;
		    		  }
		    		  else
		    		  {
		    			  float plafond = res.getFloat("plafond");
		    			  float taux = res.getFloat("taux");
		    			  CompteEpargne ce = new CompteEpargne(num, p, somme, plafond, taux);
		    			  c = ce;
		    		  }
		    			  
		    	  }
		      }
		      catch(SQLException e)
		      {
		    	  System.out.println(e.getMessage());
		      }
		      return c;
	    }
	    catch (Exception e) 
	   	{
	    	e.printStackTrace();
	    	return c;
    	} 
    	
    }

    public ArrayList getCredit(int numero)
    {
    	ArrayList c = new ArrayList();
    	String r = "SELECT * FROM credit WHERE num="+numero;
	    try 
	    {
		      Class.forName(forName);
		      Connection conn = DriverManager.getConnection(this.url, this.user, this.passwd);
		      Statement state = conn.createStatement();		      
		      try
		      {
		    	  ResultSet res = state.executeQuery(r);
		    	  ResultSetMetaData data = res.getMetaData();
		    	  int i=1;
		    	  while (res.next()) 
		    	  {
		    		  int num = res.getInt("num");
		    		  int comptenum = res.getInt("comptenum");
		    		  CompteCheque cc = (CompteCheque) getCompte(comptenum);
		    		  float somme = res.getFloat("somme");
		    		  float taux = res.getFloat("taux");
		    		  int dureemois = res.getInt("dureemois");
		    		  float mensualite = res.getFloat("mensualite");
		    		  float sommerestante = res.getFloat("sommerestante");
		    		  Credit cr = new Credit(num, cc, somme, taux, dureemois, sommerestante, mensualite);
		    		  c.add(cr);
		    	  }
		      }
		      catch(SQLException e)
		      {
		    	  System.out.println(e.getMessage());
		      }
		      return c;
	    }
	    catch (Exception e) 
	   	{
	    	e.printStackTrace();
	    	return c;
    	} 
    	
    }
    
    public ArrayList getAllPersonne()
    {
    	ArrayList c = new ArrayList();
    	String r = "SELECT * FROM personne ";
	    try 
	    {
		      Class.forName(forName);
		      Connection conn = DriverManager.getConnection(this.url, this.user, this.passwd);
		      Statement state = conn.createStatement();		      
		      try
		      {
		    	  ResultSet res = state.executeQuery(r);
		    	  ResultSetMetaData data = res.getMetaData();
		    	  int i=1;
		    	  while (res.next()) 
		    	  {
		    		  int id = res.getInt("id");
		    		  String prenom = res.getString("prenom");
		    		  String daten = res.getString("datenaissance");
		    		  String nom =res.getString("nom");
		    		  int nbcompte = res.getInt("nbcompte");
		    		  Personne p = new Personne(id, prenom, nom, daten, nbcompte);
		    		  c.add(p);
		    	  }
		    			  
		      }
		      catch(SQLException e)
		      {
		    	  System.out.println(e.getMessage());
		      }
		      return c;
	    }
	    catch (Exception e) 
	   	{
	    	e.printStackTrace();
	    	return c;
    	} 
    }
    
    public ArrayList getAllCompte()
    {
    	ArrayList c = new ArrayList();
    	String r = "SELECT * FROM compte ";
	    try 
	    {
		      Class.forName(forName);
		      Connection conn = DriverManager.getConnection(this.url, this.user, this.passwd);
		      Statement state = conn.createStatement();		      
		      try
		      {
		    	  ResultSet res = state.executeQuery(r);
		    	  ResultSetMetaData data = res.getMetaData();
		    	  int i=1;
		    	  while (res.next()) 
		    	  {
		    		  int num = res.getInt("num");
		    		  int persoid = res.getInt("persoid");
		    		  Personne p = getPersonne(persoid);
		    		  float somme = res.getFloat("somme");
		    		  String info =res.getString("typecompte");
		    		  if(info.contains("cheque"))
		    		  {
		    			  int numcarte = res.getInt("numcarte");
		    			  float decouvert = res.getFloat("decouvert");
		    			  CompteCheque cc = new CompteCheque(num,p, somme,numcarte,decouvert);
		    			  c.add(cc);
		    		  }
		    		  else
		    		  {
		    			  float plafond = res.getFloat("plafond");
		    			  float taux = res.getFloat("taux");
		    			  CompteEpargne ce = new CompteEpargne(num, p, somme, plafond, taux);
		    			  c.add(ce);
		    		  }
		    			  
		    	  }
		    			  
		      }
		      catch(SQLException e)
		      {
		    	  System.out.println(e.getMessage());
		      }
		      return c;
	    }
	    catch (Exception e) 
	   	{
	    	e.printStackTrace();
	    	return c;
    	} 
    }
    
    public ArrayList getAllCredit()
    {
    	ArrayList c = new ArrayList();
    	String r = "SELECT * FROM credit ";
	    try 
	    {
		      Class.forName(forName);
		      Connection conn = DriverManager.getConnection(this.url, this.user, this.passwd);
		      Statement state = conn.createStatement();		      
		      try
		      {
		    	  ResultSet res = state.executeQuery(r);
		    	  ResultSetMetaData data = res.getMetaData();
		    	  int i=1;
		    	  while (res.next()) 
		    	  {
		    		  int num = res.getInt("num");
		    		  int comptenum = res.getInt("comptenum");
		    		  CompteCheque cc = (CompteCheque) getCompte(comptenum);
		    		  float somme = res.getFloat("somme");
		    		  float taux = res.getFloat("taux");
		    		  int dureemois = res.getInt("dureemois");
		    		  float mensualite = res.getFloat("mensualite");
		    		  float sommerestante = res.getFloat("sommerestante");
		    		  Credit cr = new Credit(num, cc, somme, taux, dureemois, sommerestante, mensualite);
		    		  c.add(cr);
		    	  }
		    			  
		      }
		      catch(SQLException e)
		      {
		    	  System.out.println(e.getMessage());
		      }
		      return c;
	    }
	    catch (Exception e) 
	   	{
	    	e.printStackTrace();
	    	return c;
    	} 
    }

    public String deleteCompte(int num) throws ClassNotFoundException
    {
    	String r ="delete from compte where num="+num;
    	String rep = delete(r);
    	return rep;
    }
    
    public String deleteCredit(int num) throws ClassNotFoundException
    {
    	String r ="delete from credit where num="+num;
    	String rep = delete(r);
    	return rep;
    }

    public String addCompteCheque(int num, int id_personne, float solde, float decouvert) throws ClassNotFoundException
    {
    	int numcarte=(int) (Math.random() * ( 2147483647 - 0 ));
    	String r ="insert into compte (num, persoid, somme, decouvert, numcarte, typecompte) values ("+num+",'"+id_personne+"','"+solde+"','"+decouvert+"',"+numcarte+",'Compte Chèque')";
    	String rep = ajoutDB(r);
    	return rep;
    }
    
    public String addCompteEpargne(int num, int id_personne, float solde, float taux, float plafond) throws ClassNotFoundException
    {
    	int numcarte=(int) (Math.random() * ( 2147483647 - 0 ));
    	String r ="insert into compte (num, persoid, somme, taux, plafond, typecompte) values ("+num+",'"+id_personne+"','"+solde+"','"+taux+"',"+plafond+",'Compte Epargne')";
    	String rep = ajoutDB(r);
    	return rep;
    }
    
    public String addCredit(int num, int comptenum, float somme, float taux, int dureemois) throws ClassNotFoundException
    {
    	Compte c = getCompte(comptenum);
    	if(c.getInfo().contains("pargne"))
    		return "Impossible d'associer un crédit a un compte épargne";
    	float sommerestante = somme + somme*taux;
    	float mensualite = sommerestante/dureemois;
    	String r ="insert into credit (num, comptenum, somme, taux, dureemois, mensualite, sommerestante) values ("+num+",'"+comptenum+"','"+somme+"','"+taux+"',"+dureemois+","+mensualite+","+sommerestante+")";
    	String rep = ajoutDB(r);
    	return rep;
    }

    public String retraitCompte(int num,float retrait) throws ClassNotFoundException
    {
    	String rep;
    	Compte c = getCompte(num);
    	if(c.getInfo().contains("que"))
    		rep=retraitCompteCheque(num,retrait);
    	else
    		rep=retraitCompteEpargne(num,retrait);
    	return rep;
    }
    
    public String retraitCompteCheque(int num, float retrait) throws ClassNotFoundException
    {
    	CompteCheque c = (CompteCheque)getCompte(num);
    	if(!c.getInfo().contains("que"))
    		return "Erreur il s'agit d'un compte épargne";
    	float decouvert = c.getDecouvertAutorise();
    	float solde = c.getSolde();
    	if(!(solde-retrait >= -decouvert))
    		return "Solde insuffisant";
		String r = "update compte set somme = somme - "+retrait+"  where num ="+num+";";
		String rep= update(r);
		return rep;
    }
    
    public String retraitCompteEpargne(int num, float retrait) throws ClassNotFoundException
    {
    	CompteEpargne c = (CompteEpargne)getCompte(num);
    	if(!c.getInfo().contains("argne"))
    		return "Erreur il s'agit d'un compte chèque";
    	float solde = c.getSolde();
    	if(!(solde-retrait >= 0))
    		return "Solde insuffisant";
		String r = "update compte set somme = somme - "+retrait+"  where num ="+num+";";
		String rep= update(r);
		return rep;
    }
    
    public String getInteret(int num)
    {
    	String rep;
    	Compte c = getCompte(num);
    	if(!c.getInfo().contains("argne"))
    		rep = "Erreur il s'agit d'un compte chèque";
    	else
    	{
    		CompteEpargne ce = (CompteEpargne)getCompte(num);
    		float interet = ce.getTaux() * ce.getSolde();
    		rep="interet: "+interet;
    	}
    	return rep;
    }
    
    public String depotCompte(int num,float depot) throws ClassNotFoundException
    {
    	String rep;
    	Compte c = getCompte(num);
    	if(c.getInfo().contains("que"))
    		rep=depotCompteCheque(num,depot);
    	else
    		rep=depotCompteEpargne(num,depot);
    	return rep;
    }
    
    public String depotCompteCheque(int num, float depot) throws ClassNotFoundException
    {
    	CompteCheque c = (CompteCheque)getCompte(num);
    	if(!c.getInfo().contains("que"))
    		return "Erreur il s'agit d'un compte épargne";
    	float decouvert = c.getDecouvertAutorise();
		String r = "update compte set somme = somme - "+depot+"  where num ="+num+";";
		String rep= update(r);
		return rep;
    }
    
    public String depotCompteEpargne(int num, float depot) throws ClassNotFoundException
    {
    	CompteEpargne c = (CompteEpargne)getCompte(num);
    	if(!c.getInfo().contains("argne"))
    		return "Erreur il s'agit d'un compte chèque";
    	float solde = c.getSolde();
    	float plafond = c.getPlafond();
    	if((solde+depot > plafond))
    		return "Dépot impossible: plafond = "+plafond;
		String r = "update compte set somme = somme + "+depot+"  where num ="+num+";";
		String rep= update(r);
		return rep;
    }

    public String etatCompteCheque(int num) throws ClassNotFoundException
    {
    	Compte c = getCompte(num);
    	if(!c.getInfo().contains("que"))
    		return "Erreur il s'agit d'un compte épargne";
    	float solde = c.getSolde();
    	String rep;
    	if(solde>=0)
    		rep = "Compte n°"+c.getNumero()+" est saint.";
    	else
    		rep = "Compte n°"+c.getNumero()+" est a découvert.";
		return rep;
    }

    public String payerMensualiteCredit(int num) throws ClassNotFoundException
    {
    	String rep;
    	ArrayList credits = getCredit(num);
    	Credit c = (Credit)credits.get(0);
    	CompteCheque cc = c.getCmpt();
    	rep = retraitCompte(cc.getNumero(),c.getMensualite());
    	if(rep.contains("OK"))
    	{
    		String r = "update credit set sommerestante = sommerestante - "+c.getMensualite()+"  where num ="+c.getNumCredit()+";";
    		rep+=update(r);
    		r = "update credit set dureemois = dureemois - 1 where num ="+c.getNumCredit()+";";
    		rep+=update(r);
    	}
    	else
    		rep+="\nLa mensualité n'a pas pu être payé";
		return rep;
    }
    
    public String payerAnticipationCredit(int num, float somme) throws ClassNotFoundException
    {
    	String rep;
    	ArrayList credits = getCredit(num);
    	Credit c = (Credit)credits.get(0);
    	CompteCheque cc = c.getCmpt();
    	rep = retraitCompte(cc.getNumero(),somme);
    	if(rep.contains("OK"))
    	{
    		String r = "update credit set sommerestante = sommerestante - "+somme+"  where num ="+c.getNumCredit()+";";
    		rep+=update(r);
    		r = "update credit set mensualite = sommerestante/dureemois where num ="+c.getNumCredit()+";";
    		rep+=update(r);
    	}
    	else
    		rep+="\nLe payment a été refusé";
		return rep;
    }
}


