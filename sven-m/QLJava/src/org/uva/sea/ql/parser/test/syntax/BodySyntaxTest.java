package org.uva.sea.ql.parser.test.syntax;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.form.Body;
import org.uva.sea.ql.parser.test.ParseError;

public class BodySyntaxTest extends SyntaxTest {

	@Override
	protected Class<?> parseClass(String src) throws ParseError {
		return getParser().parseBody(src).getClass();
	}
	
	@Test
	public void testBodies() throws ParseError {
		assertEquals(parseClass("{ \n fdsafjdks: \"&*(&$*(Y \" boolean }"), Body.class);
		assertEquals(parseClass("{ \n jfdklsf: \"Y$(*&*(RFH( \" boolean }"), Body.class);
		assertEquals(parseClass("{ \n \t \t \r\n \r \r \n }"), Body.class);
		assertEquals(parseClass("{ }"), Body.class);
	}
}
