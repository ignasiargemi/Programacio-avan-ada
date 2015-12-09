package Continental;

public class Solucio {

	public static void main(String[] args) {
		Continental joc = new Continental();
		joc.SetContingutPos();
		//Estat inicial
		System.out.println(joc.toString());
		
		/*
		if (troba2Solucions(2)) {
			
		}
		*/
		//Estat final
		System.out.println(joc.toString());
	}
	
	private Continental partida = new Continental();
	
	public Solucio(Continental partida) {
		this.partida = partida;
	}

	public boolean troba2Solucions(int i) {
		return trobaSolucio(1,i);
	}

	public boolean trobaSolucio(int nivell, int solucio_cont) {
		//if ()
		return false;
	}

}
