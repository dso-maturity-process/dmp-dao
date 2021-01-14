package com.governmentcio.dmp.dao;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

@SuppressWarnings("serial")
public class RoleDaoSerializer extends StdSerializer<RoleDao> {

	public RoleDaoSerializer() {
		this(null);
	}

	public RoleDaoSerializer(Class<RoleDao> t) {
		super(t);
	}

	@Override
	public void serialize(RoleDao value, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException {

		jgen.writeStartObject();
		jgen.writeNumberField("id", value.getId());
		jgen.writeStringField("description", value.getDescription());
		jgen.writeStringField("type", value.getType());
		jgen.writeEndObject();
	}
}
