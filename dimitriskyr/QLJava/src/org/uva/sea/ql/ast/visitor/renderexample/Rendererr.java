package org.uva.sea.ql.ast.visitor.renderexample;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
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
import org.uva.sea.ql.ast.visitor.IStatementVisitor;

public class Rendererr implements IStatementVisitor {

	private final JPanel panel;
	JFrame frame = new JFrame("QL Language");
	
	public Rendererr() {
		this.panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		}
	
	public static JPanel render(Statement statement) {
		Rendererr r = new Rendererr();
		statement.accept(r);
		return r.getPanel();
		}
	
	private JPanel getPanel(){
		return panel;
	}
	
	@Override
	public void visit(Form form) {
		JPanel formPanel = render(form.getBlock());
	}


	@Override
	public void visit(final IfThen ifThen) {
		ifThen.getIfBlock().accept(this);
		JPanel ifblock = render(ifThen.getIfBlock());
		//registerConditionDeps(ifThen.getCondition(), ifblock);
		ifblock.setVisible(false);
		panel.add(ifblock);
		frame.setContentPane(panel);
		frame.pack();
		frame.setVisible(true);
	}
	
	@Override
	public void visit(final IfThenElse ifThenElse) {
		ifThenElse.getIfBlock().accept(this);
		ifThenElse.getElseBlock().accept(this);
		JPanel tru = render(ifThenElse.getIfBlock());
		JPanel fls = render(ifThenElse.getElseBlock());
		//registerConditionDeps(ifThenElse.getCondition(), tru, fls);
		tru.setVisible(false);
		fls.setVisible(false);
		panel.add(tru);
		panel.add(fls);
		frame.setContentPane(panel);
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void visit(SimpleQuestion simpleQuestion) {
		JLabel graphlabel = new JLabel(simpleQuestion.getString().getValue());
		JComponent ctl = typeToWidget(simpleQuestion, true);
		//registerHandler(simpleQuestion, ctl);
		panel.add(graphlabel);
		panel.add(ctl);
		panel.setName(simpleQuestion.getIdent().toString());
		frame.setVisible(true);
		frame.setContentPane(panel);
		frame.pack();
	}
	
	@Override
	public void visit(ComQuestion comQuestion) {
		JLabel graphlabel = new JLabel(comQuestion.getString().getValue());
		JComponent ctl = typeToWidget(comQuestion, true);
		/*registerComputedDeps(comQuestion, ctl);
		registerPropagator(comQuestion);
		initValue(comQuestion, ctl); */
		panel.add(graphlabel);
		panel.add(ctl);
		frame.setContentPane(panel);
		frame.pack();
		frame.setVisible(true);
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
	
	private JComponent typeToWidget(QuestionElement question, boolean enabled) {

		if (question.getType().isCompatibleToBoolean()) {
			JComponent input = new JCheckBox();
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
