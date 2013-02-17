package org.uva.sea.ql.core.dom.statements;

import org.uva.sea.ql.core.dom.Identifier;
import org.uva.sea.ql.core.dom.Statement;
import org.uva.sea.ql.core.dom.StatementVisitor;
import org.uva.sea.ql.core.dom.types.declarations.TypeDeclaration;
import org.uva.sea.ql.core.dom.types.primitive.StringLiteral;

public class Question extends Statement{

	public Identifier name;
	public StringLiteral text;
	public TypeDeclaration type;
	
	public Question(Identifier name,StringLiteral text, TypeDeclaration type) {
		this.name=name;
		this.text=text;
		this.type=type;
	}
	
	@Override
	public void accept(StatementVisitor visitor) {
		visitor.visit(this);
	}
}
