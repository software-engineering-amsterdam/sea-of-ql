package org.uva.sea.ql.rendering;

import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.expressions.StringLiteral;
import org.uva.sea.ql.ast.statements.Block;
import org.uva.sea.ql.ast.statements.ComputedQuestion;
import org.uva.sea.ql.ast.statements.IfThenElse;
import org.uva.sea.ql.ast.statements.Question;
import org.uva.sea.ql.ast.statements.Statement;
import org.uva.sea.ql.ast.statements.StatementVisitor;
import org.uva.sea.ql.ast.types.BoolType;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.evaluation.values.Bool;
import org.uva.sea.ql.evaluation.values.Int;
import org.uva.sea.ql.rendering.controls.CheckBox;
import org.uva.sea.ql.rendering.controls.Control;
import org.uva.sea.ql.rendering.controls.IntegerField;
import org.uva.sea.ql.rendering.controls.TextField;

public class RenderingVisitor implements StatementVisitor<Object> {
	
	private final JPanel panel;
	private final State state;
	private final static String COLUMN_SIZE = "350";
	
	public RenderingVisitor(State state) {
		panel = new JPanel(new MigLayout("", COLUMN_SIZE, ""));
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
		Control control = createControl(question);
		registerEventHandler(question, control);
		add(control);
		return null;
	}	

	@Override
	public Object visit(ComputedQuestion computedQuestion) {
		addLabel(computedQuestion.getLabel());
		Control control = createControl(computedQuestion);
		control.getControl().setEnabled(false);
		registerEventHandler(computedQuestion, control);
		registerComputedQuestionDependencies(computedQuestion, state, control);
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
		registerConditionDependencies(ifThenElse.getCondition(), conditionTrue, conditionFalse);
		addPanel(conditionTrue);
		addPanel(conditionFalse);
		return null;
	}	
	
	private void registerConditionDependencies(Expr condition, JPanel conditionTrue, JPanel conditionFalse) {
		ConditionObserver conditionObserver = new ConditionObserver(condition, conditionTrue, conditionFalse, state);
		addObserver(conditionObserver);
	}

	private void addPanel(JPanel panel) {
		this.panel.add(panel, "span");
	}

	private void add(Control control) {		
		panel.add(control.getControl(), "wrap");
	}
	
	private void registerEventHandler(Question question, Control control) {
		ObservableQuestion observableQuestion = new ObservableQuestion(question, state, control);
		state.putObservable(question.getVariable(), observableQuestion);
		control.addListener(observableQuestion);
	}
	
	private void registerComputedQuestionDependencies(ComputedQuestion computedQuestion, State state, Control control) {
		ComputedQuestionObserver computedQuestionObserver = new ComputedQuestionObserver(control, state, computedQuestion);
		addObserver(computedQuestionObserver);	
	}	
	
	private void addLabel(StringLiteral label) {
		String text = label.getValue();
		text = text.replaceAll("\"", "");
		panel.add(new JLabel(text));
	}
	
	private void addObserver(Observer observer) {
		for (Entry<Ident, Observable> observable : state.getObservables().entrySet())
			state.addObserver(observable.getKey(), observer);
	}
	
	private Control createControl(Question question) {
		Type type = question.getType();
		Ident identifier = question.getVariable();
		if (type instanceof BoolType) {
			state.putValue(identifier, new Bool(false));
			return new CheckBox();			
		}
		else if (type instanceof IntType) {
			state.putValue(identifier, new Int(0));
			return new IntegerField();
		}
		state.putValue(identifier, new org.uva.sea.ql.evaluation.values.String(""));
		return new TextField();
	}

}
