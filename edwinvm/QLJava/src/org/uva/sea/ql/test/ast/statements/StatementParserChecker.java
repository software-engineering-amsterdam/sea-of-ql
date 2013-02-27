package org.uva.sea.ql.test.ast.statements;

import org.uva.sea.ql.ast.statements.conditions.IfThenElseStatement;
import org.uva.sea.ql.ast.statements.conditions.IfThenStatement;
import org.uva.sea.ql.ast.statements.questions.AnswerableQuestion;
import org.uva.sea.ql.ast.statements.questions.ComputedQuestion;
import org.uva.sea.ql.parser.antlr.check.ANTLRParserConditionBlocks;
import org.uva.sea.ql.parser.antlr.check.ANTLRParserQuestions;
import org.uva.sea.ql.parser.errors.ParseError;
import org.uva.sea.ql.test.ast.ASTNodeChecker;

public class StatementParserChecker extends ASTNodeChecker {
	
	public StatementParserChecker(ANTLRParserConditionBlocks parser) { super(parser); }
	public StatementParserChecker(ANTLRParserQuestions parser)       { super(parser); }
	
	public void statementMatchesIfThenCondition(String input)     throws ParseError { match(input, IfThenStatement.class);     }
	public void statementMatchesIfThenElseCondition(String input) throws ParseError { match(input, IfThenElseStatement.class); }
	public void statementMatchesAnswerableQuestion(String input)  throws ParseError { match(input, AnswerableQuestion.class);  }
	public void statementMatchesComputedQuestion(String input)    throws ParseError { match(input, ComputedQuestion.class);    }
	
}