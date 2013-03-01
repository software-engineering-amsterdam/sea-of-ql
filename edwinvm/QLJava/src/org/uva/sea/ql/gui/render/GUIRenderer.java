package org.uva.sea.ql.gui.render;

import java.util.Observable;
import java.util.Observer;
import java.util.Map.Entry;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.uva.sea.ql.ast.expressions.Expression;
import org.uva.sea.ql.ast.expressions.Identifier;
import org.uva.sea.ql.ast.statements.FormStatement;
import org.uva.sea.ql.ast.statements.StatementBody;
import org.uva.sea.ql.ast.statements.conditions.IfThenElseStatement;
import org.uva.sea.ql.ast.statements.conditions.IfThenStatement;
import org.uva.sea.ql.ast.statements.questions.AnswerableQuestion;
import org.uva.sea.ql.ast.statements.questions.ComputedQuestion;
import org.uva.sea.ql.ast.statements.questions.Question;
import org.uva.sea.ql.ast.statements.questions.QuestionLabel;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.values.Str;
import org.uva.sea.ql.ast.visitors.statementchecker.Visitor;
import org.uva.sea.ql.gui.observe.AnswerableQuestionObservable;
import org.uva.sea.ql.gui.observe.ComputedQuestionObserver;
import org.uva.sea.ql.gui.observe.ConditionObserver;
import org.uva.sea.ql.gui.observe.State;
import org.uva.sea.ql.gui.render.widgets.Widget;

public class GUIRenderer implements Visitor {

	private final JPanel _panel;
	private final State _state;

	private GUIRenderer(State state) {
		_panel = new JPanel();
		_state = state;
	}

	public static JPanel render(FormStatement statement, State state) {
		GUIRenderer renderer = new GUIRenderer(state);
		statement.accept(renderer);
		return renderer.getPanel();
	}

	public static JPanel render(StatementBody bodyStatements, State state) {
		GUIRenderer renderer = new GUIRenderer(state);
		bodyStatements.accept(renderer);
		return renderer.getPanel();
	}

	@Override
	public void visit(final IfThenStatement statement) {
		JPanel renderedBody = render(statement.getBody(), _state);
		// Make sure something happens if condition is recomputed
		registerObserver(statement.getCondition(), renderedBody);
		renderedBody.setVisible(false);
		addPanel(renderedBody);
	}

	@Override
	public void visit(final IfThenElseStatement statement) {
		JPanel renderedBody     = render(statement.getBody(), _state);
		JPanel renderedElseBody = render(statement.getElseBody(), _state);
		// Make sure something happens if condition is recomputed
		registerObserver(statement.getCondition(), renderedBody, renderedElseBody);
		renderedBody.setVisible(false);
		renderedElseBody.setVisible(false);
		addPanel(renderedBody);
		addPanel(renderedElseBody);
	}

	@Override
	public void visit(AnswerableQuestion statement) {
		addLabel(statement.getQuestionLabel());
		Widget widget = renderWidgetFor(statement.getType());
		registerEventHandler(statement, widget);
		add(widget);
	}

	@Override
	public void visit(ComputedQuestion statement) {
		addLabel(statement.getQuestionLabel());
		Widget widget = renderWidgetFor(statement.getExpression().typeOf(_state.getTypeEnvironment()), false);
		// Let it listen to other questions
		registerObserver(statement, widget);
		registerEventHandler(statement, widget);
//		initValue(statement, widget);
		add(widget);
	}

	@Override
	public void visit(StatementBody statements) {
		for (FormStatement statement: statements.getStatements()) {
			statement.accept(this);
		}
	}
	
	private Widget renderWidgetFor(Type type) {
		return renderWidgetFor(type, true);
	}
	
	private Widget renderWidgetFor(Type type, boolean isEditableWidget) {
		Widget widget = WidgetRenderer.render(type);
		if (!isEditableWidget) {
			widget.setEnabled(false);
		}
		return widget;
	}
	
	private void addPanel(JPanel renderedBody) {
		_panel.add(renderedBody);
	}
	
	private void addLabel(QuestionLabel questionLabel) {
		addQuestionLabel(questionLabel.getLabel());
	}
	
	private void addQuestionLabel(Str label) {
		_panel.add(new JLabel(label.getValue()));
	}
	
	private void add(Widget widget) {
		_panel.add(widget.getWidget());
	}
	
	private JPanel getPanel() {
		return _panel;
	}
	
	private void registerEventHandler(Question question, Widget widget) {
		AnswerableQuestionObservable observable = new AnswerableQuestionObservable(widget, _state, question);
		_state.putObservable(question.getQuestionVariable().getVariable(), observable);
		widget.addListener(observable);
	}
	
	private void registerObserver(Expression condition, JPanel renderedBody) {
		registerObserver(condition, renderedBody, null);
	}
	
	private void registerObserver(Expression condition, JPanel renderedBody, JPanel renderedElseBody) {
		ConditionObserver observer = new ConditionObserver(condition, renderedBody, renderedElseBody, _state);
		addObserver(observer);
	}
	
	private void registerObserver(ComputedQuestion statement, Widget widget) {
		ComputedQuestionObserver observer = new ComputedQuestionObserver(widget, _state, statement);
		addObserver(observer);
	}

	private void addObserver(Observer observer) {
		for (Entry<Identifier, Observable> observable : _state.getObservableEnvironment().entrySet()) {
			_state.addObserver(observable.getKey(), observer);
		}
	}
	
}