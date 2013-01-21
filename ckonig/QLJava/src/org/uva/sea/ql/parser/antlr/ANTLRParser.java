package org.uva.sea.ql.parser.antlr;

import java.io.IOException;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.ParseError;

public class ANTLRParser implements IParse {
	
	@Override
	public Expr parseForm(String src) throws ParseError {
		ANTLRStringStream stream = new ANTLRStringStream(src);
		CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(new QLLexer(stream));
		QLParser parser = new QLParser(tokens);
		try {
			return parser.parse();
		} catch (RecognitionException e) {
			throw new ParseError(e.getMessage());
		}
	}
	@Override
	public Expr parseFile(String filename) throws ParseError, IOException {
		ANTLRFileStream fs = new ANTLRFileStream(filename);		
		CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(new QLLexer(fs));
		QLParser parser = new QLParser(tokens);
		try {
			return parser.parse();
		} catch (RecognitionException e) {
			throw new ParseError(e.getMessage());
		}
	}
	@Override
	public Expr parseExpression(String src) throws ParseError {
		ANTLRStringStream stream = new ANTLRStringStream(src);
		CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(new QLLexer(stream));
		QLParser parser = new QLParser(tokens);
		try {
			return parser.orExpr();
		} catch (RecognitionException e) {
			throw new ParseError(e.getMessage());
		}
	}
}
