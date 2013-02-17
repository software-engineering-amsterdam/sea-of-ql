package org.uva.sea.ql.visitors;


import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.ast.expr.value.BoolLiteral;
import org.uva.sea.ql.ast.expr.value.Value;
import org.uva.sea.ql.ast.formelements.Block;
import org.uva.sea.ql.ast.formelements.CompQuestion;
import org.uva.sea.ql.ast.formelements.Form;
import org.uva.sea.ql.ast.formelements.FormElement;
import org.uva.sea.ql.ast.formelements.IfThen;
import org.uva.sea.ql.ast.formelements.IfThenElse;
import org.uva.sea.ql.ast.formelements.Question;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitors.interfaces.IElementVisitor;

public class Renderer implements IElementVisitor {

	private final JPanel panel;
	private final State state;
	private final ExprEvaluator exprevaluator;
	private static Gui gui1;

	private Renderer(State state) {
		this.state = state;
		this.panel = new JPanel(new MigLayout());
		this.exprevaluator = new ExprEvaluator(state.getValueEnv());
	}

	public static JPanel render(FormElement element, State state, Gui gui) {
		gui1 = gui;
		Renderer r = new Renderer(state);
		element.accept(r);
		return r.getPanel();
	}

	private JPanel getPanel() {
		return panel;
	}
	
	@Override
	public void visit(Block element) {
		for (FormElement elem : element.getBlock()) {
			elem.accept(this);
		}
	}

	@Override
	public void visit(CompQuestion element) {
		String name = element.getQuestionName().getName();
		Type type = element.getQuestionType();
		Value value = element.getQuestionExpr().accept(exprevaluator);
		state.setValue(name, value);
		JComponent component = TypeToWidget.CreateWidget(type, value, false);
		addQuestion(element.getQuestionLabel().getValue(), component);
		ActionListenere.CreateListener(name, type, component, state,gui1);
	}

	@Override
	public void visit(Form element) {
		JPanel formPanel = render(element.getFormBody(), state, gui1);
		panel.add(formPanel);
		panel.setBorder(BorderFactory.createTitledBorder(element.getFormName().getName()));
	}

	@Override
	public void visit(IfThen element) {
		boolean condition = ((BoolLiteral) element.getCondition().accept(exprevaluator)).getValue();
		JPanel thenPanel = render(element.getThenBody(), state, gui1);
		thenPanel.setVisible(condition);
		addPanels(condition, thenPanel, null);
	}

	@Override
	public void visit(IfThenElse element) {
		boolean condition = ((BoolLiteral) element.getCondition().accept(exprevaluator)).getValue();
		JPanel thenPanel = render(element.getThenBody(), state, gui1);
		JPanel elsePanel = render(element.getElseBody(), state, gui1);
		thenPanel.setVisible(condition);
		elsePanel.setVisible(!condition);
		addPanels(condition, thenPanel, elsePanel);
	}

	@Override
	public void visit(Question element) {
		String name = element.getQuestionName().getName();
		Type type = element.getQuestionType();
		valueInitializer(name, type);
		Value value = state.getValue(name);
		JComponent component = TypeToWidget.CreateWidget(type, value, true);
		addQuestion(element.getQuestionLabel().getValue(), component);
		ActionListenere.CreateListener(name, type, component, state, gui1);
	}

	private void addQuestion(String label, JComponent component) {
		panel.add(new JLabel(label.substring(1, label.length() - 1)),"width :100:,push");
		panel.add(component, "wrap");
	}

	private void addPanels(boolean condition, JPanel thenPanel, JPanel elsePanel) {
		if (condition == true) {
			panel.add(thenPanel, "wrap");
		} else if (elsePanel != null) {
			panel.add(elsePanel, "wrap");
		}
	}

	private void valueInitializer(String name, Type type) {
		if (!state.hasRegisteredValue(name)) {
			state.setValue(name, TypeInitializer.typeInitialize(type));
		}
	}

}
