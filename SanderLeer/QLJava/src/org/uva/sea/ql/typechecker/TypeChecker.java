package org.uva.sea.ql.typechecker;

import java.util.ArrayList;
import org.uva.sea.ql.ast.ASTNode;

public class TypeChecker {
	private final SymbolTable symbols;
	private final ArrayList<String> errors;
	
	public TypeChecker() {
		this.symbols = new SymbolTable();
		this.errors = new ArrayList<>();
	}

	protected void addError(String s) {
		errors.add(s);
	}

	public String getErrors() {
		StringBuilder sb = new StringBuilder();
		for (String error : errors) {
			if (sb.length() > 0) {
				sb.append("\n");
			}
			sb.append(error);
		}
		return sb.toString();
	}

	public boolean hasErrors() {
		return !errors.isEmpty();
	}

	public boolean Check(ASTNode ast) {
		symbols.clear();
		errors.clear();
		TypeCheckerVisitor visitor = new TypeCheckerVisitor(symbols, errors);
		ast.accept(visitor);
		return !hasErrors();
	}
}
