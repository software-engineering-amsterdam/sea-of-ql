package org.uva.sea.ql.gui.render;

import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.uva.sea.ql.ast.statements.FormStatement;
import org.uva.sea.ql.ast.statements.StatementBody;
import org.uva.sea.ql.ast.statements.conditions.IfThenElseStatement;
import org.uva.sea.ql.ast.statements.conditions.IfThenStatement;
import org.uva.sea.ql.ast.statements.questions.AnswerableQuestion;
import org.uva.sea.ql.ast.statements.questions.ComputedQuestion;
import org.uva.sea.ql.ast.statements.questions.QuestionLabel;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.values.Str;
import org.uva.sea.ql.ast.visitors.statementchecker.Visitor;
import org.uva.sea.ql.gui.observe.QuestionnaireObserver;
import org.uva.sea.ql.gui.observe.State;
import org.uva.sea.ql.gui.render.widgets.Widget;
import org.uva.sea.ql.gui.render.widgets.WidgetLabel;

public class QuestionnaireRenderer implements Visitor {

	private JPanel _panel;
	private final ArrayList<JPanel> _panels;
	private final State _state;

	private QuestionnaireRenderer(State state) {
		_panels = new ArrayList<JPanel>();
		_panel = new JPanel();
		_state = state;
	}

	public static JPanel render(FormStatement statement, State state) {
		QuestionnaireRenderer renderer = new QuestionnaireRenderer(state);
		statement.accept(renderer);
		return renderer.getPanel();
	}

	public static ArrayList<JPanel> render(StatementBody bodyStatements, State state) {
		QuestionnaireRenderer renderer = new QuestionnaireRenderer(state);
		bodyStatements.accept(renderer);
		return renderer.getPanels();
	}

	@Override
	public void visit(final IfThenStatement statement) {
		ArrayList<JPanel> renderedBody = render(statement.getBody(), _state);
		// Make sure something happens if condition is recomputed
		QuestionnaireObserver.registerObserver(statement.getCondition(), renderedBody, _state);
		hideVisibilityFor(renderedBody);
		addPanels(renderedBody);
	}

	@Override
	public void visit(final IfThenElseStatement statement) {
		ArrayList<JPanel> renderedBody     = render(statement.getBody(), _state);
		ArrayList<JPanel> renderedElseBody = render(statement.getElseBody(), _state);
		// Make sure something happens if condition is recomputed
		QuestionnaireObserver.registerObserver(statement.getCondition(), renderedBody, renderedElseBody, _state);
		hideVisibilityFor(renderedBody);
		hideVisibilityFor(renderedElseBody);
		addPanels(renderedBody);
		addPanels(renderedElseBody);
	}

	@Override
	public void visit(AnswerableQuestion statement) {
		addLabel(statement.getQuestionLabel());
		Widget widget = renderWidgetFor(statement.getType());
		QuestionnaireObserver.registerEventHandler(statement, widget, _state);
		add(widget);
	}

	@Override
	public void visit(ComputedQuestion statement) {
		addLabel(statement.getQuestionLabel());
		Widget widget = renderWidgetFor(statement.getExpression().typeOf(_state.getTypeEnvironment()), false);
		// Let it listen to other questions
		QuestionnaireObserver.registerObserver(statement, widget, _state);
		QuestionnaireObserver.registerEventHandler(statement, widget, _state);
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
}