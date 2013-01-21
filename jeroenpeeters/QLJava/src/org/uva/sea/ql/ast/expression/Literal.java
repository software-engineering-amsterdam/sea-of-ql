package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.ast.DataType;
import org.uva.sea.ql.parser.ASTVisitor;


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

}
