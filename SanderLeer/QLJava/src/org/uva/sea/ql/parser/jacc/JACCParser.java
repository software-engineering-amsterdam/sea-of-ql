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
			throw new ParseException("parse error: " + parser.getError());
		}
		ASTNode astRoot = parser.getResult();

		SymbolTableBuilder symbolsBuilder = new SymbolTableBuilder(astRoot);
		SymbolTable symbols = symbolsBuilder.build();
		
//		TypeChecker typeChecker = new TypeChecker(astRoot, symbols);
//		if (!typeChecker.check()) {
//			throw new ParseException("typecheck error: " + typeChecker.getError());
//		}
		
		ASTPrinter astPrinter = new ASTPrinter();
		astRoot.accept(astPrinter);
		// TODO: remove before production
		System.out.println(astPrinter.toString() + "\n");
		
		return astRoot;
	}
}
