package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.types.Ident;
import org.uva.sea.ql.ast.types.Type;

public class Element{

	public Ident name;
	//public String question;
	public Type type;
	
	public Element(Ident name, Type type) {
		this.name=name;
		//this.question=question;
		this.type=type;
	}	
}
