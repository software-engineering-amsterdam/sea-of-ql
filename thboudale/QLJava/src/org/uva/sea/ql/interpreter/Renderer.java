package org.uva.sea.ql.interpreter;

import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.statements.BlockOfStatements;
import org.uva.sea.ql.ast.statements.ComputedQuestion;
import org.uva.sea.ql.ast.statements.Question;
import org.uva.sea.ql.ast.statements.ifElseStatement;
import org.uva.sea.ql.ast.statements.ifStatement;
import org.uva.sea.ql.visitor.IFormStmtVisitor;

public class Renderer implements IFormStmtVisitor<Void> {

	@Override
	public Void visit(Question stmt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(ComputedQuestion stmt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(ifStatement stmt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(ifElseStatement stmt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(BlockOfStatements stmt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(Form frm) {
		// TODO Auto-generated method stub
		return null;
	}
}