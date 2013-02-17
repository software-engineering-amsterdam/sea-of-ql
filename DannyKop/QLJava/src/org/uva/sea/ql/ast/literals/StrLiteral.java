package org.uva.sea.ql.ast.literals;

import org.uva.sea.ql.ast.types.StrType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.SymbolTable;

public class StrLiteral extends Literal<String> {

	private final String value;
	
	/**
	 * Constructor
	 * @param v - the string
	 */
	public StrLiteral(String v) {
		this.value = v;
	}
	public String getValue(){
		return this.value;
	}
	@Override
	public Type typeOf(SymbolTable st) {
		return new StrType();
	}

}
