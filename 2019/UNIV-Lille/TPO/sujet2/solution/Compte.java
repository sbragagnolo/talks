/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author carre
 */
class Compte {

    double credit, debit;

    Compte(double credit) {
        this.credit = credit;
    }

    void crediter(double x) {
        credit = credit + x;
    }

    void debiter(double x) {
        debit = debit + x;
    }

    double solde() {
        return credit - debit;
    }

    @Override
    public String toString() {
        return "Solde = " + this.solde() + " Debit = " + debit + " Credit = " + credit;
    }

     void virerVers(double x, Compte dest) {
        debiter(x);
        dest.crediter(x);
    }

}
