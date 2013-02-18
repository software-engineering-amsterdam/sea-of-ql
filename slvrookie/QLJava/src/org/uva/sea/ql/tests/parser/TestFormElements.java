package org.uva.sea.ql.tests.parser;

import static org.junit.Assert.*;
import org.junit.Test;
import org.uva.sea.ql.ast.formelements.CompQuestion;
import org.uva.sea.ql.ast.formelements.IfThen;
import org.uva.sea.ql.ast.formelements.IfThenElse;
import org.uva.sea.ql.ast.formelements.Question;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.antlr.IParse;
import org.uva.sea.ql.parser.antlr.ParseError;

public class TestFormElements {

	final private IParse parser = new ANTLRParser();
	
	@Test
	public void testQuestion() throws ParseError {
		String form1 =  "hasSoldHouse1: \"Did you sell a house in 2010?\" money \n";
		String form2 =  "hasSoldHouse1: \"Did you sell a house in 2010?\" boolean \n";
		String form3 =  "hasSoldHouse1: \"Did you sell a house in 2010?\" string \n";
		assertEquals(Question.class, parser.parseFormElement(form1).getClass());
		assertEquals(Question.class, parser.parseFormElement(form2).getClass());
		assertEquals(Question.class, parser.parseFormElement(form3).getClass());
	}

	@Test
	public void testCompQuestion() throws ParseError {
		String form1 =  "hasSoldHouse1: \"Did you sell a house in 2010?\" money(3.00 +4.00) \n";
		String form2 =  "hasSoldHouse1: \"Did you sell a house in 2010?\" boolean(true) \n";
		String form3 =  "hasSoldHouse1: \"Did you sell a house in 2010?\" string(\"\") \n";
		assertEquals(CompQuestion.class, parser.parseFormElement(form1).getClass());
		assertEquals(CompQuestion.class, parser.parseFormElement(form2).getClass());
		assertEquals(CompQuestion.class, parser.parseFormElement(form3).getClass());
	}

	@Test
	public void testIfBody() throws ParseError {
		String form1 = " if (true){ hasSoldHouse1: \"Value residue:\" int \n }" ;
		String form2 = " if (has){ hasSoldHouse1: \"Value residue:\" int \n }" ;
		String form3 = " if (5){}" ;
		String form4 = " if (ble) { if (kek) { } }";
		assertEquals(IfThen.class, parser.parseFormElement(form1).getClass());
		assertEquals(IfThen.class, parser.parseFormElement(form2).getClass());
		assertEquals(IfThen.class, parser.parseFormElement(form3).getClass());
		assertEquals(IfThen.class, parser.parseFormElement(form4).getClass());
	}
	
	@Test
	public void testIfElseBody() throws ParseError {
		String form1 = " if (true){ hasSoldHouse1: \"Value residue:\" int \n } else {hasSoldHouse1: \"Value residue:\" int \n}" ;
		String form2 = " if (has){ hasSoldHouse1: \"Value residue:\" int \n } else { if (5) {} }" ;
		String form3 = " if (5){} else {}" ;
		String form4 = " if ( true ) { } else { } }";
		assertEquals(IfThenElse.class, parser.parseFormElement(form1).getClass());
		assertEquals(IfThenElse.class, parser.parseFormElement(form2).getClass());
		assertEquals(IfThenElse.class, parser.parseFormElement(form3).getClass());
		assertEquals(IfThenElse.class, parser.parseFormElement(form4).getClass());
	}

}
