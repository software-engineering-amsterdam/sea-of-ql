package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.types.IDENT;
import org.uva.sea.ql.ast.types.TypeDefinition;

public class FormElement extends Expr{

	public IDENT name;
	public StringLiteral text;
	public TypeDefinition type;
	
	public FormElement(IDENT name,StringLiteral text, TypeDefinition type) {
		this.name=name;
		this.text=text;
		this.type=type;
	}	
}
