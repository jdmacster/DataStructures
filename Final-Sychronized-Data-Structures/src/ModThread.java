public class ModThread extends Thread {

	private Queue<Integer> q;
	private int val;
	long delay;
	
	/**
	 * constuctor
	 * @param value
	 * @param q
	 * @param name
	 * @param delay
	 */
	public ModThread(int value, Queue<Integer> q, String name, long delay) {
		super(name);
		this.val = value;
		this.q = q;
		this.delay = delay;
	}
		
	/**
	 * runs a producer thread, which pushes on to the local queue. Almost a carbon copy of the notes, not sure why broken
	 */
	public void runProducer() {	
		while(true) {
			Queue<Integer> local = q;
			local.push(val);
			q.push((Integer) local.top());
			try {
				Thread.sleep(delay);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(this.getName()+" value "+q);
		}
	
	}
	
	/**
	 * runs a consumer thread, which pops a value out of the local queue. Almost a carbon copy of the notes, not sure why broken
	 */
	public void runConsumer() {	
		while(true) {
			Queue<Integer> local = q;
			System.out.println(this.getName()+" value "+local);
			local.pop();
			q.pop();
			try {
				Thread.sleep(delay);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	
	}
}