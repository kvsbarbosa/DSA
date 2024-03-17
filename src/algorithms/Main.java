package algorithms;

import algorithms.list.*;

public class Main {

	public static void main(String[] args) {

		LinkedList lista = new LinkedList();
		lista.add("Rafael");
		lista.add(0, "Paulo");
		lista.add(1, "Camila");
		
		System.out.println(lista);
	}

}
