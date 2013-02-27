package org.uva.sea.ql.ast.nodes.statements;

import java.util.ArrayList;

import org.uva.sea.ql.visitor.Visitable;
import org.uva.sea.ql.visitor.Visitor;

public class Block extends MultiStatement implements Visitable {
	public Block(ArrayList<Statement> nodes){
		super(nodes);
	}
	@Override
	public boolean isBlockStatement(){
		return true;
	}
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}