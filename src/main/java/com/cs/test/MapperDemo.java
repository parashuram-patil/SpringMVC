package com.cs.test;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class MapperDemo {
  
  private final ObjectMapper mapper = new ObjectMapper();
  
 /* MapperDemo() {
    super();
    this.mapper = mapper == null ? new ObjectMapper() : mapper;
  }*/
  
  public String toJson(final Object instance) throws IOException
  {
    return mapper.writeValueAsString(instance);
  }
  
  public <T> T fromJson(final String json, final Class<T> clazz) throws IOException
  {
    return mapper.readValue(json, clazz);
  }
}