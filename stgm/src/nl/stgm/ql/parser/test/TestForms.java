package nl.stgm.ql.parser.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.parser.rats.RatsParser;

public class TestForms
{
	private IParse parser;

	public TestForms()
	{
		this.parser = new RatsParser();
	}

	@Test public void testEmptyForms() throws ParseError
	{
		assertEquals(
			Form.class,
			parser.parse("form Box1HouseOwning { }").getClass()
		);
		assertEquals(
			Form.class,
			parser.parse("form Box1HouseOwning{}").getClass()
		);
		assertEquals(
			Form.class,
			parser.parse("form Box1HouseOwning{  } ").getClass()
		);
	}

	@Test(expected=ParseError.class) public void testBadEmptyForms() throws ParseError
	{
		// extra spacing before form is only allowed in full Document
		parser.parse(" form Box1HouseOwning{}");
		parser.parse("form Box1HouseOwning");
		parser.parse("form {}");
	}

	@Test public void testFormWithOneQuestion() throws ParseError
	{
		assertEquals(
			Form.class,
			parser.parse(
				"form Box1HouseOwning { hasSoldHouse: \"Did?\" boolean }"
			).getClass()
		);
	}

	@Test(expected=ParseError.class) public void testBadFormsWithOneQuestion() throws ParseError
	{
		parser.parse("form Box1HouseOwning { hasSoldHouse: '\"Did?\" boolean }");
		parser.parse("form Box1HouseOwning { hasSoldHouse : \"Did?\" boolean }");
		parser.parse("form Box1HouseOwning { hasSoldHouse '\"Did?\" boolean }");
		parser.parse("form Box1HouseOwning { hasSoldHouse '\"Did?\" }");
		parser.parse("form Box1HouseOwning { hasSoldHouse boolean }");
		parser.parse("form Box1HouseOwning { hasSoldHouse: }");
	}
}
