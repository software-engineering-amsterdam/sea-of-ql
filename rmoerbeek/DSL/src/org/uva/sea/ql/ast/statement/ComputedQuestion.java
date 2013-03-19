package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.expression.Expr;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.Str;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitors.StatementVisitor;

public class ComputedQuestion extends Question{

	//private final Ident id; // identifier of the question
	//private final String label; // actual question shown on screen
	//private final Type type;
	private final Expr expression;

	public ComputedQuestion(Ident id, String l, Type t, Expr e) {
		super(id, l, t);
		//this.identifier = id;
		//this.label = l;
		//this.type = t;
		this.expression = e;
	}
	
	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	//public Ident getId() {
	//	return id;
	//}
	
	//public String getLabel() {
	//	return label;
	//}

	//public Type getType() {
	//	return type;
	//}
	
	public Expr getExpression() {
		return expression;
	}

}
