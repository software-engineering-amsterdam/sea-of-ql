package org.uva.sea.ql.ast.literals;

import org.uva.sea.ql.ast.types.BoolType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitor.SymbolTable;

public class BoolLiteral extends Literal<Boolean> {
	
	private final boolean value;
	
	/**
	 * Constructor
	 * @param v 
	 */
	public BoolLiteral(boolean v){
		this.value = v;
	}
	/**
	 * Constructor
	 * @param v
	 */
	public BoolLiteral(String v){
		this(Boolean.parseBoolean(v));
	}
	@Override
	public Type typeOf(SymbolTable st) {
		// TODO Auto-generated method stub
		return new BoolType();
	}
	public Boolean getValue(){
		return this.value;
	}

}
