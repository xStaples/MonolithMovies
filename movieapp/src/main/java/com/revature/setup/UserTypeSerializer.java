package com.revature.setup;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.revature.model.UserType;

public class UserTypeSerializer extends StdSerializer <UserType> {

  public UserTypeSerializer() {
    this(null);
  }
  public UserTypeSerializer(Class<UserType> u) {
    super(u);
  }


@Override
public void serialize(UserType usertype, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {

  jgen.writeStartObject();
  jgen.writeNumberField("id", usertype.getId());
  jgen.writeStringField("type", usertype.getType());
  jgen.writeEndObject();
}
  
}
