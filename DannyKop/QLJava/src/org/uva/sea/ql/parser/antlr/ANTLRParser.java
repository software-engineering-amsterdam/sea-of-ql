package org.uva.sea.ql.parser.antlr;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.parser.test.IParse;
import org.uva.sea.ql.parser.test.ParseError;

public class ANTLRParser implements IParse {

	@Override
	public ASTNode parse(String src) throws ParseError {
		ANTLRStringStream stream = new ANTLRStringStream(src);
		CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(new QLLexer(stream));
		QLParser parser = new QLParser(tokens);
		try {
			return parser.form();
		} catch (RecognitionException e) {
			throw new ParseError(e.getMessage());
		}
	}
	
	
	// TESTING PURPOSES!
    public static void main(String[] args) throws RecognitionException {
    	ANTLRParser p = new ANTLRParser();
    	try {
    		/*
    		ASTNode e = p.parse("form Box1HouseOwning {" +
    							"hasSoldHouse: \"Did you sell a house in 2010?\" boolean" +
    							"hasBoughtHouse: \"Did you by a house in 2010?\" boolean" +
    							"hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean" +
    							"if (hasSoldHouse) { sellingPrice: \"Price the house was sold for:\" boolean" +
    							"privateDebt: \"Private debts for the sold house:\" boolean" +
    							"valueResidue: \"Value residue:\" boolean(sellingPrice - privateDebt)" +
    							"}" +
    						"}");*/
    						
    		ASTNode e = p.parse("form Box1HousOwning {checker: \"asdasd\" boolean}");
    		System.out.println("Ok => value: "+ e.toString() + " class:" + e.getClass());
    	}catch(ParseError pe){
    		System.out.println("Error: " + pe.getMessage());
    	}
    }

}
