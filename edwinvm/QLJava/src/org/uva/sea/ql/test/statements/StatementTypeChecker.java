package org.uva.sea.ql.test.statements;

import static org.junit.Assert.assertTrue;

import org.uva.sea.ql.ast.expressions.Expression;
import org.uva.sea.ql.ast.statements.FormStatement;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.check.TypeEnvironment;
import org.uva.sea.ql.check.statements.StatementChecker;
import org.uva.sea.ql.parser.IParser;
import org.uva.sea.ql.parser.errors.ErrorMessages;
import org.uva.sea.ql.parser.errors.ParseError;

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
	public void isAValidStatementBlock(String input)   throws ParseError { isAValidStatement(input); } 
	
	public  FormStatement parse(String input)          throws ParseError { return (FormStatement) _parser.parse(input); }
	private FormStatement parseStatement(String input) throws ParseError { return parse(input); }
	
	private Boolean checkStatement(String input)       throws ParseError {
		FormStatement statement = parseStatement(input);
		_statementChecker.check(statement);
		return !_errorMessages.hasErrors();
	}
	
	public Type getTypeOf(Expression expression) { 
		return expression.typeOf(_typeEnvironment); 
	}
	
}