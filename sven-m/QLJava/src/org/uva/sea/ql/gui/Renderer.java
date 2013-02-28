package org.uva.sea.ql.gui;

import java.util.Stack;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.ast.form.Body;
import org.uva.sea.ql.ast.form.Computed;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.form.FormElement;
import org.uva.sea.ql.ast.form.IfElseStatement;
import org.uva.sea.ql.ast.form.IfStatement;
import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.ast.form.types.BoolType;
import org.uva.sea.ql.ast.form.types.IntType;
import org.uva.sea.ql.ast.form.types.StrType;
import org.uva.sea.ql.ast.form.types.Type;
import org.uva.sea.ql.ast.form.types.UndefinedType;
import org.uva.sea.ql.ast.visitor.FormVisitor;
import org.uva.sea.ql.ast.visitor.TypeVisitor;
import org.uva.sea.ql.gui.control.display.DisplayControl;
import org.uva.sea.ql.gui.control.input.InputControl;
import org.uva.sea.ql.gui.control.input.NumberField;
import org.uva.sea.ql.gui.control.input.BooleanField;
import org.uva.sea.ql.gui.control.input.TextField;
import org.uva.sea.ql.gui.misc.ValueState;
import org.uva.sea.ql.gui.propagation.ComputedObserver;
import org.uva.sea.ql.gui.propagation.ConditionObserver;
import org.uva.sea.ql.gui.propagation.ObservableQuestion;

public class Renderer implements FormVisitor<Void>, TypeVisitor<InputControl> {
	private JPanel mainPanel;
	private Stack<JPanel> panelStack;
	private ValueState state;

	private Renderer(ValueState state) {
		this.panelStack = new Stack<>();
		this.mainPanel = pushPanel();
		this.state = state;
	}
	
	private JPanel getMainPanel() {
		return mainPanel;
	}

	private Stack<JPanel> getPanelStack() {
		return panelStack;
	}

	public ValueState getState() {
		return state;
	}

	/* Panels */

	private JPanel createPanel(boolean visible) {
		JPanel panel = new JPanel(new MigLayout("hidemode 3"));
		panel.setVisible(visible);

		return panel;

	}

	private JPanel pushPanel() {
		return pushPanel(null);
	}

	private JPanel pushPanel(JPanel newPanel) {
		if (newPanel == null) {
			newPanel = createPanel(true);
		}

		insertPanel(newPanel);

		return getPanelStack().push(newPanel);
	}

	private void insertPanel(JPanel newPanel) {
		if (getCurrentPanel() != null) {
			getCurrentPanel().add(newPanel, "span");
		}
	}

	private JPanel popPanel() {
		return getPanelStack().pop();
	}

	private JPanel getCurrentPanel() {
		return getPanelStack().empty() ? null : panelStack.peek();
	}

	private JPanel getPanel() {
		return getMainPanel();
	}

	/* Controls */

	private InputControl createControl(Type type) {
		return type.accept(this);
	}

	private void addControl(JComponent widget) {
		getCurrentPanel().add(widget, "wrap");
	}

	private void addLabel(String text) {
		getCurrentPanel().add(new JLabel(text));
	}

	/* Static entry */
	
	public static JPanel render(Form form, ValueState state) {
		Renderer renderer = new Renderer(state);
		form.accept(renderer);
		
		return renderer.getPanel();
	}

	/* Form visitor */

	@Override
	public Void visit(Form ast) {
		return ast.getBody().accept(this);
	}

	@Override
	public Void visit(Body ast) {

		for (FormElement formElement : ast.getElements()) {
			formElement.accept(this);
		}

		return null;
	}

	@Override
	public Void visit(IfStatement ast) {
		JPanel ifTrue = createPanel(false);

		ConditionObserver conditionObserver = new ConditionObserver(
				ast.getCondition(), ifTrue, getState());
		getState().addObserverToAll(conditionObserver);

		pushPanel(ifTrue);
		ast.getBody().accept(this);
		popPanel();

		return null;
	}

	@Override
	public Void visit(IfElseStatement ast) {
		JPanel ifTrue = createPanel(false);
		JPanel ifFalse = createPanel(false);

		ConditionObserver conditionObserver = new ConditionObserver(
				ast.getCondition(), ifTrue, ifFalse, getState());

		pushPanel(ifTrue);
		ast.getBody().accept(this);
		popPanel();

		pushPanel(ifFalse);
		ast.getElse().accept(this);
		popPanel();

		getState().addObserverToAll(conditionObserver);

		return null;
	}

	@Override
	public Void visit(Question ast) {
		addLabel(ast.getLabel());
		InputControl control = createControl(ast.getType());

		addControl(control.getWidget());

		ObservableQuestion observableQuestion = new ObservableQuestion(ast,
				getState(), control);

		getState().putObservable(ast.getIdent(), observableQuestion);

		return null;
	}

	@Override
	public Void visit(Computed ast) {
		addLabel(ast.getLabel());

		DisplayControl control = new DisplayControl();

		addControl(control.getWidget());

		ComputedObserver computedObserver = new ComputedObserver(ast, control,
				getState());

		getState().addObserverToAll(computedObserver);

		ObservableQuestion observableQuestion = new ObservableQuestion(ast,
				getState(), computedObserver);

		getState().putObservable(ast.getIdent(), observableQuestion);

		return null;
	}

	/* Type visitor */

	@Override
	public InputControl visit(BoolType type) {
		return new BooleanField();
	}

	@Override
	public InputControl visit(StrType type) {
		return new TextField();
	}

	@Override
	public InputControl visit(IntType type) {
		return new NumberField();
	}

	@Override
	public InputControl visit(UndefinedType type) {
		return null;
	}

}
