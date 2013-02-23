package org.uva.sea.ql.startup;

import org.uva.sea.ql.general.SymbolTable;

public class CorrectWebApp implements WebApp {

    private final String code;
    private final SymbolTable symbolTable;

    public CorrectWebApp(String code, SymbolTable symbolTable) {
        this.code = code;
        this.symbolTable = symbolTable;
    }

    @Override
    public boolean isCorrect() {
        return true;
    }

    @Override
    public String getGeneratedQLCode() {
        return code;
    }

    @Override
    public SymbolTable getSymbolTable() {
        return symbolTable;
    }
}
