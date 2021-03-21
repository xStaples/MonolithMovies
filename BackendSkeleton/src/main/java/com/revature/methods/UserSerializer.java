package com.revature.methods;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.revature.models.User;


public class UserSerializer extends StdSerializer <User> {

	public UserSerializer() {
		this(null);
	}
	
	public UserSerializer(Class<User> u) {
		super(u);
	}
	
	
	public void serialize(User user, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
		jgen.writeStartObject();
		jgen.writeNumberField("id", user.getId());
		jgen.writeStringField("username", user.getUsername());
		jgen.writeStringField("password", user.getPassword());
		jgen.writeEndObject();
	}
}
