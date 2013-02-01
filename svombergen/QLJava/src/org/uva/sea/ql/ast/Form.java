package org.uva.sea.ql.ast;

import java.util.List;

public class Form {
	protected Expr name;
	protected List<Question> result;
	protected IfStatement ifStat;

	public Form(Expr x, List<Question> r, IfStatement ifSt){
		name = x;
		result = r;
		ifStat = ifSt;
	}
	
	public String toString(){
		return name.toString() + ", " +result.toString();
	}
}
