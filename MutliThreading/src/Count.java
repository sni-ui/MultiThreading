/*class Count extends Thread
{
   Count()
   {
     super("my extending thread");
     System.out.println("Thread here is " + this);
     start();
   }
   public void run()
   {
     try
     {
        for (int i=0 ;i<10;i++)
        {
           System.out.println(" Count " + i);
           Thread.sleep(1000);
        }
     }
     catch(InterruptedException e)
     {
        System.out.println("Thread got interrupted");
     }
     System.out.println("Thread is in dead here.." );
   }
}
class ExtendingExample
{
   public static void main(String args[])
   {
      Count cnt = new Count();
      try
      {
         while(cnt.isAlive())
         {
           System.out.println("Main thread will be alive till the child thread is live");
           Thread.sleep(1500);
         }
      }
      catch(InterruptedException e)
      {
        System.out.println("Main thread interrupted");
      }
      System.out.println("Main thread's run is over" );
   }
}*/
/*
class Count implements Runnable
{
   Thread mythread ;
   Count()
   { 
      mythread = new Thread(this, "my runnable thread");
      System.out.println("my thread created" + mythread);
      mythread.start();
   }
   public void run()
   {
      try
      {
        for (int i=0 ;i<10;i++)
        {
          System.out.println("Printing the count " + i);
          Thread.sleep(1000);
        }
     }
     catch(InterruptedException e)
     {
        System.out.println("my thread interrupted");
     }
     System.out.println("thread went to stop state" );
   }
}
class RunnableExample
{
    public static void main(String args[])
    {
       Count cnt = new Count();
       try
       {
          while(cnt.mythread.isAlive())
          {
            System.out.println("Child thread and parent thread alive"); 
            Thread.sleep(1500);
          }
       }
       catch(InterruptedException e)
       {
          System.out.println("Main thread interrupted");
       }
       System.out.println("Main thread stopped" );
    }
}*/

/*
class SingleThread extends Thread {
	public void run() {
		System.out.println("Single Thread.");
	}

	public static void main(String[] args) {
		SingleThread thread = new SingleThread();
		thread.start();
	}
}

class RunnableThread implements Runnable {
	@Override
	public void run() {
		try {
			System.out.println("Runnable Thread:" + Thread.currentThread().getName());
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
}

class Count {
	public static void main(String[] args) {
		Thread t1 = new Thread(new RunnableThread());
		Thread t2 = new Thread(new RunnableThread());
		SingleThread t3 = new SingleThread();

		t1.start();
		t2.start();
		try {
			t2.join();
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		t3.start();
	}
}*/



import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


 class Count {
	
public static void main(String[] args) {
	        ExecutorService executor = Executors.newFixedThreadPool(10);
	        System.out.println("All threads");
	        for (int i = 0; i <= 10; i++) {
	            Runnable worker = new WorkerThread("" + i);
	            executor.execute(worker);
	          }
	        executor.shutdown();
	        while (!executor.isTerminated()) {
	        }
	        System.out.println("Finished all threads");
	    }
	}
class WorkerThread implements Runnable {

	private String command;
	    
	    public WorkerThread(String s){
	        this.command=s;
	    }

	    @Override
	    public void run() {
	        System.out.println(Thread.currentThread().getName()+" Start. Command = "+command);
	        processCommand();
	        System.out.println(Thread.currentThread().getName()+" End.");
	    }

	    private void processCommand() {
	        try {
	            Thread.sleep(5000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public String toString(){
	        return this.command;
	    }
	
	}
