package org.uva.sea.ql.ast.statements;

import java.util.HashSet;
import java.util.Set;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.nodes.IMultiNode;

public class Block extends Expr implements IMultiNode {
	
	private final Set<Expr> statements;
	public Block(HashSet<Expr> statements ){
		this.statements = statements;
	}
	public void addValues(Expr statement){
		this.statements.add(statement);
	}
	public int getValuesCount(){
		return this.statements.size();
	}
	public Expr getValue(int key){
		return (Expr)this.statements.toArray()[key];
	}
	@Override
	public boolean isMultiNode() {
		return true;
	}
	@Override
	public boolean isBinaryNode() {
		return false;
	}
	@Override
	public boolean isUnaryNode() {
		return false;
	}
}
