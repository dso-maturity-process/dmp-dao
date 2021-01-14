package com.governmentcio.dmp.dao;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

@SuppressWarnings("serial")
public class UserDaoSerializer extends StdSerializer<UserDao> {

	public UserDaoSerializer() {
		this(null);
	}

	public UserDaoSerializer(Class<UserDao> t) {
		super(t);
	}

	@Override
	public void serialize(UserDao value, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException {

		jgen.writeStartObject();
		jgen.writeNumberField("id", value.getId());
		jgen.writeStringField("firstName", value.getFirstName());
		jgen.writeStringField("lastName", value.getLastName());
		jgen.writeStringField("userName", value.getUserName());
		jgen.writeStringField("password", value.getPassword());
		jgen.writeStringField("createdTimestamp", value.getCreatedTimestamp().toString());
		jgen.writeEndObject();
	}
}
