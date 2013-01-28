package org.uva.sea.ql.parser.test;

import org.uva.sea.ql.ast.IASTNode;

public interface IParse {
	IASTNode parse(String src) throws ParseError;
}
