package org.uva.sea.ql.parser.impl;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.uva.sea.ql.ast.Node;
import org.uva.sea.ql.ast.expression.ExprNode;
import org.uva.sea.ql.parser.IParser;
import org.uva.sea.ql.parser.QLLexer;
import org.uva.sea.ql.parser.QLParser;
import org.uva.sea.ql.parser.QLTreeWalker;
import org.uva.sea.ql.parser.exception.ParserException;

public class ANTLRParser implements IParser
{

	@Override
	public Node parseForm(String src) throws ParserException
	{
		final QLParser parser = createQLParser(src);		
		try
		{
            parser.form();
			return null;
		}
		catch (RecognitionException e)
		{
			throw new ParserException(e.getMessage());
		}
	}
	
	@Override
	public ExprNode parseExpr(String src) throws ParserException
	{
        try
        {
            final QLParser qlParser = createQLParser(src);
            final QLTreeWalker qlTreeWalker = createQLTreeWalker(qlParser);
            QLTreeWalker.expression_return expression = qlTreeWalker.expression();
            return expression.node;
        }
        catch (RecognitionException e)
        {
            throw new ParserException(e.getMessage());
        }
    }

    public QLTreeWalker createQLTreeWalker(final QLParser qlParser) throws ParserException
    {
        try
        {
            final CommonTree commonTree = (CommonTree) qlParser.expression().getTree();
            final CommonTreeNodeStream commonTreeNodeStream = new CommonTreeNodeStream(commonTree);
            return new QLTreeWalker(commonTreeNodeStream);
        }
        catch(RecognitionException e)
        {
            throw new ParserException(e.getMessage());
        }
    }

	public QLParser createQLParser(String src)
	{
		final CharStream stream = new ANTLRStringStream(src);
		final QLLexer lexer = new QLLexer(stream);
		final TokenStream tokenStream = new CommonTokenStream(lexer);
		return new QLParser(tokenStream);
	}

}
