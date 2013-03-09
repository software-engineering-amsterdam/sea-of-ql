package org.uva.sea.ql.validation;

import org.uva.sea.ql.Questionnaire;
import org.uva.sea.ql.visitor.VisitingException;

public interface IQuestionnaireTypeChecker {
	public boolean checkTypes(Questionnaire form) throws VisitingException, TypeCheckerDoesNotSupportQuestionnaireException;
}
