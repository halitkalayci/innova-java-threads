package com.innova;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.*;
import java.util.concurrent.ScheduledExecutorService;

public class ExecutorsExample {
  public static void main(String[] args) {
    // ExecutorService executor = Executors.newSingleThreadExecutor(); // Single-thread tek tek işlem
    ExecutorService executor = Executors.newFixedThreadPool(3);
    //ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);
    for(int i=0; i<5; i++)
    {
      Runnable task = new Worker("Task " + i);
      executor.execute(task);
    }

    executor.shutdown(); // Threadlere'e yeni görev almaz, sıradaki görevleri tamamlar..
    //executor.shutdownNow(); // Threadler'i anında sonlandırır
  }
}
class Worker implements  Runnable
{
  private String message;

  public Worker(String message) {
    this.message = message;
  }

  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName() + " (Start) " + message);
    try{
      Thread.sleep(3000);
    }catch(Exception e){
    }
    System.out.println(Thread.currentThread().getName() + " (End) " + message);
  }
}