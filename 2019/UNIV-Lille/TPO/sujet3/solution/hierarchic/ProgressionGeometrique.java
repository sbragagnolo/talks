public class ProgressionGeometrique extends Progression {
	
	public ProgressionGeometrique(double premier, double r) {
		super(premier,r);
	}

	public void next() {
		termes[rang+1]=termes[rang]*raison;
		rang++;
	}
}	