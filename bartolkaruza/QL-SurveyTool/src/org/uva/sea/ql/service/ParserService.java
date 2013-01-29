package org.uva.sea.ql.service;

import java.util.List;

import org.uva.sea.ql.ast.Question;
import org.uva.sea.ql.error.QLError;

public interface ParserService {
	
	public List<QLError> getErrors();
	
	public void parseNewForm(String form);
	
	public List<Question> getVisibleQuestions();

}
