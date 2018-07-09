package com.cs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
  
  @GetMapping("getRequest/{id}")
  public @ResponseBody Integer handleRequest(@PathVariable Integer id)
  {
    System.out.println("**********************");
    System.out.println(id);
    System.out.println("**********************");
    
    return id + 100;
  }
  
}
