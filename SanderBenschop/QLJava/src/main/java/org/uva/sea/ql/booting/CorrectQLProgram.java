package org.uva.sea.ql.booting;

import org.uva.sea.ql.general.SymbolTable;

public class CorrectQLProgram implements QLProgram {

    private final String code;
    private final SymbolTable symbolTable;

    public CorrectQLProgram(String code, SymbolTable symbolTable) {
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
