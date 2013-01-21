package org.uva.sea.ql.ast;

import org.uva.sea.ql.interfaces.IVisitor;
import org.uva.sea.ql.interfaces.INumeric;
import org.uva.sea.ql.interfaces.IPrimitive;
import org.uva.sea.ql.util.Stack;

public class Int extends Expr implements INumeric, IPrimitive {

	private final Integer value;

	public Int(){
		// create uninitialized int object
		this.value = null;
	}
	
	
	public Int(int n) {
		this.value = n;
	}

	
	/**
	 * @precondition: isDefined() has been called to confirm the value in this object was
	 * initialized
	 */
	public int getValue() {
		return value;
	}
	
	
	public boolean isDefined(){
		return value != null;
	}
	
	
	public void accept(IVisitor visitor, Stack stack) throws Exception {
		visitor.visit(this, stack);
	}
	
}
