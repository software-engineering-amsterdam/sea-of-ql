package org.uva.sea.ql.interpreter.swing;

import java.util.List;

import org.uva.sea.ql.ast.BinaryExpr;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.ReturnsBoolOperands;
import org.uva.sea.ql.ast.ReturnsMathOperands;
import org.uva.sea.ql.ast.UnaryExpr;
import org.uva.sea.ql.ast.bool.And;
import org.uva.sea.ql.ast.bool.Eq;
import org.uva.sea.ql.ast.bool.GEq;
import org.uva.sea.ql.ast.bool.GT;
import org.uva.sea.ql.ast.bool.LEq;
import org.uva.sea.ql.ast.bool.LT;
import org.uva.sea.ql.ast.bool.NEq;
import org.uva.sea.ql.ast.bool.Not;
import org.uva.sea.ql.ast.bool.Or;
import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.interpreter.swing.panel.QuestionPanel;

public class BoolEvaluator {

	private List<QuestionPanel> questions;

	public BoolEvaluator(List<QuestionPanel> questions) {
		this.questions = questions;
	}

	public boolean eval(Expr e) throws EvaluationException {
		MathEvaluator math = new MathEvaluator(questions);
		if (e instanceof UnaryExpr) {
			UnaryExpr u = (UnaryExpr) e;
			if (u instanceof Not) {
				return !eval(u.getAdjacent());
			}
		}
		if (e instanceof BinaryExpr) {
			BinaryExpr b = (BinaryExpr) e;
			if (b instanceof And) {
				return eval(b.getLeft()) && eval(b.getRight());
			}
			if (b instanceof Or) {
				return eval(b.getLeft()) || eval(b.getRight());
			}
			if (b instanceof Eq) {
				if (b.getLeft() instanceof ReturnsBoolOperands
						&& b.getRight() instanceof ReturnsBoolOperands) {
					return eval(b.getLeft()) == eval(b.getRight());
				}
				if (b.getLeft() instanceof ReturnsMathOperands
						&& b.getRight() instanceof ReturnsMathOperands) {
					return math.eval(b.getLeft()) == math.eval(b.getRight());
				}
			}
			if (b instanceof NEq) {
				if (b.getLeft() instanceof ReturnsBoolOperands
						&& b.getRight() instanceof ReturnsBoolOperands) {
					return eval(b.getLeft()) != eval(b.getRight());
				}
				if (b.getLeft() instanceof ReturnsMathOperands
						&& b.getRight() instanceof ReturnsMathOperands) {
					return math.eval(b.getLeft()) != math.eval(b.getRight());
				}
			}
			if (b instanceof LEq) {
				return math.eval(b.getLeft()) <= math.eval(b.getRight());
			}
			if (b instanceof LT) {
				return math.eval(b.getLeft()) < math.eval(b.getRight());
			}
			if (b instanceof GEq) {
				return math.eval(b.getLeft()) >= math.eval(b.getRight());
			}
			if (b instanceof GT) {
				return math.eval(b.getLeft()) > math.eval(b.getRight());
			}
		}
		if (e instanceof Ident) {
			Ident i = (Ident) e;
			for (QuestionPanel q : questions) {
				if (q.getQuestion().getIdentName().equals(i.getName())) {
					if (q.getQuestion().getType() instanceof ReturnsBoolOperands) {
						return q.getBoolValue();
					}
				}
			}
		}
		throw new EvaluationException("bool evaluation failed");
	}

}
