package com.thread;

public class Semaforo extends Thread {
	private Thread tread;
	boolean parar = false;
	Cores cor;
	
	Semaforo(Cores cor){
		this.cor = cor;
		
		tread = new Thread(this);
		tread.start();
	}
	
	public void run() {
		while(!parar) {
			try {
				switch(cor) {
				case Vermelho:
					Thread.sleep(2000);
					break;
				case Amarelo:
					Thread.sleep(300);
					break;
				case Verde:
					Thread.sleep(1000);
					break;
				}
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			
			alterarCor();
			
		}
	}
	
	synchronized void alterarCor() {
		switch(cor) {
			case Vermelho:
				cor = Cores.Amarelo;
				break;
			case Amarelo:
				cor = Cores.Verde;
				break;
			case Verde:
				cor = Cores.Vermelho;
				break;
		}
		
		notify();
		
	}
	
	synchronized void esperarMudanca() {
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	Cores getCores() {
		return cor;
	}
	
	void pararSemaforo() {
		parar = true;
	}
	
}
