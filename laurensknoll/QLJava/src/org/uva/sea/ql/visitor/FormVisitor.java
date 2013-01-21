package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.form.QuestionForm;

public interface FormVisitor<T> {

	public T visit(QuestionForm questionForm);

}
