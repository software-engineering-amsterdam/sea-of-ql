package org.uva.sea.ql.ast.primitive;

import org.uva.sea.ql.ast.Primitive;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.interfaces.IVisitor;
import org.uva.sea.ql.util.Environment;

public class Int extends Primitive {

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
	
	
	public Type typeOf(Environment env){
		return new org.uva.sea.ql.ast.types.Int();
	}
	
	
	@Override
	public <T> T accept(IVisitor<T> visitor) {
		return visitor.visit(this);
	}	
}
