package com.governmentcio.dmp.dao;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

@SuppressWarnings("serial")
public class SurveyResponseDaoSerializer
		extends StdSerializer<SurveyResponseDao> {

	public SurveyResponseDaoSerializer() {
		this(null);
	}

	public SurveyResponseDaoSerializer(Class<SurveyResponseDao> t) {
		super(t);
	}

	@Override
	public void serialize(SurveyResponseDao value, JsonGenerator jgen,
			SerializerProvider provider) throws IOException, JsonProcessingException {

		jgen.writeStartObject();
		jgen.writeNumberField("id", value.getId());
		jgen.writeStringField("answer", value.getAnswer());
		jgen.writeStringField("question", value.getQuestion());
		jgen.writeEndObject();
	}
}
