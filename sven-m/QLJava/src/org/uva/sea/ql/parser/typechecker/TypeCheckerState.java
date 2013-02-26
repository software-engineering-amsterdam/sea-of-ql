package org.uva.sea.ql.parser.typechecker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.form.types.Type;
import org.uva.sea.ql.parser.typechecker.error.SemanticError;

public class TypeCheckerState {
	Map<Ident, Type> types;
	List<SemanticError> errors;
	
	public TypeCheckerState() {
		types = new HashMap<>();
		errors = new ArrayList<>();
	}
	
	public void setType(Ident ident, Type type) {
		types.put(ident, type);
	}
	
	public Type getType(Ident id) {
		return types.get(id);
	}
	
	public void reportError(SemanticError error) {
		errors.add(error);
	}

	public Map<Ident, Type> getTypeState() {
		return Collections.unmodifiableMap(types);
	}

	public String getErrorsString() {
		String errorsString = "";
		for (SemanticError error : errors) {
			errorsString += error.toString() + "\n";
		}
		
		return errorsString;
	}
	
	public List<SemanticError> getErrors() {
		return new ArrayList<>(errors);
	}
	
}
