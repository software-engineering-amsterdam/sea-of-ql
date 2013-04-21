package nl.stgm.ql.parser.test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import nl.stgm.ql.parser.*;
import nl.stgm.ql.ast.form.*;

public class TestForms extends QLTest
{
	private void assertFormClass(Class c, String s) throws ParseError
	{
		assertClass(c, parser.parseForm(s));
	}

	@Test public void testEmptyForms() throws ParseError
	{
		assertFormClass(Form.class, "form Box1HouseOwning { }");
		assertFormClass(Form.class, "form Box1HouseOwning{}");
		assertFormClass(Form.class, "form Box1HouseOwning{  } ");
	}

	@Test(expected=ParseError.class) public void testExtraSpacing() throws ParseError
	{
		// extra spacing before form is only allowed in full document
		parser.parseForm(" form Box1HouseOwning{}");
	}

	@Test(expected=ParseError.class) public void testBadForm1() throws ParseError
	{
		parser.parseForm("form Box1HouseOwning");
	}

	@Test(expected=ParseError.class) public void testBadForm2() throws ParseError
	{
		parser.parseForm("form {}");
	}

	@Test public void testFormWithOnegetQuestion() throws ParseError
	{
		assertFormClass(Form.class, "form Box1HouseOwning { hasSoldHouse: \"Did?\" boolean }");
	}

	@Test(expected=ParseError.class) public void testBadFormQuestion1() throws ParseError
	{
		parser.parseForm("form Box1HouseOwning { hasSoldHouse: '\"Did?\" boolean }");
	}

	@Test(expected=ParseError.class) public void testBadFormQuestion2() throws ParseError
	{
		parser.parseForm("form Box1HouseOwning { hasSoldHouse : \"Did?\" boolean }");
	}

	@Test(expected=ParseError.class) public void testBadFormQuestion3() throws ParseError
	{
		parser.parseForm("form Box1HouseOwning { hasSoldHouse '\"Did?\" boolean }");
	}

	@Test(expected=ParseError.class) public void testBadFormQuestion4() throws ParseError
	{
		parser.parseForm("form Box1HouseOwning { hasSoldHouse '\"Did?\" }");
	}

	@Test(expected=ParseError.class) public void testBadFormQuestion5() throws ParseError
	{
		parser.parseForm("form Box1HouseOwning { hasSoldHouse boolean }");
	}

	@Test(expected=ParseError.class) public void testBadFormQuestion6() throws ParseError
	{
		parser.parseForm("form Box1HouseOwning { hasSoldHouse: }");
	}
}
