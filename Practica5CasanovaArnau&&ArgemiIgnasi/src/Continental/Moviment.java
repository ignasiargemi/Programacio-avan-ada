package Continental;

public class Moviment {
	private Posicio posIncial;
	private Posicio posFinal;
	private Posicio posEliminada;
	
	public Moviment(Posicio pI, Posicio pF, Posicio pE) {
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
		String resultat = "";
		resultat += "Posicio inicial: " +this.posIncial.toString() + "\n";
		resultat += "Posicio final: " +this.posFinal.toString() + "\n";
		resultat += "Posicio eliminada: " +this.posEliminada.toString() + "\n";
		return resultat;
	}
}
