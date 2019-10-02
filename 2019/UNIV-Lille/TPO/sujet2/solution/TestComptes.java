
public class TestComptes {

	public static void main(String[] args) {

		Compte unCompte = null;
		CompteEpargne unCE = null;

		// Typage statique (compile and comment ...)

		//// Compte
		unCompte.crediter(100.0);
		unCompte.debiter(50.0);
		System.out.println(unCompte);

		//// CompteEpargne
		////// Heritage
		unCE.crediter(100.0);
		unCE.debiter(50.0);
		System.out.println(unCE);
		////// Specifiques
		System.out.println(unCE.interets());
		unCE.echeance();
		//////// KO!
		//////// System.out.println(unCompte.interets());
		//////// unCompte.echeance();

		//// Sous-typage
		unCompte = unCE;
		//// unCE = unCompte; // KO!

		// Redefinition de methode
		unCompte = new Compte(1000.0);
		unCE = new CompteEpargne(1000.0, 0.05);
		// ...

		// Typage dynamique ...
		debitInteractif(unCompte); // => type dynamique de c = Compte
		debitInteractif(unCE); // => type dynamique de c = CompteEpargne
		unCompte = unCE;
		debitInteractif(unCompte); // => type dynamique de c = CompteEpargne
	}

	static void debitInteractif(Compte c) {
		// ...
	}
}
