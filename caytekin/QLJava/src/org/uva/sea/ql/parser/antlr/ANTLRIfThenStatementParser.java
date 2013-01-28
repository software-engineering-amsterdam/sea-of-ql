package org.uva.sea.ql.parser.antlr;

import org.antlr.runtime.RecognitionException;
import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.parser.test.ParseError;

public class ANTLRIfThenStatementParser extends GeneralANTLRParser{
	
	public ASTNode parseANonTerminal(QLParser parser) throws ParseError {
		try {
			System.out.println("Testing if then statement");
			return parser.ifThenStatement();
		} catch (RecognitionException e) {
			throw new ParseError(e.getMessage());
		}
	}

}
