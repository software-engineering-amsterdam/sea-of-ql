package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.uva.sea.ql.ast.Add;
import org.uva.sea.ql.ast.GT;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.Int;
import org.uva.sea.ql.ast.LEq;
import org.uva.sea.ql.ast.LT;
import org.uva.sea.ql.ast.Mul;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.antlr.QLLexer;
import org.uva.sea.ql.parser.antlr.QLParser;

public class dotest{
	
public static void main(String[] args) throws ParseError{
	ANTLRStringStream stream = new ANTLRStringStream("src > , 123");
	CommonTokenStream tokens = new CommonTokenStream();
	tokens.setTokenSource(new QLLexer(stream));
	QLParser parser = new QLParser(tokens);
	try {
		 parser.orExpr();
		 System.out.println("ok dog");
	} catch (RecognitionException e) {
		throw new ParseError(e.getMessage());
	}
}
}

