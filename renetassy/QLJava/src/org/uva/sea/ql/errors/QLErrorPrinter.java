package org.uva.sea.ql.errors;

public class QLErrorPrinter implements IQLErrorVisitor {

	@Override
	public void visit(ExprError error) {
		System.out.println("The operands of \""+ error.getOperator() +"\" are not compatible");
	}

	@Override
	public void visit(StmntError error) {
		
	}

}
