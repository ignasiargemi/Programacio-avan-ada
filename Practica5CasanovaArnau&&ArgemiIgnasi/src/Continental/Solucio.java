package Continental;

public class Solucio {
	private Continental partida = new Continental();
	
	public Solucio() {
		this.partida = new Continental();
	}

	public boolean trobaSolucio(int nivell) throws Exception {
		if (this.partida.esSolucio()) {
			System.out.println("Solucionat");
			return true;
		}
		for (int i = 0; i < this.partida.mida; ++i) { //Files
			for (int j = 0; j < this.partida.mida; ++j) { //Columnes
				for(int k =0; k < this.partida.direccions.length; ++k) { //Direccions
					if (this.partida.casellaValida(i, j)) {
						int direccio = this.partida.possibleDireccio(i, j, this.partida.direccions[k]);
						if (direccio >= 1 && direccio <= 4) {
							//Registar moviment
							this.partida.afegirMoviment(direccio,i,j);
							//System.out.println(nivell);
							//System.out.println(this.partida.toString());
							//Crida recursiva
							if (trobaSolucio(nivell+1)) {
								return true;
							}
							else {
								//desfer moviment i seguir amb la cerca
								this.partida.desferMoviment(direccio, i, j);
							}
						}
					}
				}
			}
		}
		return false;
	}
	
	public String toString() {
		return this.partida.toString();
	}

	public String toStringMoviments() {
		return this.partida.toStringMoviments();
	}

}
