package Continental;

public class Solucio {
	private Continental partida = new Continental();
	
	public Solucio() {
		this.partida = new Continental();
	}

	public boolean trobaSolucio(int nivell) throws Exception {
		for (int i = 0; i < this.partida.getMida(); ++i) { //Files
			for (int j = 0; j < this.partida.getMida(); ++j) { //Columnes
				if (this.partida.casellaValida(i, j)) {
					for(int k =0; k < this.partida.getDireccions().length; ++k) { //Direccions
						Moviment m = this.partida.possibleMoviment(i,j,this.partida.getDireccions()[k]);
						if (m != null) {
							//Registar moviment
							this.partida.afegirMoviment(m);
							//System.out.println(nivell);
							System.out.println(this.partida.toString());
							//Crida recursiva
							if (nivell == 31) {
								if (this.partida.esSolucio()) {return true;}
							}
							trobaSolucio(nivell+1);
							//desfer moviment i seguir amb la cerca
							this.partida.desferMoviment(m);
							
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
