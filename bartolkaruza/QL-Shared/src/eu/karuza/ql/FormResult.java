package eu.karuza.ql;

import java.util.List;

public class FormResult {

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
