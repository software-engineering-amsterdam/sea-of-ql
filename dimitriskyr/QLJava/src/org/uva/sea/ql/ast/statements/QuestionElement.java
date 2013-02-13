package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.Type;
import org.uva.sea.ql.ast.values.Ident;
import org.uva.sea.ql.ast.values.String_lit;
import org.uva.sea.ql.ast.visitor.IStatementVisitor;

public class QuestionElement extends Statement{
	
	private Ident id;
	private String_lit question;
	private Type type;
	private Expr expression;
	
	public QuestionElement(Ident ident, String_lit string, Type bool){
		this.id=ident;
		this.question=string;
		this.type=bool;
	}
	
	public QuestionElement(Ident ident, String_lit string, Type bool, Expr expression ){
		this.id=ident;
		this.question=string;
		this.type=bool;
		this.expression=expression;
	}
	
	public Type getType() {
		return type;
	}
	
	public Ident getIdent() {
		return id;
	}
	
	public Expr getExpression() {
		return expression;
	}
	
	public String_lit getString() {
		return question;
	}
	
	@Override
	public void accept(IStatementVisitor visitor) {
		visitor.visit(this);
	}

}
