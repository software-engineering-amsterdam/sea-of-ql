package org.uva.sea.ql.parser;

import org.uva.sea.ql.ast.ASTNode;

public interface IParse {
	ASTNode parse(String src) throws ParseError;
}
