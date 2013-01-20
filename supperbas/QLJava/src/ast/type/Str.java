package ast.type;

import ast.visitor.Visitor;

public class Str implements Type {

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}