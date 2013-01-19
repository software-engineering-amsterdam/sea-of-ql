package org.uva.sea.ql.parser.antlr;

import org.antlr.runtime.RecognitionException;
import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.parser.test.ParseError;

public class ANTLRAndParser extends GeneralANTLRParser{
	
	public ASTNode parseANonTerminal(QLParser parser) throws ParseError { 
		try {
			return parser.andExpr();
		} catch (RecognitionException e) {
			throw new ParseError(e.getMessage());
		}
	}

}
