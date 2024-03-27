package model;

import java.util.concurrent.Semaphore;

public class AirplaneThread extends Thread {

	private Semaphore semaphore;

	public AirplaneThread() {
		super();
	}

	public AirplaneThread(Semaphore semaphore) {
		this.semaphore = semaphore;
	}

	@Override
	public void run() {
		try {
			maneuver();
			taxiing();
			takeOff();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void maneuver() throws InterruptedException {
		int rolledTime = (int) ((Math.random() * 401) + 300);
		System.out.println(this + " starts maneuver (" + rolledTime + "ms)");
		sleep(rolledTime);
	}

	private void taxiing() throws InterruptedException {
		int rolledTime = (int) ((Math.random() * 501) + 500);
		System.out.println(this + " starts taxiing (" + rolledTime + "ms)");
		sleep(rolledTime);
	}

	private void takeOff() throws InterruptedException {
		int rolledTime = (int) ((Math.random() * 201) + 600);
		semaphore.acquire();
		System.out.println(this + " enter runway (" + rolledTime + "ms)");
		sleep(rolledTime);
		System.out.println(this + " take-off");
		semaphore.release();
	}
	
	@Override
	public String toString() {
		return this.getName().replaceAll("Thread-", "Airplane ");
	}

}
