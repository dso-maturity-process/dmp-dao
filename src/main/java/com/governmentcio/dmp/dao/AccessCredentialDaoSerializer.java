package com.governmentcio.dmp.dao;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

@SuppressWarnings("serial")
public class AccessCredentialDaoSerializer
		extends StdSerializer<AccessCredentialDao> {

	public AccessCredentialDaoSerializer() {
		this(null);
	}

	public AccessCredentialDaoSerializer(Class<AccessCredentialDao> t) {
		super(t);
	}

	@Override
	public void serialize(AccessCredentialDao value, JsonGenerator jgen,
			SerializerProvider provider) throws IOException, JsonProcessingException {

		jgen.writeStartObject();
		jgen.writeStringField("accessCode", value.getAccessCode());
		jgen.writeEndObject();
	}
}
