package org.uva.sea.ql.parsers;

import org.uva.sea.ql.ast.types.Expr;
import org.uva.sea.ql.parsers.antlr.QLParser;
import org.antlr.runtime.RecognitionException;

public class RelExprParser extends ParserBase {

	public Expr callExprUnderTest(QLParser parser) throws RecognitionException {
		return parser.relExpr();
	}
}