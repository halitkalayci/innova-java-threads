package com.innova;
// Thread classından extend etmek
// Runnable interfaceinden impl. etmek
class MyThread extends Thread {
  @Override
  public void run() {
    for (int i=0; i<100; i++)
    {
      System.out.println("#MyThread i:" + i);
    }
  }
}
class MyThread2 implements Runnable
{

  @Override
  public void run() {
    for (int i=0; i<100; i++)
    {
      System.out.println("#MyThread2 i:" + i);
    }
  }
}


public class ThreadExample {
  public static void main(String[] args) {
    System.out.println("** Threads && Executors **");

    MyThread myThread = new MyThread();
    Thread myThread2 = new Thread(new MyThread2());

    myThread.start();
    myThread2.start();

    // Thread Statuses
    // NEW, RUNNABLE, BLOCKED, WAITING, TERMINATED
  }
}
