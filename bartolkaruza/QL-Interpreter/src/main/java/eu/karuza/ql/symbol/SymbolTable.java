package eu.karuza.ql.symbol;

import java.io.Serializable;
import java.util.HashMap;

public class SymbolTable implements Serializable {

	private static final long serialVersionUID = -3632302036461299441L;

	private HashMap<String, Symbol> symbols = new HashMap<String, Symbol>();

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

	public void clear() {
		symbols.clear();
	}

}
