package org.uva.sea.ql.semanticanalysis;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.general.symboltable.SymbolTable;
import org.uva.sea.ql.semanticanalysis.error.SemanticQLError;

import java.util.List;

public interface SemanticalAnalyser {

    List<SemanticQLError> semanticallyValidateForm(Form form);
}
