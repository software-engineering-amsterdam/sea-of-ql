package org.uva.sea.ql.core.dom.statements;

import org.uva.sea.ql.core.dom.Identifier;
import org.uva.sea.ql.core.dom.Statement;
import org.uva.sea.ql.core.dom.StatementVisitor;
import org.uva.sea.ql.core.dom.types.declarations.TypeDefinition;
import org.uva.sea.ql.core.dom.types.primitive.StringLiteral;

public class FormElement extends Statement{

	public Identifier name;
	public StringLiteral text;
	public TypeDefinition type;
	
	public FormElement(Identifier name,StringLiteral text, TypeDefinition type) {
		this.name=name;
		this.text=text;
		this.type=type;
	}

	@Override
	public void accept(StatementVisitor visitor) {
		visitor.visit(this);
	}	
}
