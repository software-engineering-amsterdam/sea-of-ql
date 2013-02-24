package org.uva.sea.ql.renderer;

import java.util.List;
import java.util.Map.Entry;
import java.util.Observable;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.IStatementVisitor;
import org.uva.sea.ql.ast.QLComponent;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.statements.Body;
import org.uva.sea.ql.ast.statements.ComputedQuestion;
import org.uva.sea.ql.ast.statements.IfStatement;
import org.uva.sea.ql.ast.statements.Question;
import org.uva.sea.ql.ast.statements.Statement;
import org.uva.sea.ql.evaluation.values.Bool;
import org.uva.sea.ql.evaluation.values.Int;
import org.uva.sea.ql.evaluation.values.Str;
import org.uva.sea.ql.renderer.control.CheckBox;
import org.uva.sea.ql.renderer.control.Control;
import org.uva.sea.ql.renderer.control.Spinner;
import org.uva.sea.ql.renderer.control.TextField;

public class Renderer implements IStatementVisitor<Void> {
	
	private final JPanel panel;
	
	private final State state;
	
	public Renderer(State state) {
		
		this.state = state;
		this.panel = new JPanel(new MigLayout());
	}
	
	public static JPanel render(QLComponent statement, State state) {
		
		Renderer r = new Renderer(state);
		
		if (statement != null) {
			statement.accept(r);
		}
			
		return r.getPanel();
	}
	
	public JPanel getPanel() {
		return panel;
	}
	
	@Override
	public Void visit(Question question) {
				
		Control ctrl = createControl(question);
		registerHandler(ctrl,question);
	
		addQuestionToPanel(question,ctrl);
		
		return null;
	}

	@Override
	public Void visit(ComputedQuestion computedQuestion) {
		
		Control ctrl = createControl(computedQuestion);
		ctrl.getWidget().setEnabled(false);
		
		registerHandler(ctrl,computedQuestion);
		registerComputationObserver(ctrl,computedQuestion);
		
		addQuestionToPanel(computedQuestion,ctrl);

		return null;
	}
	
	@Override
	public Void visit(IfStatement ifStatement) {
			
		Expr expr = ifStatement.getExpr();
		JPanel ifBody = render(ifStatement.getBody(),state);
		
		ifBody.setVisible(false);
		
		registerConditionObserver(expr, ifBody);
		
		addStatementBodyToPanel(ifBody);
		
		return null;
	}
	
	@Override
	public Void visit(Body body) {
		
		List<Statement> statements = body.getStatements();
		
		for (Statement statement : statements) {
			statement.accept(this);
		}
		
		return null;
	}

	@Override
	public Void visit(Form form) {
		
		form.getBody().accept(this);
		
		return null;	
	}
	
	private void registerComputationObserver(Control ctrl, ComputedQuestion computedQuestion) {
		
		ComputationObserver computationObs = new ComputationObserver(computedQuestion, ctrl, state);
		
		for (Entry<String, Observable> observable : state.getObservables().entrySet()) {
			state.addObserver(observable.getKey(), computationObs);
		}	
	}
	
	private void registerConditionObserver(Expr expr, JPanel statementBody) {
		
		ConditionObserver condObserver = new ConditionObserver(statementBody, expr, state);
		
		for (Entry<String, Observable> observable : state.getObservables().entrySet()) {
			state.addObserver(observable.getKey(), condObserver);
		}
	}
	
	private void addStatementBodyToPanel(JPanel statementBody) {
		panel.add(statementBody,"span");
	}
	
	private void addQuestionToPanel(Question q, Control ctrl) {
		
		JLabel label = new JLabel(q.getLabel().getValue());
		panel.add(label);
		
		panel.add(ctrl.getWidget(),"wrap");
		
	}
	
	private void registerHandler(Control ctrl, Question question) {
		
		ObservableQuestion obs = new ObservableQuestion(state, ctrl, question);
		state.putObservable(question.getID().getName(), obs);
		
		ctrl.addListener(obs);
	}
	
	private Control createControl(Question q) {
		
		if(q.getType().isCompatibleToBool()) {
			state.putValue(q.getID().getName(), new Bool(false));
			return new CheckBox();
		}
		
		if(q.getType().isCompatibleToInt()) {
			state.putValue(q.getID().getName(), new Int(0));
			return new Spinner();
		}
		
		if(q.getType().isCompatibleToString()) {
			state.putValue(q.getID().getName(), new Str(""));
			return new TextField();
		}
		
		return null;	
	}
}
