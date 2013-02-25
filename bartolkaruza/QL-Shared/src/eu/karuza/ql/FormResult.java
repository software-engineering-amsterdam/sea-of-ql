package eu.karuza.ql;

import java.io.Serializable;
import java.util.List;

public class FormResult implements Serializable {

	private static final long serialVersionUID = 4256448669060242580L;
	private String name;
	private List<QuestionResult> result;

	public List<QuestionResult> getResult() {
		return result;
	}

	public void setResult(List<QuestionResult> result) {
		this.result = result;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
