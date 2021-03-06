package eu.karuza.ql.parser;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import eu.karuza.ql.ast.Form;
import eu.karuza.ql.error.ErrorHandler;
import eu.karuza.ql.error.QLError;
import eu.karuza.ql.symbol.Symbol;
import eu.karuza.ql.symbol.SymbolTable;

public class ParserContext implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6999454250035007570L;
	
	public static final String CHARACTER_ENCODING = "UTF-8";
	
	private ErrorHandler handler;
	private SymbolTable table;
	private Form form;

	public ParserContext() {
		this.handler = new ErrorHandler();
		this.table = new SymbolTable();
	}

	public ParserContext(ErrorHandler errorHandler) {
		this(errorHandler, new SymbolTable());
	}

	public ParserContext(SymbolTable symbolTable) {
		this(new ErrorHandler(), symbolTable);
	}

	public ParserContext(ErrorHandler errorHandler, SymbolTable symbolTable) {
		this.handler = errorHandler;
		this.table = symbolTable;
	}

	public ErrorHandler getHandler() {
		return handler;
	}

	public void setHandler(ErrorHandler handler) {
		this.handler = handler;
	}

	public SymbolTable getTable() {
		return table;
	}

	public void setTable(SymbolTable table) {
		this.table = table;
	}
	
	public void clear() {
		this.table.clear();
		this.handler.clear();
	}
	
	public List<QLError> getErrors() {
		return handler.getErrors();
	}
	
	public void addError(QLError error) {
		this.handler.addError(error);
	}
	
	public Symbol getSymbol(String name) {
		return this.table.getSymbol(name);
	}
	
	public boolean hasSymbol(String name) {
		return this.table.hasSymbol(name);
	}
	
	public void putSymbol(String name, Symbol symbol) {
		this.table.putSymbol(name, symbol);
	}
	
	public void reportOperationTypeError(String operation, int lineNumber) {
		this.handler.reportOperationTypeError(operation, lineNumber);
	}
	
	public Map<String, Symbol> getSymbols() {
		return this.table.getSymbols();
	}
	
	public Form getForm() {
		return form;
	}
	
	public void setForm(Form form) {
		this.form = form;
	}

	public boolean hasErrors() {
		return handler.getErrors().size() != 0;
	}

}
