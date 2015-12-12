package Continental;

public class Coordenada {
	private int posX;
	private int posY;
	
	public Coordenada(int x, int y) {
		this.posX = x;
		this.posY = y;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public String toString() {
		return "[" + posX + ", " + posY + "]";
	}
	
}
