/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author carre
 */
public class ListeContigue<E> extends Liste<E> {

    //implementation
    E[] tab;

    @Override
    protected void primitiveAdd(E x) {
        this.tab[this.nbElements] = x;
    }

    @Override
    protected E primitiveGet(int index) {
        return tab[index];
    }

    @Override
    public String toString() {
        String tmp = "";
        for (E x : tab) {
            tmp += x + " ";
        }
        return tmp;
    }

    public ListeContigue(int max_size) {
        super(max_size);
	// impossible sur des generic array tab = new E[this.max_size];
	// type erasure ne s'applique pas, et comme E n'existe pas, la creation dynamique ne s'applique pas
	// d'ou, mais avec warning unsafe cast:
        tab = (E[])new Object[this.max_size];
	// unsafe cast parce que les tableaux sont covariants sur le type des elements 
	// (contrairement aux classes generiques),
	// ce qui permettra tjs des choses du genre (qqsoit E!) :
	// Object[] intrus = tab;
	// intrus[this.nbElements++] = new Object(); 
	// et boom (essayer cumulSurfaces() sur une liste de figure
	// d'ou l'interet d'encapsuler le tableau dans ListeContigue
	// remarque que meme pas java.lang.ArrayStoreException a cause de l'erasure (=> Object)
	}

    protected ListeContigue() {
        super();
    }
}
