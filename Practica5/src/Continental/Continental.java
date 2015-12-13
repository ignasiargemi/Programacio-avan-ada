package Continental;

public class Continental {
	
	
	/**
	 * Launch the application.
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		Continental joc = new Continental();
		System.out.print(joc.imprimir());
		
        long t1 = System.currentTimeMillis();
        int n = 2;
        if (joc.trobarNSolucions(n)) {
        	
			long t2 = System.currentTimeMillis();
		
			System.out.println();
			System.out.print(joc.imprimir());
			
			System.out.println();
		    System.out.println(String.format(n+ " solucions trobades en " + (t2 - t1) + " ms [%,d iteracions]", joc.getIteracions()));
        }
	}	
    
    /**
     * Direccions posibles del moviment
     */
	public static final int AMUNT = 0, DRETA = 1, AVALL = 2, ESQUERRA = 3;
    public static final int [] direccions = {AMUNT,AVALL,ESQUERRA,DRETA};

	//Tipus de caselles
	public static final int BUIDA = 0;
	public static final int PLENA = 1;
	public static final int NULA = 8;

	public static final int mida = 7;
	
	private Solucio moviments; // refer�ncia al joc
	private int[][] taulell;
	private long iteracions = 0L; 	// contador d'iteracions per informaci�
	private int comptador = 1;


	public Continental(){
		this.moviments = new Solucio();
		this.taulell = new int[mida][mida];
		SetContingutPos();
		
	}
	
	public long getIteracions() {
		return iteracions;
	}

	public boolean trobarNSolucions(int n) throws Exception {
		return trobarSolucio(1,n);
	}

	/**
	 * T�cnica Backtracking per resoldre el joc del Continental
	 * 
	 * @param mov moviment actual, comen�ant per 1
	 * @throws Exception 
	 */
	public boolean trobarSolucio(int nivell, int sol_cont) throws Exception {
	
		// The base case: if it's already solved, we're done
	
		if (esSolucio()){
	    	System.out.println();
	    	System.out.println();
			System.out.println("SOLUCI� "+ comptador);
			System.out.println("***************");
			//imprimir_sequencia();
			moviments.imprimir();
			
	    	if(comptador==sol_cont) {
	    		
	            return true;
	    	} else {
	    		comptador++;
	            return false;
	    	}	    	
	    } 
	
		for (int x = 0; x < mida; x++)					// per totes les files
			for (int y = 0; y < mida; y++)				// per totes les columnes
				if (esCasellaOcupada(x, y)) {
	    			//for (int direccio : nou.direccions)	
					for (int direccio : direccions)						// per totes les direccions
	             	{ 
	                	iteracions++;
	                	if(iteracions%100000==0) System.out.print(".");
	
	                	// Calcular nova posici� al fer el salt
	                    int novaX = getNovaX(x, direccio);
	                    int novaY = getNovaY(y, direccio);
	                    
	        	        if (esMovimentAcceptable(x, y, novaX, novaY)) {
	        	        	
	        	        	ferMoviment(x, y, novaX, novaY); 
	        	        	
	        	        	if (trobarSolucio(nivell+1,sol_cont)) { // Crida recursiva
	        	                // That move led to success :-)
	                            return true;
	        	            } else {
	        	                // That move led to failure :-(
	        	                desferMoviment(x, y, direccio);
	        	            }
	        	        }
	                }
				}
	    return false;
	}

	public String imprimir() {
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

	private void SetContingutPos() {
		for (int i = 0; i < mida; ++i) {
			for (int j = 0; j < mida; ++j) {
				if (j == 3 && i == 3) this.taulell[i][j] = BUIDA;
				else if ((i < 2 || i > 4) && (j < 2 || j > 4)) this.taulell[i][j] = NULA;
				else this.taulell[i][j] = PLENA;
			}
		}
	}
	
	
    private boolean esSolucio(){
	    return (equal(this.taulell,this.getTaulellFinal()));
	}
    
    private boolean esMovimentAcceptable(int x, int y, int novaX, int novaY) {
    	
        boolean inside =     
		   x >= 0 
        && y >= 0
        && x < this.taulell.length 
        && y < this.taulell[x].length
        && novaX >= 0 
        && novaY >= 0 
        && novaX < this.taulell.length 
        && novaY < this.taulell[novaX].length
        ;
        
        /*
        boolean validDirection = false;
    	for (int direccio : direccions)			// per totes les direccions
     	{ 
            int validX = this.getNovaX(x, direccio);
            int validY = this.getNovaY(y, direccio);    	

            validDirection = (validX == novaX && validY == novaY);
        	if (validDirection) break;
     	}
     	*/
                
        return     inside                     
        		&& esCasellaOcupada(x,y)								// Casella ha d'estar ocupada
                && esCasellaBuida(novaX,novaY) 							// Casella nova ha d'estar buida
        		&& esCasellaOcupada((x + novaX) / 2, (y + novaY) / 2)	// Casella entre mig ha d'estar ocupada
        		;
        /*
        return     inside                     
                && validDirection 
        		&& esCasellaOcupada(x,y)								// Casella ha d'estar ocupada
                && esCasellaBuida(novaX,novaY) 							// Casella nova ha d'estar buida
        		&& esCasellaOcupada((x + novaX) / 2, (y + novaY) / 2)	// Casella entre mig ha d'estar ocupada
        		;
         */
    }
    /**
     * Salta la fitxa desde la posició indicada sobre la fitxa veina amb la direcció donada
     * i elimina la fitxa que ha saltat per sobre. 
     * */
    private void ferMoviment(int x, int y, int novaX, int novaY) {
        setFitxa(novaX, novaY);
        buidarCasella(x, y);
        buidarCasella((x + novaX) / 2, (y + novaY) / 2);
    	moviments.ferMoviment(x, y, novaX, novaY);
        
    }

    /**
     * La fitxa salta enrere amb la direcció donada i la fitxa menjada torna al seu lloc.
     */
    private void desferMoviment(int x, int y, int direction) {
            int newX = getNovaX(x, direction);
            int newY = getNovaY(y, direction);
            
            buidarCasella(newX, newY);
            setFitxa(x, y);
            setFitxa((x + newX) / 2, (y + newY) / 2);

            try {
				moviments.desferUltimMoviment();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
    
    private int getNovaX(int x, int direction) {
            int newX = x;
            switch (direction) {
            case DRETA: newX += 2;
                        break;
            case ESQUERRA: newX -= 2;
            }
            return newX;
    }
    
    private int getNovaY(int y, int direccio) {
            int novaY = y;
            
            switch (direccio) {
            case AMUNT: novaY -= 2;
                            break;
            case AVALL: novaY += 2;
            }
            
            return novaY;
    } 


    private void buidarCasella(int x, int y) {
    	this.taulell[x][y] = BUIDA;
    }

    private void setFitxa(int x, int y) {
    	this.taulell[x][y] = PLENA;
    }
    
    private boolean esCasellaOcupada(int x, int y) {
        return  this.taulell[x][y] == PLENA;
    }    
    
     private boolean esCasellaBuida(int x, int y) {
        return this.taulell[x][y] == BUIDA;
    }
    
     /*
    private void setContingut(int fila, int columna, int value) throws Exception {
		if (foraLimits(fila, columna))
			throw new Exception("Error fila i/o columna fora del taullel");

		this.taulell[fila][columna] = value;
	}
	*/
    
     /*
    private boolean foraLimits(int fila, int columna) throws Exception{
		return ((fila < 0 || fila > this.taulell.length) || (columna < 0 || columna > this.taulell.length)); 
			
	}
	*/
    
    private int[][] getTaulellFinal() {
		int [][] caselles_final = {
			{8,8,0,0,0,8,8},
			{8,8,0,0,0,8,8},
			{0,0,0,0,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,0,0,0,0},
			{8,8,0,0,0,8,8},
			{8,8,0,0,0,8,8}
		};

		return caselles_final;
	}
    
    private boolean equal(int[][] array1, int[][] array2) {

        if (array1 == null || array2 == null) return false;

    	if (array1.length != array2.length)
        	  return false;
    	else {
              for (int i = 0; i < array2.length; i++){
                  if (array1[i].length != array2[i].length) return false;
                  for (int j = 0; j < array2[i].length; j++) {
	                  if (array2[i][j] != array1[i][j]) {
	                	  return false;    
	                  }                 
                  }
              }
    	}
        return true;
    }
}
