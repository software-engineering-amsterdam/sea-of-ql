package org.uva.sea.ql.parser.antlr;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.parser.test.IParse;
import org.uva.sea.ql.parser.test.ParseError;

public abstract class GeneralANTLRParser implements IParse {

	
	public abstract ASTNode parseANonTerminal(QLParser parser) throws ParseError;
	
	@Override
	public ASTNode parse(String src) throws ParseError {
		ANTLRStringStream stream = new ANTLRStringStream(src);
		CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(new QLLexer(stream));
		QLParser parser = new QLParser(tokens);
		return parseANonTerminal(parser);
	}

}
