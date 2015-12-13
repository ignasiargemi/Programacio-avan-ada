package Continental;

public class Coordenada {
	//Atributs
	private int coordX;
	private int coordY;
	
	//Creadora
	public Coordenada(int x, int y) {
		this.coordX = x;
		this.coordY = y;
	}

	//Getters
	public int getPosX() {
		return coordX;
	}

	public int getPosY() {
		return coordY;
	}

	//To String
	public String toString() {
		return "[" + coordX + ", " + coordY + "]";
	}
}
