package org.uva.sea.ql.ast.nodes.statements;

import java.util.Map;

import org.uva.sea.ql.ast.nodes.expressions.Ident;
import org.uva.sea.ql.ast.statements.visitor.Visitor;
import org.uva.sea.ql.types.Type;

public class Form extends Statement {
	private final Ident identifier;
	private final Block block;
	
	public Form(Ident identifier, Statement block){
		this.identifier = identifier;
		this.block = (Block)block;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnvironment) {
		// typeEnvironment.put(this.identifier,new TForm());
		return getType();
	}

	@Override
	public Type getType() {
		return null;
	}
	
	public Block getBlock(){
		return this.block;
	}
	
	public Ident getIdent(){
		return this.identifier;
	}
}