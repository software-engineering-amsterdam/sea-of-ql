package org.uva.sea.ql.ast.type;

import java.util.List;

public class Questions extends Type {
	
	private final List<Question> questions;
	
	public Questions(List<Question> questions){
		this.questions = questions;
	}

	public List<Question> getQuestions() {
		return questions;
	}

}
