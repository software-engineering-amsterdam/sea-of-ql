package org.uva.sea.ql.utility;

import java.util.HashMap;

import org.uva.sea.ql.ast.value.Value;

public class SymbolTable {

	private static SymbolTable instance;
	private HashMap<String, Value> symbols = new HashMap<String, Value>();

	public static SymbolTable getInstance() {
		if (instance == null) {
			instance = new SymbolTable();
		}
		return instance;
	}

	public void putSymbol(String string, Value value) {
		symbols.put(string, value);
	}

	public boolean hasSymbol(String name) {
		return symbols.containsKey(name);
	}

	public Value getSymbol(String name) {
		return symbols.get(name);
	}

}
