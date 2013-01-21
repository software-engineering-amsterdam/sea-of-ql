package org.uva.sea.ql.ast;

import java.util.List;

public class QuestionnaireContent extends Expr{

	private List<QuestionnaireItemInterface> questionnaireItems;
	
	public QuestionnaireContent(List<QuestionnaireItemInterface> qItems){
		questionnaireItems = qItems;
	}
	
	public List<QuestionnaireItemInterface> getAllQuestionnaireItems(){
		return questionnaireItems;
	}
}
