package org.uva.sea.ql.webserver.models;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.*;

@XmlRootElement
public class ValidationWrapper {
	private final String value;
	
	@JsonCreator
	public ValidationWrapper(@JsonProperty("value") String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
