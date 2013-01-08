package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.parser.antlr.ANTLRParser;

public class TestForm {
	
	IParse parser = new ANTLRParser();
	
	@Test
	public void testBaseForm() throws ParseError {
		assertEquals(parser.parse("form somename {}").getClass(), Form.class);
	}

}
