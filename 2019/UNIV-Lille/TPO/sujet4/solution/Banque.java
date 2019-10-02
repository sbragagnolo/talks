/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author carre
 */
public class Banque {

    static final int MAX = 1000;

    //v.i
    Compte[] comptes = new Compte[MAX];
    int dernier = -1;


    //methodes
    Compte getCompte(int i) throws CompteInexistant {
        Compte s;
        try {
            s = comptes[i];
            if (s == null) {
                throw new CompteInexistant();
            }
        } catch (IndexOutOfBoundsException ex) {
            throw new CompteInexistant();
        }
        return s;
    }

    CompteEpargne getCompteEpargne(int i) throws CompteInexistant,
            OperationNonValide {
        try {
            return (CompteEpargne) getCompte(i);
        } catch (ClassCastException ex) {
            throw new OperationNonValide();
        }
    }

    public int ouvrirCompte() {
        dernier++;
        comptes[dernier] = new Compte();
        return dernier;
    }

    //Partie 2.1
    public int ouvrirCompteEpargne() {
        dernier++;
        comptes[dernier] = new CompteEpargne();
        return dernier;
    }

    public int ouvrirCEL() {
        dernier++;
        comptes[dernier] = new CEL();
        return dernier;
    }

    public void crediter(int i, double x) throws CompteInexistant {
        getCompte(i).crediter(x);
    }

    public void debiter(int i, double x) throws CompteInexistant {
        getCompte(i).debiter(x);
    }

    public double totalSolde() throws CompteInexistant {
        double s = 0.0;
        for (int i = 0; i <= dernier; i++) {
            s += getCompte(i).solde();
        }
        return s;
    }

    public String etat(int i) throws CompteInexistant {
        return getCompte(i).toString();
    }

    public void etat() throws CompteInexistant {
        for (int i = 0; i <= dernier; i++) {
            System.out.printf("Etat du compte numero %d %s\n", i, etat(i));
        }
        System.out.print("Total des soldes : " + totalSolde() + "\n");
    }

    public void virement(int numSrc, int numDest, double x) throws CompteInexistant {
        getCompte(numSrc).virerVers(x, getCompte(numDest));
    }

    public double interets(int i) throws CompteInexistant, OperationNonValide {
        return getCompteEpargne(i).interets();
    }

    public void echeance(int i) throws CompteInexistant, OperationNonValide {
        getCompteEpargne(i).echeance();
    }
}
