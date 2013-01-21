package org.uva.sea.ql.parser.antlr;

import org.antlr.runtime.RecognitionException;
import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.parser.test.ParseError;

public class ANTLRComputedQuestionParser extends GeneralANTLRParser{
	
	public ASTNode parseANonTerminal(QLParser parser) throws ParseError {
		try {
			System.out.println("Testing computed questions...");
			return parser.computedQuestion();
		} catch (RecognitionException e) {
			throw new ParseError(e.getMessage());
		}
	}

}
