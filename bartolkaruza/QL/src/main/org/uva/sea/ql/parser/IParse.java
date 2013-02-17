package org.uva.sea.ql.parser;

import java.io.InputStream;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.expr.grouping.Expr;
import org.uva.sea.ql.error.ParseError;

public interface IParse {
	
	Expr parseExpression(String src) throws ParseError;

	ASTNode parseNode(String src) throws ParseError;
	
	ASTNode parseFile(String fileName) throws ParseError;

	ASTNode parseNodeFromStream(InputStream stream) throws ParseError;
}
