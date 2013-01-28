package khosrow.uva.sea.ql.parser.test;

import khosrow.uva.sea.ql.ast.decl.Form;

public interface IParse {
	Form parse(String src) throws ParseError;
}
