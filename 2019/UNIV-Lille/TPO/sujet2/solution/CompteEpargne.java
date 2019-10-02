/**
 *
 * @author carre
 */

class CompteEpargne extends Compte {

	double taux;

	CompteEpargne(double credit, double taux) {
		super(credit);
		this.taux = taux;
	}

	double interets() {
		return solde() * taux;
	}

	void echeance() {
		crediter(interets());
	}

	@Override
	void debiter(double x) {
		if (this.solde() >= x) {
			super.debiter(x);
		}
	}

	@Override
	public String toString() {
		return super.toString() + "	Taux = " + taux + "  Interets = " + interets();
	}

}
