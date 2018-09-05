package com.cs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cs.proto.compile.person.PersonProto.Person;

@Controller
public class MyProtoController {
  
  @RequestMapping(value = "protoBuf", method = RequestMethod.GET, produces = "application/x-protobuf")
  public @ResponseBody Person getPersonProto() {
    Person.Builder person = Person.newBuilder();
    person.setAge(27);
    person.setEmail("a@a.a");
    person.setName("Psp");
    
    Person person2 = Person.newBuilder().build();
    
    return person.build();
  }
}
