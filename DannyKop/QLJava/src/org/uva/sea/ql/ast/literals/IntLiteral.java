package org.uva.sea.ql.ast.literals;

import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitor.SymbolTable;

public class IntLiteral extends Literal<Integer> {

	private final int value;

	/**
	 * Constructor
	 * @param v - int value
	 */
	public IntLiteral(int v) {
		this.value = v;
	}

	@Override
	public Type typeOf(SymbolTable st) {
		return new IntType();
	}
	public Integer getValue(){
		return this.value;
	}

}
