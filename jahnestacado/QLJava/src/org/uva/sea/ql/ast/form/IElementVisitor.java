package org.uva.sea.ql.ast.form;




public interface IElementVisitor {
	
		 public void visit(Form qlElement);
		 public void visit(Body qlElement);
		 public void visit(Question qlElement);
		 public void visit(ComputedQuestion qlElement);
		 public void visit(IfThenElse qlElement);
		 public void visit(IfThen qlElement);

}
