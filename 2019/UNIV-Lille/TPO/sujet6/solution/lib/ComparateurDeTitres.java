package lib;
import java.util.*;

public class ComparateurDeTitres implements Comparator<Ouvrage> {
	public int compare(Ouvrage o1, Ouvrage o2) {
		return o1.getTitre().compareTo(o2.getTitre());
	}
}