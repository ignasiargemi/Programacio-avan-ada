package Continental;

public class Moviment {
	private Coordenada posIncial;
	private Coordenada posFinal;
	private Coordenada posEliminada;
	
	public Moviment(Coordenada pI, Coordenada pE, Coordenada pF) {
		this.posIncial = pI;
		this.posFinal = pF;
		this.posEliminada = pE;
	}

	public Coordenada getPosIncial() {
		return posIncial;
	}

	public Coordenada getPosFinal() {
		return posFinal;
	}

	public Coordenada getPosEliminada() {
		return posEliminada;
	}
	
	public String toString() {
		return "(" + this.posIncial.toString() + ", " + this.posFinal.toString() + ", " 
				+ this.posEliminada.toString() + ")";
	}
}
