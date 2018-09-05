package com.cs.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cs.model.MyModel;

@Component
public class Test {
  
  @Autowired
  MapperDemo mapper;
  
  public String execute(MyModel model) throws Exception
  {
    
    String importModelString = null;
    
    importModelString = mapper.toJson(model);
    
    //ObjectMapper mapper = new ObjectMapper();
    //importModelString = mapper.writeValueAsString(model);
    
    System.out.println("**********************");
    System.out.println("Model as String -----> " + importModelString);
    System.out.println("**********************");
    
    return importModelString;
    
  }
}
