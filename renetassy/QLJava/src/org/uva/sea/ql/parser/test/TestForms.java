package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.uva.sea.ql.ast.stmnt.Form;
import org.uva.sea.ql.parser.antlr.ANTLRParser;


@RunWith(Parameterized.class)
public class TestForms {

	private IParse parser;

	@Parameters
	public static List<Object[]> theParsers() {

		List<Object[]> antlrList = new ArrayList<Object[]>();
		antlrList.add(new Object[] {new ANTLRParser()});
		return antlrList;

	} 

	public TestForms(IParse parser) {
		this.parser = parser;
	}

	@Test
	public void TestSingleQuestionForm() throws ParseError {
		
		assertEquals(Form.class, parser.parseForm("form SQForm { question1 : \"How u doin?\" string }").getClass());
		assertEquals(Form.class, parser.parseForm("form SQForm { question1 : \"Hoe gaat het?\" bool }").getClass());
		assertEquals(Form.class, parser.parseForm("form SQForm { question1 : \"Inampou ginete?\" int }").getClass());
		
	}
	
	@Test
	public void TestMultiQuestionForm() throws ParseError {
		
		assertEquals(Form.class, parser.parseForm("form MQForm { " +
				" question1 : \"How u doin?\" string " +
				" question2 : \"Filaraki mhpws exeis 50 lepta?\" int " +
				" question3 : \"Na valw venzini sto mixanaki pou thelw?\" bool " +
				" }").getClass());
	}
	
	@Test
	public void TestIfForm() throws ParseError {
		
		assertEquals(Form.class, parser.parseForm("form MQForm { " +
				" question1 : \"Peace\" string " +
				" question2 : \"Make Love Not War\" int" +
				" 	if (!love) { " +
				" 		question1 : \"Then what?\" bool " +
				"		question2 : \"...then what?\" string " +
				"	}" +
				" question3 : \"agapi re mounia\" bool " +
				" }").getClass());
	}
	
	@Test
	public void TestNestedIfForm() throws ParseError {
		
		assertEquals(Form.class, parser.parseForm("form MQForm { " +
				" question1 : \"Peace\" string " +
				" question2 : \"Make Love Not War\" int" +
				" 	if (!love) { " +
				" 		question4 : \"Then what?\" bool " +
				"		if (love * 4) { " +
				"			question6 : \" wtf? \" int " +
				"		}" +
				"		question5 : \"...then what?\" string" +
				"		if (true + false * peace / 9898) { " +
				"			question7 : \" kali fasi \" int " +
				"			if (-8) { " +
				"				question8 : \" lekker \" string " +
				"				question9 : \" joli \" bool " +
				"			}" +
				"		}" +
				"	}" +
				" question3 : \"ti leei psile?\" bool " +
				" }").getClass());
	}
	
	@Test
	public void TestSampleForm() throws ParseError {
		
		assertEquals(Form.class, parser.parseForm("form Box1HouseOwning { " +
				" hasSoldHouse: \"Did you sell a house in 2010? \" bool " +
				" hasBoughtHouse: \"Did you by a house in 2010? \" bool " +
				" hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction? \" bool " +
				" 	if (hasSoldHouse) {" +
				"		sellingPrice: \"Price the house was sold for:\" int " +
				"		privateDebt: \"Private debts for the sold house:\" int " +
				"		valueResidue: \"Value residue:\" int (sellingPrice - privateDebt)" +
				"	}" +
				" }").getClass());
	}

}
