package com.cs.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cs.model.MyModel;

@Controller
public class MyController {
  
  final static Logger logger = Logger.getLogger(MyController.class);
  
  @GetMapping("getRequest/{id}")
  public @ResponseBody Integer handleGetRequest(@PathVariable Integer id)
  {
    logger.info("handleGetRequest() Invoked");
    System.out.println("**********************");
    System.out.println(id);
    System.out.println("**********************");
    
    return id + 100;
  }
  
  @PostMapping("postRequest/{id}")
  public @ResponseBody MyModel handlePostRequest(@PathVariable Integer id, @RequestBody MyModel model)
  {
    logger.info("handleGetRequest() Invoked");
    System.out.println("**********************");
    System.out.println(id + "::" + model.getFname() + "::" + model.getLname());
    System.out.println("**********************");
    
    return model;
  }
  
  @RequestMapping(value = "/putRequest/{id}", method = {RequestMethod.PUT })
  public @ResponseBody MyModel handlePutRequest(@PathVariable Integer id, @RequestBody MyModel model)
  {
    logger.info("handlePutRequest() Invoked");
    System.out.println("**********************");
    System.out.println(id + "::" + model.getFname() + "::" + model.getLname());
    System.out.println("**********************");
    
    return model;
  }
  
  @RequestMapping(value = "/deleteRequest/{id}", method = {RequestMethod.DELETE })
  public @ResponseBody Integer handleDeleteRequest(@PathVariable Integer id)
  {
    logger.info("handleDeleteRequest() Invoked");
    System.out.println("**********************");
    System.out.println(id);
    System.out.println("**********************");
    
    return id;
  }
  
  
}
