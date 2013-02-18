package org.uva.sea.ql.parser;

import org.uva.sea.ql.ast.expression.ExprNode;
import org.uva.sea.ql.ast.statement.impl.BlockNode;
import org.uva.sea.ql.parser.exception.ParserException;

import java.io.IOException;

public interface IParser
{
    QLParser createQLParser(String src);

    QLTreeWalker createQLTreeWalker(QLParser qlParser);

    BlockNode parseFormFromFile(String filename) throws ParserException, IOException;

    BlockNode parseForm(String src) throws ParserException;

	ExprNode parseExpr(String src) throws ParserException;
}
