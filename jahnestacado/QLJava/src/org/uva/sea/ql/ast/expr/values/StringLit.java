package org.uva.sea.ql.ast.expr.values;

import java.util.Map;

import org.uva.sea.ql.ast.types.StringType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.IExprVisitor;

public class StringLit extends Value<String>  {
   
	
	public StringLit(String value) {
		super(value);
		
	}


	@Override
	public <T> T accept(IExprVisitor<T> nodeVisitor) {
		return nodeVisitor.visit(this);
		
	}

	@Override
	public Type isOfType(Map<String, Type> typeEnv) {
		return new StringType();
	}

}
