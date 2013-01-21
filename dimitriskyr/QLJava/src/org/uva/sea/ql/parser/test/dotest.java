package org.uva.sea.ql.parser.test;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.DOTTreeGenerator;
import org.uva.sea.ql.parser.antlr.QLLexer;
import org.uva.sea.ql.parser.antlr.QLParser;
import org.antlr.stringtemplate.*;

public class dotest{
	
public static void main(String[] args) throws ParseError, RecognitionException{
	String source= "form dfgd { hfghf: \"fghfgh\" true }";
	ANTLRStringStream stream = new ANTLRStringStream(source);
	CommonTokenStream tokens = new CommonTokenStream();
	tokens.setTokenSource(new QLLexer(stream));
	QLParser parser = new QLParser(tokens);
    CommonTree tree = (CommonTree)parser.form().getTree();
    DOTTreeGenerator gen = new DOTTreeGenerator();
    StringTemplate st = gen.toDOT(tree);
    System.out.println(st);
	// parser.form();
		System.out.println("ok dog");
	
}
}

