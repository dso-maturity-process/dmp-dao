package com.governmentcio.dmp.dao;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

@SuppressWarnings("serial")
public class SurveyInstanceDaoSerializer
		extends StdSerializer<SurveyInstanceDao> {

	public SurveyInstanceDaoSerializer() {
		this(null);
	}

	public SurveyInstanceDaoSerializer(Class<SurveyInstanceDao> t) {
		super(t);
	}

	@Override
	public void serialize(SurveyInstanceDao value, JsonGenerator jgen,
			SerializerProvider provider) throws IOException, JsonProcessingException {

		jgen.writeStartObject();
		jgen.writeNumberField("id", value.getId());
		jgen.writeStringField("surveytemplateid", value.getName());
		jgen.writeStringField("name", value.getName());
		jgen.writeStringField("description", value.getDescription());
		jgen.writeEndObject();
	}
}
