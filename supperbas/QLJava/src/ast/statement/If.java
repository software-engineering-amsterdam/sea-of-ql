package ast.statement;

import ast.*;
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

	public Expression getCondition() {
		return condition;
	}

	public Statement getConsequent() {
		return consequent;
	}

}
