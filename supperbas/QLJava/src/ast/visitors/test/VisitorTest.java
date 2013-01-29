package ast.visitors.test;

import parser.JACCParser;

import ast.visitors.*;

public class VisitorTest {
	
	@SuppressWarnings("unused")
	private String str;
	private final JACCParser parser;
	private final CheckExpr visitor;

	public VisitorTest(CheckExpr visitor) {
		this.parser = new JACCParser();
		this.visitor = visitor;
		init();
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

}
