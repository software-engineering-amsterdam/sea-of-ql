package org.uva.sea.ql.gui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.literal.StringLiteral;
import org.uva.sea.ql.ast.statement.*;
import org.uva.sea.ql.gui.controls.Control;
import org.uva.sea.ql.interpreter.ComputedObserver;
import org.uva.sea.ql.interpreter.ConditionObserver;
import org.uva.sea.ql.interpreter.State;

public class Renderer implements StatementVisitor<Boolean> {
	
	private final JPanel panel;
	private final State state;
	
	public static JPanel render(Statement stat, State state) {
		Renderer renderer = new Renderer(state);
		stat.accept(renderer);
		return renderer.getPanel();
	}

	public Renderer(State state) {
		this.state = state;
		this.panel = new JPanel();
		panel.setLayout(new MigLayout("wrap 2"));
	}
	
	public JPanel getPanel() {
		return panel;
	}
	
	public State getState() {
		return state;
	}
	
	private void addLabel(StringLiteral name) {
		JLabel label = new JLabel(name.getValue());
		panel.add(label);
	}
	
	private void addPanel(JPanel panel) {
		this.panel.add(panel);
	}
	
	private void add(Control control) {
		panel.add(control.getUIComponent());
	}
	
	/*private Value eval(Expression expr, State state) {
		return expr.accept(new Eval(state.getEnvironment()));
	}*/
	
	private void registerComputedDeps(ComputedQuestion stat, Control ctrl) {
		ComputedObserver obs = new ComputedObserver(ctrl, state, stat);
		state.addGlobalObserver(obs);
		state.putObservable(stat.getIdentifier(), ctrl);
	}
	
	private void initValue(ComputedQuestion stat, Control ctrl) {
		//Value value = new IntegerValue(0);//stat.getExpression().accept(new Eval(state.getEnvironment()));
		//state.putValue(stat.getIdentifier(), value);
		//ctrl.setValue(value);
	}

	private void registerHandler(Question stat, Control ctrl) {
		state.putObservable(stat.getIdentifier(), ctrl);
	}

	public Control typeToWidget(Question stat, boolean editable) {
		Control control = stat.getType().accept( new TypeToWidget(stat.getIdentifier(), state) );
		control.setEnabled(editable);
		return control;
	}
	
	public Boolean visit(Question stat) {
		addLabel(stat.getLabel());
		Control ctrl = typeToWidget(stat, true);
		registerHandler(stat, ctrl);
		add(ctrl);
		return true;
	}
	
	public Boolean visit(ComputedQuestion stat) {
		addLabel(stat.getLabel());
		Control ctrl = typeToWidget(stat, false);
		registerComputedDeps(stat, ctrl);
		//registerPropagator(stat);
		initValue(stat, ctrl);
		add(ctrl);
		return null;
	}
	
	private void registerConditionDeps(Expression expr, JPanel tru, JPanel fls) {
		ConditionObserver obs = new ConditionObserver(expr, state, tru, fls);
		state.addGlobalObserver(obs);
	}
	
	public Boolean visit(IfBlock stat) {
		JPanel tru = render(stat.getBody(), state);
		//JPanel fls = render(stat.getElseBody(), state);
		registerConditionDeps(stat.getCondition(), tru, null);
		tru.setVisible(false);
		//fls.setVisible(false);
		addPanel(tru);
		//addPanel(fls);
		return true;
	}

	public Boolean visit(Form stat) {
		return stat.getBody().accept(this);
	}

	public Boolean visit(Statements stat) {
		for(Statement s : stat.getStatements())
			s.accept(this);
		return true;
	}

}
