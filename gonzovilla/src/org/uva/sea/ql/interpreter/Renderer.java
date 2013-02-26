package org.uva.sea.ql.interpreter;

import javax.swing.JPanel;

import org.uva.sea.ql.ast.stat.Block;
import org.uva.sea.ql.ast.stat.ComputedQuestion;
import org.uva.sea.ql.ast.stat.Form;
import org.uva.sea.ql.ast.stat.FormUnit;
import org.uva.sea.ql.ast.stat.IfElseStatement;
import org.uva.sea.ql.ast.stat.IfStatement;
import org.uva.sea.ql.ast.stat.Question;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitor.VisitorStatements;

public class Renderer implements VisitorStatements<Void>{
	
	private final JPanel panel;
	private final State state;
	
	public static JPanel render(FormUnit stat, State state) {
		Renderer r = new Renderer(state);
		stat.accept(r);
		return r.getPanel();
	}
	
	private JPanel getPanel() {
		return panel;
	}
	
	private Renderer(State state) {
		this.state = state;
		this.panel = new JPanel();
	}
	
	@Override
	public Void visit(Form form) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Void visit(ComputedQuestion computedQuestion) {
	addLabel(computedQuestion.getName());
	Control ctl = typeToWidget(computedQuestion.getType(), false);
	registerComputedDeps(computedQuestion, ctl);
	registerPropagator(computedQuestion);
	initValue(computedQuestion, ctl);
	add(ctl);
	}

	
	private Control typeToWidget(Type type, boolean b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(Question question) {
	addLabel(question.getLabel());
	Control ctl = typeToWidget(question.getType(), true);
	registerHandler(question, ctl);
	add(ctl);
	}
	
	@Override
	public Void visit(final IfStatement ifStatement) {
	JPanel tru = render(ifStatement.getBody(), state);
	JPanel fls = render(ifStatement.getElseBody(), state);
	registerConditionDeps(ifStatement.getCond(), tru, fls);
	tru.setVisible(false);
	fls.setVisible(false);
	addPanel(tru);
	addPanel(fls);
	}

	@Override
	public Void visit(Block block) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(IfElseStatement ifElseStatement) {
		// TODO Auto-generated method stub
		return null;
	}


}
