package org.uva.sea.ql.ast;

import java.util.List;

public class Form {
	protected Expr name;
	protected List<Statement> sList;

	public Form(Expr x, List<Statement> r){
		name = x;
		sList = r;
	}
	
	public String toString(){
		return name.toString() + ", " +sList.toString();
	}
}
