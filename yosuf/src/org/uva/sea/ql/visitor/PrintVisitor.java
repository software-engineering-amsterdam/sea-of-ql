package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.CompoundStatement;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.exp.Expression;
import org.uva.sea.ql.util.LogPrinter;

public class PrintVisitor implements ASTNodeVisitor {

	@Override
	public void visit(final Form form) {
		LogPrinter.debugInfo(form);
	}

	@Override
	public void visi(final Expression expression) {

	}

	@Override
	public void visit(final CompoundStatement compoundStatement) {

	}

}
