package org.uva.sea.ql.ast.visitor;

import java.awt.Checkbox;
import java.awt.Component;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.statements.Block;
import org.uva.sea.ql.ast.statements.ComQuestion;
import org.uva.sea.ql.ast.statements.IfThen;
import org.uva.sea.ql.ast.statements.IfThenElse;
import org.uva.sea.ql.ast.statements.QuestionElement;
import org.uva.sea.ql.ast.statements.SimpleQuestion;
import org.uva.sea.ql.ast.statements.StatementElement;
import org.uva.sea.ql.ast.gui.State;

public class Renderer implements IStatementVisitor {

	private final JPanel panel;
	private final State state;
	
	public static JPanel render(Statement statement, State state) {
		Renderer r = new Renderer(state);
		statement.accept(r);
		return r.getPanel();
		}
	
	private JPanel getPanel(){
		return panel;
	}
	
	private Renderer(State state) {
		this.state = state;
		this.panel = new JPanel();
		}
	
	@Override
	public void visit(Form form) {
		JPanel formPanel = render(form.getBlock(), state);
		panel.add(formPanel);
		panel.setName(form.getName().toString());
	}


	@Override
	public void visit(final IfThen ifThen) {
		JPanel ifblock = render(ifThen.getIfBlock(), state);
		//registerConditionDeps(ifThen.getCondition(), ifblock);
		ifblock.setVisible(false);
		panel.add(ifblock);
	}
	
	@Override
	public void visit(final IfThenElse ifThenElse) {
		JPanel tru = render(ifThenElse.getIfBlock(), state);
		JPanel fls = render(ifThenElse.getElseBlock(), state);
		//registerConditionDeps(ifThenElse.getCondition(), tru, fls);
		tru.setVisible(false);
		fls.setVisible(false);
		panel.add(tru);
		panel.add(fls);
	}

	@Override
	public void visit(SimpleQuestion simpleQuestion) {
		JLabel graphlabel = new JLabel(simpleQuestion.getString().getValue());
		Component ctl = typeToWidget(simpleQuestion, true);
		//registerHandler(simpleQuestion, ctl);
		panel.add(graphlabel);
		panel.add(ctl);
	}
	
	@Override
	public void visit(ComQuestion comQuestion) {
		JLabel graphlabel = new JLabel(comQuestion.getString().getValue());
		Component ctl = typeToWidget(comQuestion, true);
		/*registerComputedDeps(comQuestion, ctl);
		registerPropagator(comQuestion);
		initValue(comQuestion, ctl); */
		panel.add(graphlabel);
		panel.add(ctl);
	}

	@Override
	public void visit(Block block) {
		for (Statement blockbody : block.getBody()) {
			blockbody.accept(this);
		}
	}
	
	@Override
	public void visit(QuestionElement questionElement) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(StatementElement statementElement) {
		// TODO Auto-generated method stub

	}
	
	private Component typeToWidget(QuestionElement question, boolean enabled) {

		if (question.getType().isCompatibleToBoolean()) {
			Component input = new Checkbox();
			input.setEnabled(enabled);
			return input;
		}
		else if (question.getType().isCompatibleToMoney()) {
			JComponent input = new JTextField(5);
			input.setEnabled(enabled);
			return input;
		}
		if (question.getType().isCompatibleToInteger()) {
			JComponent input = new JTextField(5);
			input.setEnabled(enabled);
			return input;
		}
		return null;
	}	
	

}
