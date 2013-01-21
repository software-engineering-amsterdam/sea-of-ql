package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.literals.TextLiteral;
import org.uva.sea.ql.parser.ASTVisitor;

public class Question extends Statement {

	private final Ident ident;
	private final TextLiteral label;
	private final DataType dataType;
	
	public Question(final Ident ident, final TextLiteral label, final DataType dataType){
		this.ident = ident;
		this.label = label;
		this.dataType = dataType;
	}
	
	public void accept(ASTVisitor v){
		v.visit(this);
	}

	public Ident getIdent() {
		return ident;
	}

	public TextLiteral getLabel() {
		return label;
	}

	public DataType getDataType() {
		return dataType;
	}

}
