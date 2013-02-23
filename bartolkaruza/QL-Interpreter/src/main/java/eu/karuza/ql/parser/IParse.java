package eu.karuza.ql.parser;

import java.io.InputStream;


import eu.karuza.ql.ast.ASTNode;
import eu.karuza.ql.ast.Expr;
import eu.karuza.ql.error.ParseError;

public interface IParse {
	
	Expr parseExpression(String src) throws ParseError;

	ASTNode parseNode(String src) throws ParseError;
	
	ASTNode parseFile(String fileName) throws ParseError;

	ASTNode parseNodeFromStream(InputStream stream) throws ParseError;
}
