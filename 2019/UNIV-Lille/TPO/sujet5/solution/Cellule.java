/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author carre
 */
public class Cellule<E> {

    E valeur;
    Cellule<E> next;

    public Cellule(E valeur, Cellule<E> next) {
        this.valeur = valeur;
        this.next = next;
    }

    public Cellule<E> getNext() {
        return next;
    }

    public E getValeur() {
        return valeur;
    }

    public void setNext(Cellule<E> next) {
        this.next = next;
    }

    public void setValeur(E valeur) {
        this.valeur = valeur;
    }
}
