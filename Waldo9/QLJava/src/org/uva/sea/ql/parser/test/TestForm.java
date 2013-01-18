package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.parser.antlr.*;

@RunWith(Parameterized.class)
public class TestForm {

	private IParse parser;

	@Parameters
	public static List<Object[]> theParser() {
	  List<Object[]> parserList = new ArrayList<Object[]>();
	  parserList.add(new Object[] {new ANTLRParser()});
	  return parserList;
	}
	
	public TestForm(IParse parser) {
		this.parser = parser;
	}	
	
	@Test
	public void testForm() throws ParseError, IOException {
		QLFileReader qlFileReader = new QLFileReader();
		assertEquals(Form.class, parser.parseForm(qlFileReader.readQLFile("QLTestcase1.ql")).getClass());
		assertEquals(Form.class, parser.parseForm(qlFileReader.readQLFile("QLTestcase2.ql")).getClass());
	}

}
