class Fork {
	int forkId;
	boolean acquired;

	Fork(int id) {
		this.forkId = id;
		this.acquired = false;
	}

}

class Philosopher extends Thread {
	String name;
	Fork leftFork;
	Fork rightFork;

	Philosopher(String name, Fork left, Fork right) {
		this.name = name;
		this.leftFork = left;
		this.rightFork = right;
	}

	void eat() {
		synchronized (leftFork) {
			synchronized (rightFork) {

				// checks for both the forks
				if (this.leftFork.acquired == false
						&& this.rightFork.acquired == false)

				{ // picking up both the forks
					System.out.println(this.name + " pickes up left fork.");
					this.leftFork.acquired = true;
					System.out.println(this.name + " pickes up right fork.");
					this.rightFork.acquired = true;

					// starts to eat
					System.out.println(this.name + " is Eating...");
					try {
						Thread.sleep(2000);		// eats for two seconds...
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(this.name + " is done Eating.");

					// putting the forks down
					this.leftFork.acquired = false;
					this.rightFork.acquired = false;
					System.out.println(this.name + " puts down the forks");
				} else {
					System.out
							.println(this.name + "can't eat. So he thinks...");
					this.think();
				}
			}
		}
	}

	void think() {
		try {
			System.out.println(this.name + " is thinking...");
			Thread.sleep(2000);
			System.out.println(this.name + " is now hungry...");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		this.eat();
		this.think();
		this.eat();
	}
}

public class DiningDemo {

	public static void main(String[] args) {

		// placing the forks on table
		Fork fork1 = new Fork(1);
		Fork fork2 = new Fork(2);
		Fork fork3 = new Fork(3);
		Fork fork4 = new Fork(4);
		Fork fork5 = new Fork(5);

		// making the philosophers sit
		Philosopher P1 = new Philosopher("Aristotle", fork1, fork2);
		Philosopher P2 = new Philosopher("Plato", fork2, fork3);
		Philosopher P3 = new Philosopher("Newton", fork3, fork4);
		Philosopher P4 = new Philosopher("Einstien", fork4, fork5);
		Philosopher P5 = new Philosopher("Aryabhatt", fork5, fork1);

		// let the dining begin !!
		P1.start();
		P2.start();
		P3.start();
		P4.start();
		P5.start();

	}
}
