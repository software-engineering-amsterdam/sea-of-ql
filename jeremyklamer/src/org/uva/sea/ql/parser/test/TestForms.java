package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.uva.sea.ql.ast.expr.value.Ident;
import org.uva.sea.ql.ast.statement.Form;
import org.uva.sea.ql.interpreter.Env;
import org.uva.sea.ql.interpreter.Value;
import org.uva.sea.ql.parser.antlr.ANTLRParser;


@RunWith(Parameterized.class)
public class TestForms {
	private IParse parser;

	@Parameters
	public static List<Object[]> theParsers() {
		List<Object[]> retVal = new ArrayList<Object[]>();
		retVal.add(new Object[] {new ANTLRParser()});
		return retVal;
	}
	
	public TestForms(IParse parser) {
		this.parser = parser;
	}

	
	@Test
	public void testBasicForms() throws ParseError {
		Ident ident1 = new Ident("hallo");
		Ident ident2 = new Ident("hallo");
		Ident ident3 = new Ident("hallo2");
		
		boolean one = ident1.equals(ident2);
		boolean two = ident1.equals(ident3);
		
		
		assertEquals(Form.class,parser.parseForm("form basicForm1 { question1 : \"Is everything ok? \" boolean }").getClass());
		assertEquals(Form.class,parser.parseForm("form basicForm2 { question1 : \"How much does a burge cost? \" integer }").getClass());
		assertEquals(Form.class,parser.parseForm("form basicForm2 { question1 : \"Total integer spent: \" integer( 5 * 18) }").getClass());
	}
	
	@Test
	public void testComplForms() throws ParseError {
		assertEquals(Form.class, parser.parseForm("" +
				"form testForm1 { question1 : \"How are you? \" boolean " +
					"question2 : \"Good? \" integer " +
					"question3 : \"Better? \" integer(8 * 7) " + 
					"question4 : \"Best? \" boolean " +
					"}").getClass());
	}
	
	@Test
	public void testIfForms() throws ParseError {
		assertEquals(Form.class, parser.parseForm(
				"form Box1HouseOwning {" +
					"hasSoldHouse: \"Did you sell a house in 2010?\" integer(15 + 18) " +
					"hasBoughtHouse: \"Did you by a house in 2010?\" boolean " +
					"hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\"" +
					"boolean " +
					"if (hasSoldHouse) {" +
						"sellingPrice: \"Price the house was sold for:\" integer " +
						"privateDebt: \"Private debts for the sold house:\" integer " +
						"valueResidue: \"Value residue:\" integer(13 - 5) " +
						"} " +
					"}").getClass());
	}
	
	@Test
	public void testIfThenForms() throws ParseError {
		assertEquals(Form.class, parser.parseForm(
				"form Box1HouseOwning {" +
					"hasSoldHouse: \"Did you sell a house in 2010?\" integer(15 + 18) " +
					"hasBoughtHouse: \"Did you by a house in 2010?\" boolean " +
					"hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\"" +
					"boolean " +
					"if (hasSoldHouse) {" +
						"sellingPrice: \"Price the house was sold for:\" integer " +
						"privateDebt: \"Private debts for the sold house:\" integer " +
						"valueResidue: \"Value residue:\" integer(13 - 5) " +
						"} " +
					"else { sellingPrice: \"lastquestion:\" integer " +
						"} " +
					"}").getClass());
	}
	
	@Test
	public void testNestedIfForms() throws ParseError {
		assertEquals(Form.class, parser.parseForm(
				"form Box1HouseOwning {" +
					"hasSoldHouse: \"Did you sell a house in 2010?\" integer(15 + 18) " +
					"hasBoughtHouse: \"Did you by a house in 2010?\" boolean " +
					"hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\"" +
					"boolean " +
					"if (hasSoldHouse) {" +
						"sellingPrice: \"Price the house was sold for:\" integer " +
						"privateDebt: \"Private debts for the sold house:\" integer " +
						"valueResidue: \"Value residue:\" integer(13 - 5) " +
						"if (hasSoldHouse) {" +
							"sellingPrice: \"Price the house was sold for:\" integer " +
							"privateDebt: \"Private debts for the sold house:\" integer " +
							"valueResidue: \"Value residue:\" integer(13 - 5) " +
							"} " +
						"} " +
					"else { sellingPrice: \"lastquestion:\" integer " +
						"} " +
					"}").getClass());
	}
	
	@Test
	public void testFormTypes3() throws ParseError {
		
//		List<Message> es = parser.parseForm(
//		"form Box1HouseOwning {" +
//		"hasSoldHouse: \"For how much did you sell your house?\" integer " +
//		"if (hasSoldHouse > 10000) {" +
//			"sellingPrice: \"Price the house was sold for:\" integer " +
//			"} " +
//		"else { sellingPrice: \"lastquestion:\" integer " +
//			"} " +
//			"}").checkType(new Env(new HashMap<Ident,org.uva.sea.ql.ast.type.Type>(), new HashMap<Ident,Value>()));
		
		assertEquals(0, parser.parseForm(
				"form Box1HouseOwning {" +
					"hasSoldHouse: \"Did you sell a house in 2010?\" boolean " +
					"if (hasSoldHouse) {" +
						"sellingPrice: \"Price the house was sold for:\" integer " +
						"} " +
					"else { sellingPrice: \"lastquestion:\" integer " +
						"} " +
				"}").checkType(new Env(new HashMap<Ident,org.uva.sea.ql.ast.type.Type>(), new HashMap<Ident,Value>())).size());
	}
	
	@Test
	public void testFormTypes() throws ParseError {
		assertEquals(0, parser.parseForm(
				"form Box1HouseOwning {" +
					"hasSoldHouse: \"Did you sell a house in 2010?\" boolean " +
					"hasBoughtHouse: \"Did you by a house in 2010?\" boolean " +
					"hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\"" +
					"boolean " +
					"if (hasSoldHouse) {" +
						"sellingPrice: \"Price the house was sold for:\" integer " +
						"privateDebt: \"Private debts for the sold house:\" integer " +
						"valueResidue: \"Value residue:\" integer(13 - 5) " +
						"} " +
					"else { sellingPrice: \"How much would you sell your house for :\" integer " +
						"} " +
				"}").checkType(new Env(new HashMap<Ident,org.uva.sea.ql.ast.type.Type>(), new HashMap<Ident,Value>())).size());
		
		assertEquals(1, parser.parseForm(
				"form Box1HouseOwning {" +
					"hasSoldHouse: \"Did you sell a house in 2010?\" boolean " +
					"if (hasSoldHouse > 0) {" +
						"sellingPrice: \"Price the house was sold for:\" integer " +
						"} " +
					"else { sellingPrice: \"lastquestion:\" integer " +
						"} " +
				"}").checkType(new Env(new HashMap<Ident,org.uva.sea.ql.ast.type.Type>(), new HashMap<Ident,Value>())).size());
				
		assertEquals(0, parser.parseForm(
				"form Box1HouseOwning {" +
					"hasSoldHouse: \"For how much did you sell your house?\" integer " +
					"if (hasSoldHouse > 10000) {" +
						"sellingPrice: \"Price the house was sold for:\" integer " +
						"} " +
					"else { sellingPrice: \"lastquestion:\" integer " +
						"} " +
				"}").checkType(new Env(new HashMap<Ident,org.uva.sea.ql.ast.type.Type>(), new HashMap<Ident,Value>())).size());
		
		assertEquals(2, parser.parseForm(
				"form Box1HouseOwning {" +
					"hasSoldHouse: \"For how much did you sell your house?\" boolean " +
					"if (hasSoldHouse > 10000) {" +
						"hasSoldHouse: \"Price the house was sold for:\" integer " +
						"} " +
					"else { sellingPrice: \"lastquestion:\" integer " +
						"} " +
				"}").checkType(new Env(new HashMap<Ident,org.uva.sea.ql.ast.type.Type>(), new HashMap<Ident,Value>())).size());
		
		assertEquals(2, parser.parseForm(
				"form Box1HouseOwning {" +
					"hasSoldHouse: \"For how much did you sell your house?\" integer(5+10) " +
					"hasSoldHouse2: \"Price the house was sold for:\" boolean " +
					"if (hasSoldHouse > true) {" +
						"hasSoldHouse: \"Price the house was sold for:\" boolean " +
						"} " +
					"else { sellingPrice: \"lastquestion:\" integer " +
						"} " +
				"}").checkType(new Env(new HashMap<Ident,org.uva.sea.ql.ast.type.Type>(), new HashMap<Ident,Value>())).size());
		
	}
	
}
