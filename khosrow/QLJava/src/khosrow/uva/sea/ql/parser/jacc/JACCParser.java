package khosrow.uva.sea.ql.parser.jacc;

import java.io.StringReader;

import khosrow.uva.sea.ql.ast.decl.Form;
import khosrow.uva.sea.ql.parser.test.IParse;
import khosrow.uva.sea.ql.parser.test.ParseError;

public class JACCParser implements IParse {
	@Override
	public Form parse(String src) throws ParseError {
		QLLexer lexer = new QLLexer(new StringReader(src));
		lexer.nextToken();
		QLParser parser = new QLParser(lexer);
		if (!parser.parse()) {
			throw new ParseError("error");
		}
		return parser.getResult();
	}

}
