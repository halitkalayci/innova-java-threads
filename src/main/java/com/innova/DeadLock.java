package com.innova;

public class DeadLock
{
  public static void main(String[] args) {
    final Object resource1 = "resource1";
    final Object resource2 = "resource2";

    Thread t1 = new Thread(() -> {
      synchronized (resource1)
      {
        System.out.println("Thread 1: Locked Resource 1");
        try {
          Thread.sleep(100);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
        System.out.println("Thread 1: Waiting for resource 2");
        synchronized (resource2)
        {
          System.out.println("Thread 1: Locked resource 2");
        }
      }
    });

    Thread t2 = new Thread(() -> {
      synchronized (resource2)
      {
        System.out.println("Thread 2: Locked Resource 2");
        try {
          Thread.sleep(100);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
        System.out.println("Thread 2: Waiting for resource 1");
        synchronized (resource1)
        {
          System.out.println("Thread 2: Locked resource 1");
        }
      }
    });


    t1.start();
    t2.start();

  }
}
