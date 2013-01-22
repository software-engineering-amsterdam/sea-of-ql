package org.uva.sea.ql.ast;

import org.uva.sea.ql.util.Environment;

public abstract class Primitive extends Expr{
	
	@Override
	public Primitive interpret(Environment env) throws Exception{
		return this;
	}

}
