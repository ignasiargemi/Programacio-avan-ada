package Arbre;

import Arbre.ArbreException;

public interface Ab<E> {
	
	public E Arrel() throws Exception;

	public Ab<E> fillEsquerre() throws Exception;
	
	public Ab<E> fillDret() throws Exception;
	
	public boolean abBuit();
	
	public void Buidar();
}
