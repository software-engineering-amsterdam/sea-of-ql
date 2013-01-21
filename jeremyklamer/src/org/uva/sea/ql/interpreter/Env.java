package org.uva.sea.ql.interpreter;

import java.util.HashMap;
import java.util.Map;

import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.type.Type;

public class Env {
	
	private Map<Ident, Type> vars;
	
	public Env(){
		vars = new HashMap<Ident, Type>(); 
	}

	public Map<Ident, Type> getVars() {
		return vars;
	}

	public void setVars(Map<Ident, Type> vars) {
		this.vars = vars;
	}

}
