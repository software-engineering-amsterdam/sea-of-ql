package org.uva.sea.ql.typechecking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ICodeLocationInformation;
import org.uva.sea.ql.ast.expressions.Identifier;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.parser.ParseError;

public class TypeContext {

	private final Map<Identifier, Type> symbolTable;
	private final List<ParseError> errors;

	public TypeContext() {
		this.symbolTable = new HashMap<Identifier, Type>();
		this.errors = new ArrayList<ParseError>();
	}

	public void addError(final ICodeLocationInformation element,
			final String message) {
		this.errors.add(new ParseError(element, message));

	}

	public List<ParseError> getErrors() {
		return this.errors;
	}

	public Map<Identifier, Type> getSymbolTable() {
		return this.symbolTable;
	}

	public boolean hasErrors() {
		return !this.errors.isEmpty();
	}
}
