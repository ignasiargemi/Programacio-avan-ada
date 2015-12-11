package Continental;

public class Moviment {
	private Posicio posIncial;
	private Posicio posFinal;
	private Posicio posEliminada;
	
	public Moviment(Posicio pI, Posicio pE, Posicio pF) {
		this.posIncial = pI;
		this.posFinal = pF;
		this.posEliminada = pE;
	}

	public Posicio getPosIncial() {
		return posIncial;
	}

	public Posicio getPosFinal() {
		return posFinal;
	}

	public Posicio getPosEliminada() {
		return posEliminada;
	}
	
	public String toString() {
		return "(" + this.posIncial.toString() + ", " + this.posFinal.toString() + ", " 
				+ this.posEliminada.toString() + ")";
	}
}
