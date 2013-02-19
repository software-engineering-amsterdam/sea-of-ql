package org.uva.sea.ql.ast.literals;

import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.SymbolTable;

public class IntLiteral extends Literal<Integer> {

	private final int value;

	/**
	 * Constructor
	 * @param v - int value
	 */
	public IntLiteral(int v) {
		this.value = v;
	}
	public Integer getValue(){
		return this.value;
	}
	@Override
	public Type typeOf(SymbolTable st) {
		return new IntType();
	}

}
