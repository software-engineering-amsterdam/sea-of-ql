package org.uva.sea.ql.interpreter.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

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
import org.uva.sea.ql.ast.literal.IntLiteral;
import org.uva.sea.ql.ast.math.Add;
import org.uva.sea.ql.ast.math.Div;
import org.uva.sea.ql.ast.math.Mul;
import org.uva.sea.ql.ast.math.Neg;
import org.uva.sea.ql.ast.math.Pos;
import org.uva.sea.ql.ast.math.Sub;
import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.Money;
import org.uva.sea.ql.ast.types.StrType;
import org.uva.sea.ql.interpreter.swing.panel.IfStatementPanel;
import org.uva.sea.ql.interpreter.swing.panel.QuestionPanel;

public class Evaluator {
	private final SwingRegistry registry;
	private QuestionPanel questionPanel;

	public Evaluator(SwingRegistry registry, QuestionPanel questionPanel) {
		this.registry = registry;
		this.questionPanel = questionPanel;
		addEvaluator();
	}

	private void addEvaluator() {
		if (questionPanel.getQuestion().getType() instanceof BooleanType) {
			JCheckBox checkbox = (JCheckBox) questionPanel.getInput();
			checkbox.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					evaluateFunctions();
				}
			});
		}
		if (questionPanel.getQuestion().getType() instanceof Money
				|| questionPanel.getQuestion().getType() instanceof StrType) {
			JTextField t = (JTextField) questionPanel.getInput();
			t.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					evaluateFunctions();
				}
			});
			t.addKeyListener(new KeyListener() {

				@Override
				public void keyTyped(KeyEvent arg0) {
					evaluateFunctions();
				}

				@Override
				public void keyReleased(KeyEvent arg0) {
					evaluateFunctions();

				}

				@Override
				public void keyPressed(KeyEvent arg0) {
					evaluateFunctions();
				}
			});
		}

	}

	private void evaluateFunctions() {

		for (IfStatementPanel isp : registry.getIfStatements()) {
			try {
				isp.eval(registry);
			} catch (EvaluationException ex) {
				isp.setVisible(false);
			}
			isp.repaint();
		}
	}

	public static boolean evalBool(Expr e, List<QuestionPanel> questions)
			throws EvaluationException {
		if (e instanceof UnaryExpr) {
			UnaryExpr u = (UnaryExpr) e;
			if (u instanceof Not) {
				return !evalBool(u.getAdjacent(), questions);
			}
		}
		if (e instanceof BinaryExpr) {
			BinaryExpr b = (BinaryExpr) e;
			if (b instanceof And) {
				return evalBool(b.getLeft(), questions)
						&& evalBool(b.getRight(), questions);
			}
			if (b instanceof Or) {
				return evalBool(b.getLeft(), questions)
						|| evalBool(b.getRight(), questions);
			}
			if (b instanceof Eq) {
				if (b.getLeft() instanceof ReturnsBoolOperands
						&& b.getRight() instanceof ReturnsBoolOperands) {
					return evalBool(b.getLeft(), questions) == evalBool(
							b.getRight(), questions);
				}
				if (b.getLeft() instanceof ReturnsMathOperands
						&& b.getRight() instanceof ReturnsMathOperands) {
					return evalMath(b.getLeft(), questions) == evalMath(
							b.getRight(), questions);
				}
			}
			if (b instanceof NEq) {
				if (b.getLeft() instanceof ReturnsBoolOperands
						&& b.getRight() instanceof ReturnsBoolOperands) {
					return evalBool(b.getLeft(), questions) != evalBool(
							b.getRight(), questions);
				}
				if (b.getLeft() instanceof ReturnsMathOperands
						&& b.getRight() instanceof ReturnsMathOperands) {
					return evalMath(b.getLeft(), questions) != evalMath(
							b.getRight(), questions);
				}
			}
			if (b instanceof LEq) {
				return evalMath(b.getLeft(), questions) <= evalMath(
						b.getRight(), questions);
			}
			if (b instanceof LT) {
				return evalMath(b.getLeft(), questions) < evalMath(
						b.getRight(), questions);
			}
			if (b instanceof GEq) {
				return evalMath(b.getLeft(), questions) >= evalMath(
						b.getRight(), questions);
			}
			if (b instanceof GT) {
				return evalMath(b.getLeft(), questions) > evalMath(
						b.getRight(), questions);
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

	public static float evalMath(Expr e, List<QuestionPanel> questions)
			throws EvaluationException {
		return evalMath(e, questions, false);
	}

	public static float evalMath(Expr e, List<QuestionPanel> questions,
			boolean replaceEmtyWithZero) throws EvaluationException {
		if (e instanceof UnaryExpr) {
			UnaryExpr u = (UnaryExpr) e;
			if (u instanceof Neg) {
				return evalMath(u.getAdjacent(), questions, replaceEmtyWithZero) * (-1);
			}
			if (u instanceof Pos) {
				return evalMath(u.getAdjacent(), questions, replaceEmtyWithZero) * (1);
			}
		}
		if (e instanceof BinaryExpr) {
			BinaryExpr b = (BinaryExpr) e;
			if (b instanceof Add) {
				return evalMath(b.getLeft(), questions)
						+ evalMath(b.getRight(), questions, replaceEmtyWithZero);
			}
			if (b instanceof Sub) {
				return evalMath(b.getLeft(), questions)
						- evalMath(b.getRight(), questions, replaceEmtyWithZero);
			}
			if (b instanceof Mul) {
				return evalMath(b.getLeft(), questions)
						* evalMath(b.getRight(), questions, replaceEmtyWithZero);
			}
			if (b instanceof Div) {
				return evalMath(b.getLeft(), questions)
						/ evalMath(b.getRight(), questions, replaceEmtyWithZero);
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
