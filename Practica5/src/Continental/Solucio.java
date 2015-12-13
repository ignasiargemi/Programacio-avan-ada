package Continental;
import java.util.ArrayList;

public class Solucio {

    private ArrayList<Moviment> historial;

	Solucio(){
		this.historial = new ArrayList<Moviment>();
	}
    
	public int getMoviments () {
		return historial.size();
	}
	
	public void ferMoviment(int x, int y, int novaX, int novaY) {
    	int menjaX = (x + novaX) / 2;
    	int menjaY = (y + novaY) / 2;
		historial.add(new Moviment(new Coordenada(x,y), new Coordenada(novaX,novaY), new Coordenada(menjaX,menjaY)));
	}
	
	/**
	 * 
	 * @return null quan no hi ha moviments
	 */
	public Moviment obtenirUltimMoviment(){
		if (historial.isEmpty())
			return null;
		
		return historial.get(historial.size()-1);
	}

	/**
	 * @return l'ultim moviment
	 * @throws Exception
	 */
	public Moviment desferUltimMoviment() throws Exception{
		if (historial.isEmpty())
			throw new Exception ("Error desfer �ltim moviment:  no hi ha cap moviment");
		Moviment m = obtenirUltimMoviment();
		historial.remove(m);
		return m;
	}
	
	public ArrayList<Moviment> getllistaMoviments(){
		return this.historial;
	}

	public void imprimir(){
		
        int i=1;
        for (Moviment c: getllistaMoviments()) {
            System.out.println(
            		String.format("%d. Inici:(%s,%s)\tFinal:(%s,%s)\tMenjada:(%s,%s)"
            		, i++
            		, c.getCoordIniciX(),c.getCoordIniciY()
					, c.getCoordFinalX(),c.getCoordFinalY()
					, c.getCoordMenjadaX(),c.getCoordMenjadaY()
			));
        }
    }	
}
