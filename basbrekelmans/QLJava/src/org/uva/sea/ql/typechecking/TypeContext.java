package org.uva.sea.ql.typechecking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ICodeLocationInformation;
import org.uva.sea.ql.ast.expressions.Identifier;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.parser.QLError;

public class TypeContext {

	private final Map<Identifier, Type> symbolTable;
	private final List<QLError> errors;

	public TypeContext() {
		this.symbolTable = new HashMap<Identifier, Type>();
		this.errors = new ArrayList<QLError>();
	}

	public void addError(final ICodeLocationInformation element,
			final String message) {
		this.errors.add(new QLError(element, message));

	}

	public List<QLError> getErrors() {
		return this.errors;
	}

	public Map<Identifier, Type> getSymbolTable() {
		return this.symbolTable;
	}

	public boolean hasErrors() {
		return !this.errors.isEmpty();
	}
}
