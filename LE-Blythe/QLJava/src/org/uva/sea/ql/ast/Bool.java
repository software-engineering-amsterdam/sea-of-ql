package org.uva.sea.ql.ast;

import org.uva.sea.ql.interfaces.IBoolean;
import org.uva.sea.ql.interfaces.IVisitor;
import org.uva.sea.ql.interfaces.IPrimitive;
import org.uva.sea.ql.util.Stack;

public class Bool extends Expr implements IBoolean, IPrimitive {

	private final Boolean value;
	
	public Bool(){
		value = null;
	}
	
	
	public Bool(boolean b){
		value = b;
	}
	

	public boolean isDefined() {
		return value != null;
	}

	
	/**
	 * @precondition: isDefined() has been called to confirm the value in this object was
	 * initialized
	 */
	public boolean isSatisfied() {
		return value;
	}
	
	
	public void accept(IVisitor visitor, Stack stack) throws Exception{
		visitor.visit(this, stack);
	}

}
