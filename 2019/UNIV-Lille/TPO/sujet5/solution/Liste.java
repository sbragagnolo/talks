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

    public int size() {
        return nbElements;
    }

    public void add(E x) throws ListePleineException {
        if (this.nbElements == this.max_size) {
            throw new ListePleineException();
        } else {
            primitiveAdd(x);
            nbElements++;

        }
    }

    protected abstract void primitiveAdd(E x);

    public E get(int index) throws IndexOutOfBoundsException {
        E tmp = null;
        if (index < 0 || index >= this.nbElements) {
            throw new IndexOutOfBoundsException();
        } else {
            tmp = this.primitiveGet(index);
        }
        return tmp;
    }

    protected abstract E primitiveGet(int index);

    public void fill(E[] t) throws ListePleineException {
        for (E x : t) {
            this.add(x);
        }
    }

    @Override
    public abstract String toString();

    public Liste(int max_size) {
        this.max_size = max_size;
    }

    protected Liste() {
    } // for Java init constraints

    //public boolean remove(E x) ...
    //public void removeAll(E[] t) ...
    //public boolean contains(E x) ...
    //public boolean containsAll(E[] t) ...
}
