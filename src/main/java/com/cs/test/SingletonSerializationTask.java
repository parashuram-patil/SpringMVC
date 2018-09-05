package com.cs.test;

public class SingletonSerializationTask {
  
  public static void execute(Runnable code)
  {
    long start = System.nanoTime();
    try {
      code.run();
    }
    finally {
      long end = System.nanoTime();
      System.out.println("Total Time taken by : " + Thread.currentThread().getName() + " ---> " + (end - start) / 1.0e9);
    }
  }
}
