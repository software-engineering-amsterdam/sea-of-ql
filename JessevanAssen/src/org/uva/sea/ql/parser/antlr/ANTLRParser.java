package org.uva.sea.ql.parser.antlr;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.Parser;

public class ANTLRParser implements Parser {

	@Override
	public Form parse(String src) throws ParseError {
        SimpleErrorReporter errorReporter = new SimpleErrorReporter();
		ANTLRStringStream stream = new ANTLRStringStream(src);
		CommonTokenStream tokens = new CommonTokenStream();
        QLLexer lexer = new QLLexer(stream);
        lexer.setErrorReporter(errorReporter);
		tokens.setTokenSource(lexer);
		QLParser parser = new QLParser(tokens);
        parser.setErrorReporter(errorReporter);
		try {
			Form form = parser.form();
            if(!errorReporter.hasErrors())
                return form;
            else {
                StringBuilder errorListBuilder = new StringBuilder();
                for(String error : errorReporter)
                    errorListBuilder
                            .append(" - ")
                            .append(error)
                            .append(System.lineSeparator());
                throw new ParseError(errorListBuilder.toString());
            }
		} catch (RecognitionException e) {
			throw new ParseError(e.getMessage());
        }
	}

}
