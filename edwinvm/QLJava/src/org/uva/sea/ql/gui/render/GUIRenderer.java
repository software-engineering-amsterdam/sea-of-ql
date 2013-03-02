package org.uva.sea.ql.gui.render;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Map.Entry;

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
import org.uva.sea.ql.gui.render.widgets.WidgetLabel;

public class GUIRenderer implements Visitor {

	private final ArrayList<JPanel> _panels;
	private JPanel _panel;
	private final State _state;

	private GUIRenderer(State state) {
		_panels = new ArrayList<JPanel>();
		_panel = new JPanel();
		_state = state;
	}

	public static JPanel render(FormStatement statement, State state) {
		GUIRenderer renderer = new GUIRenderer(state);
		statement.accept(renderer);
		return renderer.getPanel();
	}

	public static ArrayList<JPanel> render(StatementBody bodyStatements, State state) {
		GUIRenderer renderer = new GUIRenderer(state);
		bodyStatements.accept(renderer);
		return renderer.getPanels();
	}

	@Override
	public void visit(final IfThenStatement statement) {
		ArrayList<JPanel> renderedBody = render(statement.getBody(), _state);
		// Make sure something happens if condition is recomputed
		registerObserver(statement.getCondition(), renderedBody);
		hideVisibilityFor(renderedBody);
		addPanels(renderedBody);
	}

	@Override
	public void visit(final IfThenElseStatement statement) {
		ArrayList<JPanel> renderedBody     = render(statement.getBody(), _state);
		ArrayList<JPanel> renderedElseBody = render(statement.getElseBody(), _state);
		// Make sure something happens if condition is recomputed
		registerObserver(statement.getCondition(), renderedBody, renderedElseBody);
		hideVisibilityFor(renderedBody);
		hideVisibilityFor(renderedElseBody);
		addPanels(renderedBody);
		addPanels(renderedElseBody);
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
	
	private void addPanel(JPanel panel) {
		_panels.add(panel);
	}
	
	private void addPanels(ArrayList<JPanel> renderedBody) {
		_panels.addAll(renderedBody);
	}
	
	private void addLabel(QuestionLabel questionLabel) {
		addQuestionLabel(questionLabel.getLabel());
	}
	
	private void addQuestionLabel(Str label) {
		WidgetLabel widgetLabel = new WidgetLabel(label);
		addToPanel(widgetLabel.getLabel());
	}
	
	private void add(Widget widget) {
		addToPanel(widget.getWidget());
		addPanel(_panel);
		_panel = new JPanel();
	}
	
	private void addToPanel(Component widgetComponent) {
		_panel.add(widgetComponent);
	}
	
	private ArrayList<JPanel> getPanels() {
		return _panels;
	}
	
	private JPanel getPanel() {
		return _panel;
	}
	
	private void hideVisibilityFor(ArrayList<JPanel> renderedBody) {
		for (JPanel panel: renderedBody) {
			panel.setVisible(false);
		}
	}
	
	private void registerEventHandler(Question question, Widget widget) {
		AnswerableQuestionObservable observable = new AnswerableQuestionObservable(widget, _state, question);
		_state.putObservable(question.getQuestionVariable().getVariable(), observable);
		widget.addListener(observable);
	}
	
	private void registerObserver(Expression condition, ArrayList<JPanel> renderedBody) {
		registerObserver(condition, renderedBody, null);
	}
	
	private void registerObserver(Expression condition, ArrayList<JPanel> renderedBody, ArrayList<JPanel> renderedElseBody) {
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