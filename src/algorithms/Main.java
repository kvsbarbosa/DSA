package algorithms;

import algorithms.list.*;
import algorithms.stack.*;

public class Main {

	public static void main(String[] args) {

		MyStackV1 pilha = new MyStackV1();

		Peca peca = new Peca();

		pilha.push(peca);

		Peca pecaRemovida = (Peca) pilha.remove();

		if (peca != pecaRemovida) {
			System.out.println("Erro: a peça removida não é igual " + " a que foi inserida");
		}

		if (!pilha.isEmpty()) {
			System.out.println("Erro: A pilha não está vazia");
		}
	}

}
