package org.uva.sea.ql.ast.expr;

import java.util.Map;

import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.types.UndefinedType;
import org.uva.sea.ql.visitor.IExprVisitor;

public class Ident extends Expr {

	private final String name;

	public Ident(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public <T> T accept(IExprVisitor<T> nodeVisitor) {
		return nodeVisitor.visit(this);
		
	}
	
	@Override
	public Type getExprType(Map<String, Type> typeEnv) {
		if(typeEnv.containsKey(this.getName())){
			return typeEnv.get(this.getName());
			
		}
		//* Throws an error if the variable is not declared****
		return new UndefinedType();
	}
	
	

}
