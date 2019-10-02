public class ProgressionArithmetique extends Progression {

	public ProgressionArithmetique(double premier, double r) {
		super(premier,r);
	}

	public void next() {
		termes[rang+1]=termes[rang]+raison;
		rang++;
	}
}	