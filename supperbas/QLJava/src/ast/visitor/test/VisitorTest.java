package ast.visitor.test;

import org.junit.Test;

import parser.JACCParser;
import parser.test.ParseError;

import ast.visitor.*;

public class VisitorTest {
	
	@SuppressWarnings("unused")
	private String str;
	private final JACCParser parser;
	public VisitorTest() {
		this.parser = new JACCParser();
		//this.visitor = visitor;
		//init();
	}
	
	public void init(){
		str = 	"form Box1HouseOwning {"+
					"\"Did you sell a house in 2010?\" hasSoldHouse: boolean "+
					"\"Did you by a house in 2010?\" hasBoughtHouse: boolean "+
					"\"Did you enter a loan for maintenance/reconstruction?\" "+
					"hasMaintLoan: boolean "+
					"if (hasSoldHouse) { "+
						"\"Private debts for the sold house:\" privateDebt: money "+
						"\"Price the house was sold for:\" sellingPrice: money "+
						"\"Value residue:\" valueResidue = sellingPrice - privateDebt "+
					"}"+
				"}";
	}
	
	@Test
	public void test() throws ParseError {
		String program = "form Box1HouseOwning {"+
				"\"Did you sell a house in 2010?\" hasSoldHouse: boolean "+
				"\"Did you by a house in 2010?\" hasBoughtHouse: boolean "+
				"\"Did you enter a loan for maintenance/reconstruction?\" "+
				"hasMaintLoan: boolean "+
				"if (hasSoldHouse) { "+
					"\"Private debts for the sold house:\" privateDebt: integer "+
					"\"Price the house was sold for:\" sellingPrice: integer "+
					"\"Value residue:\" valueResidue = sellingPrice - privateDebt "+
				"}"+
			"}";
		this.parser.parse( program ).accept(
			new PrintExpressionVisitor()
		);
	}

}
