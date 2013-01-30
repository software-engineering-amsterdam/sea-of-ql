package org.uva.sea.ql.formLoader;

import org.uva.sea.ql.Message;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.Parser;
import org.uva.sea.ql.semanticAnalyzer.SemanticAnalyzerVisitor;

import java.util.Iterator;
import java.util.List;

public class FormLoaderImpl implements FormLoader {

    private final FormSource formSource;
    private final Parser formParser;

    public FormLoaderImpl(FormSource formSource, Parser formParser) {
        this.formSource = formSource;
        this.formParser = formParser;
    }

    @Override
    public Form loadForm() {
        try {
            Form form = formParser.parse(formSource.loadFormData());
            List<Message> errors = SemanticAnalyzerVisitor.analyze(form);
            if(errors.isEmpty())
                return form;
            else
                throw buildSemanticAnalysisErrorlistException(errors);
        } catch(ParseError parseError) {
            throw new FormLoaderException(parseError);
        }
    }

    private FormLoaderException buildSemanticAnalysisErrorlistException(Iterable<Message> errors) {
        StringBuilder exceptionStringBuilder = new StringBuilder("The following errors occurred during the semantic analysis of the form:\n");

        for(Iterator<Message> iterator = errors.iterator(); iterator.hasNext(); ) {
            exceptionStringBuilder
                    .append(" - ")
                    .append(iterator.next().toString());
            if(iterator.hasNext())
                exceptionStringBuilder.append("\n");
        }

        return new FormLoaderException(exceptionStringBuilder.toString());
    }
}
