package org.uva.sea.ql.ast;


public class QuestionnaireForm extends Expr {
	
	private String formName;
	private QuestionnaireContent content;
	
	public QuestionnaireForm(String formName, QuestionnaireContent content) {
		this.formName = formName;
		this.content = content;
	}

	public String getFormName() {
		return formName;
	}
	
	public QuestionnaireContent getContent(){
		return content;
	}
}
