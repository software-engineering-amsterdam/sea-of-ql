package org.uva.sea.ql.parser.test.statements;

import static org.junit.Assert.assertTrue;

import org.uva.sea.ql.ast.FormStatement;
import org.uva.sea.ql.check.statements.StatementChecker;
import org.uva.sea.ql.parser.ErrorMessages;
import org.uva.sea.ql.parser.IParser;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.TypeEnvironment;

public class StatementTypeChecker {
	
	private final IParser _parser;
	private final TypeEnvironment _typeEnvironment;
	private final ErrorMessages _errorMessages;
	private final StatementChecker _statementChecker;
	
	public StatementTypeChecker(IParser parser) {
		_parser = parser;
		_typeEnvironment  = new TypeEnvironment();
		_errorMessages    = new ErrorMessages();
		_statementChecker = new StatementChecker(_typeEnvironment, _errorMessages);
	}
	
	public void isAValidStatement(String input)        throws ParseError { assertTrue(checkStatement(input)); }
	
	private FormStatement parseStatement(String input) throws ParseError { return parse(input); }
	
	public FormStatement parse(String input)           throws ParseError { return (FormStatement) _parser.parse(input); }
	
	private Boolean checkStatement(String input)       throws ParseError {
		FormStatement statement = parseStatement(input);
		_statementChecker.check(statement);
		return !_errorMessages.hasErrors();
	}
	
}