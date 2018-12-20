package com.banque.beans;

public class CompteEpargne extends Compte
{
	private float plafond;
	private float taux;
	
	public CompteEpargne(int num, Personne p, float solde, float plafond, float taux)
	{
		this.setNumero(num);
		this.setProprietaire(p);
		this.setSolde(solde);
		this.setInfo("compteepargne");
		this.setPlafond(plafond);
		this.setTaux(taux);
	}
		
	
	public float getTaux() 
	{
		return taux;
	}
	public void setTaux(float taux) 
	{
		this.taux = taux;
	}
	public float getPlafond() 
	{
		return plafond;
	}
	public void setPlafond(float plafond) 
	{
		this.plafond = plafond;
	}
	
	
}
