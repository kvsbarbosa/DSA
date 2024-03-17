package algorithms;

import algorithms.list.*;

public class Main {

	public static void main(String[] args) {
		Aluno a1 = new Aluno();
		Aluno a2 = new Aluno();
		Aluno a3 = new Aluno();
		
		a1.setNome("Kaio");
		a2.setNome("Gigi");
		a3.setNome("Mig");
		
		MyList list = new MyList();
		
		list.add(a1);
		list.add(a2);
		list.add(0, a3);
		
		System.out.println(list);
	}

}
