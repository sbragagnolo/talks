import java.util.*;

public class Test {

	static Scanner in = new Scanner(System.in);

	static void manip(Progression s) {
		String cont;
		int n;
		System.out.print("next (y/n)? ");
		cont=in.next();
		while (cont.equals("y")) {
			s.next();
			System.out.println("-> "+s.getTerme());
			System.out.print("next (y/n)? ");
			cont=in.next();
		}
		System.out.print("\nnb termes supplementaires? ");
		n=in.nextInt();
		s.next(n);
		System.out.println("\nprogression\n-> "+s);
	}

	public static void main (String argv[]) {
		Progression s;
		double first, raison;
		int choix;

		System.out.print("\nProgression arithmetique taper 1\nProgression geometrique taper 2\n? ");
		choix=in.nextInt();

		System.out.print("\npremier terme? ");
		first=in.nextDouble();
		System.out.print("\nraison? ");
		raison=in.nextDouble();

		switch (choix) {
			case 1 : manip(new ProgressionArithmetique(first, raison));
			 break;
			case 2 : manip(new ProgressionGeometrique(first, raison));
			 break;
		}
	}
}