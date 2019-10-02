public class ListeContigue<E> extends Liste<E> {
    E[] tab; //implementation contigue

    // constructeurs

    protected ListeContigue() {
        super();
    }

    public ListeContigue(int max_size) {
        super(max_size);
        tab = (E[])new Object[this.max_size];

    }

    // methodes
    protected void primitiveAdd(E x) {
        this.tab[this.nbElements] = x;
    }
    protected E primitiveGet(int index) {
        return tab[index];
    }
}
