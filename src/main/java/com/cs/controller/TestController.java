package com.cs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cs.model.MyModel;
import com.cs.test.SerializationTask;
import com.cs.test.Test;

@Controller
public class TestController {
  
  @Autowired
  Test                             test;
  
  @Autowired
  protected ApplicationContext     appContext;
  
  @Autowired
  protected ThreadPoolTaskExecutor specialTaskExecutor;
  
  @PostMapping("test/{id}")
  public @ResponseBody String handlePostRequest(@PathVariable Integer id,
      @RequestBody MyModel model) throws Exception
  {
    Integer i = 0;
    for (i = 0; i < 10; i++) {
      // test.execute(model);
      // ExecuteSerializationTask.execute(()->startExecution(model));
      
      SerializationTask bean = appContext.getBean(SerializationTask.class, model);
      specialTaskExecutor.submit(bean);
    }
    
    return i.toString();
  }
  
  @SuppressWarnings("unused")
  private void startExecution(MyModel model)
  {
    try {
      test.execute(model);
    }
    catch (Exception e) {
      e.printStackTrace();
      System.out.println("Error startign execution");
    }
  }
  
}
