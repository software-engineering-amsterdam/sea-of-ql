package org.uva.sea.ql.parser.test.statements;

import static org.junit.Assert.assertTrue;

import org.uva.sea.ql.ast.FormStatement;
import org.uva.sea.ql.ast.Type;
import org.uva.sea.ql.ast.statements.Question;
import org.uva.sea.ql.ast.statements.questions.AnswerableQuestion;
import org.uva.sea.ql.check.statements.StatementChecker;
import org.uva.sea.ql.parser.ErrorMessages;
import org.uva.sea.ql.parser.IParser;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.TypeEnvironment;
import org.uva.sea.ql.parser.antlr.check.ANTLRParserQuestions;

public class StatementTypeChecker {
	
	private final IParser _parser;
	private final TypeEnvironment _typeEnvironment;
	private final ErrorMessages _errorMessages;
	private final StatementChecker _statementChecker;
	
	public StatementTypeChecker() {
		_parser = new ANTLRParserQuestions();
		_typeEnvironment = new TypeEnvironment();
		_errorMessages   = new ErrorMessages();
		_statementChecker = new StatementChecker(_typeEnvironment, _errorMessages);
	}
	
	public void isAValidStatement(String input)  throws ParseError { assertTrue(checkStatement(input)); }
	
	public void isOfTypeBoolean(String input)    throws ParseError { assertTrue(getTypeFor(input).isCompatibleToBool());    }
	public void isOfTypeInt(String input)        throws ParseError { assertTrue(getTypeFor(input).isCompatibleToInt());     }
	public void isOfTypeMoney(String input)      throws ParseError { assertTrue(getTypeFor(input).isCompatibleToMoney());   }
	public void isOfTypeNumeric(String input)    throws ParseError { assertTrue(getTypeFor(input).isCompatibleToNumeric()); }
	public void isOfTypeString(String input)     throws ParseError { assertTrue(getTypeFor(input).isCompatibleToStr());     }
	
	private Boolean checkStatement(String input) throws ParseError {
		FormStatement statement = parseStatement(input);
		_statementChecker.check(statement);
		return !_errorMessages.hasErrors();
	}
	
	private FormStatement parseStatement(String input) throws ParseError { return (FormStatement) _parser.parse(input); }
	private Question      parseQuestion(String input)  throws ParseError { return (Question) _parser.parse(input); }
	
	private Type getTypeFor(String input)         throws ParseError { return getTypeForVariable(input); }
	private Type getTypeForVariable(String input) throws ParseError {
		AnswerableQuestion statement = (AnswerableQuestion) parseQuestion(input);
		return statement.getType();
	}
	
}