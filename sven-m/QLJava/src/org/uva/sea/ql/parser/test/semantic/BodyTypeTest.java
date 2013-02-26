package org.uva.sea.ql.parser.test.semantic;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.uva.sea.ql.parser.antlr.ParseError;

public class BodyTypeTest extends AbstractFormTypeTest {

	@Override
	protected boolean typeCheck(String src) throws ParseError {
		return getParser().parseBody(src).accept(getTypeChecker());
	}
	
	@Test
	public void testBodies() throws ParseError {
		assertTrue(typeCheck("{ g1: \"label\" integer }"));
		assertTrue(typeCheck("{ q2: \"label\" boolean }"));
		assertTrue(typeCheck("{ q3: \"label\" string }"));
		assertTrue(typeCheck("{ }"));
	}
	
}
