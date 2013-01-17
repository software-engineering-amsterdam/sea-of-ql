package org.uva.sea.ql.parser.antlr;

import org.antlr.runtime.RecognitionException;
import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.parser.test.ParseError;

public class ANTLRExpressionParser extends GeneralANTLRParser{
	
	public ASTNode parseANonTerminal(QLParser parser) throws ParseError {
		try {
			return parser.unExpr();
		} catch (RecognitionException e) {
			throw new ParseError(e.getMessage());
		}
	}

}
