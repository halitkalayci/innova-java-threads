package com.innova;

import com.sun.source.tree.LiteralTree;

import java.util.ArrayList;
import java.util.List;

class MemoryLeak
{
  private List<int[]> memoryLeakList = new ArrayList<>();

  public void generateMemoryLeak() {
    for(int i=0; i<1000; i++)
    {
      int[] largeArray = new int[1000000];
      memoryLeakList.add(largeArray);
    }
  }
}

public class MemoryOverload {
  public static void main(String[] args) throws Exception{
    MemoryLeak leak = new MemoryLeak();
    leak.generateMemoryLeak();

    Thread.sleep(50000);
  }
}
