package Continental;

public class Taulell {
	private int[][] taulell;
	
	public Taulell(int mida) {
		this.taulell = new int[mida][mida];
	}
	
	public int getContingutPos(int i, int j) {return this.taulell[i][j];}
	
	public void SetContingutPos(int i, int j, int contingut) {this.taulell[i][j] = contingut;}

}
