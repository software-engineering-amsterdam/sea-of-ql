package org.uva.sea.ql.ast;

public class Question extends Expr implements QuestionnaireItemInterface {

	// private final Expr question;
	private QuestionType questionType;
	private String questionIdentifier;
	private String questionLabel;
	private Expr valueExpr = null;
	public Question(String qIdentifier, String qLabel,	QuestionType qType) {
		this.questionIdentifier = qIdentifier;
		this.questionLabel = qLabel;
		this.questionType = qType;
	}

	public Question(String qIdentifier, String qLabel,	QuestionType qType, Expr valExpr) {
		this.questionIdentifier = qIdentifier;
		this.questionLabel = qLabel;
		this.questionType = qType;
		this.valueExpr =  valExpr;
	}
	
	public QuestionType getQuestionType(){
		return questionType;
	}

	public String getQuestionIdentifier() {
		return questionIdentifier;
	}

	public String getQuestionLabel() {
		return questionLabel;
	}

	public Expr getValueExpr() {
		return valueExpr;
	}
	
	
	
}
