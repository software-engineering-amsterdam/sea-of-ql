package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.expr.Binary;
import org.uva.sea.ql.ast.form.Body;
import org.uva.sea.ql.ast.form.ComputedQuestion;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.form.Question;

public interface Visitor {
		public void visit(Binary expr);
		public void visit(Form form);
		public void visit(Body body);
		public void visit(Question question);
		public void visit(ComputedQuestion computedQuestion);
}
