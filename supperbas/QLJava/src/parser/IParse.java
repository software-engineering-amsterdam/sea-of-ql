package parser;

import ast.Form;

public interface IParse {
	Form parse(String src) throws ParseError;
}
