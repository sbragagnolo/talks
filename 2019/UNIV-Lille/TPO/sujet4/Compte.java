public class Compte {
 //champs
 double credit, debit;
 //methodes
 public void crediter(double v) {
  credit = credit + v;
 }
 public void debiter(double v) {
  debit = debit + v;
 }
 public double solde() {
  return (credit - debit);
 }
 public void virerVers(double v, Compte autre) {
 }
 public String toString() {
  return "solde=" + this.solde() + "debit= " + debit + " credit= " + credit;
 }
}