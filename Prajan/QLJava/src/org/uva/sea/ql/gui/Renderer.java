package org.uva.sea.ql.gui;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.form.Calculation;
import org.uva.sea.ql.ast.form.Declaration;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.form.IfConditionalExpr;
import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.ast.form.Statements;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.observer.ComputedObserver;
import org.uva.sea.ql.observer.ConditionObserver;
import org.uva.sea.ql.observer.Control;
import org.uva.sea.ql.visitor.FormElementVisitor;
import org.uva.sea.ql.visitor.TypeToWidget;

public class Renderer implements FormElementVisitor<Boolean> {

	private JPanel panel;
	public final State state;
	private final GridLayout layoutMain;
	private final GridLayout layoutQuesiton;
	private final Map<Ident, Type> typeEnv;

	// form visitor used to get the form elements
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
		this.typeEnv = new HashMap<Ident, Type>();
		this.layoutMain = new GridLayout(0, 1);
		this.layoutQuesiton = new GridLayout(0, 2);
		this.panel.setLayout(layoutMain);
	}

	@Override
	public Boolean visit(Form form) {
		this.panel = render(form.getStatements());
		return null;
	}

	@Override
	public Boolean visit(Calculation calculation) {
		return null;
	}

	@Override
	public Boolean visit(IfConditionalExpr ifconditionalexpr) {
		renderConditionalExpr(ifconditionalexpr);
		return null;
	}

	@Override
	public Boolean visit(Statements allquestion) {
		return null;
	}

	public JPanel render(Statements allQuestion) {
		JPanel renderPanel = new JPanel();
		renderPanel.setLayout(layoutMain);
		renderPanel.add(renderQuestions(allQuestion.getQuestion()));
		for (IfConditionalExpr ifCond : allQuestion.getIfconditionalexpr()) {
			JPanel condPanel = renderConditionalExpr(ifCond);
			renderPanel.add(condPanel);
		}
		return renderPanel;
	}

	private JPanel renderConditionalExpr(IfConditionalExpr cond) {
		JPanel condPanel = new JPanel();
		condPanel.setLayout(layoutMain);
		JPanel ifCond = render(cond.getStatements());
		JPanel elseCond = renderQuestions(cond.getElseStatements());
		ConditionObserver conditionObserver = new ConditionObserver(ifCond, elseCond, this.state, cond);
		cond.addObserver(conditionObserver);
		condPanel.add(ifCond);
		condPanel.add(elseCond);
		return condPanel;
	}

	private JPanel renderQuestions(List<Question> questions) {
		JPanel panelQuestions = new JPanel();
		panelQuestions.setLayout(layoutMain);
		List<Calculation> calculations = new ArrayList<Calculation>();
		for (Question question : questions) {
			if (!question.isDeclaration())
				calculations.add(question.getCalculation());
		}
		for (Question question : questions) {
			panelQuestions.add(renderQuestion(question, calculations));
		}
		return panelQuestions;
	}

	private JPanel renderQuestion(Question question, List<Calculation> calculations) {

		JPanel questionPanel = new JPanel();
		questionPanel.setLayout(layoutQuesiton);
		addLabel(questionPanel, question.getQuestionText());

		Type type;
		Ident ident;
		if (question.isDeclaration()) {
			type = question.getDeclaration().getIdenttype();
			ident = question.getDeclaration().getIdent();
		} else {
			type = question.getCalculation().getOrexpr().typeOf(typeEnv);
			ident = question.getCalculation().getIdent();
		}

		TypeToWidget typeToWidget = new TypeToWidget(this.state, ident);
		Control control = type.accept(typeToWidget);

		if (!question.isDeclaration()) {
			for (Calculation c : calculations) {
				ComputedObserver co = new ComputedObserver(control, this.state, c);
				c.addObserver(co);
			}
		}

		add(questionPanel, control);
		return questionPanel;
	}

	@Override
	public Boolean visit(Question question) {
		return null;
	}

	@Override
	public Boolean visit(Declaration declaration) {
		return null;
	}

	public void registerHandler(JComponent control) {

	}

	private void add(JPanel controlPanel, Control control) {
		JComponent c = (JComponent) control;
		controlPanel.add(c);
	}

	private void addLabel(JPanel labelPanel, String text) {

		JLabel label = new JLabel(text);
		labelPanel.add(label);
	}

	public State getState() {
		return state;
	}

}
