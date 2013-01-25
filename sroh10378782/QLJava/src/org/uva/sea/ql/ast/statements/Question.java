package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.nodes.IBinaryNode;

public class Question extends Expr implements IBinaryNode{
	private final Expr ident;
	private final Expr questionBody;
	
	public Question(Expr id,Expr questionString, Expr answertype){
		this.ident 		= id;
		this.questionBody	= new QuestionBody(questionString, answertype);
	}
	
	@Override
	public Expr getLhs() {
		return this.ident;
	}
	
	@Override
	public Expr getRhs() {
		return this.questionBody;
	}
	
	@Override
	public boolean isBinaryNode() {
		return true;
	}
	@Override
	public boolean isUnaryNode() {
		return false;
	}
	@Override
	public boolean isMultiNode() {
		return false;
	}
}