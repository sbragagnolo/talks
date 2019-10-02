/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author carre
 */
public abstract class Liste<E> {
    int max_size;
    int nbElements;
    // implementation : see subclasses

    // constructeurs
    protected Liste() {
    }

    public Liste(int max_size) {
        this.max_size = max_size;
    }

    // methodes
    public int size() {return nbElements;}

    public void add(E x) throws ListePleineException {
        if (this.nbElements == this.max_size) {
            throw new ListePleineException();
        } else {
            this.primitiveAdd(x); // generique (inclusion)
            nbElements++;
        }}
    protected abstract void primitiveAdd(E x);

    public void fill(E[] t) throws ListePleineException {
        for (E x : t) {
            this.add(x);
        }
    }
}