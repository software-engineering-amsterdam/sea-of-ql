package org.uva.sea.ql.ast.expression.literal;

import org.uva.sea.ql.ast.DataType;
import org.uva.sea.ql.ast.expression.Expression;


public abstract class Literal extends Expression {
	
	private final DataType dataType;
	
	public Literal(final DataType dataType){
		this.dataType = dataType;
	}

	public DataType getDataType(){
		return this.dataType;
	}
	

	@Override
	public String toString() {
		return "Literal [dataType=" + dataType + "]";
	}

}
