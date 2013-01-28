package org.uva.sea.ql.parser;

import org.uva.sea.ql.ast.Node;
import org.uva.sea.ql.ast.expression.ExprNode;
import org.uva.sea.ql.parser.exception.ParserException;

public interface IParser
{
    QLParser createQLParser(String src);

    QLTreeWalker createQLTreeWalker(QLParser qlParser);

	Node parseForm(String src) throws ParserException;
	
	ExprNode parseExpr(String src) throws ParserException;
}
