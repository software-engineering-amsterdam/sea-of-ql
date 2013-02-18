package org.uva.sea.ql.parser.test.ast.statements;

import org.uva.sea.ql.ast.statements.conditions.IfThen;
import org.uva.sea.ql.ast.statements.conditions.IfThenElse;
import org.uva.sea.ql.ast.statements.questions.AnswerableQuestion;
import org.uva.sea.ql.ast.statements.questions.ComputedQuestion;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.antlr.check.ANTLRParserConditionBlocks;
import org.uva.sea.ql.parser.antlr.check.ANTLRParserQuestions;
import org.uva.sea.ql.parser.test.ast.ASTNodeChecker;

public class StatementParserChecker extends ASTNodeChecker {
	
	public StatementParserChecker(ANTLRParserConditionBlocks parser) { super(parser); }
	public StatementParserChecker(ANTLRParserQuestions parser)       { super(parser); }
	
	public void statementMatchesIfThenCondition(String input)     throws ParseError { match(input, IfThen.class);     }
	public void statementMatchesIfThenElseCondition(String input) throws ParseError { match(input, IfThenElse.class);     }
	public void statementMatchesAnswerableQuestion(String input)  throws ParseError { match(input, AnswerableQuestion.class); }
	public void statementMatchesComputedQuestion(String input)    throws ParseError { match(input, ComputedQuestion.class);   }
	
}