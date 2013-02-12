package org.uva.sea.ql.questionnaire;

import org.uva.sea.ql.ast.expr.ASTNode;

public class Questionnaire extends ASTNode{

	private final String questionnaireName;
	private final Block questionnaireBlock= null;
	public Questionnaire(String qName){
		this.questionnaireName = qName;
	}
	
	public String getName(){
		return this.questionnaireName;
	}

}
