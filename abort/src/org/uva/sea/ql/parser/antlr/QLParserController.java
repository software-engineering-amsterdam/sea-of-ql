package org.uva.sea.ql.parser.antlr;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.uva.sea.ql.ast.base.Node;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.traversal.TypeChecker;

public class QLParserController {
	public Node parse(final String src) throws RecognitionException {
		ANTLRStringStream stream = new ANTLRStringStream(src);
		CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(new QLLexer(stream));
		QLParser parser = new QLParser(tokens);
		
		return parser.orExpression();
	}
	
	public Form parseForm(final String src) throws RecognitionException {
		ANTLRStringStream stream = new ANTLRStringStream(src);
		CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(new QLLexer(stream));
		QLParser parser = new QLParser(tokens);

		return parser.form();
	}
	
	public void parseAndVisitForm(final String src) throws RecognitionException {
		final Node form = parseForm(src);
		final TypeChecker t = new TypeChecker();
		form.accept(t);
	}
}
