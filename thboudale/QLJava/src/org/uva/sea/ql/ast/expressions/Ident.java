package org.uva.sea.ql.ast.expressions;

import java.util.Map;
import org.uva.sea.ql.ast.types.AType;
import org.uva.sea.ql.ast.types.ErrorType;
import org.uva.sea.ql.semanticCheck.ExprVisitor;

public class Ident extends AExpr {
	private final String name;

	public Ident(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public AType typeOf(Map<Ident, AType> typeEnv) {

		for (Ident id : typeEnv.keySet()) {
			if (id.getName().equals(this.name)) {
				return typeEnv.get(id);
			}
		}
		return new ErrorType();
		 		
		/*if (typeEnv.containsKey(this)) {
			return typeEnv.get(this);
		}
		return new ErrorType();*/
	}
	
	@Override
	public <T> T accept(ExprVisitor<T> visitor) {
		return visitor.visit(this);
	}
}