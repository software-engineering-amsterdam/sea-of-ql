package org.uva.sea.ql.webserver.models;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.*;

/**
 * Represents webservice form input fields.
 * 
 * @author J. Dijkstra
 */
@XmlRootElement
public class ValidationWrapper {
	/**
	 * Value of the validation input.
	 */
	private final String value;
	
	/**
	 * Constructor.
	 * @param value value of the validation input
	 */
	@JsonCreator
	public ValidationWrapper(@JsonProperty("value") String value) {
		this.value = value;
	}
	
	/**
	 * Retrieve the value of the validation input.
	 * @return value
	 */
	public String getValue() {
		return value;
	}
}
