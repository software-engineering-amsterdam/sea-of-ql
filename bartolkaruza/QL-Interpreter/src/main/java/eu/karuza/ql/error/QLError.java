package eu.karuza.ql.error;

import java.io.Serializable;

public class QLError implements Serializable {

	private static final long serialVersionUID = 3519307324771392279L;
	private String cause;

	public QLError(String cause) {
		this.cause = cause;
	}

	public String getCause() {
		return cause;
	}
}
