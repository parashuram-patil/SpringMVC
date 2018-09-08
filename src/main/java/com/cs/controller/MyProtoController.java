package com.cs.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cs.proto.model.PersonProto.Person;
import com.cs.proto.model.PhoneNumberProto.PhoneNumber;
import com.cs.proto.model.PhoneNumberProto.PhoneType;

@Controller
public class MyProtoController {
  
  final static Logger logger = Logger.getLogger(MyController.class);
  
  @RequestMapping(value = "protoBuf", method = RequestMethod.GET, produces = "application/x-protobuf")
  public @ResponseBody Person getPersonProto() {
    
    logger.info("getPersonProto() Invoked");
    
    Person.Builder person = Person.newBuilder();
    person.setAge(27);
    person.setEmail("a@a.a");
    person.setName("Psp");
    person.addPhones(PhoneNumber.newBuilder().setNumber("123456789").setType(PhoneType.MOBILE));
    person.addPhones(PhoneNumber.newBuilder().setNumber("987654321").setType(PhoneType.HOME));
    
    Person person2 = Person.newBuilder().build();
    
    return person.build();
  }
}
