package org.uva.sea.ql.ast;

import java.util.List;

public class IfBlock extends Expr implements QuestionnaireItemInterface {

	private Expr cExpr;
	private String cExprString;
	private List<QuestionnaireItemInterface> ifBlockItems;
	public IfBlock(Expr conditionExpression, List<QuestionnaireItemInterface> ifBlItems) {
		this.cExpr = conditionExpression;
		this.ifBlockItems = ifBlItems;
	}

	public IfBlock(String conditionExpression, List<QuestionnaireItemInterface> ifBlItems) {
		this.cExprString = conditionExpression;
		this.ifBlockItems = ifBlItems;
	}

	public Expr getcExpr() {
		return cExpr;
	}

	public String getcExprString() {
		return cExprString;
	}

	public List<QuestionnaireItemInterface> getIfBlockItems() {
		return ifBlockItems;
	}
	
}
