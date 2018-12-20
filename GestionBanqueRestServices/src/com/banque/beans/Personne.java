package com.banque.beans;

import java.util.ArrayList;

public class Personne 
{

	private	int id;
	private int nbCompte = 0;
	private String firstName;
	private String lastName;
	private String dateNaissance;
	
	public Personne(int id, String prenom, String nom, String daten)
	{
		setId(id);
		setFirstName(prenom);
		setLastName(nom);
		setDateNaissance(daten);
	}
	public Personne(int id, String prenom, String nom, String daten, int nbcompte)
	{
		setId(id);
		setFirstName(prenom);
		setLastName(nom);
		setDateNaissance(daten);
		setNbCompte(nbcompte);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNbCompte() {
		return nbCompte;
	}
	public void setNbCompte(int nbCompte) {
		this.nbCompte = nbCompte;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	
}
