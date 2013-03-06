package org.uva.sea.ql.interpreter;

import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.stat.Block;
import org.uva.sea.ql.ast.stat.ComputedQuestion;
import org.uva.sea.ql.ast.stat.Form;
import org.uva.sea.ql.ast.stat.FormUnit;
import org.uva.sea.ql.ast.stat.IfElseStatement;
import org.uva.sea.ql.ast.stat.IfStatement;
import org.uva.sea.ql.ast.stat.Question;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitor.VisitorStatements;

public class VisitorRenderer implements VisitorStatements<Void>{
	
	private final JPanel panel;
	private final State state;
	
	public VisitorRenderer(State state) {
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		this.state = state;
	}	
	
	public static JPanel render(FormUnit formUnit, State state) {
		VisitorRenderer visitorRenderer = new VisitorRenderer(state);
		formUnit.accept(visitorRenderer);
		return visitorRenderer.getPanel();
		}
	
	public JPanel getPanel() {
		return panel;
		}
	
	public State getState() {
		return state;
	}
	
	private void addLabel(String label) {
		panel.add(new JLabel(label));
	}
	
	@Override
	public Void visit(Form form) {
		return null;
	}

	@Override
	public Void visit(ComputedQuestion computedQuestion) {
		addLabel(computedQuestion.getBody());
		Control ctl = typeToWidget(computedQuestion.getType());
		ctl.getControl().setEnabled(false);
		registerComputedDeps(computedQuestion, ctl);
		registerComputedHandler(computedQuestion, ctl);
		initComputedValue(computedQuestion, ctl);
		add(ctl);
		return null;
	}

	private void initComputedValue(ComputedQuestion computedQuestion, Control ctl) {
		Type type = computedQuestion.getType();
		String name = computedQuestion.getIdent().getName();
		VisitorInitType visitorInitType = new VisitorInitType(state, name);
		type.accept(visitorInitType);
	}

	@Override
	public Void visit(Question question) {
		addLabel(question.getBody());
		Control ctl = typeToWidget(question.getType());
		registerQuestionHandler(question, ctl);
		initQuestionValue(question, ctl);
		add(ctl);
		return null;
	}

	private void initQuestionValue(Question question, Control ctl) {
		Type type = question.getType();
		String name = question.getIdent().getName();
		VisitorInitType visitorInitType = new VisitorInitType(state, name);
		type.accept(visitorInitType);
	}

	@Override
	public Void visit(IfStatement ifStatement) {
		JPanel ifBody = render(ifStatement.getBody(), state);
		registerConditionDeps(ifStatement.getCondition(), ifBody);
		ifBody.setVisible(false);
		addPanel(ifBody);
		return null;
	}

	@Override
	public Void visit(IfElseStatement ifElseStatement) {
		JPanel tru = render(ifElseStatement.getIfBody(), state);
		JPanel fls = render(ifElseStatement.getElseBody(), state);
		registerConditionDeps(ifElseStatement.getCondition(), tru, fls);
		tru.setVisible(false);
		fls.setVisible(false);
		addPanel(tru);
		addPanel(fls);
		return null;
	}

	@Override
	public Void visit(Block block) {
		for (FormUnit formUnit : block.getBody())
			formUnit.accept(this);
		return null;
	}
	
	private void registerComputedDeps(ComputedQuestion computedQuestion, Control ctl) {
		ComputedQuestionObserver computedQuestionObserver = new ComputedQuestionObserver(ctl, state, computedQuestion);
		addObserver(computedQuestionObserver);			
	}

	private void registerConditionDeps(Expr condition, JPanel ifBody) {
		ConditionObserver conditionObserver = new ConditionObserver(condition, ifBody, state);
		addObserver(conditionObserver);
	}
	
	private void registerConditionDeps(Expr condition, JPanel tru, JPanel fls) {
		ConditionObserver conditionObserver = new ConditionObserver(condition, tru, fls, state);
		addObserver(conditionObserver);
	}
	
	private void add(Control ctl) {
		panel.add(ctl.getControl());
	}
	
	private void addObserver(Observer observer) {
		for (Entry<String, Observable> observable : state.getObservables().entrySet())
			state.addObserver(observable.getKey(), observer);		
	}
	
	private void addPanel(JPanel jPanel) {
		this.panel.add(jPanel);
	}
	
	private Control typeToWidget(Type type) {
		TypeToWidgetVisitor typeToWidgetVisitor = new TypeToWidgetVisitor();
		return type.accept(typeToWidgetVisitor);
	}
	
	private void registerQuestionHandler(Question question, Control ctl) {
		ObservableQuestion observableQuestion = new ObservableQuestion(question, state, ctl);
		state.putObservable(question.getIdent().getName(), observableQuestion);
		ctl.addListener(observableQuestion);
	}

	private void registerComputedHandler(ComputedQuestion computedQuestion, Control ctl) {
		ObservableComputed observableComputed = new ObservableComputed(computedQuestion, state, ctl);
		state.putObservable(computedQuestion.getIdent().getName(), observableComputed);
		ctl.addListener(observableComputed);
	}


}
