package org.uva.sea.ql.parsers;

import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.parsers.antlr.QLParser;
import org.antlr.runtime.RecognitionException;

public class IfStatementParser extends ParserBaseForStatements {

	public Statement callExprUnderTest(QLParser parser) throws RecognitionException {
		return parser.ifStatement();
	}
}
