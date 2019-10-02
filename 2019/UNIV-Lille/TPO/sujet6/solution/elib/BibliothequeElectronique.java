package elib;
import lib.*;

public class BibliothequeElectronique extends Bibliotheque {
		public void listing(Display on) {
			  for(String code : ouvrages.keySet())
			   on.show(ouvrages.get(code));
		}
}
