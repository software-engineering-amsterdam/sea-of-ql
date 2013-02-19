package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.form.Body;
import org.uva.sea.ql.ast.form.ComputedQuestion;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.form.IfThen;
import org.uva.sea.ql.ast.form.IfThenElse;
import org.uva.sea.ql.ast.form.Question;



public interface IElementVisitor {
	
		 public void visit(Form qlElement);
		 public void visit(Body qlElement);
		 public void visit(Question qlElement);
		 public void visit(ComputedQuestion qlElement);
		 public void visit(IfThenElse qlElement);
		 public void visit(IfThen qlElement);

}
