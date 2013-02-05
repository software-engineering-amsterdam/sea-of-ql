package org.uva.sea.ql.errors;

public interface IQLErrorVisitor {
	
	public void visit(ExprError error);
	
	public void visit(StmntError error);

}
