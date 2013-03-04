package org.uva.sea.ql.ast.nodes.statements;

import java.util.Map;

import org.uva.sea.ql.ast.nodes.expressions.Expr;
import org.uva.sea.ql.ast.nodes.expressions.Ident;
import org.uva.sea.ql.ast.statements.visitor.Visitor;
import org.uva.sea.ql.types.Type;

public class IfThenElse extends Statement {
	
	private final Expr condition;
	private final Block ifBlock;
	private final Block elseBlock;
	
	public IfThenElse(Expr condition, Statement ifBlock, Statement elseBlock){
		this.condition = condition;
		this.ifBlock = (Block)ifBlock;
		this.elseBlock = (Block)elseBlock;
	}
	public Expr getCondition(){
		return this.condition;
	}
	public Block getIfBlock(){
		return this.ifBlock;
	}
	public Block getElseBlock(){
		return this.elseBlock;
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
	@Override
	public Type getType() {
		return null;
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnvironment) {
		return null;
	}
}