package org.uva.sea.ql.parser.impl;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.parser.IParser;
import org.uva.sea.ql.parser.QLLexer;
import org.uva.sea.ql.parser.QLParser;
import org.uva.sea.ql.parser.exception.ParserException;

public class ANTLRParser implements IParser
{

	@Override
	public void parseForm(String src) throws ParserException
	{
		final QLParser parser = createQLParser(src);		
		try
		{
			parser.form();
		}
		catch (RecognitionException e)
		{
			throw new ParserException(e.getMessage());
		}
	}
	
	@Override
	public Expr parseExpr(String src) throws ParserException
	{
		final QLParser parser = createQLParser(src);		
		try
		{
			return parser.orExpr();
		}
		catch (RecognitionException e)
		{
			throw new ParserException(e.getMessage());
		}
	}

	private QLParser createQLParser(String src)
	{
		final CharStream stream = new ANTLRStringStream(src);
		final QLLexer lexer = new QLLexer(stream);
		final TokenStream tokenStream = new CommonTokenStream(lexer);
		final QLParser parser = new QLParser(tokenStream);
		return parser;
	}

}
