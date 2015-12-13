package Continental;
public class Moviment {
	
	private Coordenada coordInici;
	private Coordenada coordFinal;
	private Coordenada coordMenjada;

	public Coordenada getCoordInici() {
		return coordInici;
	}

	public Coordenada getCoordFinal() {
		return coordFinal;
	}

	public Coordenada getCoordMenjada() {
		return coordMenjada;
	}
	
	public Moviment(Coordenada ini, Coordenada fin, Coordenada menja){
		this.coordInici = ini;
		this.coordFinal = fin;
		this.coordMenjada = menja;
	}

	public int getCoordIniciX() {
		return coordInici.getPosX();
	}
	
	public int getCoordIniciY() {
		return coordInici.getPosY();
	}

	public int getCoordFinalX() {
		return coordFinal.getPosX();
	}
	
	public int getCoordFinalY() {
		return coordFinal.getPosY();
	}

	public int getCoordMenjadaX() {
		return coordMenjada.getPosX();
	}
	
	public int getCoordMenjadaY() {
		return coordMenjada.getPosY();
	}
}
