package org.uva.sea.ql.service;

import java.util.List;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.Question;
import org.uva.sea.ql.error.ErrorHandler;
import org.uva.sea.ql.error.ParseError;
import org.uva.sea.ql.error.QLError;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.semantic.ExpressionSemanticChecker;
import org.uva.sea.ql.semantic.StatementSemanticChecker;
import org.uva.sea.ql.symbol.DefinitionCollector;
import org.uva.sea.ql.symbol.SymbolTable;

public class ParserServiceImpl implements ParserService {

	private final ErrorHandler handler = new ErrorHandler();
	private final SymbolTable table = new SymbolTable();
	private final IParse parser = new ANTLRParser();
	private Form currentForm;
	
	@Override
	public List<QLError> getErrors() {
		return handler.getErrors();
	}

	@Override
	public void parseNewForm(String form) {
		table.clear();
		handler.clear();
		try {
			currentForm = (Form) parser.parseNode(form);
		} catch (ParseError e) {
			handler.addError(new QLError(e.getLocalizedMessage()));
			return; // Parse exception occurred, abort further checking
		}
		DefinitionCollector generator = new DefinitionCollector(table, handler);
		ExpressionSemanticChecker exprChecker = new ExpressionSemanticChecker(table, handler);
		StatementSemanticChecker statementChecker = new StatementSemanticChecker(table, handler, generator, exprChecker);
		currentForm.accept(statementChecker);
	}

	@Override
	public List<Question> getVisibleQuestions() {
		return null;
	}

}
