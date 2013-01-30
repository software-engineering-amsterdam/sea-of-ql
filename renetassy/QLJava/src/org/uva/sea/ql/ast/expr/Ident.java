package org.uva.sea.ql.ast.expr;

import java.util.Map;

import org.uva.sea.ql.ast.ExprTypeChecker;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.types.UndefinedType;

public class Ident extends Expr {

	private final String name;

	public Ident(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public boolean accept(ExprTypeChecker visitor) {
		return visitor.visit(this);
	}

	@Override
	public Type isOfType(Map<String, Type> typeEnvironment) {
		
		if(typeEnvironment.containsKey(name)) {
			return typeEnvironment.get(name);
		}
		
		return new UndefinedType();
	}

}
