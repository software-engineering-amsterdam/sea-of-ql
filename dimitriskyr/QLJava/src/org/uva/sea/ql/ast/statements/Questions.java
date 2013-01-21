package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ast.Question;
import org.uva.sea.ql.ast.Type;


public class Questions extends Question {
	private Type ident;
	private Type string;
	private Type bool;
	
	public Questions(Type ident, Type string, Type bool){
		this.ident=ident;
		this.string=string;
		this.bool=bool;
	}
	

	public Type getValue1() {
		return ident;
	}
	
	public Type getValue2() {
		return string;
	}
	
	public Type getValue3() {
		return bool;
	}

}
