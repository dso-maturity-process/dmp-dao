package com.governmentcio.dmp.dao;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

@SuppressWarnings("serial")
public class SurveyTemplateQuestionTemplateDaoSerializer
		extends StdSerializer<SurveyTemplateQuestionTemplateDao> {

	public SurveyTemplateQuestionTemplateDaoSerializer() {
		this(null);
	}

	public SurveyTemplateQuestionTemplateDaoSerializer(
			Class<SurveyTemplateQuestionTemplateDao> t) {
		super(t);
	}

	@Override
	public void serialize(SurveyTemplateQuestionTemplateDao value,
			JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException {

		jgen.writeStartObject();
		jgen.writeNumberField("id", value.getId());
		jgen.writeNumberField("id", value.getId());
		jgen.writeEndObject();
	}
}
