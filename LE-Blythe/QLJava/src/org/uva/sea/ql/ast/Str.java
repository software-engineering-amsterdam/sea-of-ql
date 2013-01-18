package org.uva.sea.ql.ast;

import org.uva.sea.ql.interfaces.IVisitor;
import org.uva.sea.ql.interfaces.IPrimitive;
import org.uva.sea.ql.util.Stack;

public class Str extends Expr implements IPrimitive {

	private final String value;
	
	public Str(){
		value = null;
	}
	
	
	public Str(String s){
		value = s;
	}
	
	
	public boolean isDefined(){
		return value != null;
	}
	
	
	public void accept(IVisitor visitor, Stack stack) throws Exception {
		visitor.visit(this, stack);
	}
}
