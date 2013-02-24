package org.uva.sea.ql.parser.test.syntax;

import org.uva.sea.ql.parser.antlr.ParseError;
import org.uva.sea.ql.parser.test.AbstractTest;

public abstract class SyntaxTest extends AbstractTest {
	
	protected abstract Class<?> parseClass(String src) throws ParseError;
	
}
