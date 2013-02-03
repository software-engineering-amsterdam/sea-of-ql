package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.types.IDENT;
import org.uva.sea.ql.ast.types.Type;

public class Element{

	public IDENT name;
	//public String question;
	public Type type;
	
	public Element(IDENT name, Type type) {
		this.name=name;
		//this.question=question;
		this.type=type;
	}	
}
