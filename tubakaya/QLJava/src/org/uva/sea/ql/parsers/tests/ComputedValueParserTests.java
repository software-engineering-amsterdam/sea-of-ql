package org.uva.sea.ql.parsers.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.core.dom.statements.ComputedValue;
import org.uva.sea.ql.parsers.ComputedValueParser;
import org.uva.sea.ql.parsers.ParserBaseForStatements;
import org.uva.sea.ql.parsers.exceptions.ParseException;

public class ComputedValueParserTests {

	private ParserBaseForStatements parser;
	
	@Before
    public void setUp() {
		this.parser = new ComputedValueParser();
    }
	
	@Test
	public void does_returnComputedValue_when_thereIsASubtractionDone() throws ParseException {
		
		String text="valueResidue: \"Value residue:\" integer(2 - 1)";
		assertEquals(ComputedValue.class, parser.parse(text).getClass());		
	}
	
	@Test
	public void does_returnComputedValue_when_thereIsNoCalculationButAValue() throws ParseException {
		
		String text="valueResidue: \"Value residue:\" integer(2)";
		assertEquals(ComputedValue.class, parser.parse(text).getClass());		
	}
}
