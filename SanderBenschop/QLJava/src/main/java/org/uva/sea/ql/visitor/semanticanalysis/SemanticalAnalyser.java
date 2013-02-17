package org.uva.sea.ql.visitor.semanticanalysis;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.visitor.semanticanalysis.error.SemanticQLError;

import java.util.List;

public interface SemanticalAnalyser {

    List<SemanticQLError> semanticallyValidateForm(Form form);
}
