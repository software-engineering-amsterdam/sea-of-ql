package org.uva.sea.ql.test.syntactic;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;
import org.uva.sea.ql.ast.stat.Form;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.qlsource.QLReader;
import org.uva.sea.ql.test.IParse;
import org.uva.sea.ql.test.ParseError;

public class TestForm {
	
	private IParse parser;

	public TestForm() {
		parser = new ANTLRParser();
	}
	
	@Test
	public void testForm() throws ParseError, IOException {
		QLReader qlReader = new QLReader();		
		assertEquals(parser.parseForm(qlReader.read("InputForm.ql")).getClass(), Form.class);
		
	}
}