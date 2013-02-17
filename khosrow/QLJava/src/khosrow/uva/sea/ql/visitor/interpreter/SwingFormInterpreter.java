package khosrow.uva.sea.ql.visitor.interpreter;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import khosrow.uva.sea.ql.ast.expr.Expr;
import khosrow.uva.sea.ql.ast.expr.Ident;
import khosrow.uva.sea.ql.ast.stmt.*;
import khosrow.uva.sea.ql.ast.type.Type;
import khosrow.uva.sea.ql.env.Env;
import khosrow.uva.sea.ql.ui.*;
import khosrow.uva.sea.ql.ui.controls.Control;
import khosrow.uva.sea.ql.values.Value;
import khosrow.uva.sea.ql.visitor.IStmtVisitor;
import khosrow.uva.sea.ql.visitor.eval.ExprEvaluator;

public class SwingFormInterpreter implements IStmtVisitor<Void> {
	private final Env env;
	private final State state;
	private final JPanel panel;
	
	public SwingFormInterpreter(Env env){
		this.env = env;
		this.state = new State(env);
		this.panel = new JPanel();
	}	
	
	@Override
	public Void visit(Assign stmt) {
		Value valToAssign = evaluateExpression(stmt.getExpr());
		env.assignValue(stmt.getIdent(), valToAssign);
		return null;
	}

	@Override
	public Void visit(If stmt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(ExpressionQuestion stmt) {
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(SimpleQuestion stmt) {
		// TODO Auto-generated method stub
		//stmt.getType()
		return null;
	}

	@Override
	public Void visit(Label stmt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(Stmts stmts) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Env getEnv() {
		return env;
	}

	public State getState() {
		return state;
	}

	public JPanel getPanel() {
		return panel;
	}
	
	private Value evaluateExpression(Expr expr) {
		return ExprEvaluator.Evaluate(expr, env);
	}
	
	private void addComponent(Control ctr) {
		panel.add(ctr.getComponent());
	}
	
	private void addLabel(String label) {
		panel.add(new JLabel(label));
	}
	
	private Control getWidget(Type type, boolean isVisible) {
		Control ctr = TypeToSwingWidget.convert(type);
		ctr.setVisible(isVisible);
		return ctr;
	}
	
	private void registerDependencies(Label stmt, Control ctr) {
		List<Ident> dependencies = new ArrayList<Ident>();
		DependencyTracer.Find(stmt.getExpr(), dependencies);
		for(Ident ident:dependencies)
			state.addObserver(ident, new ComputedObserver(stmt, state, ctr));
		
	}

}
