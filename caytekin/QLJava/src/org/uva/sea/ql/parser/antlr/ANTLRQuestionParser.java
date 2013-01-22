package org.uva.sea.ql.parser.antlr;

import org.antlr.runtime.RecognitionException;
import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.parser.test.ParseError;

public class ANTLRQuestionParser extends GeneralANTLRParser{
	
	public ASTNode parseANonTerminal(QLParser parser) throws ParseError {
		try {
			System.out.println("Testing questions...");
			return parser.question();
		} catch (RecognitionException e) {
			throw new ParseError(e.getMessage());
		}
	}

}
