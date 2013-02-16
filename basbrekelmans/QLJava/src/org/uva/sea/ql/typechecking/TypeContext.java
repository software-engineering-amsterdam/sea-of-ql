package org.uva.sea.ql.typechecking;

import java.util.HashMap;
import java.util.Map;

import org.uva.sea.ql.ast.Node;
import org.uva.sea.ql.ast.expressions.Identifier;
import org.uva.sea.ql.ast.types.Type;

public class TypeContext {

	private Map<Identifier, Type> symbolTable;
	private Map<Node, String> errors;

	public TypeContext() {
		this.symbolTable = new HashMap<Identifier, Type>();
		this.errors = new HashMap<Node, String>();
	}
	
	public Map<Identifier, Type> getSymbolTable() {
		return symbolTable;
	}
	
	public Map<Node, String> getErrors() {
		return errors;
	}
	
	public boolean hasErrors() {
		return !errors.isEmpty();
	}
}
