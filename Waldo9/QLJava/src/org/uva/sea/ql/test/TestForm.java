package org.uva.sea.ql.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.parser.ANTLRParser;

public class TestForm {

	private IParse parser;

	@Before
	public void setUp() {
		parser = new ANTLRParser();
	}
	
	@Test
	public void testForm() throws ParseError, IOException {
		QLFileReader qlFileReader = new QLFileReader();
		assertEquals(Form.class, parser.parseForm(qlFileReader.readQLFile("QLTestcase1.ql")).getClass());
		assertEquals(Form.class, parser.parseForm(qlFileReader.readQLFile("QLTestcase2.ql")).getClass());
	}

}
