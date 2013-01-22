package org.uva.sea.ql.parser.antlr;

import java.io.IOException;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.expr.grouping.Expr;
import org.uva.sea.ql.error.ParseError;
import org.uva.sea.ql.parser.IParse;

public class ANTLRParser implements IParse {

	@Override
	public Expr parseExpression(String src) throws ParseError {
		try {
			return getParser(src).orExpr();
		} catch (RecognitionException e) {
			throw new ParseError(e.getMessage());
		}
	}

	@Override
	public ASTNode parseNode(String src) throws ParseError {
		try {
			return getParser(src).form();
		} catch (RecognitionException e) {
			throw new ParseError(e.getMessage());
		}
	}

	private QLParser getParser(String src) {
		ANTLRStringStream stream = new ANTLRStringStream(src);
		CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(new QLLexer(stream));
		QLParser parser = new QLParser(tokens);
		return parser;
	}

	public ASTNode parseFile(String fileName) throws ParseError{
		try {
			return getParserFromFile(fileName).form();
		} catch (IOException e) {
			throw new ParseError(e.getMessage());
		} catch (RecognitionException e) {
			throw new ParseError(e.getMessage());
		}
	}

	private QLParser getParserFromFile(String file) throws IOException {
		ANTLRFileStream stream = new ANTLRFileStream(file);
		CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(new QLLexer(stream));
		QLParser parser = new QLParser(tokens);
		return parser;

	}

}