package org.uva.sea.ql.runner;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.error.ErrorHandler;
import org.uva.sea.ql.error.ParseError;
import org.uva.sea.ql.error.QLError;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.semantic.ExpressionSemanticChecker;
import org.uva.sea.ql.semantic.StatementSemanticChecker;
import org.uva.sea.ql.symbol.SymbolGenerator;
import org.uva.sea.ql.symbol.SymbolTable;

public class FrontEndRunner {

	public static void main(String[] args) {
		if (args.length > 0) {

			IParse parser = new ANTLRParser();
			ErrorHandler handler = new ErrorHandler();
			SymbolTable table = new SymbolTable();
			Form form = null;
			try {
				form = (Form) parser.parseFile(args[0]);
			} catch (ParseError e) {
				handler.addError(new QLError(e.getMessage()));
			}
			if(form != null) {
				form.accept(new StatementSemanticChecker(table, handler, new SymbolGenerator(table, handler), new ExpressionSemanticChecker(table, handler)));
			}
			if(handler.getErrors().isEmpty()) {
				System.out.println("All checks passed, 0 errors");
			} else {
				handler.printErrors();
			}

		}
	}

}
