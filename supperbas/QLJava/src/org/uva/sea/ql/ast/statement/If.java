package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.*;

public class If extends Statement {

	private final Expression condition;
	private final Block trueBlock;
	private final Block falseBlock;

	public If(Expression condition, Block trueBlock){
		this(condition, trueBlock, new Block());
	}
	
	public If(Expression condition, Block trueBlock, Block falseBlock) {
		this.condition = condition;
		this.trueBlock = trueBlock;
		this.falseBlock = falseBlock;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	public Expression getCondition() {
		return condition;
	}

	public Block getTrueBlock() {
		return trueBlock;
	}
	
	public Block getFalseBlock() {
		return falseBlock;
	}
}
