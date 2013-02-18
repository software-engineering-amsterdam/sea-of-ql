package org.uva.sea.ql.parser;

import org.uva.sea.ql.ast.Node;
import org.uva.sea.ql.ast.expression.ExprNode;
import org.uva.sea.ql.parser.exception.ParserException;

import java.io.IOException;

public interface IParser
{
    QLParser createQLParser(String src);

    QLTreeWalker createQLTreeWalker(QLParser qlParser);

	Node parseForm(String src) throws ParserException;

    Node parseFormFromFile(String filename) throws ParserException, IOException;

	ExprNode parseExpr(String src) throws ParserException;
}
