package org.uva.sea.ql.parser.antlr;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.uva.sea.ql.parser.test.IParse;
import org.uva.sea.ql.parser.test.ParseError;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Value;

public class ANTLRParser implements IParse {

	public QLParser parse(String src) throws ParseError {
		ANTLRStringStream stream = new ANTLRStringStream(src);
		CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(new QLLexer(stream));
		QLParser parser = new QLParser(tokens);
		return parser;
	}

	@Override
	public Expr parseExpression(String src) throws ParseError {
		try {
			return parse(src).orExpr();
			} catch (RecognitionException e) {
			throw new ParseError(e.getMessage());
			}
	} 
	
	public Value parseValue(String src) throws ParseError {
		try {
			return parse(src).value();
			} catch (RecognitionException e) {
			throw new ParseError(e.getMessage());
			}
	}
	
	
	
	
}
