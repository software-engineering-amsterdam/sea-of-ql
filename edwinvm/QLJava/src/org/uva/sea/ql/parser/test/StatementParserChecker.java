package org.uva.sea.ql.parser.test;

import org.uva.sea.ql.ast.statements.ConditionBlock;
import org.uva.sea.ql.ast.statements.questions.AnswerableQuestion;
import org.uva.sea.ql.ast.statements.questions.ComputedQuestion;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.antlr.check.ANTLRParserConditionBlocks;
import org.uva.sea.ql.parser.antlr.check.ANTLRParserQuestions;

public class StatementParserChecker extends ASTNodeChecker {
	
	public StatementParserChecker(ANTLRParserConditionBlocks parser) { super(parser); }
	public StatementParserChecker(ANTLRParserQuestions parser)       { super(parser); }
	
	public void statementMatchesConditionBlock(String input)     throws ParseError { match(input, ConditionBlock.class);     }
	public void statementMatchesAnswerableQuestion(String input) throws ParseError { match(input, AnswerableQuestion.class); }
	public void statementMatchesComputedQuestion(String input)   throws ParseError { match(input, ComputedQuestion.class);   }
	
}