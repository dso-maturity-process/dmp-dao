package com.governmentcio.dmp.dao;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

@SuppressWarnings("serial")
public class ProjectSerializer extends StdSerializer<ProjectDao> {

	public ProjectSerializer() {
		this(null);
	}

	public ProjectSerializer(Class<ProjectDao> t) {
		super(t);
	}

	@Override
	public void serialize(ProjectDao value, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException {

		jgen.writeStartObject();
		jgen.writeStringField("name", value.getName());
		jgen.writeEndObject();
	}
}
