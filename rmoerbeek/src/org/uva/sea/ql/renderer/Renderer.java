package org.uva.sea.ql.renderer;

import org.uva.sea.ql.ast.expression.Expr;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.statement.Body;
import org.uva.sea.ql.ast.statement.ComputedQuestion;
import org.uva.sea.ql.ast.statement.ElseIfStat;
import org.uva.sea.ql.ast.statement.ElseStat;
import org.uva.sea.ql.ast.statement.Form;
import org.uva.sea.ql.ast.statement.IfStat;
import org.uva.sea.ql.ast.statement.NonComputedQuestion;
import org.uva.sea.ql.ast.statement.Question;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.ast.visitors.StatementVisitor;

import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Renderer implements StatementVisitor<Void> {
	
	private final JPanel panel;
	private final State state;
	
	public Renderer(State s) {
		this.state = s;
		this.panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
	}
	
	public static JPanel render(Statement stat, State state) {
		Renderer r = new Renderer(state);
		stat.accept(r);
		return r.getPanel();
	}
	
	public JPanel getPanel() {
		return this.panel;
	}
	

	@Override
	public Void visit(Body stat) {
		for (Statement s :stat.getElems()) {
			s.accept(this);
		}
		return null;
	}

	@Override
	public Void visit(ComputedQuestion stat) {
		addLabel(stat.getLabel());
		
		/* Get the right control
		 * A checkbox for booleans, and a textbox for integers and strings
		 */
		Control contrl = typeToWidget(state, stat, false);
		registerHandler(stat, contrl);
		
		/* Add dependencies */
		registerComputedDeps(stat, contrl);

		add(contrl);
		return null;
	}

	private void add(Control contrl) {
		this.panel.add(contrl.getControl());
	}

	private void registerComputedDeps(ComputedQuestion stat, Control contrl) {
		addObserver(new ComputedObserver(contrl, state, stat));
		
	}

	private void addLabel(String label) {
		this.panel.add(new JLabel(label));
		
	}

	@Override
	public Void visit(ElseIfStat stat) {
		return null;
	}

	@Override
	public Void visit(ElseStat stat) {
		return null;
	}

	@Override
	public Void visit(Form stat) {
		List<Statement> formElems = stat.getBody().getElems();
		
		for (Statement s : formElems ) {
			s.accept(this);
		}
		return null;
	}

	@Override
	public Void visit(final IfStat stat) {		
		JPanel yes = render(stat.getBody(), state);

		if(!stat.getElseIfs().isEmpty()) {	// If there is no else statement after if
			JPanel no = render(stat.getElseIfs().get(0).getBody(), state);
			registerConditionDeps(stat.getCondition(), stat.getElseIfs().get(0).getCondition(), yes, no);
			yes.setVisible(false);
			no.setVisible(false);
			addPanel(yes);
			addPanel(no);
		}
		else {
			registerConditionDeps(stat.getCondition(), yes);
			yes.setVisible(false);
			addPanel(yes);
			}

		return null;
	}

	private void registerConditionDeps(Expr condition, JPanel yes) {
		addObserver(new ConditionObserver(condition, yes, this.state));	
	}

	private void registerConditionDeps(Expr ifCondition, Expr ifElseCondition, JPanel yes, JPanel no) {
		addObserver(new ConditionObserver(ifCondition, ifElseCondition, yes, no, this.state));
	}

	private void addObserver(Observer observer) {
		for (Map.Entry<Ident, Observable> entry : state.getObservables().entrySet()) {
			state.addObserver(entry.getKey(), observer);
		}
	}

	private void addPanel(JPanel p) {
		panel.add(p);
		
	}

	@Override
	public Void visit(NonComputedQuestion stat) {
		addLabel(stat.getLabel());
		Control contrl = typeToWidget(state, stat, true);
		registerHandler(stat, contrl);
		add(contrl);
		return null;
	}

	private void registerHandler(Question stat, Control contrl) {
		QuestionObservable qo = new QuestionObservable(stat, state, contrl);
		state.putObservable(stat.getIdentifier(), qo);
		contrl.addListener(qo);	
	}

	private Control typeToWidget(State state, Question s, boolean b) {
		return s.getType().accept( new TypeToWidgetVisitor(state, s, b));
	}
	
	

}
