package org.uva.sea.ql.visitor;


import java.util.HashMap;
import java.util.Map;

import org.uva.sea.ql.ast.types.Type;

public class Context {

    private final Map<String, Type> symbols;
    private final String errors;

    public Context() {
        this.symbols = new HashMap<String, Type>();
        this.errors = new String();
    }

    public String getErrors() { 
    	return errors; 
    }
    
    public void addError(String error){
    	this.errors.concat(error);
    }
    
    public Map<String, Type> getSymbols() { 
    	return symbols; 
    }
    
    public void setIdent(String ident, Type type) {
		this.symbols.put(ident, type);
	}
    
    public boolean isDeclared(String ident) {
		if (this.symbols.containsKey(ident)) {
			return true;
		}
		return false;
    }
    
}
