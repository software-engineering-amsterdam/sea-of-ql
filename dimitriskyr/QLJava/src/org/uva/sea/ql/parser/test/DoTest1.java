package org.uva.sea.ql.parser.test;

import java.util.ArrayList;
import java.util.HashMap;

import org.antlr.runtime.*;
import org.uva.sea.ql.ast.Type;
import org.uva.sea.ql.ast.values.Ident;
import org.uva.sea.ql.ast.visitor.StatementVisitor;
import org.uva.sea.ql.parser.antlr.*;;

public class DoTest1{
	
public static void main(String[] args) throws ParseError, RecognitionException{
	HashMap<Ident, Type> typeEnv = new HashMap<Ident, Type>();
	ArrayList<String> errormessages = new ArrayList<String>();
	StatementVisitor visitor=new StatementVisitor(typeEnv,errormessages);
	ANTLRParser parsethat= new ANTLRParser();
	String source= "form dfgd { hfghf: \"fghfgh\" boolean }";
	ANTLRStringStream stream = new ANTLRStringStream(source);
	CommonTokenStream tokens = new CommonTokenStream();
	tokens.setTokenSource(new QLLexer(stream));
	QLParser parser = new QLParser(tokens);
	parser.form();
	parsethat.parseIfThen("if (true && true) { sellingPrice: \"Price the house was sold for:\" money }").accept(visitor);
	System.out.println("ok dog");
	
}
}

