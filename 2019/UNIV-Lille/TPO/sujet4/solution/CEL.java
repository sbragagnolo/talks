/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author carre
 */
public class CEL extends CompteEpargne {

    double seuil = 1000;

    @Override
    public void debiter(double x) {
        if ((this.solde() - x) >= 0) {
            super.debiter(x);
        }
    }

    public void virerVers(double x, Compte dest) {
        if ((this.solde() - x) >= 0) {
            debiter(x);
            dest.crediter(x);
        }
    }

    @Override
    public String toString() {
        return super.toString() + " Seuil = " + seuil + "\n";
    }
}
