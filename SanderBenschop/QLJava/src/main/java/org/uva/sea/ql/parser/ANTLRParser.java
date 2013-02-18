package org.uva.sea.ql.parser;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.apache.commons.io.FileUtils;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.parser.antlr.QLLexer;
import org.uva.sea.ql.parser.antlr.QLParser;
import org.uva.sea.ql.parser.error.SyntacticQLError;
import org.uva.sea.ql.parser.error.reporting.SyntacticErrorReporter;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ANTLRParser implements Parser {

    private final SyntacticErrorReporter syntacticErrorReporter;

    public ANTLRParser(SyntacticErrorReporter syntacticErrorReporter) {
        this.syntacticErrorReporter = syntacticErrorReporter;
    }

    @Override
    public Form parse(File file) throws IOException {
        return parse(FileUtils.readFileToString(file));
    }

    @Override
    public Form parse(String src) {
        syntacticErrorReporter.clearErrors();
        try {
            ANTLRStringStream stream = new ANTLRStringStream(src);
            CommonTokenStream tokens = new CommonTokenStream();
            tokens.setTokenSource(new QLLexer(stream));
            QLParser parser = new QLParser(tokens);
            parser.setErrorReporter(syntacticErrorReporter);
            return parser.form();
        } catch (RecognitionException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public boolean hasErrors() {
        return syntacticErrorReporter.hasErrors();
    }

    @Override
    public List<SyntacticQLError> getErrors() {
        return syntacticErrorReporter.getErrors();
    }
}
