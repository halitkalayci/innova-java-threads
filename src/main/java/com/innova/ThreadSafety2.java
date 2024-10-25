package com.innova;

class Volatile {
  private volatile boolean running = true;

  public void run() {
    System.out.println("Task started..");

    while(running)
    {
      System.out.println(".");
      try{
        Thread.sleep(500);
      }catch(Exception e)
      {
        e.printStackTrace();
      }
    }

    System.out.println("Task stopped");
  }

  public void stopTask() {
    running = false;
  }
}

public class ThreadSafety2 {
  public static void main(String[] args) throws Exception {
    Volatile volatileExample = new Volatile();

    Thread t1 = new Thread(volatileExample::run);
    t1.start();

    Thread t2 = new Thread(volatileExample::run);
    t2.start();


    Thread.sleep(3000);
    System.out.println("Task is stopping...");
    volatileExample.stopTask();

    t1.join();
    t2.join();
  }
}
