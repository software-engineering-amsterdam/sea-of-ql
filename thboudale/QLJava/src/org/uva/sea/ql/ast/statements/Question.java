package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.types.AType;
import org.uva.sea.ql.semanticCheck.FormStmtVisitor;

public class Question extends AStatement {
	private final Ident ident;
	private final String label;
	private final AType type;

	public Question(Ident ident, String label, AType type) {
		this.ident = ident;
		this.label = label;
		this.type = type;
	}
	
	public Ident getIdent() {
		return ident;
	}
	
	public String getLabel() {
		return label;
	}
	
	public AType getType() {
		return type;
	}

	@Override
	public <T> T accept(FormStmtVisitor<T> visitor) {
		return visitor.visit(this);		
	}
}