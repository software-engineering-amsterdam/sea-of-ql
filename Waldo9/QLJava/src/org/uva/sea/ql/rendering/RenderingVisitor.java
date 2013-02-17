package org.uva.sea.ql.rendering;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.ast.expressions.StringLiteral;
import org.uva.sea.ql.ast.statements.Block;
import org.uva.sea.ql.ast.statements.ComputedQuestion;
import org.uva.sea.ql.ast.statements.IfThenElse;
import org.uva.sea.ql.ast.statements.Question;
import org.uva.sea.ql.ast.statements.Statement;
import org.uva.sea.ql.ast.statements.StatementVisitor;
import org.uva.sea.ql.ast.types.BoolType;
import org.uva.sea.ql.ast.types.Type;

public class RenderingVisitor implements StatementVisitor<Object>, FocusListener {
	
	private final JPanel panel;
	private final State state;
	
	public RenderingVisitor(State state) {
		panel = new JPanel(new MigLayout("", "350", ""));
		this.state = state;
	}	

	public static JPanel render(Statement statement, State state) {
		RenderingVisitor renderingVisitor = new RenderingVisitor(state);
		if (statement != null)
			statement.accept(renderingVisitor);
		return renderingVisitor.getPanel();
	}

	public JPanel getPanel() {
		return panel;
	}

	@Override
	public Object visit(Question question) {
		addLabel(question.getLabel());
		JComponent control = typeToControl(question.getType());
		registerEventHandler(question, control);
		add(control);
		return null;
	}	

	@Override
	public Object visit(ComputedQuestion computedQuestion) {
		addLabel(computedQuestion.getLabel());
		JComponent control = typeToControl(computedQuestion.getType());
		add(control);
		return null;
	}	

	@Override
	public Object visit(Block block) {
		for (Statement statement : block.getStatements())
			statement.accept(this);
		return null;
	}

	@Override
	public Object visit(IfThenElse ifThenElse) {
		JPanel conditionTrue = render(ifThenElse.getBody(), state);
		JPanel conditionFalse = render(ifThenElse.getElseBody(), state);
		conditionTrue.setVisible(false);
		conditionFalse.setVisible(false);
		addPanel(conditionTrue);
		addPanel(conditionFalse);
		return null;
	}	
	
	private void addPanel(JPanel panel) {
		this.panel.add(panel, "span");
	}

	private void add(JComponent control) {
		panel.add(control, "wrap");
	}
	
	private void registerEventHandler(Question question, JComponent control) {
		control.addFocusListener(this);
	}

	private JComponent typeToControl(Type type) {
		if (type instanceof BoolType) {
			return new JCheckBox();
		}
		return new JTextField(15);
	}
	
	private void addLabel(StringLiteral label) {
		panel.add(new JLabel(label.getValue()));
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
