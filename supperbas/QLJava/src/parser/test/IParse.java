package parser.test;

import ast.Statement;

public interface IParse {
	Statement parse(String src) throws ParseError;
}
