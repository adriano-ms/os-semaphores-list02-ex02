package view;

import java.util.concurrent.Semaphore;

import model.AirplaneThread;

public class Main {

	public static final int AIRPLANES_AMOUNT = 12;
	
	public static void main(String[] args) {
		
		AirplaneThread[] airplanes = new AirplaneThread[AIRPLANES_AMOUNT];
		Semaphore semaphore = new Semaphore(2);

		for(int i = 0; i < AIRPLANES_AMOUNT; i++)
			airplanes[i] = new AirplaneThread(semaphore);
		
		for(int i = 0; i < AIRPLANES_AMOUNT; i++)
			airplanes[i].start();
		
	}

}
