package Continental;
public class Moviment {
	//Atributs
	private Coordenada casellaInici;
	private Coordenada casellaFinal;
	private Coordenada casellaEliminada;

	//Creadora
	public Moviment(Coordenada inicial, Coordenada fi, Coordenada eliminada){
		this.casellaInici = inicial;
		this.casellaFinal = fi;
		this.casellaEliminada = eliminada;
	}

	//Getters
	public int getCoordIniciX() {
		return casellaInici.getPosX();
	}
	
	public int getCoordIniciY() {
		return casellaInici.getPosY();
	}

	public int getCoordFinalX() {
		return casellaFinal.getPosX();
	}
	
	public int getCoordFinalY() {
		return casellaFinal.getPosY();
	}

	public int getCoordMenjadaX() {
		return casellaEliminada.getPosX();
	}
	
	public int getCoordMenjadaY() {
		return casellaEliminada.getPosY();
	}
	
	//To String
	public String toString() {
		return "(" + this.casellaInici.toString() + ", " + this.casellaEliminada.toString() + ", " 
				+ this.casellaFinal.toString() + ")";
	}
}
