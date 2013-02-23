package org.uva.sea.ql.ast.nodes.statements;

import java.util.ArrayList;

import org.uva.sea.ql.ast.nodes.MultiNode;

public abstract class MultiStatement extends Statement implements MultiNode<Statement> {
	private final ArrayList<Statement> values;
	private final boolean isBinaryNode = true;
	private final boolean isUnaryNode = false;
	private final boolean isMultiNode = false;
	
	public MultiStatement(ArrayList<Statement> statements){
		this.values = statements;
	}
	
	@Override
	public void addValue(Statement value) {
		this.values.add(value);
	}

	@Override
	public int getValuesCount() {
		return this.values.size();
	}

	@Override
	public ArrayList<Statement> getValues() {
		return this.values;
	}
	
	@Override
	public Statement getValue(int index){
		return this.values.get(index);
	}
	
	@Override
	public boolean isBinaryNode() {
		return this.isBinaryNode;
	}

	@Override
	public boolean isUnaryNode() {
		return this.isUnaryNode;
	}

	@Override
	public boolean isMultiNode() {
		return this.isMultiNode;
	}
}
