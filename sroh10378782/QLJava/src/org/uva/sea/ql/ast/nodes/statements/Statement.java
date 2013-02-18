package org.uva.sea.ql.ast.nodes.statements;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.visitor.Visitor;

public abstract class Statement extends Expr {
	private final String astNodeType = "Statement";
	
	public String getNodeType(){
		return this.astNodeType;
	}
	
	public boolean isQuestionStatement(){
		return false;
	}
	public boolean isBlockStatement(){
		return false;
	}
	public boolean isQuestionBodyStatement(){
		return false;
	}
	public boolean isFormStatement(){
		return false;
	}
	public boolean isConditionStatement(){
		return false;
	}
	public boolean isConditionalStatement(){
		return false;
	}
	
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}