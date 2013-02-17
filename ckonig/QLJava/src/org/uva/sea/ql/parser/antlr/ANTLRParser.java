package org.uva.sea.ql.parser.antlr;

import java.io.IOException;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.uva.sea.ql.ast.elements.Form;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.ParseError;

public class ANTLRParser implements IParse {
    public ANTLRParser() {

    }

    private static final String DEFAULT_FILENAME = "example.ql";

    @Override
    public final Form parseForm(String src) throws ParseError {
        return parse(new ANTLRStringStream(src));
    }

    @Override
    public final Form parseDefaultFile() throws ParseError {
        return parseFile(DEFAULT_FILENAME);
    }

    @Override
    public final Expr parseExpression(String src) throws ParseError {
        final QLParser parser = getParser(new ANTLRStringStream(src));
        try {
            return parser.orExpr();
        } catch (RecognitionException e) {
            throw new ParseError(e.getMessage());
        }
    }

    private Form parseFile(String filename) throws ParseError {
        try {
            return parse(new ANTLRFileStream(filename));
        } catch (IOException ex) {
            throw new ParseError("File not found");
        }
    }

    private Form parse(CharStream stream) throws ParseError {
        final QLParser parser = getParser(stream);
        try {
            return parser.parse();
        } catch (RecognitionException e) {
            throw new ParseError(e.getMessage());
        }
    }

    private QLParser getParser(CharStream stream) {
        final CommonTokenStream tokens = new CommonTokenStream();
        tokens.setTokenSource(new QLLexer(stream));
        return new QLParser(tokens);
    }
}
