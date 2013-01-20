package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.literals.Text;


public class Question extends Expr {

	private final Ident ident;
	private final Text label;
	private final DataType dataType;
	
	public Question(final Ident ident, final Text label, final DataType dataType){
		this.ident = ident;
		this.label = label;
		this.dataType = dataType;
	}

}
