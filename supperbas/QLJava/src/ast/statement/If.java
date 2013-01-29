package ast.statement;

import java.util.Map;

import ast.*;
import ast.type.Ident;
import ast.type.Type;
import ast.visitor.Visitor;

public class If extends Statement {

	private final Expression condition;
	private final Statement consequent;

	public If(Expression condition, Statement consequent) {
		this.condition = condition;
		this.consequent = consequent;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return null; // visitor.visit(this);
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		// TODO Auto-generated method stub
		return null;
	}

	public Expression getCondition() {
		return condition;
	}

	public Statement getConsequent() {
		return consequent;
	}

}
