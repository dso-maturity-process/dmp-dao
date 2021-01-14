package com.governmentcio.dmp.dao;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

@SuppressWarnings("serial")
public class UserRoleDaoSerializer extends StdSerializer<UserRoleDao> {

	public UserRoleDaoSerializer() {
		this(null);
	}

	public UserRoleDaoSerializer(Class<UserRoleDao> t) {
		super(t);
	}

	@Override
	public void serialize(UserRoleDao value, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException {

		jgen.writeStartObject();

		jgen.writeNumberField("id", value.getId());
		jgen.writeObjectField("user", value.getUserDao());
		jgen.writeObjectField("role", value.getRoleDao());
		jgen.writeNumberField("projectid", value.getProjectID());

		jgen.writeEndObject();
	}
}
