package org.uva.sea.ql.tests.visitor;



import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.antlr.runtime.ANTLRFileStream;
import org.junit.Test;
import org.uva.sea.ql.ast.expr.value.BoolLiteral;
import org.uva.sea.ql.ast.expr.value.IntLiteral;
import org.uva.sea.ql.ast.expr.value.MoneyLiteral;
import org.uva.sea.ql.ast.expr.value.Value;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.antlr.IParse;
import org.uva.sea.ql.parser.antlr.ParseError;
import org.uva.sea.ql.visitors.ElementChecker;
import org.uva.sea.ql.visitors.ExprEvaluator;


public class TestTypeChecker {

	final private IParse parser = new ANTLRParser();
	final String path = "src/org/uva/sea/ql/tests/TestQL.ql";
	final String expr1 = "3 != 2";
	final Map<String, Value> env = new HashMap<String, Value>();
	@Test
	public void testTypeCheck() throws ParseError {
		
		ExprEvaluator eval = new ExprEvaluator(env);
		try {
			File filePath = new File(path);
			ANTLRFileStream charStream = new ANTLRFileStream(filePath.getAbsolutePath());
			ElementChecker.check(parser.parseForm(charStream.toString()));
			Value val = parser.parseExpr(expr1).accept(eval);
			if (val instanceof IntLiteral){
    			System.out.println(((IntLiteral) val).getValue());
    		}
    		if (val instanceof BoolLiteral){
    			System.out.println(((BoolLiteral) val).getValue());
    		}
    		if (val instanceof MoneyLiteral){
    			System.out.println(((MoneyLiteral) val).getValue());
    		}
		} catch (IOException e) {
			e.printStackTrace();
		}

		
	}
	
}
