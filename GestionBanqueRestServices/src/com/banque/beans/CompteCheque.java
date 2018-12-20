package com.banque.beans;


public class CompteCheque extends Compte
{

	
	private int numeroCarte;
	private float decouvertAutorise;
	
	public CompteCheque(int num, Personne p, float solde, int numcarte, float decouvert)
	{
		this.setNumero(num);
		this.setProprietaire(p);
		this.setSolde(solde);
		this.setInfo("comptecheque");
		this.setDecouvertAutorise(decouvert);
		this.setNumeroCarte(numcarte);
	}
	
	public int getNumeroCarte() {
		return numeroCarte;
	}
	public void setNumeroCarte(int numeroCarte) {
		this.numeroCarte = numeroCarte;
	}
	public float getDecouvertAutorise() {
		return decouvertAutorise;
	}
	public void setDecouvertAutorise(float decouvertAutorise) {
		this.decouvertAutorise = decouvertAutorise;
	}
	
}
