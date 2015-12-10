package Continental;

public class Taulell {
	private int[][] taulell;
	public static final int BUIDA = 0;
	public static final int PLENA = 1;
	public static final int NULA = -1;
	
	public Taulell(int mida) {
		this.taulell = new int[mida][mida];
	}
	
	public int getContingutPos(int i, int j) {
		//System.out.println(i + " " + j);
		if (i < 0 || i > this.taulell.length-1 || j < 0 || j > this.taulell.length-1) return -11;
		else return this.taulell[i][j];
	}
	
	public void SetContingutPos(int i, int j, int contingut) {this.taulell[i][j] = contingut;}
	
	public void mouFitxa(Moviment m, int accio) throws Exception {
		if (m == null) throw new Exception("No es pot moure cap fitxa");
		if (accio == 1) {//Afegeix moviment
			taulell[m.getPosIncial().getPosX()][m.getPosIncial().getPosY()] = BUIDA;
			taulell[m.getPosEliminada().getPosX()][m.getPosEliminada().getPosY()] = BUIDA;
			taulell[m.getPosFinal().getPosX()][m.getPosFinal().getPosY()] = PLENA;
		}
		else {//Desfer moviemnt
			taulell[m.getPosIncial().getPosX()][m.getPosIncial().getPosY()] = PLENA;
			taulell[m.getPosEliminada().getPosX()][m.getPosEliminada().getPosY()] = PLENA;
			taulell[m.getPosFinal().getPosX()][m.getPosFinal().getPosY()] = BUIDA;
		}
	}

}
