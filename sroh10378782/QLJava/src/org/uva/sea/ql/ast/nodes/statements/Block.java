package org.uva.sea.ql.ast.nodes.statements;

import java.util.ArrayList;
import java.util.Map;

import org.uva.sea.ql.ast.nodes.expressions.Ident;
import org.uva.sea.ql.ast.statements.visitor.Visitor;
import org.uva.sea.ql.types.Type;

public class Block extends Statement {
	private final ArrayList<Statement> values;
	public Block(ArrayList<Statement> values){
		this.values = values;
	}
	public void addValue(Statement value) {
		this.values.add(value);
	}
	public int getValuesCount() {
		return this.values.size();
	}
	public ArrayList<Statement> getValues() {
		return this.values;
	}
	public Statement getValue(int index){
		return this.values.get(index);
	}
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	@Override
	public Type typeOf(Map<Ident, Type> typeEnvironment) {
		return null;
	}
	@Override
	public Type getType() {
		return null;
	}
}