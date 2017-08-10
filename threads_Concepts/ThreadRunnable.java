package threads_Concepts;

public class ThreadRunnable implements Runnable{
	
	@Override
	public void run() {
		
		try{
			for (int i = 50; i!=0; i--) {
				System.out.println("Interface Thread" + i);
				Thread.sleep(500);
			}}
			catch (InterruptedException e){
				System.out.println("Interface Thread Interrupted");
			}
		System.out.println("Child Thread Exiting");
		
	}
	
	

}
