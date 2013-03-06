package org.uva.sea.ql.parser;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.Form;

public interface IParse {

	ASTNode parse(String src) throws ParseError;

	Form parseForm(String src) throws ParseError;
}
