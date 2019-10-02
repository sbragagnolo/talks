package lib;

public class Ouvrage {
	
	protected String titre, auteur;
	protected boolean emprunte;
	protected int compteur; // nombre d'emprunts

	public Ouvrage(String tit, String aut) {
		titre=tit; auteur=aut;
	}
	public String toString() {
		return titre+" "+auteur+" disponible="+!emprunte+" compteur="+compteur;
	}
	public void emprunter() throws NonDisponibleException {
		  if (emprunte) throw new NonDisponibleException();
		  else {
			  emprunte=true; compteur++;
		  }
	}
	public void rendre() {
		emprunte=false;
	}
	int getCompteur() {return compteur;} 
	String getTitre() {return titre;}
}