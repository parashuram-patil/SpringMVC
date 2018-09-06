package com.cs.proto.person;

import java.io.IOException;

import com.cs.proto.compile.person.PersonProto.Person;
import com.cs.proto.compile.person.PhoneNumberProto.PhoneNumber;
import com.cs.proto.compile.person.PhoneNumberProto.PhoneType;
import com.google.protobuf.util.JsonFormat;

public class PersonDemo {
  
  public static void main(String[] args) throws IOException
  {
    Person.Builder person = Person.newBuilder();
    person.setAge(27);
    person.setEmail("a@a.a");
    person.setName("Psp");
    person.addPhones(PhoneNumber.newBuilder().setNumber("123456789").setType(PhoneType.MOBILE));
    person.addPhones(PhoneNumber.newBuilder().setNumber("987654321").setType(PhoneType.HOME));

    System.out.println(JsonFormat.printer().print(person));
    //JsonFormat format = new JsonFormat();
    //System.out.println(format.printToString(person.build()));
    
    String personString = "{\r\n" + 
        "  \"name\": \"Psp\",\r\n" + 
        "  \"email\": \"a@a.a\",\r\n" + 
        "  \"age\": 27,\r\n" + 
        "  \"phones\": [{\r\n" + 
        "    \"number\": \"123456789\"\r\n" + 
        "  }, {\r\n" + 
        "    \"number\": \"987654321\",\r\n" + 
        "    \"type\": \"HOME\"\r\n" + 
        "  }]\r\n" + 
        "}";
    
    Person.Builder person1 = Person.newBuilder();
    JsonFormat.parser().merge(personString, person1);
    //InputStream inputStream = new ByteArrayInputStream(personString.getBytes(Charset.forName("UTF-8")));
    //format.merge(inputStream, person1);
    System.out.println(person1);
  }
}
