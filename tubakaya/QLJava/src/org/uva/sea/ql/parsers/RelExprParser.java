package org.uva.sea.ql.parsers;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.parsers.antlr.QLParser;
import org.antlr.runtime.RecognitionException;

public class RelExprParser extends ParserBaseForExpressions {

	public Expression callExprUnderTest(QLParser parser) throws RecognitionException {
		return parser.relExpr();
	}
}
