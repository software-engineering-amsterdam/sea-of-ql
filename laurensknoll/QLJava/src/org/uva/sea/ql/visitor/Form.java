package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.form.Question;

public interface Form<T> {

	public T visit(Question questionForm);

}
