package com.innova;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Benchmark {
  public static void main(String[] args) throws Exception{
    //ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();
    ExecutorService executorService = Executors.newFixedThreadPool(100);
    IntStream.range(0, 1000).forEach(i -> {
      executorService.submit(() -> {
        System.out.println("Starting thread: " + i);
        performTask(i);
        System.out.println("Ending thread: " + i);
      });
    });
    executorService.shutdown();

    Thread.sleep(500000);
  }

  private static void performTask(int taskId) {
    long sum = 0;
    for (int i = 0; i < 1000000; i++) {
      sum += i;
      System.out.println(taskId + ". task i:" + i);
    }
  }
}
