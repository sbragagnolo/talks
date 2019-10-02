import java.util.*;

public class TestGeometrique {
	public static void main (String argv[]) {
		Scanner in = new Scanner(System.in);
		ProgressionGeometrique s;
		double first,raison;
		int n;
		String cont;
		System.out.print("\npremier terme? ");
		first=in.nextDouble();
		System.out.print("\nraison? ");
		raison=in.nextDouble();
		s = new ProgressionGeometrique(first, raison);
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
}