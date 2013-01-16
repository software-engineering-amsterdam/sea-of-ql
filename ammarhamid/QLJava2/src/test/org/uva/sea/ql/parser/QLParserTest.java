package org.uva.sea.ql.parser;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.uva.sea.ql.parser.exception.ParserException;
import org.uva.sea.ql.parser.impl.ANTLRParser;

@RunWith(Parameterized.class)
public class QLParserTest
{
	private IParser parser;

	@Parameters
	public static List<Object[]> theParsers()
	{
		final List<Object[]> parsers = new ArrayList<Object[]>();
		parsers.add(new Object[] { new ANTLRParser() });
		return parsers;
	}

	public QLParserTest(IParser parser)
	{
		this.parser = parser;
	}
	
	@Before
	public void setup()
	{
		
	}
	
	@After
	public void tearDown()
	{
		System.out.println("Done");
	}

	@Test
	public void simpleValidFormTest() throws ParseException
	{
		this.parser.parseForm("" +
				"form test " +
				"{ " +
				"	hasSoldHouse: \"Did you sell a house in 2010?\" boolean " +
				"	hasSoldCar: \"Did you sell a car in 2010?\" integer " +
				"	if (1+1==2) " +
				"	{ " +
				"		hasNothing: \"nothing?\" boolean " +
				"	}" +
				"	else" +
				"	{" +
				"		hasNothing: \"nothing?\" boolean " +
				"	}" +
				"}");		
	}

	@Test
	public void simpleInvalidFormTest()
	{
		try
		{
			this.parser.parseForm("" +
					"test " +
					"{ " +
					"	hasSoldHouse: \"Did you sell a house in 2010?\" boolean " +
					"	hasSoldCar: \"Did you sell a car in 2010?\" integer " +
					"	if (1+1==2) " +
					"	{ " +
					"		hasNothing: \"nothing?\" boolean " +
					"	}" +
					"	else" +
					"	{" +
					"		hasNothing: \"nothing?\" boolean " +
					"	}" +
					"}");
			Assert.fail("Ill-formed program - should fail !!");
		}
		catch (ParserException e)
		{
			// expected
			System.out.println(e.getMessage());	
		}		
	}
	
}
