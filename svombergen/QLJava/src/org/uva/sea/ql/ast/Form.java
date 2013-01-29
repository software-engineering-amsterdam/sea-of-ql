package org.uva.sea.ql.ast;

import java.util.List;

public class Form {
	protected Expr name;
	protected List<Ding> result;

	public Form(Expr x, List<Ding> r){
		name = x;
		result = r;
	}
	
	public String toString(){
		return name.toString() + ", " +result.toString();
	}
}
