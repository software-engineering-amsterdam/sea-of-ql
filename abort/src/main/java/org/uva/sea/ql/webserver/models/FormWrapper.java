package org.uva.sea.ql.webserver.models;

import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.*;

@XmlRootElement
public class FormWrapper {
	private final Map<String, String> formMap;
	private final String name;
	
	@JsonCreator
	public FormWrapper(@JsonProperty("name") final String name, @JsonProperty("form") final Map<String, String> formMap) {
		this.name = name;
		this.formMap = formMap;
	}

	public Map<String, String> getFormMap() {
		return formMap;
	}
	
	public String getName() {
		return name;
	}
}
