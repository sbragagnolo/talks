/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Scanner;

/**
 *
 * @author carre
 */
public class Guichet {

    static Scanner in = new Scanner(System.in);
    // creation de la banque :
    static Banque bank = new Banque();

    //compteur operations invalides
    static int invalides_ops = 0;

    public static void main(String[] args) {
        int choix = 0;
        do {
            menu();
            System.out.print("votre choix? ");
            choix = in.nextInt();
            switch (choix) {
                case 1: // etat des comptes
                    try {
                        bank.etat();
                    } catch (CompteInexistant ex) {
                        System.out.print("Compte inexistant\n");
                    }
                    break;
                case 2: // creer un nouveau compte
                    menuNouveauCompte();
                    break;
                case 3: // crediter un compte
                    menuCrediter();
                    break;
                case 4: // debiter un compte
                    menuDebiter();
                    break;
                case 5: // effectuer un virement
                    menuVirement();
                    break;
                case 6: //calculer les interets du compte i
                    menuInterets();
                    break;
                case 7: //echeancer le compte i
                    menuEcheancer();
                    break;
                case 0: // quitter
            }
        } while (choix != 0);
        System.out.printf("Operations invalides : %d\n", invalides_ops);

        // bye!
        System.out.println("au revoir");
    }

    static void menu() {
        System.out.println("\n1: etat des comptes\n2: creer un nouveau compte\n3: crediter un compte\n4: debiter un compte\n5: effectuer un virement\n6: interets d'un compte\n7: echeancer un compte\n0: quitter");
    }

    static void menuNouveauCompte() {
        int num = -1;
        int choix;
        System.out.print("Type du compte ?\n1: Compte\n2: Compte Epargne\n");
        choix = in.nextInt();

        switch (choix) {
            case 1:
                num = bank.ouvrirCompte();
                System.out.println("numero= " + num);

                break;
            case 2:
                num = bank.ouvrirCompteEpargne();
                System.out.println("numero= " + num);

                break;
            default:
                System.out.println("Erreur de choix!");

        }
    }

    static void menuCrediter() {
        int num;
        System.out.print("\nnumero du compte? ");
        num = in.nextInt();
        System.out.print("somme? ");
        try {
            bank.crediter(num, in.nextDouble());
        } catch (CompteInexistant ex) {
            System.out.print("Compte inexistant\n");
        }

    }

    static void menuDebiter() {
        int num;
        System.out.print("\nnumero du compte? ");
        num = in.nextInt();
        System.out.print("somme? ");
        try {
            bank.debiter(num, in.nextDouble());
        } catch (CompteInexistant ex) {
            System.out.print("Compte inexistant\n");
        }
    }

    static void menuVirement() {
        int from, to;
        System.out.print("\ncompte a debiter? ");
        from = in.nextInt();
        System.out.print("compte a crediter? ");
        to = in.nextInt();
        System.out.print("somme? ");
        try {
            bank.virement(from, to, in.nextDouble());
        } catch (CompteInexistant ex) {
            System.out.print("Compte inexistant\n");
        }
    }

    static void menuInterets() {
        int num;
        System.out.print("\nnumero du compte? ");
        num = in.nextInt();
        try {
            System.out.println("interets creditables: "+ bank.interets(num));
        } catch (OperationNonValide ex) {
            System.out.println("operation impossible sur ce compte!");
            invalides_ops = invalides_ops + 1;
        } catch (CompteInexistant ex) {
            System.out.print("Compte inexistant\n");
        }
    }

    static void menuEcheancer() {
        int num;
        System.out.print("\nnumero du compte? ");
        num = in.nextInt();
        try {
            bank.echeance(num);
        } catch (OperationNonValide ex) {
            System.out.println("operation impossible sur ce compte!");
            invalides_ops = invalides_ops + 1;
        } catch (CompteInexistant ex) {
            System.out.print("Compte inexistant\n");
        }
    }
}
