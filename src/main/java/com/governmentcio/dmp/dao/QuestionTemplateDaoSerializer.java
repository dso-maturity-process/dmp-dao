package com.governmentcio.dmp.dao;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

@SuppressWarnings("serial")
public class QuestionTemplateDaoSerializer
		extends StdSerializer<SurveyTemplateDao> {

	public QuestionTemplateDaoSerializer() {
		this(null);
	}

	public QuestionTemplateDaoSerializer(Class<SurveyTemplateDao> t) {
		super(t);
	}

	@Override
	public void serialize(SurveyTemplateDao value, JsonGenerator jgen,
			SerializerProvider provider) throws IOException, JsonProcessingException {

		jgen.writeStartObject();
		jgen.writeNumberField("id", value.getId());
		jgen.writeStringField("name", value.getName());
		jgen.writeStringField("description", value.getDescription());
		jgen.writeEndObject();
	}
}
