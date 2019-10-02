/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author carre
 */
public class CompteEpargne extends Compte {

    double taux = 0.05;

    @Override
    public void debiter(double x) {
        if (this.solde() >= x) {
            super.debiter(x);
        }
    }

    public void virerVers(double x, Compte dest) {
        if (this.solde() >= x) {
            debiter(x);
            dest.crediter(x);
        }
    }

    public double interets() {
        return solde() * taux;
    }

    public void echeance() {
        crediter(interets());
    }

    @Override
    public String toString() {
        return super.toString() + "	Taux = " + taux + "  Interets = " + interets();
    }
}
