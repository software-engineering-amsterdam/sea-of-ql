package org.uva.sea.ql.ast.nodes.statements;

import java.util.Map;

import org.uva.sea.ql.ast.nodes.expressions.Expr;
import org.uva.sea.ql.ast.nodes.expressions.Ident;
import org.uva.sea.ql.ast.statements.visitor.Visitor;
import org.uva.sea.ql.types.Type;

public class IfThen extends Statement {
	private final Expr condition;
	private final Block block;
	
	public IfThen(Expr condition, Statement block){
		this.condition = condition;
		this.block = (Block)block;
	}
	public Expr getCondition(){
		return this.condition;
	}
	public Block getBlock(){
		return this.block;
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