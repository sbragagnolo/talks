/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author carre
 */
public class Compte {

    double credit, debit;

    public Compte(double credit, double debit) {
        this.credit = credit;
        this.debit = debit;
    }

    Compte() {
    }

    public double solde() {
        return credit - debit;
    }

    public void crediter(double x) {
        credit = credit + x;
    }

    public void debiter(double x) {
        debit = debit + x;
    }

    public void virerVers(double x, Compte dest) {
        debiter(x);
        dest.crediter(x);
    }

    @Override
    public String toString() {
        return "Solde = " + this.solde() + " Debit = " + debit + " Credit = " + credit;
    }
}
