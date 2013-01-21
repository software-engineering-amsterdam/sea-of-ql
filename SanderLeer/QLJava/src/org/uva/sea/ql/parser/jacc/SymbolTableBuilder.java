package org.uva.sea.ql.parser.jacc;

import org.uva.sea.ql.ast.*;

public class SymbolTableBuilder {
	private final ASTNode astRoot;

	public SymbolTableBuilder(ASTNode astRoot) {
		this.astRoot = astRoot;
	}

	public SymbolTable build() throws ParseException {
		SymbolTable symbols = new SymbolTable();
		SymbolTableVisitor visitor = new SymbolTableVisitor(symbols);
		astRoot.accept(visitor);
		if (visitor.hasErrors()) {
			throw new ParseException(visitor.getErrors());
		}
		return symbols;
	}
}
