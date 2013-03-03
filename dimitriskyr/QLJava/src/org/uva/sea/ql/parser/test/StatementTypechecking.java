package org.uva.sea.ql.parser.test;

import java.util.ArrayList;
import java.util.HashMap;

import org.antlr.runtime.*;
import org.uva.sea.ql.ast.Type;
import org.uva.sea.ql.parser.antlr.*;
import org.uva.sea.ql.visitor.StatementVisitor;

;

public class StatementTypechecking {

	private final static String simplequestion = "bye : \"body\" money ";
	private final static String comquestion = "hello : \"body\" money (43 - 30)";
	private final static String ifBlock = "if (true) {" + comquestion + "}";
	private final static String elseBlock = "else {" + simplequestion + "}";
	private final static String form = "form ident {" + ifBlock + "}";

	public static void main(String[] args) throws ParseError,
			RecognitionException {

		HashMap<String, Type> typeEnv = new HashMap<String, Type>();
		ArrayList<String> errormessages = new ArrayList<String>();
		StatementVisitor visitor = new StatementVisitor(typeEnv, errormessages);
		ANTLRParser parsethat = new ANTLRParser();
		String source = "form dfgd { hfghf: \"fghfgh\" boolean }";
		ANTLRStringStream stream = new ANTLRStringStream(source);
		CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(new QLLexer(stream));
		QLParser parser = new QLParser(tokens);
		parser.form();
		parsethat.parseForm(form).accept(visitor);
		System.out.println("ok dog");
		parsethat.parseStatement(ifBlock).accept(visitor);
		if (errormessages.isEmpty())
		System.out.println("ok man");
		parsethat.parseStatement(ifBlock + elseBlock).accept(visitor);
		System.out.println("ok dude");
		parsethat.parseStatement(simplequestion + "bye :\"body\" money ")
				.accept(visitor);
		System.out.println("ok nigga");
		parsethat.parseStatement(comquestion).accept(visitor);
		System.out.println("ok boy");
	}
}
