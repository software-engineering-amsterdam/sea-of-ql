package nl.stgm.ql.parser.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import nl.stgm.ql.parser.rats.RatsParser;

import nl.stgm.ql.ast.form.*;

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
			parser.parseForm("form Box1HouseOwning { }").getClass()
		);
		assertEquals(
			Form.class,
			parser.parseForm("form Box1HouseOwning{}").getClass()
		);
		assertEquals(
			Form.class,
			parser.parseForm("form Box1HouseOwning{  } ").getClass()
		);
	}

	@Test(expected=ParseError.class) public void testBadEmptyForms() throws ParseError
	{
		// extra spacing before form is only allowed in full Document
		parser.parseForm(" form Box1HouseOwning{}");
		parser.parseForm("form Box1HouseOwning");
		parser.parseForm("form {}");
	}

	@Test public void testFormWithOneQuestion() throws ParseError
	{
		assertEquals(
			Form.class,
			parser.parseForm(
				"form Box1HouseOwning { hasSoldHouse: \"Did?\" boolean }"
			).getClass()
		);
	}

	@Test(expected=ParseError.class) public void testBadFormsWithOneQuestion() throws ParseError
	{
		// hmm this testing may not work as expected, if first ParseError already validates test
		parser.parseForm("form Box1HouseOwning { hasSoldHouse: '\"Did?\" boolean }");
		parser.parseForm("form Box1HouseOwning { hasSoldHouse : \"Did?\" boolean }");
		parser.parseForm("form Box1HouseOwning { hasSoldHouse '\"Did?\" boolean }");
		parser.parseForm("form Box1HouseOwning { hasSoldHouse '\"Did?\" }");
		parser.parseForm("form Box1HouseOwning { hasSoldHouse boolean }");
		parser.parseForm("form Box1HouseOwning { hasSoldHouse: }");
	}
}
