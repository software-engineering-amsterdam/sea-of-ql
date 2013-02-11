package org.uva.sea.ql.parser.jacc;

import java.io.StringReader;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.stm.Form;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.ParseError;

public class JACCParser implements IParse {

	@Override
	public ASTNode parse(final String src) throws ParseError {
		QLLexer lexer = new QLLexer(new StringReader(src));
		QLParser parser = new QLParser(lexer);

		if (!parser.parse()) {
			throw new ParseError("Error parsing ASTNode: "
					+ parser.getErrorMessage());
		}
		return parser.getResult();
	}

	@Override
	public Form parseForm(final String src) throws ParseError {
		QLLexer lexer = new QLLexer(new StringReader(src));
		QLParser parser = new QLParser(lexer);

		if (!parser.parse()) {
			throw new ParseError("Error parsing Form: "
					+ parser.getErrorMessage());
		}
		return parser.getForm();
	}

}
