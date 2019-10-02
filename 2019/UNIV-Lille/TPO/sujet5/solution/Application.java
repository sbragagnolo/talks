/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author carre
 */
public class ApplicationCor {

    public static void main(String[] args) throws ListePleineException {
        Liste<Rectangle> lRectangles = new ListeContigue<Rectangle>(10);
        Liste<Cercle> lCercles = new ListeContigue<Cercle>(10);
	
	// Q3.1
        initRectangles(lRectangles);
        printListe(lRectangles);
        initCercles(lCercles);
        printListe(lCercles);

        // Q3.2 contrainte extends
        System.out.println("Contrainte extends");
        etat(lRectangles);
        etat(lCercles);

        // Q3.3 contrainte super
        Liste<Rectangle> lr = new ListeChainee<Rectangle>(10);
        Liste<Figure> lFigures = new ListeChainee<Figure>(100);
        System.out.println("Contrainte super");
        appendRects(lr, lRectangles); // (a)
        etat(lr);
        appendRects(lFigures, lRectangles); // (b)
        etat(lFigures);
        //appendRects(lr, lCercles); // (c)

        Liste<Cercle> lc = new ListeChainee<Cercle>(10);
        appendCercles(lc, lCercles); // (a)
        etat(lc);
        appendCercles(lFigures, lCercles); // (b)
        etat(lFigures);
        //appendCercles(lc, lRectangles);


        //Q3.4 Generalisation (restreinte aux types de figures)
        System.out.println("Generalisation (restreinte aux types de figures)");

        lr = new ListeChainee<Rectangle>(10);
        lc = new ListeChainee<Cercle>(10);
        lFigures = new ListeChainee<Figure>(10);

        Liste<Figure> lf = new ListeChainee<Figure>(100);

        System.out.println("<T extends Figure> void append(Liste<? super T> dest, Liste<T> src");
        System.out.println("applies to any T <= Figure");
        append(lr, lRectangles);
        etat(lr); // (a)
        append(lFigures, lRectangles);
        etat(lFigures);// (b)
        // append(lr, lCercles); // (c)
        append(lf, lFigures);
        etat(lf);

	//Q3.4 Generalisation (T quelconque)
        System.out.println("Generalisation (T quelconque)");
	System.out.println("figures...");
        append(lr, lRectangles);
        etat(lr); // (a)
        append(lFigures, lRectangles);
        etat(lFigures);// (b)
        // append(lr, lCercles); // (c)
        append(lf, lFigures);
        etat(lf);
	// comptes bancaires...
	Liste<Compte> lcptes = new ListeChainee<Compte>(100);
	Liste<CompteEpargne> lce = new ListeChainee<CompteEpargne>(100);
	lcptes.add(new Compte());
	lcptes.add(new Compte());
	lce.add(new CompteEpargne());
	lce.add(new CompteEpargne());

	System.out.println("comptes...");
	System.out.println("lcptes="+lcptes);
	append(lcptes, lce);
	System.out.println("lcptes="+lcptes);
	// append(lce,lcptes);
}

    static void initRectangles(Liste<Rectangle> l) {
        try {
            l.add(new Rectangle(0.0, 0.0, 10.0, 20.0));
            l.add(new Rectangle(50.0, 50.0, 150.0, 250.0));
            l.add(new Rectangle(100.0, 100.0, 1100.0, 2100.0));
        } catch (ListePleineException ex) {
            System.out.println("full!");
        }
    }

    static void initCercles(Liste<Cercle> l) {
        try {
            l.add(new Cercle());
            l.add(new Cercle());
            l.add(new Cercle());
        } catch (ListePleineException ex) {
            System.out.println("full!");
        }
    }

    static void printListe(Liste<?> l) {
        for (int i = 0; i < l.size(); i++) {
            System.out.println("i=" + i + " " + l.get(i));
        }
    }

    static double cumulSurfaces(Liste<? extends Figure> l) {
        double somme = 0.0; // des cumulSurfaces
        for (int i = 0; i < l.size(); i++) {
            somme += l.get(i).surface();
        }
        return somme;
    }

    static <T extends Figure> T maxSurface(Liste<T> l) {
        T tmp = null;
        double maxSurf = 0.0;
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i).surface() >= maxSurf) {
                maxSurf = l.get(i).surface();
                tmp = l.get(i);
            }
        }
        return tmp;
    }

    static void etat(Liste<? extends Figure> l) {
        printListe(l);
        System.out.println("cumul surfaces :" + cumulSurfaces(l));
        System.out.println("max figure:" + maxSurface(l));
        System.out.println();
    }

    static void appendRects(Liste<? super Rectangle> dest, Liste<Rectangle> src) throws ListePleineException {
        for (int i = 0; i < src.size(); i++) {
            dest.add(src.get(i));
        }
    }

    static void appendCercles(Liste<? super Cercle> dest, Liste<Cercle> src) throws ListePleineException {
        for (int i = 0; i < src.size(); i++) {
            dest.add(src.get(i));
        }
    }

    /* Q3.4 generalisation restreinte aux types de figures : applies to any T <= Figure
    static <T extends Figure> void append(Liste<? super T> dest, Liste<T> src) throws ListePleineException {
    	for (int i = 0; i < src.size(); i++) {
            dest.add(src.get(i));
	}
    }*/
    

    /* Q3.4 Generalisation (T quelconque) */
    static <T> void append(Liste<? super T> dest, Liste<T> src) throws ListePleineException {
    	for (int i = 0; i < src.size(); i++) {
            dest.add(src.get(i));
	}
    }
}

