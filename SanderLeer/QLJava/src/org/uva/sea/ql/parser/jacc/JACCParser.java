package org.uva.sea.ql.parser.jacc;

import java.io.StringReader;
import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.utils.ASTPrinter;

public class JACCParser implements Parser {
	@Override
	public ASTNode parse(String src) throws ParseException {
		// TODO: remove before production
		System.out.println("SOURCE = \"" + src + "\"");
		QLLexer lexer = new QLLexer(new StringReader(src));

		QLParser parser = new QLParser(lexer);
		if (!parser.parse()) {
			throw new ParseException("error");
		}
		ASTNode result = parser.getResult();

		SymbolTable symbols = new SymbolTable();
		SymbolTableBuilder stb = new SymbolTableBuilder(symbols);
		result.accept(stb);
		if (stb.hasErrors()) {
			throw new ParseException(stb.getErrorsAsString());
		}
		
		ASTPrinter astPrinter = new ASTPrinter();
		result.accept(astPrinter);
		// TODO: remove before production
		System.out.println(astPrinter.toString() + "\n");

		return result;
	}
}
