package org.uva.sea.ql.ast.expr;

import java.util.Map;

import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.checkers.ExpressionChecker;

public class Ident extends Expr {

	private final String name;

	public Ident(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public boolean accept(ExpressionChecker nodeVisitor) {
		return nodeVisitor.visit(this);
		
	}
	
	@Override
	public Type isOfType(Map<String, Type> typeEnv) {
		if(typeEnv.containsKey(this.getName())){
			return typeEnv.get(this.getName());
			
		}
		//* <TODO> Should throw an error if the variable is not declared****
		else return null;
	}
	
	

}
