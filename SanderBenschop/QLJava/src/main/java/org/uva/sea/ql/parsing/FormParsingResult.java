package org.uva.sea.ql.parsing;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.parsing.error.SyntacticQLError;

import java.util.List;

public class FormParsingResult {

    private final Form form;
    private final List<SyntacticQLError> syntacticQLErrors;

    public FormParsingResult(Form form, List<SyntacticQLError> syntacticQLErrors) {
        this.form = form;
        this.syntacticQLErrors = syntacticQLErrors;
    }

    public Form getForm() {
        return form;
    }

    public List<SyntacticQLError> getErrors() {
        return syntacticQLErrors;
    }

    public boolean hasErrors() {
        return (!syntacticQLErrors.isEmpty());
    }
}
