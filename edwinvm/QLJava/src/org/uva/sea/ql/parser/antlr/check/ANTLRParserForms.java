package org.uva.sea.ql.parser.antlr.check;

import org.uva.sea.ql.ast.forms.Form;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.errors.ParseError;

public class ANTLRParserForms extends ANTLRParser {
	@Override
	public Form parse(String src) throws ParseError {
		return (Form)parseInput(src, "form");
	}
}