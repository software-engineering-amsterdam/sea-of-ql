package org.uva.sea.ql.parser.impl;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.uva.sea.ql.ast.expression.ExprNode;
import org.uva.sea.ql.ast.statement.impl.BlockNode;
import org.uva.sea.ql.parser.IParser;
import org.uva.sea.ql.parser.QLLexer;
import org.uva.sea.ql.parser.QLParser;
import org.uva.sea.ql.parser.QLTreeWalker;
import org.uva.sea.ql.parser.exception.ParserException;

import java.io.IOException;

public class ANTLRParser implements IParser
{

	@Override
	public BlockNode parseForm(String src) throws ParserException
	{
		final QLParser parser = createQLParser(src);		
		return createBlockNode(parser);
	}

    @Override
    public BlockNode parseFormFromFile(String filename) throws ParserException, IOException
    {
        final QLParser parser = createQLParserFromFile(filename);
        return createBlockNode(parser);
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

    private BlockNode createBlockNode(QLParser parser)
    {
        try
        {
            final CommonTree commonTree = (CommonTree) parser.form().getTree();
            final CommonTreeNodeStream commonTreeNodeStream = new CommonTreeNodeStream(commonTree);
            final QLTreeWalker qlTreeWalker = new QLTreeWalker(commonTreeNodeStream);
            return qlTreeWalker.walk().node;
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

    public QLParser createQLParserFromFile(String filename) throws IOException
    {
		final CharStream stream = new ANTLRFileStream(filename);
		final QLLexer lexer = new QLLexer(stream);
		final TokenStream tokenStream = new CommonTokenStream(lexer);
		return new QLParser(tokenStream);
	}

}
