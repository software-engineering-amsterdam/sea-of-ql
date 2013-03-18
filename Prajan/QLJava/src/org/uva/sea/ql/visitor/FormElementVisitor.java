package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.form.Statements;
import org.uva.sea.ql.ast.form.Calculation;
import org.uva.sea.ql.ast.form.Declaration;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.form.IfConditionalExpr;
import org.uva.sea.ql.ast.form.Question;

public interface FormElementVisitor<T> {

	public T visit(Form form);

	public T visit(Statements allquestion);

	public T visit(Question question);

	public T visit(Declaration declaration);

	public T visit(Calculation calculation);

	public T visit(IfConditionalExpr ifconditionalexpr);

}
