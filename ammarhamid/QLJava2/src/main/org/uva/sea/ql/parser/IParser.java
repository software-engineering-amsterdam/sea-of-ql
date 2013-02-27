package org.uva.sea.ql.parser;

import org.uva.sea.ql.ast.FormNode;
import org.uva.sea.ql.ast.expression.ExprNode;
import org.uva.sea.ql.parser.exception.ParserException;

import java.io.IOException;

public interface IParser
{
    QLParser createQLParser(String src);

    QLTreeWalker createQLTreeWalker(QLParser qlParser);

    FormNode parseFormFromFile(String filename) throws ParserException, IOException;

    FormNode parseForm(String src) throws ParserException;

	ExprNode parseExpr(String src) throws ParserException;
}
