package ast.statement;

import ast.*;
import ast.visitor.Visitor;

public class If extends Statement {

	private final Expression condition;
	private final Block block;

	public If(Expression condition, Block block) {
		this.condition = condition;
		this.block = block;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	public Expression getCondition() {
		return condition;
	}

	public Block getBlock() {
		return block;
	}

}
