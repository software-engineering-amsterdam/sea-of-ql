package org.uva.sea.ql.parsers;

import org.uva.sea.ql.core.dom.Expression;
import org.uva.sea.ql.parsers.antlr.QLParser;
import org.antlr.runtime.RecognitionException;

public class MulExprParser extends ParserBaseForExpressions {

	public Expression callExprUnderTest(QLParser parser) throws RecognitionException {
		return parser.mulExpr();
	}
}
