package lib;

import java.util.*;

public class Bibliotheque {
		 protected Map<String,Ouvrage> ouvrages
		   = new TreeMap<String,Ouvrage>();
		 
		 public void add(String code, Ouvrage o) {
		   ouvrages.put(code,o);
		 }
		 
		 public int totalEmprunts() {// parcours des valeurs
		  int total=0;
		  Iterator<Ouvrage> iter = ouvrages.values().iterator();
		  while (iter.hasNext())
		   total=total+iter.next().getCompteur();
		  return total;
		}
		 
		public void listing() {// parcours des cles par "for each"
			  for(String code : ouvrages.keySet())
			   System.out.println(code+":"+ouvrages.get(code));
		}
		public void emprunter(String code) {
			  try {
			   ouvrages.get(code).emprunter();
			  } catch (NullPointerException ex) {
			    System.out.println("l'ouvrage "+code+" n'existe pas");
			  } catch (NonDisponibleException ex) {
			    System.out.println("ouvrage "+code+" non disponible");
			  }
		}
		public void rendre(String code) {
			try {
				ouvrages.get(code).rendre();
			}
			catch (NullPointerException ex) {
				System.out.println("l'ouvrage "+code+" n'existe pas");
			  }
		}
		public Ouvrage[] arrayTitres() {
			Ouvrage[] tmp = ouvrages.values().toArray(new Ouvrage[0]);
			Arrays.sort(tmp, new ComparateurDeTitres());
			return tmp;
		}
		public Collection<Ouvrage> collectionTitres() {
			List<Ouvrage> tmp = new ArrayList<Ouvrage>(ouvrages.values());
			Collections.sort(tmp, new ComparateurDeTitres());
			return tmp;
		}
}
