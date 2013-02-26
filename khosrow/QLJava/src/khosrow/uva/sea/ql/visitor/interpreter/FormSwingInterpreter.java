package khosrow.uva.sea.ql.visitor.interpreter;

import java.util.ArrayList;
import java.util.List;

import khosrow.uva.sea.ql.ast.expr.Expr;
import khosrow.uva.sea.ql.ast.expr.Ident;
import khosrow.uva.sea.ql.ast.stmt.*;
import khosrow.uva.sea.ql.ast.type.Type;
import khosrow.uva.sea.ql.resources.ReverseIterator;
import khosrow.uva.sea.ql.ui.*;
import khosrow.uva.sea.ql.ui.controls.Control;
import khosrow.uva.sea.ql.ui.controls.LabelControl;
import khosrow.uva.sea.ql.ui.controls.PanelControl;
import khosrow.uva.sea.ql.values.Value;
import khosrow.uva.sea.ql.visitor.IStmtVisitor;
import khosrow.uva.sea.ql.visitor.eval.ExprEvaluator;

public class FormSwingInterpreter implements IStmtVisitor<Void> {
	private final State state;
	private final PanelControl panel;
	
	private FormSwingInterpreter(State state){
		this.state = state;
		this.panel = new PanelControl();
	}	
	
	
	public static PanelControl interpret(Stmt stmt, State state) {
		FormSwingInterpreter interpreter = new FormSwingInterpreter(state);
		stmt.accept(interpreter);
		return interpreter.getPanel();
	}
	
	@Override
	public Void visit(Assign stmt) {
		Value valToAssign = evaluateExpression(stmt.getExpr());
		state.assignValue(stmt.getIdent(), valToAssign);
		return null;
	}

	@Override
	public Void visit(If stmt) {
		PanelControl tru = interpret(stmt.getBody(), state);
		registerConditionDeps(stmt.getCond(), tru);		
		tru.setVisible(false);		
		addSubPanel(tru);
		return null;
	}

	@Override
	public Void visit(ExpressionQuestion stmt) {
		LabelControl label = new LabelControl(stmt.getText());
		label.setVisible(false);
		Control ctr = getWidget(stmt.getType(), false);
		registerConditionDeps(stmt.getExpr(), label);
		registerConditionDeps(stmt.getExpr(), ctr);
		registerHandler(stmt, ctr);		
		add(label, ctr);
		return null;
	}

	@Override
	public Void visit(SimpleQuestion stmt) {
		Control ctr = getWidget(stmt.getType(), true);
		registerHandler(stmt, ctr);		
		add(new LabelControl(stmt.getText()), ctr);
		return null;
	}

	@Override
	public Void visit(Label stmt) {		
		Control ctr = getWidget(stmt.getType(), true);
		registerComputedDeps(stmt, ctr);
		Value valToAssign = evaluateExpression(stmt.getExpr());
		state.assignValue(stmt.getIdent(), valToAssign);
		ctr.setValue(valToAssign);
		ctr.setEnabled(false);		
		add(new LabelControl(stmt.getText()), ctr);
		return null;
	}

	@Override
	public Void visit(Stmts stmts) {
		ReverseIterator<Stmt> rIter = new ReverseIterator<Stmt>(stmts.iterator());			
		while(rIter.hasNext()) 
			rIter.next().accept(this);
		return null;
	}
	
	public State getState() {
		return state;
	}

	public PanelControl getPanel() {
		return panel;
	}
	
	private Value evaluateExpression(Expr expr) {
		return ExprEvaluator.Evaluate(expr, state.getEnv());
	}
	
	private void add(LabelControl label, Control ctr) {
		PanelControl subPanel = new PanelControl();
		subPanel.addLabel(label);
		subPanel.addControl(ctr);
		panel.addSubPanel(subPanel);
	}
	
	private void addSubPanel(PanelControl ctr) {
		panel.addSubPanel(ctr);
	}
		
	private Control getWidget(Type type, boolean isVisible) {
		Control ctr = TypeToSwingWidget.convert(type);
		ctr.setVisible(isVisible);
		return ctr;
	}
	
	private void registerHandler(Question stmt, Control ctr) {
		state.putObservable(stmt.getIdent(), new QlObservable());
		ctr.addListener(stmt.getIdent(),  state);
	}
	
	private void registerComputedDeps(Label stmt, Control ctr) {
		List<Ident> dependencies = new ArrayList<Ident>();
		state.putObservable(stmt.getIdent(), new QlObservable());
		DependencyTracer.getDependencies(stmt.getExpr(), dependencies);
		for(Ident ident:dependencies)
			state.addObserver(ident, new ComputedObserver(stmt, state, ctr));		
	}
	
	private void registerConditionDeps(Expr expr, Control ctr) {
		List<Ident> dependencies = new ArrayList<Ident>();
		DependencyTracer.getDependencies(expr, dependencies);
		for(Ident ident:dependencies)
			state.addObserver(ident, new ConditionObserver(expr, state, ctr));		
	}

}
