package org.uva.sea.ql.validation;

import org.uva.sea.ql.ast.AcceptsBoolOperands;
import org.uva.sea.ql.ast.AcceptsBothOperands;
import org.uva.sea.ql.ast.AcceptsMathOperands;
import org.uva.sea.ql.ast.BinaryExpr;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.ReturnsBoolOperands;
import org.uva.sea.ql.ast.ReturnsMathOperands;
import org.uva.sea.ql.ast.elements.Block;
import org.uva.sea.ql.ast.elements.Form;
import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.ast.elements.IfStatement;
import org.uva.sea.ql.ast.elements.Question;
import org.uva.sea.ql.visitor.ASTVisitor;
import org.uva.sea.ql.visitor.Registry;
import org.uva.sea.ql.visitor.VisitorException;

public class ValidationVisitor implements ASTVisitor {
	private Registry registry;

	public ValidationVisitor() {
		registry = new Registry();
	}

	@Override
	public void visit(Form form) throws VisitorException {
		if (form.getName() == null) {
			throw new AstValidationError("form name may not be null");
		}
		if (form.getBlock() == null) {
			throw new AstValidationError("form block may not be null");
		}
		form.getBlock().accept(this);
	}

	@Override
	public void visit(Block block) throws VisitorException {
		if (block.getContent() == null) {
			throw new AstValidationError("block content may not be null");
		}
		for (Expr expr : block.getContent()) {
			if (expr == null) {
				throw new AstValidationError("block line must not be null");
			}
			if (!(expr.getClass().equals(IfStatement.class) || expr.getClass()
					.equals(Question.class))) {
				throw new AstValidationError(
						"block line must be IF or question");
			}
			if (expr.getClass().equals(IfStatement.class)) {
				((IfStatement) expr).accept(this);
			}
			if (expr.getClass().equals(Question.class)) {
				((Question) expr).accept(this);
			}
		}
	}

	@Override
	public void visit(Question question) throws VisitorException {
		if (question.getIdent() == null)
			throw new AstValidationError("question ident may not be null");
		if (question.getContent() == null)
			throw new AstValidationError("question content may not be null");
		if (question.getType() == null)
			throw new AstValidationError("question type may not be null");
		for (Question q : registry.getQuestions()) {
			if (q.getIdentName().equals(question.getIdentName())) {
				throw new AstValidationError("duplicate question Identifier:"
						+ question.getIdentName());
			}
		}
		registry.addQuestion(question);

	}

	@Override
	public void visit(IfStatement ifStatement) throws VisitorException {
		if (ifStatement.getCondition() == null
				|| ifStatement.getContent() == null) {
			throw new AstValidationError(
					"if condition and content may not be null");
		}

		if (ifStatement.getCondition() instanceof ReturnsBoolOperands) {
			if (ifStatement.getCondition() instanceof AcceptsBoolOperands) {
				this.visit((AcceptsBoolOperands) ifStatement.getCondition());
			}
			if (ifStatement.getCondition() instanceof AcceptsMathOperands) {
				this.visit((AcceptsMathOperands) ifStatement.getCondition());
			}
			if (ifStatement.getCondition() instanceof AcceptsBothOperands) {
				this.visit((AcceptsBothOperands) ifStatement.getCondition());
			}
		} else {
			throw new AstValidationError("not a valid condition: "
					+ ifStatement.getCondition().getClass().toString());
		}

		ifStatement.getContent().accept(this);

	}

	private Expr getLeftIdentTypeOrLeft(BinaryExpr b) throws VisitorException {
		Expr left = b.getLeft();
		if (left instanceof Ident) {
			left = registry.getQuestionByIdent((Ident)left);
		}
		visitOperands(left);
		return left;
	}

	private Expr getRightIdentTypeOrRight(BinaryExpr b) throws VisitorException {
		Expr right = b.getRight();

		if (right instanceof Ident) {
			right = registry.getQuestionByIdent((Ident)right);
		}
		visitOperands(right);
		return right;
	}

	private void visitOperands(Expr e) throws VisitorException {
		if (e instanceof AcceptsMathOperands) {
			this.visit((AcceptsMathOperands) e);
		}
		if (e instanceof AcceptsBoolOperands) {
			this.visit((AcceptsBoolOperands) e);
		}
		if (e instanceof AcceptsBothOperands) {
			this.visit((AcceptsBothOperands) e);
		}
	}

	private void visit(AcceptsBoolOperands r) throws VisitorException {
		if (r instanceof BinaryExpr) {
			BinaryExpr b = (BinaryExpr) r;
			Expr left = getLeftIdentTypeOrLeft(b);
			Expr right = getRightIdentTypeOrRight(b);
			if (!(left instanceof ReturnsBoolOperands && right instanceof ReturnsBoolOperands)) {
				throw new AstValidationError("both childs of " + b.getClass()
						+ " must be bool");
			}
		}

	}

	private void visit(AcceptsMathOperands r) throws VisitorException {
		if (r instanceof BinaryExpr) {
			BinaryExpr b = (BinaryExpr) r;
			Expr left = getLeftIdentTypeOrLeft(b);
			Expr right = getRightIdentTypeOrRight(b);
			if (!(left instanceof ReturnsMathOperands && right instanceof ReturnsMathOperands)) {
				throw new AstValidationError("both childs of " + b.getClass()
						+ " must return math operands!");
			}
		}

	}

	private void visit(AcceptsBothOperands r) throws VisitorException {
		if (r instanceof BinaryExpr) {

			BinaryExpr b = (BinaryExpr) r;
			Expr left = getLeftIdentTypeOrLeft(b);
			Expr right = getRightIdentTypeOrRight(b);
			if (!((left instanceof ReturnsMathOperands && right instanceof ReturnsMathOperands) || (left instanceof ReturnsBoolOperands && right instanceof ReturnsBoolOperands))) {
				throw new AstValidationError("BOTH childs of " + b.getClass()
						+ " must return either math OR bool operands");
			}
		}
	}
}
