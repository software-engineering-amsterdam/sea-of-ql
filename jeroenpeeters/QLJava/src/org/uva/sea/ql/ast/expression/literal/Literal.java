package org.uva.sea.ql.ast.expression.literal;

import org.uva.sea.ql.ast.DataType;
import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.visitor.ASTVisitor;


public abstract class Literal extends Expression {
	
	private final DataType dataType;
	
	public Literal(final DataType dataType){
		this.dataType = dataType;
	}

	public DataType getDataType(){
		return this.dataType;
	}
	
	public void accept(ASTVisitor v){
		v.visit(this);
	}

	@Override
	public String toString() {
		return "Literal [dataType=" + dataType + "]";
	}

}