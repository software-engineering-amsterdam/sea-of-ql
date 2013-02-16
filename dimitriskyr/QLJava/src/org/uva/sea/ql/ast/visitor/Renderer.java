package org.uva.sea.ql.ast.visitor;

import javax.swing.JPanel;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.statements.Block;
import org.uva.sea.ql.ast.statements.ComQuestion;
import org.uva.sea.ql.ast.statements.IfThen;
import org.uva.sea.ql.ast.statements.IfThenElse;
import org.uva.sea.ql.ast.statements.QuestionElement;
import org.uva.sea.ql.ast.statements.SimpleQuestion;
import org.uva.sea.ql.ast.statements.StatementElement;
import org.uva.sea.ql.ast.values.String_lit;

public class Renderer implements IStatementVisitor {

	private final JPanel panel;
	private final Statement state;
	
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
		registerConditionDeps(ifThen.getCondition(), ifblock);
		ifblock.setVisible(false);
		addPanel(ifblock);
	}
	
	@Override
	public void visit(final IfThenElse ifThenElse) {
		JPanel tru = render(ifThenElse.getIfBlock(), state);
		JPanel fls = render(ifThenElse.getElseBlock(), state);
		registerConditionDeps(ifThenElse.getCondition(), tru, fls);
		tru.setVisible(false);
		fls.setVisible(false);
		addPanel(tru);
		addPanel(fls);
	}

	@Override
	public void visit(SimpleQuestion simpleQuestion) {
		addLabel(simpleQuestion.getString());
		Control ctl = typeToWidget(simpleQuestion.getType(), true);
		registerHandler(simpleQuestion, ctl);
		add(ctl);
	}
	
	@Override
	public void visit(ComQuestion comQuestion) {
		addLabel(comQuestion.getString());
		Control ctl = typeToWidget(comQuestion.getType(), false);
		registerComputedDeps(comQuestion, ctl);
		registerPropagator(comQuestion);
		initValue(comQuestion, ctl);
		add(ctl);
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

}
