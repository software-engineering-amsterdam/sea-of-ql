package org.uva.sea.ql.parser;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.parser.antlr.QLLexer;
import org.uva.sea.ql.parser.antlr.QLParser;
import org.uva.sea.ql.parser.error.reporting.SyntacticErrorReporter;
import org.uva.sea.ql.parser.exception.ParseException;

public class ANTLRParser implements Parser {

    private SyntacticErrorReporter syntacticErrorReporter;

    public void setSyntacticErrorReporter(SyntacticErrorReporter syntacticErrorReporter) {
        this.syntacticErrorReporter = syntacticErrorReporter;
    }

	@Override
	public Form parse(String src) throws ParseException {
		ANTLRStringStream stream = new ANTLRStringStream(src);
		CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(new QLLexer(stream));
		QLParser parser = new QLParser(tokens);
        parser.setErrorReporter(syntacticErrorReporter);
		try {
			return parser.form();
		} catch (RecognitionException e) {
			throw new ParseException(e.getMessage());
		}
	}
}
