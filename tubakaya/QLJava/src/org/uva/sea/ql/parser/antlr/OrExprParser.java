package org.uva.sea.ql.parser.antlr;

import org.uva.sea.ql.ast.types.Expr;
import org.antlr.runtime.RecognitionException;

public class OrExprParser extends ParserBase {

	public Expr callExprUnderTest(QLParser parser) throws RecognitionException {
		return parser.orExpr();
	}
}
