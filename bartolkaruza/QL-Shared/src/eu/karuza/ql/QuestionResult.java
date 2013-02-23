package eu.karuza.ql;

import java.io.Serializable;

public class QuestionResult implements Serializable {

	private static final long serialVersionUID = 4356203745467789794L;
	private String name;
	private String value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
