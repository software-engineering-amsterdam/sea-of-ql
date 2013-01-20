package ast.type;

import ast.visitor.Visitor;

public class Int implements Type {

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}