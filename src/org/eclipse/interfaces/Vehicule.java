package org.eclipse.interfaces;

// Dans une FunctionalInterface, nous retrouverons qu'une seule
//m�thode abstract

@FunctionalInterface
public interface Vehicule {
	
//	public void rouler();
	public void rouler(String type);
	
}
