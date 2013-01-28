package org.uva.sea.ql.interpreter.swing;

import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.ast.expressions.BinaryExpr;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.expressions.UnaryExpr;
import org.uva.sea.ql.ast.interfaces.ReturnsMathOperands;
import org.uva.sea.ql.ast.literal.IntLiteral;
import org.uva.sea.ql.ast.math.Add;
import org.uva.sea.ql.ast.math.Div;
import org.uva.sea.ql.ast.math.Mul;
import org.uva.sea.ql.ast.math.Neg;
import org.uva.sea.ql.ast.math.Pos;
import org.uva.sea.ql.ast.math.Sub;
import org.uva.sea.ql.interpreter.exception.EmptyInputException;
import org.uva.sea.ql.interpreter.exception.EvaluationException;


public class MathEvaluator {
	private boolean replaceEmtyWithZero;
	private SwingRegistry registry;

	public MathEvaluator(SwingRegistry registry) {
		this.registry = registry;
		this.replaceEmtyWithZero = false;
	}

	public MathEvaluator(SwingRegistry registry, boolean replaceEmptyWithZero) {
		this(registry);
		this.replaceEmtyWithZero = replaceEmptyWithZero;
	}

	public float eval(Expr e) throws EvaluationException {
		if (e instanceof UnaryExpr) {
			UnaryExpr u = (UnaryExpr) e;
			if (u instanceof Neg) {
				return eval(u.getAdjacent()) * (-1);
			}
			if (u instanceof Pos) {
				return eval(u.getAdjacent()) * (1);
			}
		}
		if (e instanceof BinaryExpr) {
			BinaryExpr b = (BinaryExpr) e;
			if (b instanceof Add) {
				return eval(b.getLeft()) + eval(b.getRight());
			}
			if (b instanceof Sub) {
				return eval(b.getLeft()) - eval(b.getRight());
			}
			if (b instanceof Mul) {
				return eval(b.getLeft()) * eval(b.getRight());
			}
			if (b instanceof Div) {
				return eval(b.getLeft()) / eval(b.getRight());
			}
		}
		if (e instanceof IntLiteral) {
			return ((IntLiteral) e).getValue();
		}
		if (e instanceof Ident) {
			Ident i = (Ident) e;
			QuestionPanel q = registry.getQuestionPanelByIdent(i);

			if (q.getQuestion().getType() instanceof ReturnsMathOperands) {
				String val = q.getStringValue();
				if (val.trim().equals("")) {
					if (replaceEmtyWithZero) {
						return 0;
					} else {
						throw new EmptyInputException();
					}
				}
				try {
					return Float.parseFloat(q.getStringValue()
							.replace(',', '.'));
				} catch (NumberFormatException ex) {
					throw new EvaluationException("invalid user input");
				}
			}

		}
		throw new EvaluationException("math evaluation failed");
	}
}
