package Arbre;

public interface Acb<E extends Comparable<E>> extends Ab<E>{
	
	public void inserir(E e) throws Exception;
	
	public boolean esborrar(E e);
	
	public boolean membre(E e);

}
