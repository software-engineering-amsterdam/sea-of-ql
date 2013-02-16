package org.uva.sea.ql.parser.test;

import java.util.ArrayList;
import java.util.HashMap;
import org.antlr.runtime.RecognitionException;
import org.uva.sea.ql.ast.Type;
import org.uva.sea.ql.ast.values.Ident;
import org.uva.sea.ql.ast.visitor.CheckExpr;
import org.uva.sea.ql.parser.antlr.ANTLRParser;


public class DoTest2 {
	
	public static void main(String[] args) throws ParseError, RecognitionException{
	ANTLRParser parser= new ANTLRParser();
	HashMap<Ident, Type> typeEnv = new HashMap<Ident, Type>(); 
	ArrayList<String> errormessages = new ArrayList<String>();
	System.out.println(" " + CheckExpr.check(parser.parseExpression("((65 - 54) > 54)"),typeEnv, errormessages));
	}
}

