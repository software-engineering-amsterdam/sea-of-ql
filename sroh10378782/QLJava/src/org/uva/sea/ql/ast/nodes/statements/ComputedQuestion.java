package org.uva.sea.ql.ast.nodes.statements;

import java.util.Map;

import org.uva.sea.ql.ast.nodes.expressions.Expr;
import org.uva.sea.ql.ast.nodes.expressions.Ident;
import org.uva.sea.ql.ast.nodes.expressions.Str;
import org.uva.sea.ql.ast.statements.visitor.Visitor;
import org.uva.sea.ql.types.Type;

public class ComputedQuestion extends Statement{
	private final Ident identifier;
	private final Str question;
	private final Expr answerType;
	public ComputedQuestion(Ident identifier, Str question, Expr answerType){
		this.identifier = identifier;
		this.question = question;
		this.answerType = answerType;
	}
	
	@Override
	public Type getType() {
		return answerType.typeOf(null);
	}
	
	public Str getQuestionString(){
		return question;
	}
	
	public Ident getIdent(){
		return this.identifier;
	}
	
	public Expr getExpr(){
		return this.answerType;
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnvironment) {
		typeEnvironment.put(this.identifier,answerType.typeOf(typeEnvironment));
		return getType();
	}
}
