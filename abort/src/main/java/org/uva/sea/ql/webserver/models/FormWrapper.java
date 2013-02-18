package org.uva.sea.ql.webserver.models;

import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.*;

/**
 * Represents webservice form input.
 * 
 * @author J. Dijkstra
 */
@XmlRootElement
public class FormWrapper {
	/**
	 * Map of keys and values that represent the form.
	 */
	private final Map<String, String> formMap;
	/**
	 * Form name.
	 */
	private final String name;
	
	/**
	 * Constructor.
	 * @param name name of the form.
	 * @param formMap keys and values that represent the form.
	 */
	@JsonCreator
	public FormWrapper(@JsonProperty("name") final String name, @JsonProperty("form") final Map<String, String> formMap) {
		this.name = name;
		this.formMap = formMap;
	}

	/**
	 * Retrieve the map of keys and values the form entails.
	 * @return map of keys and values
	 */
	public Map<String, String> getFormMap() {
		return formMap;
	}
	
	/**
	 * Retrieve the form name.
	 * @return form name
	 */
	public String getName() {
		return name;
	}
}
