package org.uva.sea.ql.validation;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.bool.BinaryBoolOperator;
import org.uva.sea.ql.ast.bool.BoolOperand;
import org.uva.sea.ql.ast.elements.Block;
import org.uva.sea.ql.ast.elements.Form;
import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.ast.elements.IfStatement;
import org.uva.sea.ql.ast.elements.Question;
import org.uva.sea.ql.ast.math.BinaryMathOperator;
import org.uva.sea.ql.ast.math.MathOperand;
import org.uva.sea.ql.ast.types.Bool;
import org.uva.sea.ql.visitor.ASTVisitor;
import org.uva.sea.ql.visitor.Registry;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class ValidationVisitor implements ASTVisitor {
	private Registry registry;

	public ValidationVisitor() {
		registry = new Registry();
	}

	@Override
	public void visit(Form form) {
		try {
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
		} catch (AstValidationError ex) {
			System.out.println("Validation error: " + ex.getMessage());
		}
	}

	@Override
	public void visit(Block block) {
		try {
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
						throw new AstValidationError(
								"block line must not be null");
					}
				}
			} else {
				throw new AstValidationError("block content may not be null");
			}
		} catch (AstValidationError ex) {
			System.out.println("Validation error: " + ex.getMessage());
		}
	}

	@Override
	public void visit(Question question) {
		try {
			if (question.getIdent() == null)
				throw new AstValidationError("question ident may not be null");
			if (question.getContent() == null)
				throw new AstValidationError("question content may not be null");
			if (question.getType() == null)
				throw new AstValidationError("question type may not be null");
			for (Question q : registry.getQuestions()) {
				if (q.getIdent().getName()
						.equals(question.getIdent().getName())) {
					throw new AstValidationError(
							"duplicate question Identifier:"
									+ question.getIdent().getName());
				}
			}
			registry.addQuestion(question);
		} catch (AstValidationError ex) {
			System.out.println("Validation error: " + ex.getMessage());
		}
	}

	@Override
	public void visit(IfStatement ifStatement) {
		try {
			if (ifStatement.getCondition() != null
					&& ifStatement.getContent() != null) {
				if (ifStatement.getCondition().getClass().equals(Ident.class)) {
					Ident i = (Ident) ifStatement.getCondition();
					for (Question q : registry.getQuestions()) {
						if (q.getIdent().getName().equals(i.getName())) {
							if (q.getType().getClass().equals(Bool.class)) {

							} else {
								throw new AstValidationError(
										"not a valid condition: "
												+ q.getType().getClass()
														.toString());
							}
						}
					}
				} else {

					if (ifStatement.getCondition() instanceof BinaryBoolOperator) {
						BinaryBoolOperator op = (BinaryBoolOperator) ifStatement
								.getCondition();
						op.accept(this);
					}
					if (ifStatement.getCondition() instanceof BinaryMathOperator) {
						BinaryMathOperator op = (BinaryMathOperator) ifStatement
								.getCondition();
						op.accept(this);
					}
					System.out.println("valid condition:"
							+ ifStatement.getCondition().toString());
				}

				ifStatement.getContent().accept(this);
			} else {
				throw new AstValidationError(
						"if condition and content may not be null");
			}
		} catch (AstValidationError ex) {
			System.out.println("Validation error: " + ex.getMessage());
		}
	}

	@Override
	public void visit(Ident ident) {
		throw new NotImplementedException();
	}

	@Override
	public void visit(BinaryBoolOperator op) {
		try {
			if (op.getLeft() instanceof BoolOperand
					&& op.getRight() instanceof BoolOperand) {
				if (op.getLeft() instanceof Ident) {
					Ident i = (Ident) op.getLeft();
					validateBool(i);
				}
				if (op.getRight() instanceof Ident) {
					Ident i = (Ident) op.getRight();
					validateBool(i);
				}
			} else {
				throw new AstValidationError("both operands must be bool"
						+ op.getLeft().toString() + " - "
						+ op.getRight().toString());
			}
		} catch (AstValidationError ex) {
			System.out.println("Validation error: " + ex.getMessage());
		}

	}

	@Override
	public void visit(BinaryMathOperator op) {
		try {
			if (op.getLeft() instanceof MathOperand
					&& op.getRight() instanceof MathOperand) {
				if (op.getLeft() instanceof Ident) {
					Ident i = (Ident) op.getLeft();
					validateMath(i);
				}
				if (op.getRight() instanceof Ident) {
					Ident i = (Ident) op.getRight();
					validateMath(i);
				}
			} else {
				throw new AstValidationError("both operands must be math : "
						+ op.getLeft().toString() + " - "
						+ op.getRight().toString());
			}
		} catch (AstValidationError ex) {
			System.out.println("Validation error: " + ex.getMessage());
		}
	}

	private void validateMath(Ident i) throws AstValidationError {
		for (Question q : registry.getQuestions()) {
			if (q.getIdent().getName().equals(i.getName())) {
				if (q.getType() instanceof MathOperand) {

				} else {
					throw new AstValidationError(
							"ident operands must be bool: " + i.getName());
				}
			}
		}
	}

	private void validateBool(Ident i) throws AstValidationError {
		for (Question q : registry.getQuestions()) {
			if (q.getIdent().getName().equals(i.getName())) {
				if (q.getType() instanceof BoolOperand) {

				} else {
					throw new AstValidationError(
							"ident operands must be math: " + i.getName());
				}
			}
		}
	}

	@Override
	public void visit(Registry registry) {
		throw new NotImplementedException();
	}

}
