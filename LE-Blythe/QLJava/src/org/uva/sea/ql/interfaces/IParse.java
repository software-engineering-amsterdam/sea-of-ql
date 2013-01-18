package org.uva.sea.ql.interfaces;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.errors.ParseError;

public interface IParse {
	ASTNode parse(String src) throws ParseError;
}
