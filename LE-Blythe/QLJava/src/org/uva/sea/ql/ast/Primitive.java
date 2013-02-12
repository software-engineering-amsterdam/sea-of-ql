package org.uva.sea.ql.ast;

import org.uva.sea.ql.util.Environment;

public abstract class Primitive extends Expr{
	
	@Override
	public Primitive interpret(Environment env){
		return this;
	}
	
	
	public boolean isDefined(){
		return true;
	}

}
