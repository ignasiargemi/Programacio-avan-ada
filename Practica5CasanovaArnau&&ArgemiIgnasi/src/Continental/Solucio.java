package Continental;

public class Solucio {
	public static void main(String[] args) throws Exception {
		Solucio joc = new Solucio();
		//Estat inicial
		System.out.println(joc.toString());
		
		//Busquem la solució
		if (joc.trobaSolucio(1,1)) System.out.println("Solucionat");
		
		//Estat final
		System.out.println(joc.toString());
		System.out.println();
		System.out.println("Llista de moviments");
		System.out.println(joc.toStringMoviments());
	}
	
	private Continental partida = new Continental();
	
	public Solucio() {
		this.partida = new Continental();
	}
	
	/*
	public boolean troba2Solucions(int i) throws Exception {
		return trobaSolucio(1,i);
	}
	*/
	public boolean trobaSolucio(int nivell, int solucio_cont) throws Exception {
		if (this.partida.esSolucio()) {
			System.out.println("Solucionat");
			return true;
		}
		else {
			for (int i = 0; i < this.partida.mida; ++i) {
				for (int j = 0; j < this.partida.mida; ++j) {
					for(int k =0; k < this.partida.direccions.length; ++k) {
						if (this.partida.casellaValida(i, j)) {
							
							//int posX = this.partida.getPosX(i,this.partida.direccions[k]);
							//int posY = this.partida.getPosY(j,this.partida.direccions[k]);
							int direccio = this.partida.possibleDireccio(i, j, this.partida.direccions[k]);
							if (direccio >= 1 && direccio <= 4) {
								//Registar moviment
								this.partida.afegirMoviment(direccio,i,j);
								System.out.println(this.partida.toString());
								//Crida recursiva
								if (trobaSolucio(nivell+1,solucio_cont)) {
									//System.out.println("Solucionat");
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
	}
	
	public String toString() {
		return this.partida.toString();
	}

	public String toStringMoviments() {
		return this.partida.toStringMoviments();
	}

}
