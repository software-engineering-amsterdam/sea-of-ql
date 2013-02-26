package org.uva.sea.ql.parsers;

import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.parsers.antlr.QLParser;
import org.antlr.runtime.RecognitionException;

public class FormParser extends ParserBaseForStatements {

	public Statement callExprUnderTest(QLParser parser) throws RecognitionException {
		return parser.form();
	}
}
