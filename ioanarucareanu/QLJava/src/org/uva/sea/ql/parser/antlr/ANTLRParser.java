package org.uva.sea.ql.parser.antlr;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

public class ANTLRParser {
	public static void main(String[] args) throws RecognitionException {
		CharStream stream = new ANTLRStringStream(
				"form Box1HouseOwning {\n"
						+ "hasSoldHouse: \"Did you sell a house in 2010?\" boolean\n"
						+ "hasBoughtHouse: \"Did you by a house in 2010?\" boolean\n"
						+ "hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean\n"
						+ "if (hasSoldHouse) {\n"
						+ "sellingPrice: \"Price the house was sold for:\" money\n"
						+ "privateDebt: \"Private debts for the sold house:\" money\n"
						+ "valueResidue: \"Value residue:\" money(sellingPrice - privateDebt)\n"
						+ "}\n" + "}");
		QLLexer lexer = new QLLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		QLParser parser = new QLParser(tokenStream);
		parser.qlform();
		System.out.print("ok");

	}
}