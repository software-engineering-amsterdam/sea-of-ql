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

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class ValidationVisitor implements ASTVisitor {
	private Registry registry;

	public ValidationVisitor() {
		registry = new Registry();
	}

	@Override
	public void visit(Form form) throws VisitorException {
		if (form.getName() != null && form.getBlock() != null) {
			form.getBlock().accept(this);
		} else {
			if (form.getName() == null) {
				throw new AstValidationError("form name may not be null");
			}
			if (form.getBlock() == null) {
				throw new AstValidationError("form block may not be null");
			}
		}

	}

	@Override
	public void visit(Block block) throws VisitorException {
		if (block.getClass() != null) {
			for (Expr l : block.getContent()) {
				if (l != null) {
					if (l.getClass().equals(IfStatement.class)
							|| l.getClass().equals(Question.class)) {
						if (l.getClass().equals(IfStatement.class)) {
							IfStatement i = (IfStatement) l;
							i.accept(this);
						}
						if (l.getClass().equals(Question.class)) {
							Question q = (Question) l;
							q.accept(this);
						}
					} else {
						throw new AstValidationError(
								"block line must be IF or question");
					}
				} else {
					throw new AstValidationError("block line must not be null");
				}
			}
		} else {
			throw new AstValidationError("block content may not be null");
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
			if (q.getIdent().getName().equals(question.getIdent().getName())) {
				throw new AstValidationError("duplicate question Identifier:"
						+ question.getIdent().getName());
			}
		}
		registry.addQuestion(question);

	}

	@Override
	public void visit(IfStatement ifStatement) throws VisitorException {
		if (ifStatement.getCondition() != null
				&& ifStatement.getContent() != null) {

			if (ifStatement.getCondition() instanceof ReturnsBoolOperands) {
				if (ifStatement.getCondition() instanceof AcceptsBoolOperands) {
					AcceptsBoolOperands r = (AcceptsBoolOperands) ifStatement
							.getCondition();
					r.accept(this);
				}
				if (ifStatement.getCondition() instanceof AcceptsMathOperands) {
					AcceptsMathOperands r = (AcceptsMathOperands) ifStatement
							.getCondition();
					r.accept(this);
				}
				if (ifStatement.getCondition() instanceof AcceptsBothOperands) {
					AcceptsBothOperands r = (AcceptsBothOperands) ifStatement
							.getCondition();
					r.accept(this);
				}
			} else {
				throw new AstValidationError("not a valid condition: "
						+ ifStatement.getCondition().getClass().toString());
			}

			ifStatement.getContent().accept(this);
		} else {
			throw new AstValidationError(
					"if condition and content may not be null");
		}

	}

	@Override
	public void visit(Ident ident) {
		throw new NotImplementedException();
	}

	@Override
	public void visit(Registry registry) {
		throw new NotImplementedException();
	}

	@Override
	public void visit(AcceptsBoolOperands r) throws VisitorException {
		if (r instanceof BinaryExpr) {
			BinaryExpr b = (BinaryExpr) r;
			Expr left = getLeft(b);
			Expr right = getRight(b);
			if (left instanceof ReturnsBoolOperands
					&& right instanceof ReturnsBoolOperands) {

			} else {
				throw new AstValidationError("both childs of " + b.getClass()
						+ " must be bool");
			}
		}

	}

	@Override
	public void visit(AcceptsMathOperands r) throws VisitorException {
		if (r instanceof BinaryExpr) {
			BinaryExpr b = (BinaryExpr) r;
			Expr left = getLeft(b);
			Expr right = getRight(b);
			if (left instanceof ReturnsMathOperands
					&& right instanceof ReturnsMathOperands) {

			} else {
				throw new AstValidationError("both childs of " + b.getClass()
						+ " must be math");
			}
		}

	}

	@Override
	public void visit(AcceptsBothOperands r) throws VisitorException {
		if (r instanceof BinaryExpr) {

			BinaryExpr b = (BinaryExpr) r;
			Expr left = getLeft(b);
			Expr right = getRight(b);
			if ((left instanceof ReturnsMathOperands && right instanceof ReturnsMathOperands)
					|| (left instanceof ReturnsBoolOperands && right instanceof ReturnsBoolOperands)) {

			} else {
				throw new AstValidationError("BOTH childs of " + b.getClass()
						+ " must be math OR bool");
			}
		}
	}

	private Expr getIdentType(Expr ident) throws AstValidationError {
		Ident i = (Ident) ident;
		for (Question q : registry.getQuestions()) {
			if (q.getIdent().getName().equals(i.getName())) {
				return q.getType();
			}
		}
		throw new AstValidationError("Ident not found:" + i.getName());
	}

	private Expr getLeft(BinaryExpr b) throws VisitorException {
		Expr left = b.getLeft();
		if (left instanceof Ident) {
			left = getIdentType(left);
		}
		acceptOperands(left);
		return left;
	}

	private Expr getRight(BinaryExpr b) throws VisitorException {
		Expr right = b.getRight();

		if (right instanceof Ident) {
			right = getIdentType(right);
		}
		acceptOperands(right);
		return right;
	}

	private void acceptOperands(Expr e) throws VisitorException {
		if (e instanceof AcceptsMathOperands) {
			((AcceptsMathOperands) e).accept(this);
		}
		if (e instanceof AcceptsBoolOperands) {
			((AcceptsBoolOperands) e).accept(this);
		}
		if (e instanceof AcceptsBothOperands) {
			((AcceptsBothOperands) e).accept(this);
		}
	}

}
