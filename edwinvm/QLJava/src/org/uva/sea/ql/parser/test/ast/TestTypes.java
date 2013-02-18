package org.uva.sea.ql.parser.test.ast;

import org.junit.Test;
import org.uva.sea.ql.parser.ParseError;

public class TestTypes extends TypeParserChecker {
	@Test
	public void testBools()   throws ParseError { inputMatchesTypeBoolean("boolean"); }
	@Test
	public void testInts()    throws ParseError { inputMatchesTypeInteger("integer"); }
	@Test
	public void testMoneys()  throws ParseError { inputMatchesTypeMoney("money");     }
	@Test
	public void testStrings() throws ParseError { inputMatchesTypeString("string");   }
}