package parser.test;

import ast.Expression;

public interface IParse {
	Expression parse(String src) throws ParseError;
}
