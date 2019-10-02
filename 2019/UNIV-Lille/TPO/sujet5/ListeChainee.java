public class ListeChainee <E> extends Liste<E> {
    Cellule<E> first; //implementation chainee

    // constructeurs
    protected ListeChainee() {
        super();
    }

    public ListeChainee(int max_size) {
        super(max_size);
    }

    // methodes
    protected void primitiveAdd(E x) {
        Cellule<E> tmp = new Cellule<E>(x, first);
        first = tmp;
    }
    protected E primitiveGet(int index) {
        Cellule<E> cell = first;
        for (int i = 0; i < index; i++) {
            cell = cell.getNext();
        }
        return cell.getValeur();
    }
}
