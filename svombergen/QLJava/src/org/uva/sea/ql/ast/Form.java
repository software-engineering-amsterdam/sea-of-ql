package org.uva.sea.ql.ast;

import java.util.List;

public class Form {
	protected Expr name;
	protected List<Statement> sList;

	public Form(Expr x, List<Statement> r){
		name = x;
		sList = r;
	}
	
	public List<Statement> getStatements(){
		return sList;
	}
	
	public String toString(){
		return name.toString() + ", " +sList.toString();
	}
	
	public void accept(Visitor v){
		for(Statement s : sList)
			s.accept(v);
	}
}
