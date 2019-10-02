package abonnements;

import lib.Ouvrage;

public class Revue extends Ouvrage{
	int numero;
	public Revue(String tit, String aut, int num) {
		super(tit, aut);
		numero=num;
	}
	public String toString() {
		return super.toString()+"numero="+numero;
	}
}
