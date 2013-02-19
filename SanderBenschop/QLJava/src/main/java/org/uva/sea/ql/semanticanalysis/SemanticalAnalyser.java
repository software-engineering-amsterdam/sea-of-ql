package org.uva.sea.ql.semanticanalysis;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.semanticanalysis.error.SemanticQLError;

import java.util.List;

public interface SemanticalAnalyser {

    List<SemanticQLError> semanticallyValidateForm(Form form);

    SymbolTable getSymbolTable();
}
