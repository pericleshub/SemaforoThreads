package com.thread;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Semaforo semaforo = new Semaforo(Cores.Verde);

		for(int i = 0; i < 10; i++) {
			System.out.println(semaforo.getCores());
			
			semaforo.esperarMudanca();
			
		}
		
		semaforo.pararSemaforo();
		
	}

}
