package org.uva.sea.ql.parser.test.statements.questions;

import static org.junit.Assert.assertTrue;

import org.uva.sea.ql.ast.statements.questions.ComputedQuestion;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.parser.antlr.check.ANTLRParserQuestions;
import org.uva.sea.ql.parser.errors.ParseError;
import org.uva.sea.ql.parser.test.statements.StatementTypeChecker;

public class ComputedQuestionTypeChecker extends StatementTypeChecker {
	
	public ComputedQuestionTypeChecker() {
		super(new ANTLRParserQuestions());
	}

	public void isOfComputedTypeBoolean(String input)     throws ParseError { assertTrue(getComputedTypeFor(input).isCompatibleToBool());    }
	public void isOfComputedTypeInt(String input)         throws ParseError { assertTrue(getComputedTypeFor(input).isCompatibleToInt());     }
	public void isOfComputedTypeMoney(String input)       throws ParseError { assertTrue(getComputedTypeFor(input).isCompatibleToMoney());   }
	public void isOfComputedTypeNumeric(String input)     throws ParseError { assertTrue(getComputedTypeFor(input).isCompatibleToNumeric()); }
	public void isOfComputedTypeString(String input)      throws ParseError { assertTrue(getComputedTypeFor(input).isCompatibleToStr());     }
	
	private ComputedQuestion parseComputedQuestion(String input)  throws ParseError { return (ComputedQuestion) parse(input); }
	
	private Type getComputedTypeFor(String input)         throws ParseError { return getComputedTypeForVariable(input); }
	private Type getComputedTypeForVariable(String input) throws ParseError {
		// Check if the statement is type valid and store its identifiers in the typeEnvironment
		isAValidStatement(input);
		ComputedQuestion statement = (ComputedQuestion) parseComputedQuestion(input);
		return getTypeOf(statement.getExpression());
	}
	
}