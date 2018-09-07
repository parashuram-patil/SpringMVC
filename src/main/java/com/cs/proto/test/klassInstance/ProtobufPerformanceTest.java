package com.cs.proto.test.klassInstance;

import java.io.FileInputStream;
import java.io.InputStream;

import com.cs.proto.compile.klassInstance.KlassInstanceProto.KlassInstance;

public class ProtobufPerformanceTest {
  
  public static void main(String[] args) throws Exception
  {
    Long startTime = System.currentTimeMillis();
    InputStream input = new FileInputStream("src/main/resources/protoTest/klassinstancecache_encoded.txt");
    
    KlassInstance klassInstance = KlassInstance.parseFrom(input);
    
    Long endTime = System.currentTimeMillis();
    System.out.println(klassInstance.getId() + " took " + (endTime - startTime) + "ms to deserialize");
  }
  
}
