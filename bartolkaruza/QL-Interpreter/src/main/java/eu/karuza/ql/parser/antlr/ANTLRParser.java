package eu.karuza.ql.parser.antlr;

import java.io.IOException;
import java.io.InputStream;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;

import eu.karuza.ql.ast.ASTNode;
import eu.karuza.ql.ast.Expr;
import eu.karuza.ql.error.ParseError;
import eu.karuza.ql.parser.IParse;
import eu.karuza.ql.parser.ParserContext;

public class ANTLRParser implements IParse {

	@Override
	public Expr parseExpression(String src) throws ParseError {
		try {
			return getParser(src).orExpr();
		} catch (RecognitionException e) {
			throw new ParseError(e);
		} catch (RuntimeException e) {
			throw new ParseError(e);
		}
	}

	@Override
	public ASTNode parseNode(String src) throws ParseError {
		try {
			return getParser(src).form();
		} catch (RecognitionException e) {
			throw new ParseError(e);
		} catch (RuntimeException e) {
			throw new ParseError(e);
		}
	}
	
	@Override
	public ASTNode parseNodeFromStream(InputStream stream) throws ParseError {
		try {
			return getStreamParser(stream).form();
		} catch (IOException e) {
			throw new ParseError(e);
		} catch (RecognitionException e) {
			throw new ParseError(e);
		}
	}
	
	private QLParser getStreamParser(InputStream inputStream) throws IOException {
		ANTLRInputStream stream = new ANTLRInputStream(inputStream, ParserContext.CHARACTER_ENCODING);
		CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(new QLLexer(stream));
		return new QLParser(tokens);
	}

	private QLParser getParser(String src) {
		ANTLRStringStream stream = new ANTLRStringStream(src);
		CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(new QLLexer(stream));
		return new QLParser(tokens);
	}

	public ASTNode parseFile(String fileName) throws ParseError{
		try {
			return getParserFromFile(fileName).form();
		} catch (IOException e) {
			throw new ParseError(e);
		} catch (RecognitionException e) {
			throw new ParseError(e);
		}
	}

	private QLParser getParserFromFile(String file) throws IOException {
		ANTLRFileStream stream = new ANTLRFileStream(file);
		CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(new QLLexer(stream));
		return new QLParser(tokens);

	}

}
