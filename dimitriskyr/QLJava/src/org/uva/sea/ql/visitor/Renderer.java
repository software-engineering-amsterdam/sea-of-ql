package org.uva.sea.ql.visitor;

import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.statements.Block;
import org.uva.sea.ql.ast.statements.ComQuestion;
import org.uva.sea.ql.ast.statements.IfThen;
import org.uva.sea.ql.ast.statements.IfThenElse;
import org.uva.sea.ql.ast.statements.QuestionElement;
import org.uva.sea.ql.ast.statements.SimpleQuestion;
import org.uva.sea.ql.ast.values.Bool;
import org.uva.sea.ql.ast.values.Ident;
import org.uva.sea.ql.ast.values.Int;
import org.uva.sea.ql.ast.values.Money;
import org.uva.sea.ql.ast.values.String_lit;
import org.uva.sea.ql.gui.*;

public class Renderer implements IStatementVisitor {

	private final JPanel panel;
	private final State state;

	public Renderer(State state) {
		this.state = state;
		this.panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	}

	public static JPanel render(Statement statement, State state) {
		Renderer r = new Renderer(state);
		statement.accept(r);
		return r.getPanel();
	}

	public JPanel getPanel() {
		return panel;
	}

	public State getState() {
		return state;
	}

	@Override
	public void visit(Form form) {
		render(form.getBlock(), state);
	}

	@Override
	public void visit(Block block) {
		for (Statement blockbody : block.getBody()) {
			blockbody.accept(this);
		}
	}

	@Override
	public void visit(IfThen ifThen) {
		JPanel ifblock = render(ifThen.getIfBlock(), state);
		System.out.println(ifThen.getCondition());
		registerConditionDeps(ifThen.getCondition(), ifblock);
		ifblock.setVisible(false);
		panel.add(ifblock);
	}

	@Override
	public void visit(IfThenElse ifThenElse) {
		JPanel tru = render(ifThenElse.getIfBlock(), state);
		JPanel fls = render(ifThenElse.getElseBlock(), state);
		registerConditionDeps(ifThenElse.getCondition(), tru, fls);
		tru.setVisible(false);
		fls.setVisible(false);
		panel.add(tru);
		panel.add(fls);
	}

	@Override
	public void visit(SimpleQuestion simpleQuestion) {
		JLabel graphlabel = new JLabel(simpleQuestion.getString().getValue());
		Control ctl = typeToWidget(simpleQuestion);
		registerHandler(simpleQuestion, ctl);
		panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		panel.add(graphlabel);
		panel.add(ctl.getComponent());
	}

	@Override
	public void visit(ComQuestion comQuestion) {
		JLabel graphlabel = new JLabel(comQuestion.getString().getValue());
		Control ctl = typeToWidget(comQuestion);
		registerHandler(comQuestion, ctl);
		registerComputedDeps(comQuestion, state, ctl);
		panel.add(graphlabel);
		panel.add(ctl.getComponent());
	}

	private void registerHandler(QuestionElement question, Control control) {
		ObservableSimpleQuestion obQuestion = new ObservableSimpleQuestion(question, state,
				control);
		state.putObservable(question.getIdent(), obQuestion);
		control.listener(obQuestion);
	}

	private void registerComputedDeps(QuestionElement question, State state,
			Control control) {
		ComputedObserver computedObserver = new ComputedObserver(control,
				state, question);
		addObserver(computedObserver);
	}

	private void addObserver(Observer observer) {
		for (Entry<Ident, Observable> observable : state.getObservables()
				.entrySet())
			state.addObserver(observable.getKey(), observer);
	}

	private void registerConditionDeps(Expr condition, JPanel conditionTrue,
			JPanel conditionFalse) {
		IfConditionObserver conditionObserver = new IfConditionObserver(
				condition, conditionTrue, conditionFalse, state);
		addObserver(conditionObserver);
	}

	private void registerConditionDeps(Expr condition, JPanel ifbody) {
		IfConditionObserver conditionObserver = new IfConditionObserver(
				condition, ifbody, state);
		addObserver(conditionObserver);
	}

	private Control typeToWidget(QuestionElement question) {
		Ident ident = question.getIdent();
		if (question.getType().isCompatibleToBoolean()) {
			state.putValue(ident.getValue(), new Bool(false));
			System.out.println(state.getEnv());
			return new BooleanToWidget();
		}

		else if (question.getType().isCompatibleToMoney()) {
			state.putValue(ident.getValue(), new Money(0));
			return new MoneyToWidget();
		}

		else if (question.getType().isCompatibleToInteger()) {
			state.putValue(ident.getValue(), new Int(0));
			return new IntegerToWidget();
		}

		else if (question.getType().isCompatibleToString()) {
			state.putValue(ident.getValue(), new String_lit(null));
			return new StringToWidget();
		} else
			return null;

	}
}
