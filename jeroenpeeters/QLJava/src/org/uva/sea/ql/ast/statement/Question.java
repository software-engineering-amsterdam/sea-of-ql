package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.DataType;
import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.expression.literal.TextLiteral;

public class Question extends Statement {

	private final Identifier ident;
	private final TextLiteral label;
	private final DataType dataType;
	
	public Question(final Identifier ident, final TextLiteral label, final DataType dataType){
		this.ident = ident;
		this.label = label;
		this.dataType = dataType;
	}

	public Identifier getIdent() {
		return ident;
	}

	public TextLiteral getLabel() {
		return label;
	}

	public DataType getDataType() {
		return dataType;
	}
	
	public <T> T accept(final StatementVisitor<T> v){
		return v.visit(this);
	}

}
