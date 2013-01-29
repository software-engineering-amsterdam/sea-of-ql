package ast.statement;

import java.util.Map;

import ast.*;
import ast.type.*;
import ast.visitor.Visitor;

public class ElseIf extends Statement {

	private final Expression condition;
	private final Statement consequent;

	public ElseIf(Expression condition, Statement consequent) {
		this.condition = condition;
		this.consequent = consequent;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return null; // visitor.visit(this);
	}

	public Expression getCondition() {
		return condition;
	}

	public Statement getConsequent() {
		return consequent;
	}

	@Override
	public Type typeOf(Map<ast.type.Ident, Type> typeEnv) {
		// TODO Auto-generated method stub
		return null;
	}

}
