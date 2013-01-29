package org.uva.sea.ql.parser;

import org.uva.sea.ql.ast.ASTNode;

public interface IParser {
	ASTNode parse(String src) throws ParseError;
}