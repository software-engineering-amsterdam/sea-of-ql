package org.uva.sea.ql.startup;

import org.uva.sea.ql.general.SymbolTable;

public class IncorrectWebApp implements WebApp {

    @Override
    public boolean isCorrect() {
        return false;
    }

    @Override
    public String getGeneratedQLCode() {
        throw new UnsupportedOperationException("QL program could not be correctly created from source code.");
    }

    @Override
    public SymbolTable getSymbolTable() {
        throw new UnsupportedOperationException("QL program could not be correctly created from source code.");
    }
}
