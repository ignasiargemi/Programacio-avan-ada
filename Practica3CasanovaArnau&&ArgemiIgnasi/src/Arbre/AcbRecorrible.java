package Arbre;


import java.util.LinkedList;
import java.util.Queue;

import Arbre.ArbreException;
import Arbre.AbEnll.NodeA;

public class AcbRecorrible<E extends Comparable<E>> extends AbEnll<E> implements Acb<E> {
	public static final int ORDRE_ASCENDENT = 1789;
	public static final int ORDRE_DESCENDENT = -7895;
	
	private Queue<E> cua;
	private int ordre;
	private boolean arbreModificat;
	
	
	public AcbRecorrible(){
		this(AcbRecorrible.ORDRE_ASCENDENT);
	}
	
	public AcbRecorrible(int ordre) {
		if (ordre!=AcbRecorrible.ORDRE_ASCENDENT &&
		ordre!=AcbRecorrible.ORDRE_DESCENDENT) throw new IllegalArgumentException("ordre: "+ ordre);
		this.ordre=ordre; this.cua=null;
		}
		
	
	public void setOrdre (int ordre) {
		if (ordre!=AcbRecorrible.ORDRE_ASCENDENT && ordre!=AcbRecorrible.ORDRE_DESCENDENT)
		throw new IllegalArgumentException("ordre: "+ ordre);
		this.ordre=ordre;
		this.cua=null;
		}
	
	public void inserir(E e) throws ArbreException{
		arbreModificat = true;
		this.arrel = inserirRecursiu(this.arrel, e);
	}
	
	private NodeA<E> inserirRecursiu(NodeA<E> a, E e) throws ArbreException{
		if (a == null){
			a = new NodeA<E>(e);
		}
		else{
			if (ordre > 0){
			int cmp = e.compareTo(a.inf);
			if (cmp == 0) throw new ArbreException("Repetit " + e);
			if (cmp < 0) {
				a.esq = inserirRecursiu(a.esq, e);
			}
			else a.dret = inserirRecursiu(a.dret, e);
		}
		else{
			int cmp = e.compareTo(a.inf);
			if (cmp == 0) throw new ArbreException("Repetit " + e);
			if (cmp < 0) {
				a.dret = inserirRecursiu(a.dret, e);
			}
			else a.esq = inserirRecursiu(a.esq, e);
			}
		}
		return a;
	}
	
	public boolean esborrar(E e){
		try {
			arrel = esborrarRecursiu(arrel, e);
			return true;
		} catch (Exception e1) {
			return false;
		}
		
	}

    private NodeA<E> esborrarRecursiu(NodeA<E> a, E e) throws Exception {
    	if (ordre > 0){
        if (a == null) {
            throw new ArbreException("l'arbre es buit");
        } 
        else if (e.compareTo(a.inf) < 0) {
            a.esq = esborrarRecursiu(a.esq, e);
        } 
        else if (e.compareTo(a.inf) > 0) {
            a.dret = esborrarRecursiu(a.dret, e);
        }
        else {
            if (a.esq == null && a.dret == null) { 
                a = null; 
            } 
            else if (a.esq != null && a.dret != null) {
            	NodeA<E> aux = a.dret;
            	while (aux.esq != null) {
            		aux = aux.esq;
                }
                a.inf = aux.inf;
                a.dret = aux;
            } 
            else if (a.esq == null){
                a = a.dret;  
            } 
            else {
                a = a.esq;
            }
        }
    	}
    	else{
    		if (a == null) {
                throw new ArbreException("l'arbre es buit");
            } 
            else if (e.compareTo(a.inf) < 0) {
                a.dret = esborrarRecursiu(a.dret, e);
            } 
            else if (e.compareTo(a.inf) > 0) {
                a.esq = esborrarRecursiu(a.esq, e);
            }
            else {
                if (a.esq == null && a.dret == null) { 
                    a = null; 
                } 
                else if (a.esq != null && a.dret != null) {
                	NodeA<E> aux = a.esq;
                	while (aux.dret != null) {
                		aux = aux.dret;
                    }
                    a.inf = aux.inf;
                    a.esq = aux;
                } 
                else if (a.esq == null){
                    a = a.dret;  
                } 
                else {
                    a = a.esq;
                }
            }
    		
    	}
        return a;
    }	
	
	
	
	public boolean membre(E e){
		return membreRec(this.arrel, e);
	}
	
	private boolean membreRec(NodeA<E> a, E e){
		if (a == null) return false;
		if (ordre > 0){
			int cmp = e.compareTo(a.inf);
			if (cmp == 0) return true;
			if (cmp < 0) return membreRec(a.esq, e);
			else return membreRec(a.dret, e);
		}
		else{
			int cmp = e.compareTo(a.inf);
			if (cmp == 0) return true;
			if (cmp < 0) return membreRec(a.dret, e);
			else return membreRec(a.esq, e);
		}
	}
	
	public void iniInordre () {
		if(cua == null) cua = new LinkedList<E>();
		if (!cua.isEmpty()) cua.clear();
        cua = this.inordre();
		arbreModificat = false;
	}

	public boolean finalInordre () {
		if (this.arrel == null) return true;
		if (this.cua == null) return true;
		if (this.cua.isEmpty()) return true;
		return false;		
	}
	
	public E segInordre () throws Exception {
		if(finalInordre()) throw new Exception("Ja s'ha retornat l'ultim element en inordre.");
		if(arbreModificat) throw new Exception("l'arbre ha estat modificat mentre es realitzava el recorregut...");
		if(cua == null) throw new Exception("No s'ha invocat el metode iniInordre per començar el recorregut.");
		else arbreModificat = false;
		try {
			return cua.poll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	public Queue<E> inordre() {
		Queue<E> cua = new LinkedList<E>();
	    if (arrel != null) {
	        arrel.inordre(cua);
	    }
	    return cua;
	}    
	
	
	public Queue<E> preordre() {
		Queue<E> cua = new LinkedList<E>();
	    if (arrel != null) {
	        arrel.preordre(cua);
	    }
	    return cua;
	}
	
	public Queue<E> postordre() {
		Queue<E> cua = new LinkedList<E>();
	    if (arrel != null) {
	        arrel.postordre(cua);
	    }
	    return cua;
	}    
	
	public String toString() {
	    String result = new String();
	  
		 Comparable<E> c = null;
		 this.iniInordre();
		 try {
			int i=0;
			while (!this.finalInordre()) {
				c = this.segInordre();
				result += c.toString() + "\n";
			}	     
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	    return result;
	}
}
