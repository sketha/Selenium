package threads_Concepts;

public class ThreadClass extends Thread {
	public void run(){
		try{
			for (int i = 50; i!=0; i--) {
				System.out.println("Class Thread" + i);
				Thread.sleep(500);
			}}
			catch (InterruptedException e){
				System.out.println("Class Thread Interrupted");
			}
		System.out.println("ThreadClass Thread Exiting");
		
	}

}
