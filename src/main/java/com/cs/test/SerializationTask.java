package com.cs.test;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.cs.model.MyModel;

@Component
@Scope("prototype")
public class SerializationTask implements Runnable {
  
  @Autowired
  Test            test;
  
  private MyModel model;
  public static Integer count = 1;
  
  Integer         min = 100;
  Integer         max = 200;
  
  public SerializationTask(MyModel model)
  {
    this.model = model;
  }
  
  @Override
  public void run()
  {
    Random random = new Random();
    int delay = random.nextInt((max - min) + 1) + min;
    try {
      test.execute(model);
      Thread.sleep(delay);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    
    System.out.println("Thread " + Thread.currentThread().getName() + " ---> " + delay + " successfully executed... > " + count++);
  }
  
}
