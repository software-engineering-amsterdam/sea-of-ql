package org.uva.sea.ql.parser.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.uva.sea.ql.ast.CompQuestion;
import org.uva.sea.ql.ast.IfBody;
import org.uva.sea.ql.ast.Question;
import org.uva.sea.ql.parser.antlr.ANTLRParser;


@RunWith(Parameterized.class)
public class TestFormElements {
	private IParse parser;

	@Parameters
	public static List<Object[]> theParser() {
		List<Object[]> parserList = new ArrayList<Object[]>();
		parserList.add(new Object[] { new ANTLRParser() });
		return parserList;
	}

	public TestFormElements(IParse parser) {
		this.parser = parser;
	}
	
	@Test
	public void testQuestion() throws ParseError {
		assertEquals(Question.class, parser.parseFormElement("dvdssd: \"fdhrdhfrrr\" int").getClass());
	}
	
	@Test
	public void testCompQuestion() throws ParseError {
		assertEquals(CompQuestion.class, parser.parseFormElement("dvdssd: \"fdhrdhfrrr\" int(432-4)").getClass());
	}
	
	@Test
	public void testIfBody() throws ParseError {
		assertEquals(IfBody.class, parser.parseFormElement("if (hasSoldHouse) { sellingPrice: \"Price the house was sold for:\" int }").getClass());
	}
}
