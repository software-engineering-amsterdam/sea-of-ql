package org.uva.sea.ql.parser.antlr;

import org.antlr.runtime.RecognitionException;
import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.parser.test.ParseError;

public class ANTLRIfThenElseStatementParser extends GeneralANTLRParser{
	
	public ASTNode parseANonTerminal(QLParser parser) throws ParseError {
		try {
			System.out.println("Testing if then else statement");
			return parser.ifThenElseStatement();
		} catch (RecognitionException e) {
			throw new ParseError(e.getMessage());
		}
	}

}
