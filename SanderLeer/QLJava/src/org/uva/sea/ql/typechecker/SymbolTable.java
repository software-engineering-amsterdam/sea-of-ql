package org.uva.sea.ql.typechecker;

import java.util.TreeMap;

import org.uva.sea.ql.ast.datatype.Datatype;

public class SymbolTable {
	private final TreeMap<String, Datatype> symbols;
	
	public SymbolTable() {
		symbols = new TreeMap<>();
	}

	public void put(String symbol, Datatype datatype) {
		symbols.put(symbol, datatype);
	}
	
	public Datatype get(String symbol) {
		return symbols.get(symbol);
	}
	
	public void remove(String symbol) {
		symbols.remove(symbol);
	}
	
	public boolean contains(String symbol) {
		return symbols.containsKey(symbol);
	}

	public void clear() {
		symbols.clear();
	}
}
