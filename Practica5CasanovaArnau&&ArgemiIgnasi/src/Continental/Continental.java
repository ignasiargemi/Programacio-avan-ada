package Continental;

public class Continental {
	private Taulell taulell;
	private static int BUIT = 0;
	private static int PLENA = 1;
	private static int NULA = -1;
	private static int mida = 7;
	
	public Continental() {
		taulell = new Taulell(mida);
		this.SetContingutPos();
	}
	
	private void SetContingutPos() {
		for (int i = 0; i < mida; ++i) {
			for (int j = 0; j < mida; ++j) {
				if (j == 3 && i == 3) this.taulell.SetContingutPos(i, j, BUIT);
				else if ((i < 2 || i > 4) && (j < 2 || j > 4)) this.taulell.SetContingutPos(i, j, NULA);
				else this.taulell.SetContingutPos(i, j, PLENA);
			}
		}
	}
	
	public String toString() {
		String resultat = "";
		for (int i = 0; i < mida; ++i) {
			for (int j = 0; j < mida; ++j) {
				if (this.taulell.getContingutPos(i, j) == NULA) resultat += "\t ";
				else if (this.taulell.getContingutPos(i, j) != NULA) resultat += " " + this.taulell.getContingutPos(i, j) + "\t ";
			}
			resultat += "\n";
		}
		return resultat;
	}
}
