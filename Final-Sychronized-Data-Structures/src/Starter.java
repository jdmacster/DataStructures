import java.util.Scanner;

public class Starter {

	public static void main(String[] args) {
		int val = 7;

		@SuppressWarnings("unused")
		int size;
		int producerThreadNumber;
		int consumerThreadNumber;
		long delayOnProducer;
		long delayOnConsumer;
		
		Queue<Integer> shared = new Queue<Integer>();
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		System.out.println("How many items should the queue hold?");
		size = scan.nextInt();
		System.out.println("How many producer threads should be running?");
		producerThreadNumber = scan.nextInt();
		System.out.println("How many consumer threads should be running?");
		consumerThreadNumber = scan.nextInt();
		System.out.println("How long should the dealy be between each item produced?");
		delayOnProducer = scan.nextLong();
		System.out.println("How long should the dealy be between each item consumed?");
		delayOnConsumer = scan.nextLong();
		
		ModThread[] producers = new ModThread[producerThreadNumber];
		ModThread[] consumers = new ModThread[consumerThreadNumber];
		
		
		for (int i = 0; i < producers.length; i++) { 	// initialize all the producers
			producers[i] = new ModThread(val, shared, "p"+i, delayOnProducer);
		}
		
		for (int i = 0; i < consumers.length; i++) { 	// initialize all the consumers
			consumers[i] = new ModThread(val, shared, "c"+i, delayOnConsumer);
		}
		
		System.out.println(producers[0]);
		
		for (int i = 0; i < producers.length || i < consumers.length; i++ ) { 	// run all of the threads
			producers[i].runProducer();
			consumers[i].runConsumer();
		}
		
	}

}