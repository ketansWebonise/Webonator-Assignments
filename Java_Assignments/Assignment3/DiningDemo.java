import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class Fork {
	int forkId;

	Fork(int id) {
		this.forkId = id;
	}
}

class Philosopher extends Thread {
	String name;
	Fork leftFork;
	Fork rightFork;

	Philosopher(String name, Fork forkOnLeft, Fork forkOnRight) {
		this.name = name;
		this.leftFork = forkOnLeft;
		this.rightFork = forkOnRight;
	}

	void eat() {
		synchronized (leftFork) {			// locking both the forks
			synchronized (rightFork) {

					System.out.println(this.name + " pickes up left fork.");
					System.out.println(this.name + " pickes up right fork.");

					// starts to eat
					System.out.println(this.name + " is Eating...");
					try {
						Thread.sleep(2000);		// eats for two seconds...
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(this.name + " is done Eating.");

					// putting the forks down
					System.out.println(this.name + " puts down the forks");
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
		List<Philosopher> greatMen = new LinkedList<Philosopher>();
		greatMen.add(new Philosopher("Aristotle", fork1, fork2));
		greatMen.add(new Philosopher("Plato", fork2, fork3));
		greatMen.add(new Philosopher("Newton", fork3, fork4));
		greatMen.add(new Philosopher("Einstien", fork4, fork5));
		greatMen.add(new Philosopher("Aryabhatt", fork5, fork1));

		// setting main thread's priority so that all philosophers start together
		Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		
		//let the dining begin
		Iterator<Philosopher> myIterator = greatMen.iterator();
		while(myIterator.hasNext())
		{
			myIterator.next().start();
		}
	}
}