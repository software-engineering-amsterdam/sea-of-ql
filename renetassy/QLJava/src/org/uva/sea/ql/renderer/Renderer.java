package org.uva.sea.ql.renderer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.IStatementVisitor;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.stmnt.Body;
import org.uva.sea.ql.ast.stmnt.ComputedQuestion;
import org.uva.sea.ql.ast.stmnt.IfStatement;
import org.uva.sea.ql.ast.stmnt.Question;
import org.uva.sea.ql.ast.stmnt.Statement;
import org.uva.sea.ql.renderer.control.CheckBox;
import org.uva.sea.ql.renderer.control.Control;
import org.uva.sea.ql.renderer.control.Spinner;
import org.uva.sea.ql.renderer.control.TextField;
import org.uva.sea.ql.values.Bool;
import org.uva.sea.ql.values.Int;
import org.uva.sea.ql.values.Str;
import org.uva.sea.ql.values.Value;

public class Renderer implements IStatementVisitor<Void> {
	
	private final Map<String, Value> env;
	
	private final JPanel panel;
	
	final int TEXTFIELD_SIZE = 15;
	
	private final State state;
	
	public static JComponent render(Form form, State state) {
		
		Renderer r = new Renderer(state);
		
		form.accept(r);
		
		return r.getPanel();
	}
	
	public Renderer(State state) {
		this.state = state;
		this.panel = new JPanel(new MigLayout());
		this.env = new HashMap<String, Value>();
	}
	
	public JPanel getPanel() {
		return panel;
	}
	
	

	@Override
	public Void visit(Question question) {
		
		//initEnv(question);
		
		Control ctrl = createControl(question);
		
		//registerHandler(state,ctrl);
		
		JLabel label = new JLabel(question.getLabel().getValue());
		panel.add(label);
		panel.add(ctrl.getWidget(),"wrap");
				
		return null;
		
	}

	@Override
	public Void visit(ComputedQuestion computedQuestion) {
		
		Control ctrl = createControl(computedQuestion);
		//JComponent widget = typeToWidget(computedQuestion);
		JLabel label = new JLabel(computedQuestion.getLabel().getValue());
		//JTextField answer = new JTextField(TEXTFIELD_SIZE);
		//answer.setEditable(false);
		
		Expr expr = computedQuestion.getExpr();
		
		panel.add(label);
		panel.add(ctrl.getWidget(),"wrap");

		return null;
	}

	@Override
	public Void visit(IfStatement ifStatement) {
		// TODO Auto-generated method stub
		
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
	
/**private void initEnv (Question question) {
		
	if(env.containsKey(question.getID().getName())) {
		Value v = env.get(question.getID().getName());
	}
	else {
		
		if(question.getType().isCompatibleToBool()) {
			env.put(question.getID().getName(), new Bool(false));	
		}
		else if(question.getType().isCompatibleToInt()) {
			env.put(question.getID().getName(), new Int(0));
		}
		else if(question.getType().isCompatibleToString()) {
			env.put(question.getID().getName(), new Str(""));
		}	
	}
}*/
	
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
