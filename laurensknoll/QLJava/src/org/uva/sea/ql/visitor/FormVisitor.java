package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.form.QuestionForm;

public interface FormVisitor {

	public VisitorResult visit(QuestionForm questionForm);

}
