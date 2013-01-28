package org.uva.sea.ql.runner;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.error.ErrorHandler;
import org.uva.sea.ql.error.ParseError;
import org.uva.sea.ql.error.QLError;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.semantic.DependencyChecker;
import org.uva.sea.ql.semantic.DereferenceChecker;
import org.uva.sea.ql.semantic.TypeChecker;
import org.uva.sea.ql.symbol.SymbolGenerator;
import org.uva.sea.ql.symbol.SymbolTable;

public class FrontEndRunner {

	public static void main(String[] args) {
		if (args.length > 0) {

			IParse parser = new ANTLRParser();
			Form form = null;
			try {
				form = (Form) parser.parseFile(args[0]);
			} catch (ParseError e) {
				ErrorHandler.getInstance().addError(new QLError(e.getMessage()));
			}
			if(form != null) {
				form.accept(new SymbolGenerator());
				form.accept(new TypeChecker());
				form.accept(new DereferenceChecker());
				DependencyChecker.newInstance(SymbolTable.getInstance(), ErrorHandler.getInstance()).checkDependencies();
			}
			if(ErrorHandler.getInstance().getErrors().isEmpty()) {
				System.out.println("All checks passed, 0 errors");
			} else {
				ErrorHandler.printErrors();
			}

		}
	}

}
