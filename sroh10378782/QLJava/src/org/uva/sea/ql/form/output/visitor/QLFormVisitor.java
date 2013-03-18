package org.uva.sea.ql.form.output.visitor;

import javax.swing.JLabel;
import javax.swing.JPanel;
import org.uva.sea.ql.ast.nodes.expressions.Ident;
import org.uva.sea.ql.ast.nodes.expressions.Str;
import org.uva.sea.ql.ast.nodes.expressions.composite.BinaryExpression;
import org.uva.sea.ql.ast.nodes.expressions.composite.UnaryExpression;
import org.uva.sea.ql.ast.nodes.statements.*;
import org.uva.sea.ql.types.*;
import org.uva.sea.ql.ast.statements.visitor.Visitor;
import org.uva.sea.ql.form.gui.components.GUIConstants;
import org.uva.sea.ql.form.gui.components.GUIControl;
import org.uva.sea.ql.form.gui.observers.ComputedQuestionObserver;
import org.uva.sea.ql.form.gui.observers.ConditionObserver;
import org.uva.sea.ql.form.gui.state.State;

public class QLFormVisitor implements Visitor {
	
	private final JPanel panel;
	private final State state;
	private int nextYPos = GUIConstants.GUI_FORM_START_Y;
	private int nextYParentPos = GUIConstants.GUI_FORM_START_Y;
	private JPanel parent = null;
	
	public static JPanel render(Statement statement, State state) {
		QLFormVisitor formRenderer = new QLFormVisitor(state);
		statement.accept(formRenderer);
		return formRenderer.getPanel();
	}
	
	private	JPanel getPanel() {
		return panel;
	}
	
	private	QLFormVisitor(State state) {
		this.state = state;
		this.panel = new JPanel();
		this.panel.setLayout(null);
	}
	
	@Override
	public void visit(Block block) {
		for(Statement statement : block.getValues()){
			statement.accept(this);
		}
	}

	@Override
	public void visit(Question question) {
		this.addControlLabel(question.getQuestionString());
		GUIControl ctrl = this.typeToControl(question.getType(), false);
		this.registerQuestion(question, ctrl);
		this.addControl(ctrl);
	}

	@Override
	public void visit(Form form) {
		form.getBlock().accept(this);
	}
	
	@Override
	public void visit(ComputedQuestion computedQuestion) {
		UnaryExpression ux = (UnaryExpression)computedQuestion.getExpr();
		BinaryExpression bx = (BinaryExpression)ux.getExpr();
		Ident ilhs = (Ident)bx.getLhs();
		Ident irhs = (Ident)bx.getRhs();
		this.addControlLabel(computedQuestion.getQuestionString());
		GUIControl ctrl = this.typeToControl(computedQuestion.getType(), true);
		ComputedQuestionObserver observer = new ComputedQuestionObserver(ctrl, this.state, computedQuestion);
		this.addControl(ctrl);
		this.state.addObserver(ilhs, observer);
		this.state.addObserver(irhs, observer);
	}

	@Override
	public void visit(IfThen ifThen) {
		this.parent = new JPanel();
		ConditionObserver observer = new ConditionObserver(ifThen.getCondition(), this.state, this.parent, null);
		Ident ident = (Ident)ifThen.getCondition();
		this.state.addObserver(ident, observer);
		ifThen.getBlock().accept(this);
		this.setAndAddParentToMainPanel(false);
	}
	
	@Override
	public void visit(IfThenElse ifThenElse) {
		this.parent = new JPanel();
		JPanel elsePanel = new JPanel();
		ConditionObserver observer = new ConditionObserver(ifThenElse.getCondition(), this.state, this.parent, elsePanel);
		Ident ident = (Ident)ifThenElse.getCondition();
		this.state.addObserver(ident, observer);
		ifThenElse.getIfBlock().accept(this);
		this.setAndAddParentToMainPanel(false);
		this.parent = elsePanel;
		ifThenElse.getElseBlock().accept(this);
		this.setAndAddParentToMainPanel(true);
	}
	
	private void setAndAddParentToMainPanel(boolean visible){
		this.parent.setVisible(visible);
		this.parent.setLayout(null);
		this.parent.setBounds(GUIConstants.GUI_FORM_START_X, this.nextYPos, 600, 150);
		this.panel.add(this.parent);
		this.parent = null;
	}
	
	private void addControlLabel(Str labelText){
		String labelString = labelText.getValue();
		labelString = labelString.substring(1, labelString.length()-1);
		JLabel label = new JLabel(labelString);
		
		label.setVisible(true);
		if(parent != null){
			label.setBounds(0, this.nextYParentPos, 300, GUIConstants.GUI_CONTROL_HEIGHT);
			parent.add(label);
		} else {
			label.setBounds(GUIConstants.GUI_FORM_START_X, this.nextYPos, 300, GUIConstants.GUI_CONTROL_HEIGHT);
			this.panel.add(label);
		}
	}
	
	private GUIControl typeToControl(Type type, boolean readonly){
		return QLGUIControlVisitor.getControl(type, readonly);
	}
	
	private void addControl(GUIControl control){
		JPanel crtlpanel = control.getPanel();
		crtlpanel.setVisible(true);
		if(parent != null){
			crtlpanel.setBounds(GUIConstants.GUI_FORM_START_X + 300, this.nextYParentPos, 300, GUIConstants.GUI_CONTROL_HEIGHT);
			parent.add(crtlpanel);
			this.nextYParentPos += GUIConstants.GUI_CONTROL_HEIGHT;
		} else {
			crtlpanel.setBounds(GUIConstants.GUI_FORM_START_X + 300, this.nextYPos, 300, GUIConstants.GUI_CONTROL_HEIGHT);
			crtlpanel.setSize(300, GUIConstants.GUI_CONTROL_HEIGHT);
			this.panel.add(crtlpanel);
			this.nextYPos += GUIConstants.GUI_CONTROL_HEIGHT;
		}
	}
	
	private void registerQuestion(Question question, GUIControl control){
		control.registerListener(question.getIdent(), state);
		state.putValue(question.getIdent(), new QLEvalVisitor(state.getValueEnv()).eval(question.getAnswerType()));
		this.state.putObservable(question.getIdent(), control);
	}
}
