package Continental;

public class Continental {
	//Main
	public static void main(String[] args) throws Exception {
		Continental joc = new Continental();
		System.out.println("Taulell inicial");
		System.out.print(joc.toString());
	
        int n = 2; //N�mero de solucions
        if (joc.trobarNSolucions(n)) {
			System.out.println();
			System.out.println("Taulell final");
			System.out.print(joc.toString());
			System.out.println();
		    System.out.println("Execuci� finalitzada");
        }
	}	
    
    //Direccions
	public static final int AMUNT = 0;
	public static final int DRETA = 1;
	public static final int AVALL = 2;
	public static final int ESQUERRA = 3;
    public static final int [] direccions = {AMUNT,AVALL,ESQUERRA,DRETA};

	// Tipus de caselles
	public static final int BUIDA = 0;
	public static final int PLENA = 1;
	public static final int NULA = 8;
	
	//Mida del taulell
	public static final int mida = 7;
	
	//Taulell solucionat
	private int [][] solucio = {
			{8,8,0,0,0,8,8},
			{8,8,0,0,0,8,8},
			{0,0,0,0,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,0,0,0,0},
			{8,8,0,0,0,8,8},
			{8,8,0,0,0,8,8}
	};

	private Solucio moviments; //Llista de moviments
	private int[][] taulell; //Taulell de joc
	private int comptador = 1; //Comptador de solucions


	//Creaci� del joc.
	public Continental(){
		this.moviments = new Solucio();
		this.taulell = new int[mida][mida];
		SetContingutPos();
	}

	public boolean trobarNSolucions(int n) throws Exception {
		return trobarSolucio(n);
	}

	public boolean trobarSolucio(int comptadorSolucions) throws Exception {
		//Comprovem si �s soluci�
		if (esSolucio()){
	    	System.out.println();
			System.out.println("Soluci� "+ comptador);
			System.out.println("***************");
			System.out.println("    Inicial-Eliminada-Final");
			System.out.print(moviments.toString());
			
	    	if(comptador==comptadorSolucions) return true;
	    	else {
	    		comptador++;
	            return false;
	    	}	    	
	    } 
		
		for (int x = 0; x < mida; x++)	{// per totes les files
			for (int y = 0; y < mida; y++)	{// per totes les columnes
				if (esCasellaOcupada(x, y)) {
					for (int k = 0; k < direccions.length; ++k)	{ // per totes les direccions
	                	// Calcular nova posici� al fer el salt
	                	int direccio = direccions[k];
	                	int [] coord = getNovesCoord(x,y,direccio);
	                	int novaX = coord[0];
	                    int novaY = coord[1];
	        	        if (esMovimentValid(x, y, novaX, novaY)) {
	        	        	ferMoviment(x, y, novaX, novaY); //Afegim el moviment
	        	        	if (trobarSolucio(comptadorSolucions)) return true; // Crida recursiva
	        	            else desferMoviment(x, y, direccio); //Desfem el moviment
	        	        }
	                }
				}
			}
		}
	    return false;
	}
	
	//Retorna un String per tal de treure el taulell per pantalla
	public String toString() {
		String resultat = "";
		for (int x = 0; x < taulell.length; x++) {
	        for (int y = 0; y < taulell[x].length; y++) {
	        	if (taulell[x][y] == NULA) resultat += "   ";
	        	else resultat += " " + taulell[x][y] + " ";
	        }
	        resultat += "\n";
	    }
		return resultat;
	}
	
	//Inicialitza el taulell
	private void SetContingutPos() {
		for (int i = 0; i < mida; ++i) {
			for (int j = 0; j < mida; ++j) {
				if (j == 3 && i == 3) this.taulell[i][j] = BUIDA;
				else if ((i < 2 || i > 4) && (j < 2 || j > 4)) this.taulell[i][j] = NULA;
				else this.taulell[i][j] = PLENA;
			}
		}
	}
	
	//Comprova si el taulell est� solucionat
    private boolean esSolucio(){
    	for (int i = 0; i < solucio.length; ++i) {
    		for (int j = 0; j < solucio.length; ++j) {
    			if (solucio[i][j] != taulell[i][j]) return false;
    		}
    	}
    	return true;
	}
    
    //Aquesta funci� comprova si el moviment és vàlid.
	private boolean esMovimentValid(int x, int y, int novaX, int novaY) throws Exception {
        if (foraLimits(novaX,novaY)) return false;
        if (!esCasellaOcupada((x+novaX)/2,(y+novaY)/2) || !esCasellaBuida(novaX,novaY)) return false;
        else return true;
    }
	
	//Aquesta funci� comrova si les coordenades estan fora dels límits del taulell.
	private boolean foraLimits(int fila, int columna) throws Exception{
		return ((fila < 0 || fila >= this.taulell.length) || (columna < 0 || columna >= this.taulell.length)); 
			
	}

	//Aquesta funci� modifica el taulell i l'afegeix a la llista.
    private void ferMoviment(int x, int y, int novaX, int novaY) {
        omplirCasella(novaX, novaY);
        buidarCasella(x, y);
        buidarCasella((x + novaX) / 2, (y + novaY) / 2);
    	moviments.ferMoviment(x, y, novaX, novaY); 
    }

    //Aquesta funci� desfa el moviment i el treu de la llista.
    private void desferMoviment(int x, int y, int direccio) throws Exception {
    	int[] coord = getNovesCoord(x,y,direccio);
        int novaX = coord[0];
        int novaY = coord[1];

        omplirCasella(x, y);
        omplirCasella((x + novaX) / 2, (y + novaY) / 2);
        buidarCasella(novaX, novaY);
        moviments.desferUltimMoviment();
    }
    
    //Troba les noves coordenades.
    private int[] getNovesCoord(int i, int j, int direccio) {
    	int[] coord = {i,j};
    	if (direccio == ESQUERRA) coord[0] -= 2;
    	else if (direccio == DRETA) coord[0] += 2;
    	else if (direccio == AMUNT) coord[1] -= 2;
    	else if (direccio == AVALL) coord[1] += 2;
    	return coord;
    }

    //Modifica la casella perqu� sigui BUIDA
    private void buidarCasella(int x, int y) {this.taulell[x][y] = BUIDA;}
    //Modifica la casella perqu� sigui PLENA
    private void omplirCasella(int x, int y) {this.taulell[x][y] = PLENA;}
    //Comprova si la casella �s PLENA
    private boolean esCasellaOcupada(int x, int y) {return this.taulell[x][y] == PLENA;}    
    //Comprova si la casella �s BUIDA
    private boolean esCasellaBuida(int x, int y) {return this.taulell[x][y] == BUIDA;}
}
