package eu.karuza.ql;

import java.io.Serializable;

public class ServerResult implements Serializable {

	private static final long serialVersionUID = 2611334113154601039L;
	private String response;

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

}
