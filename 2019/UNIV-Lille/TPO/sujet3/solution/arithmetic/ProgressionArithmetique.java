public class ProgressionArithmetique {
	protected final static int MAX = 100;
	protected double[] termes = new double[MAX];
	protected double raison;
	protected int rang;

	public ProgressionArithmetique() {this(0,1);}
	public ProgressionArithmetique(double premier, double r) {
		termes[0]=premier;
		raison=r;
	}

	public double getTerme() {
		return termes[rang];
	}
	public void next() {
		termes[rang+1]=termes[rang]+raison;
		rang++;
	}
	public void next(int n) {
		for (int i=0; i<n; i++) next();
	}
	public String toString() {
		String res = "";
		for (int i=0; i<= rang; i++) res=res+" "+termes[i];
		return res;
	}
}	