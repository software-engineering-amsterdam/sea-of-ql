package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.types.Ident;
import org.uva.sea.ql.ast.types.TypeDefinition;

public class FormElement extends Expr{

	public Ident name;
	public StringLiteral text;
	public TypeDefinition type;
	
	public FormElement(Ident name,StringLiteral text, TypeDefinition type) {
		this.name=name;
		this.text=text;
		this.type=type;
	}	
}
