package eu.karuza.ql.symbol;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class SymbolTable implements Serializable {

	private static final long serialVersionUID = -3632302036461299441L;

	private Map<String, Symbol> symbols = new HashMap<String, Symbol>();

	public void putSymbol(String string, Symbol expr) {
		symbols.put(string, expr);
	}

	public boolean hasSymbol(String name) {
		return symbols.containsKey(name);
	}

	public Symbol getSymbol(String name) {
		return symbols.get(name);
	}

	public Map<String, Symbol> getSymbols() {
		return symbols;
	}

	public void clear() {
		symbols.clear();
	}

}
