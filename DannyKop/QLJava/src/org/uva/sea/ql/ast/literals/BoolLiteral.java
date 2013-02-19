package org.uva.sea.ql.ast.literals;

import org.uva.sea.ql.ast.types.BoolType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.SymbolTable;

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
	public Boolean getValue(){
		return this.value;
	}
	@Override
	public Type typeOf(SymbolTable st) {
		return new BoolType();
	}

}
