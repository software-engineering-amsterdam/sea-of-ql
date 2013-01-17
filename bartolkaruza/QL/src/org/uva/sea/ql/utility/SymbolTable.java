package org.uva.sea.ql.utility;

import java.util.HashMap;

import org.uva.sea.ql.ast.expr.Expr;

public class SymbolTable {

	private static SymbolTable instance;
	private HashMap<String, Expr> symbols = new HashMap<String, Expr>();

	public static SymbolTable getInstance() {
		if (instance == null) {
			instance = new SymbolTable();
		}
		return instance;
	}

	public void putSymbol(String string, Expr expr) {
		symbols.put(string, expr);
	}

	public boolean hasSymbol(String name) {
		return symbols.containsKey(name);
	}

	public Expr getSymbol(String name) {
		return symbols.get(name);
	}

}
