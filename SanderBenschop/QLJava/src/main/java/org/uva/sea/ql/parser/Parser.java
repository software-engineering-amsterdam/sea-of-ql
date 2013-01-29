package org.uva.sea.ql.parser;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.parser.exception.ParseError;

public interface Parser {
	
	ASTNode parse(String src) throws ParseError;
}
