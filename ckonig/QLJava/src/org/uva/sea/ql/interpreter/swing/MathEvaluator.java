package org.uva.sea.ql.interpreter.swing;

import java.util.List;

import org.uva.sea.ql.ast.BinaryExpr;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.ReturnsMathOperands;
import org.uva.sea.ql.ast.UnaryExpr;
import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.ast.literal.IntLiteral;
import org.uva.sea.ql.ast.math.Add;
import org.uva.sea.ql.ast.math.Div;
import org.uva.sea.ql.ast.math.Mul;
import org.uva.sea.ql.ast.math.Neg;
import org.uva.sea.ql.ast.math.Pos;
import org.uva.sea.ql.ast.math.Sub;
import org.uva.sea.ql.interpreter.swing.panel.QuestionPanel;

public class MathEvaluator {
	private List<QuestionPanel> questions;
	private boolean replaceEmtyWithZero;

	public MathEvaluator(List<QuestionPanel> questions) {
		this.questions = questions;
		this.replaceEmtyWithZero = false;
	}

	public MathEvaluator(List<QuestionPanel> questions,
			boolean replaceEmptyWithZero) {
		this(questions);
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
			for (QuestionPanel q : questions) {
				if (q.getQuestion().getIdentName().equals(i.getName())) {

					if (q.getQuestion().getType() instanceof ReturnsMathOperands) {
						String val = q.getStringValue();
						if (val.trim().equals("")) {
							if (replaceEmtyWithZero) {
								return 0;
							} else {
								throw new EvaluationException(
										"waiting for input");
							}
						}
						try {
							return Float.parseFloat(q.getStringValue().replace(
									',', '.'));
						} catch (NumberFormatException ex) {
							throw new EvaluationException("invalid user input");
						}
					}
				}
			}
		}
		throw new EvaluationException("math evaluation failed");
	}
}
