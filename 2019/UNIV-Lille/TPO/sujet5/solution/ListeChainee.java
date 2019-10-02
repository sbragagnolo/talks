/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author carre
 */
public class ListeChainee<E> extends Liste<E> {

    //implementation
    Cellule<E> first;

    @Override
    protected void primitiveAdd(E x) {
        Cellule<E> tmp = new Cellule<E>(x, first);
        first = tmp;
    }

    @Override
    protected E primitiveGet(int index) {
        Cellule<E> cell = first;
        for (int i = 0; i < index; i++) {
            cell = cell.getNext();
        }
        return cell.getValeur();
    }

    @Override
    public String toString() {
        String tmp = "";
        Cellule cell = first;
        while (cell != null) {
            tmp += cell.getValeur() + " ";
            cell = cell.getNext();
        }
        return tmp;

    }

    public ListeChainee(int max_size) {
        super(max_size);
    }

    protected ListeChainee() {
        super();
    }
}
