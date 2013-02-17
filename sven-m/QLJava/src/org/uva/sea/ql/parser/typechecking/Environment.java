package org.uva.sea.ql.parser.typechecking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.form.Type;
import org.uva.sea.ql.parser.errors.SemanticError;

public class Environment {
	Map<String, Type> types;
	List<SemanticError> errors;
	
	public Environment() {
		types = new HashMap<>();
		errors = new ArrayList<>();
	}
	
	public void setType(Ident id, Type type) {
		types.put(id.getName(),	type);
	}
	
	public Type getType(Ident id) {
		return types.get(id.getName());
	}
	
	public void reportError(SemanticError error) {
		errors.add(error);
	}

	public Map<String, Type> getTypeEnvironment() {
		return new HashMap<>(types);
	}
	
}
