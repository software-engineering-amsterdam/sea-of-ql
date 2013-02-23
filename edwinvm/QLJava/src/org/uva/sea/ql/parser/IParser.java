package org.uva.sea.ql.parser;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.parser.errors.ParseError;

public interface IParser {
	ASTNode parse(String src) throws ParseError;
}