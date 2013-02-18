package org.uva.sea.ql.questionnaire.ui.swing;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import org.uva.sea.ql.ast.nodes.values.Value;
import org.uva.sea.ql.ast.stat.AnswerableStat;
import org.uva.sea.ql.ast.stat.Block;
import org.uva.sea.ql.ast.stat.ComputedStat;
import org.uva.sea.ql.ast.stat.ConditionalStat;
import org.uva.sea.ql.ast.stat.HiddenComputetStat;
import org.uva.sea.ql.ast.stat.IfThenElseStat;
import org.uva.sea.ql.ast.stat.IfThenStat;
import org.uva.sea.ql.ast.stat.Stat;
import org.uva.sea.ql.ast.stat.TypedStat;
import org.uva.sea.ql.ast.stat.VisibleComputetStat;
import org.uva.sea.ql.ast.type.BoolType;
import org.uva.sea.ql.ast.type.IntType;
import org.uva.sea.ql.ast.type.MoneyType;
import org.uva.sea.ql.ast.type.NumericType;
import org.uva.sea.ql.ast.type.StringType;
import org.uva.sea.ql.ast.type.UndefinedType;
import org.uva.sea.ql.ast.visitor.Evaluator;
import org.uva.sea.ql.ast.visitor.StatementVisitor;
import org.uva.sea.ql.ast.visitor.TypeVisitor;
import org.uva.sea.ql.questionnaire.observer.ComputedObserver;
import org.uva.sea.ql.questionnaire.observer.ConditionObserver;
import org.uva.sea.ql.questionnaire.state.State;
import org.uva.sea.ql.questionnaire.ui.swing.control.BoolControl;
import org.uva.sea.ql.questionnaire.ui.swing.control.Control;
import org.uva.sea.ql.questionnaire.ui.swing.control.DoubleControl;
import org.uva.sea.ql.questionnaire.ui.swing.control.IntControl;
import org.uva.sea.ql.questionnaire.ui.swing.control.MoneyControl;
import org.uva.sea.ql.questionnaire.ui.swing.control.TextControl;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class SwingRenderer implements StatementVisitor, TypeVisitor {

	private JPanel panel;
	private State state;

	private SwingRenderer(State state) {
		this.state = state;
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
	}

	public static JPanel renderStatement(Stat statement, State state) {
		SwingRenderer renderer = new SwingRenderer(state);
		statement.accept(renderer);
		return renderer.getPanel();
	}

	private JPanel getPanel() {
		return this.panel;
	}

	private void addLabel(String l) {
		JLabel label = new JLabel(l);
		this.panel.add(label);
	}

	private void addPanel(JComponent panel) {
		this.panel.add(panel);
	}

	private void add(Control ctl) {
		this.panel.add(ctl.getControlElement());
	}

	private void registerConditionDeps(ConditionalStat stat, JPanel tru,
			JPanel fls) {
		ConditionObserver observer = new ConditionObserver(stat.getCondition(),
				this.state, tru, fls);
		observer.evaluateDependencies();
	}

	private void registerComputedDeps(ComputedStat stat, Control ctl) {
		ComputedObserver observer = new ComputedObserver(ctl, this.state, stat);
		observer.evaluateDependencies();
	}

	private void registerPropagator(ComputedStat stat, Control control) {
		this.state.putObservable(stat.getIdent(), control);
	}

	private void initValue(ComputedStat stat, Control ctl) {
		Value value = stat.getExpr().accept(new Evaluator(this.state.getEnv()));
		if (value == null || !value.isDefined()) {
			value = stat.getType().getDefaultValue();
		}
		ctl.setValue(value);
		this.state.putValue(stat.getIdent(), value);
	}

	private void registerHandler(final AnswerableStat stat,
			final Control control) {
		control.initEventListener(stat.getIdent(), state);
		this.state.putObservable(stat.getIdent(), control);
	}

	private Control typeToWidget(TypedStat stat, boolean changeable) {
		Control control = stat.getType().accept(this);
		control.initEventListener(stat.getIdent(), this.state);
		control.setIsChangeable(changeable);
		return control;
	}

	@Override
	public void visit(VisibleComputetStat stat) {
		addLabel(stat.getLabel());
		Control ctl = typeToWidget(stat, false);
		registerComputedDeps(stat, ctl);
		registerPropagator(stat, ctl);
		initValue(stat, ctl);
		add(ctl);
	}

	@Override
	public void visit(AnswerableStat stat) {
		addLabel(stat.getLabel());
		Control ctl = typeToWidget(stat, true);
		registerHandler(stat, ctl);
		add(ctl);
	}

	@Override
	public void visit(IfThenStat stat) {
		JPanel tru = renderStatement(stat.getBody(), state);
		tru.setBackground(Color.green);
		registerConditionDeps(stat, tru, null);
		Value trueState = stat.getCondition().accept(
				new Evaluator(this.state.getEnv()));
		boolean isTruVisible = trueState.isDefined()
				&& (Boolean) trueState.getValue();
		tru.setVisible(isTruVisible);
		addPanel(tru);
	}

	@Override
	public void visit(IfThenElseStat stat) {
		JPanel tru = renderStatement(stat.getBody(), state);
		JPanel fls = renderStatement(stat.getElseBody(), state);
		tru.setBackground(Color.green);
		fls.setBackground(Color.red);
		registerConditionDeps(stat, tru, fls);
		Value trueState = stat.getCondition().accept(
				new Evaluator(this.state.getEnv()));
		boolean isTruVisible = trueState.isDefined()
				&& (Boolean) trueState.getValue();
		boolean isFalseVisible = trueState.isDefined()
				&& !(Boolean) trueState.getValue();
		tru.setVisible(isTruVisible);
		fls.setVisible(isFalseVisible);
		addPanel(tru);
		addPanel(fls);
	}

	@Override
	public void visit(Block block) {
		JPanel blockPanel = new JPanel();
		blockPanel.setLayout(new BoxLayout(blockPanel, BoxLayout.Y_AXIS));
		Box box = Box.createVerticalBox();
		for (Stat s : block.getStatements()) {
			box.add(renderStatement(s, this.state));
			box.add(Box.createRigidArea(new Dimension(0, 10)));
		}
		addPanel(box);
	}

	@Override
	public void visit(HiddenComputetStat stat) {
		// addLabel(stat.getLabel());
		// Control ctl = typeToWidget(stat, false);
		// registerComputedDeps(stat, ctl);
		// registerPropagator(stat, ctl);
		// initValue(stat, ctl);
		// add(ctl);
	}

	@Override
	public Control visit(BoolType bool) {
		return new BoolControl(this.state);
	}

	@Override
	public Control visit(IntType i) {
		return new IntControl(this.state);
	}

	@Override
	public Control visit(MoneyType money) {
		return new MoneyControl(this.state);
	}

	@Override
	public Control visit(StringType str) {
		return new TextControl(this.state);
	}

	@Override
	public Control visit(NumericType i) {
		return new DoubleControl(this.state);
	}

	@Override
	public Control visit(UndefinedType i) {
		throw new NotImplementedException();
	}

}
