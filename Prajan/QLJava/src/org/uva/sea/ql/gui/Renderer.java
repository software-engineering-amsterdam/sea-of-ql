package org.uva.sea.ql.gui;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.uva.sea.ql.ast.form.Calculation;
import org.uva.sea.ql.ast.form.Declaration;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.form.IfConditionalExpr;
import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.visitor.FormElementVisitor;

public class Renderer implements FormElementVisitor<Boolean> {

	private final JPanel panel;
	private final State state;

	public static JPanel render(Form form, State state) {

		Renderer r = new Renderer(state);
		form.accept(r);
		return r.getPanel();
	}

	public JPanel getPanel() {
		return panel;
	}

	private Renderer(State state) {
		this.state = state;
		this.panel = new JPanel();
		GridLayout layout = new GridLayout(0, 1);
		this.panel.setLayout(layout);

	}

	private void addLabel(String text) {

		JLabel label = new JLabel(text);
		panel.add(label);

	}

	@Override
	public Boolean visit(Form form) {
		// TODO Auto-generated method stub

		for (Question question : form.getQuestion()) {
			question.accept(this);
		}

		for (IfConditionalExpr ifExpr : form.getIfconditionalexpr()) {
			ifExpr.accept(this);
		}

		return null;
	}

	@Override
	public Boolean visit(Question question) {

		for (Declaration declaration : question.getDeclaration()) {
			declaration.accept(this);
		}

		for (Calculation calculation : question.getCalculation()) {
			calculation.accept(this);
		}

		addLabel(question.getQuestionText());
		return null;
	}

	@Override
	public Boolean visit(Calculation calculation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(IfConditionalExpr ifconditionalexpr) {

		for (Question thenQuestion : ifconditionalexpr.getThenStatements()) {
			thenQuestion.accept(this);
		}

		for (Question elseQuestion : ifconditionalexpr.getElseStatements()) {
			elseQuestion.accept(this);
		}

		return null;
	}

	@Override
	public Boolean visit(Declaration declaration) {
		// TODO Auto-generated method stub
		return null;
	}

}
