package org.uva.sea.ql.web.inputvalidation;

import org.uva.sea.ql.visitor.semanticanalysis.SymbolTable;

import javax.inject.Inject;

public class QuestionValidator implements QLInputValidator{

    @Inject
    private SymbolTable symbolTable;

    @Override
    public QLInputValidationResult validate(String identifierName, String value) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
