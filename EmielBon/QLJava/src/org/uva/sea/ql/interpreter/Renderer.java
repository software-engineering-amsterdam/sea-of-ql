package org.uva.sea.ql.interpreter;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import org.uva.sea.ql.ast.expression.literal.StringLiteral;
import org.uva.sea.ql.ast.statement.*;
import org.uva.sea.ql.ast.type.Type;

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
		panel.setLayout(new MigLayout());
	}
	
	public JPanel getPanel() {
		return panel;
	}
	
	public State getState() {
		return state;
	}
	
	private void addLabel(StringLiteral name) {
		JLabel label = new JLabel(name.getValue());
		add(label);
	}
	
	private void add(JComponent component) {
		panel.add(component);
	}
	
	public Boolean visit(ComputedQuestion stat) {
		/*addLabel(stat.getLabel());
		Control ctrl = typeToWidget(stat.getType(), false);
		registerComputedDeps(stat, ctrl);
		registerPropagator(stat);
		initValue(stat, ctrl);
		add(ctrl);*/
		return null;
	}

	public Boolean visit(Question stat) {
		addLabel(stat.getLabel());
		Control ctrl = typeToWidget(stat.getType(), true);
		//registerHandler(stat, ctrl);
		add(ctrl);
		return true;
	}

	public Control typeToWidget(Type type, boolean editable) {
		return null;
	}
	
	public Boolean visit(IfBlock stat) {
		// TODO Auto-generated method stub
		return null;
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
