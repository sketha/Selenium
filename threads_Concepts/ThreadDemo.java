package threads_Concepts;

public class ThreadDemo {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread());
		ThreadRunnable t1 = new ThreadRunnable();
		Thread t= new Thread(t1);
		t.setName("Child Thread");
		System.out.println(t);
		ThreadClass t2 = new ThreadClass();
		t2.setName("ThreadClass Thread");
		System.out.println(t2);
		 t.start();
		 t2.start();
		 try{
				for (int i = 50; i!=0; i--) {
					System.out.println("Main Thread" + i);
					Thread.sleep(1000);
				}}
				catch (InterruptedException e){
					System.out.println("Main Thread Interrupted");
				}
			System.out.println("Main Thread Exiting");

	}

}
