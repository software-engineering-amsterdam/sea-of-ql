package org.uva.sea.ql.parser.test;

import org.antlr.runtime.RecognitionException;
import org.uva.sea.ql.ast.visitor.renderexample.Rendererr;
import org.uva.sea.ql.parser.antlr.ANTLRParser;

public class RenderingChecking {
	
	private final static String simplequestion1 = "hasSoldHouse: \"Did you sell a house in 2010?\" boolean ";
	private final static String simplequestion2 = "hasBoughtHouse: \"Did you by a house in 2010?\" boolean ";
	private final static String simplequestion3 = "hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean ";
	private final static String simplequestion4 = "sellingPrice: \"Price the house was sold for:\" money ";
	private final static String simplequestion5 = "privateDebt: \"Private debts for the sold house:\" money ";
	private final static String comquestion = "valueResidue: \"Value residue:\" money (543-654) ";
	private final static String ifBlock="if (hasSoldHouse) {" +simplequestion4+ simplequestion5 + comquestion +"}";
	private final static String elseBlock="else {" +simplequestion4+ simplequestion5 +  "}";
	private final static String form = "form Box1HouseOwning {"  + simplequestion1 + simplequestion2 + simplequestion3 + ifBlock + "}";
 
	
public static void main(String[] args) throws ParseError, RecognitionException{
	
	Rendererr render=new Rendererr();
	ANTLRParser parsethat= new ANTLRParser();
	parsethat.parseForm(form).accept(render);
	System.out.println("ok dog");
	}
}