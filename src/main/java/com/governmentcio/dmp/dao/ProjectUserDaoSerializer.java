package com.governmentcio.dmp.dao;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

@SuppressWarnings("serial")
public class ProjectUserDaoSerializer extends StdSerializer<ProjectUserDao> {

	public ProjectUserDaoSerializer() {
		this(null);
	}

	public ProjectUserDaoSerializer(Class<ProjectUserDao> t) {
		super(t);
	}

	@Override
	public void serialize(ProjectUserDao value, JsonGenerator jgen,
			SerializerProvider provider) throws IOException, JsonProcessingException {

		jgen.writeStartObject();

		jgen.writeNumberField("id", value.getId());
		jgen.writeObjectField("user", value.getUserDao());

		jgen.writeEndObject();
	}
}
