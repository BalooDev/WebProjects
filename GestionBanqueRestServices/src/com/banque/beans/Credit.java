package com.banque.beans;


public class Credit 
{
	private CompteCheque cmpt;
	private int numCredit;
	private float somme;
	private float taux;
	private int dureeMois;
	private float sommeRestante;
	private float mensualite;
	
	public Credit(int num, CompteCheque cc, float somme, float taux, int dureeMois, float sommeRestante, float mensualite)
	{
		setNumCredit(num);
		setCmpt(cc);
		setSomme(somme);
		setTaux(taux);
		setDureeMois(dureeMois);
		setSommeRestante(sommeRestante);
		setMensualite(mensualite);
	}
	
	public CompteCheque getCmpt() {
		return cmpt;
	}
	public void setCmpt(CompteCheque cmpt) {
		this.cmpt = cmpt;
	}
	public int getNumCredit() {
		return numCredit;
	}
	public void setNumCredit(int numCredit) {
		this.numCredit = numCredit;
	}
	public float getSomme() {
		return somme;
	}
	public void setSomme(float somme) {
		this.somme = somme;
	}
	public float getTaux() {
		return taux;
	}
	public void setTaux(float taux) {
		this.taux = taux;
	}
	public int getDureeMois() {
		return dureeMois;
	}
	public void setDureeMois(int dureeMois) {
		this.dureeMois = dureeMois;
	}
	public float getSommeRestante() {
		return sommeRestante;
	}
	public void setSommeRestante(float sommeRestante) {
		this.sommeRestante = sommeRestante;
	}
	public float getMensualite() {
		return mensualite;
	}
	public void setMensualite(float mensualite) {
		this.mensualite = mensualite;
	}

	
}
