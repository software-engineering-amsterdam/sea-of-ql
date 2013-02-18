package parser.test;

import ast.Form;

public interface IParse {
	Form parse(String src) throws ParseError;
}
