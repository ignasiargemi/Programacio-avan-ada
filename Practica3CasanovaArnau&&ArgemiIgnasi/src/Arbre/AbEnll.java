package Arbre;

import java.util.Queue;

public class AbEnll<E> implements Ab<E>{
	
	protected class NodeA<E> {
		E inf;
		NodeA<E> esq,dret;
		
		public NodeA(){this(null);}
		
		public NodeA(E e){this(e, null, null);}
		
		public NodeA(E e, NodeA<E> esq, NodeA<E> dret){
			this.inf = e;
			this.esq = esq;
			this.dret = dret;
		}
		
		public void inordre(Queue<E> cua) {
		    if(esq!=null) esq.inordre(cua);
		    try {cua.add(inf);} catch (Exception ex) { }
		    if(dret!=null) dret.inordre(cua);
		}
		
		public void preordre(Queue<E> cua) {
		    try {cua.add(inf);} catch (Exception ex) { }
		    if (esq!=null) esq.preordre(cua);
		    if (dret!=null) dret.preordre(cua);
		}

		
		public void postordre(Queue<E> cua) {
		    if (esq!=null) esq.postordre(cua);
		    if (dret!=null) dret.postordre(cua);
		    try {
		    	cua.add(inf);
		    } catch (Exception ex) { }
		}
		
		
		public boolean equals(Object obj){
		     boolean iguals = false;
		     if(obj instanceof NodeA){
		      	NodeA<E> aux = (NodeA<E>)obj;
		       	iguals = inf.equals(aux.inf);
		      }
		      return iguals;
		 }
		
	}
	
	protected NodeA<E> arrel;
	
	public AbEnll(){
		this.arrel = null;
	}
	
	public AbEnll(NodeA<E> esq, E e, NodeA<E> dret){
		this.arrel = new NodeA<E>();
		this.arrel.inf = e;
		this.arrel.esq = esq;
		this.arrel.dret = dret;
	}

	public E Arrel() throws ArbreException {
		if (this.arrel == null) throw new  ArbreException("Ab buit no te arrel");
		return this.arrel.inf;
	}

	public Ab<E> fillEsquerre() throws ArbreException {
		if (this.arrel == null) throw new ArbreException("Ab buit no te fills");
		AbEnll<E> resultat = new AbEnll<E>();
		resultat.arrel = this.arrel.esq;
		return resultat;
	}

	public Ab<E> fillDret() throws ArbreException {
		if (this.arrel == null) throw new ArbreException("Ab buit no te fills");
		AbEnll<E> retorn = new AbEnll<E>();
		retorn.arrel = this.arrel.dret;
		return retorn;
	}

	public boolean abBuit() {
		return arrel == null;
	}

	public void Buidar() {
		arrel = null;
	}
	
	

}
