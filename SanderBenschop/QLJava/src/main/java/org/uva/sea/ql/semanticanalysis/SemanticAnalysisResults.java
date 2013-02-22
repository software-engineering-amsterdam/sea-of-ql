package org.uva.sea.ql.semanticanalysis;

import org.uva.sea.ql.general.SymbolTable;
import org.uva.sea.ql.semanticanalysis.error.SemanticQLError;

import java.util.List;

public class SemanticAnalysisResults {

    private final SymbolTable symbolTable;
    private final List<SemanticQLError> semanticQLErrorList;

    public SemanticAnalysisResults(SymbolTable symbolTable, List<SemanticQLError> semanticQLErrorList) {
        this.symbolTable = symbolTable;
        this.semanticQLErrorList = semanticQLErrorList;
    }

    public SymbolTable getSymbolTable() {
        return symbolTable;
    }

    public List<SemanticQLError> getErrors() {
        return semanticQLErrorList;
    }

    public boolean hasErrors() {
        return (!semanticQLErrorList.isEmpty());
    }
}
