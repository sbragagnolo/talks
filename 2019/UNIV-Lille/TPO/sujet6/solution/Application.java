import lib.*;
import elib.*;

public class Application {
 public static void main(String[] args) {
	Bibliotheque bib = new Bibliotheque();

	bib.add("I101",new Ouvrage("C","Kernighan"));
	bib.add("L202",new Ouvrage("Germinal","Zola"));
	bib.add("S303",new Ouvrage("Parapente","Ali Gali"));
	bib.add("I345",new Ouvrage("Java","Eckel"));
	
	bib.listing();
	
	System.out.println("array par titre:");
	for(Ouvrage x : bib.arrayTitres())
		System.out.println(x);
	
	System.out.print("collection par titre:");
	System.out.println(bib.collectionTitres());
	
	 BibliothequeElectronique ebib = new  BibliothequeElectronique();
	 ebib.add("I101",new Ouvrage("C","Kernighan"));
	 ebib.add("L202",new Ouvrage("Germinal","Zola"));
	 ebib.add("S303",new Ouvrage("Parapente","Ali Gali"));
	 ebib.add("I345",new Ouvrage("Java","Eckel"));
	 
	 ebib.listing(new Display());
	 
	
 }
}