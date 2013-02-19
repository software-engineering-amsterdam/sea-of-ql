package org.uva.sea.ql.visitors.rendering;

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
import org.uva.sea.ql.gui.Gui;
import org.uva.sea.ql.visitors.IElementVisitor;
import org.uva.sea.ql.visitors.utils.State;

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
	public void visit(Block block) {
		for (FormElement elem : block.getBlock()) {
			elem.accept(this);
		}
	}

	@Override
	public void visit(Form form) {
		JPanel formPanel = render(form.getBody(), state, gui1);
		panel.add(formPanel);
		panel.setBorder(BorderFactory.createTitledBorder(form.getName().getStringName()));
	}

	@Override
	public void visit(IfThen ifThen) {
		boolean condition = ((BoolLiteral) ifThen.getCondition().accept(exprevaluator)).getValue();
		JPanel thenPanel = render(ifThen.getThenBody(), state, gui1);
		addConditionalPanels(condition, thenPanel, null);
	}

	@Override
	public void visit(IfThenElse ifThenElse) {
		boolean condition = ((BoolLiteral) ifThenElse.getCondition().accept(exprevaluator)).getValue();
		JPanel thenPanel = render(ifThenElse.getThenBody(), state, gui1);
		JPanel elsePanel = render(ifThenElse.getElseBody(), state, gui1);
		addConditionalPanels(condition, thenPanel, elsePanel);
	}

	@Override
	public void visit(Question question) {
		String name = question.getName().getStringName();
		Type type = question.getType();
		valueInitializer(name, type);
		Value value = state.getValue(name);
		JComponent component = TypeToWidget.CreateWidget(type, value, true);
		addQuestion(question.getLabel().getValue(), component);
		QLActionListener.createListener(name, type, component, state, gui1);
	}
	
	@Override
	public void visit(CompQuestion compQuestion) {
		String name = compQuestion.getName().getStringName();
		Type type = compQuestion.getType();
		Value value = compQuestion.getExpr().accept(exprevaluator);
		state.setValue(name, value);
		JComponent component = TypeToWidget.CreateWidget(type, value, false);
		addQuestion(compQuestion.getLabel().getValue(), component);
		QLActionListener.createListener(name, type, component, state, gui1);
	}

	private void addQuestion(String label, JComponent component) {
		panel.add(new JLabel(label.substring(1, label.length() - 1)),"width :100:,push");  //removes StringLiteral quotes before creating the label
		panel.add(component, "wrap");
	}

	/* 
	 * If the condition is not fulfilled don't add the conditional panel 
	 * to the main panel because it will just be a big non-visible
	 * block taking space. 
	 * Only add conditional panels when their condition becomes true.
	 * 
	 */
	
	private void addConditionalPanels(boolean condition, JPanel thenPanel, JPanel elsePanel) {
		if (condition) {
			thenPanel.setBorder(BorderFactory.createLoweredBevelBorder());
			thenPanel.setVisible(condition);
			panel.add(thenPanel, "wrap");
		} else if (elsePanel != null) {
			elsePanel.setBorder(BorderFactory.createLoweredSoftBevelBorder());
			elsePanel.setVisible(!condition);
			panel.add(elsePanel, "wrap");
		}
	}

	private void valueInitializer(String name, Type type) {
		if (!state.hasRegisteredValue(name)) {
			state.setValue(name, ValueInitializer.initializeValue(type));
		}
	}

}
