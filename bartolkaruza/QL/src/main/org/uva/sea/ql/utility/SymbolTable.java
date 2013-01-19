package org.uva.sea.ql.utility;

import java.util.HashMap;

public class SymbolTable {

	private static SymbolTable instance;
	private HashMap<String, Symbol> symbols = new HashMap<String, Symbol>();

	public static SymbolTable getInstance() {
		if (instance == null) {
			instance = new SymbolTable();
		}
		return instance;
	}

	public void putSymbol(String string, Symbol expr) {
		symbols.put(string, expr);
	}

	public boolean hasSymbol(String name) {
		return symbols.containsKey(name);
	}

	public Symbol getSymbol(String name) {
		return symbols.get(name);
	}
	
	public HashMap<String, Symbol> getSymbols() {
		return symbols;
	}

}
