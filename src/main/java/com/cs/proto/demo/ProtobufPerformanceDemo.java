package com.cs.proto.demo;

import java.io.FileInputStream;
import java.io.InputStream;

import com.cs.proto.model.KlassInstanceProto.KlassInstance;

public class ProtobufPerformanceDemo {
  
  public static void main(String[] args) throws Exception
  {
    Long startTime = System.currentTimeMillis();
    InputStream input = new FileInputStream("src/main/resources/protoTest/klassinstancecache_encoded.txt");
    
    KlassInstance klassInstance = KlassInstance.parseFrom(input);
    
    Long endTime = System.currentTimeMillis();
    System.out.println("Protobuf took " + (endTime - startTime) + "ms to deserialize");
  }
}