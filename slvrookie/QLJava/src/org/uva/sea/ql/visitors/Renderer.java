package org.uva.sea.ql.visitors;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.ast.expr.value.BoolLiteral;
import org.uva.sea.ql.ast.expr.value.IntLiteral;
import org.uva.sea.ql.ast.expr.value.MoneyLiteral;
import org.uva.sea.ql.ast.expr.value.StringLiteral;
import org.uva.sea.ql.ast.expr.value.Value;
import org.uva.sea.ql.ast.formelements.Block;
import org.uva.sea.ql.ast.formelements.CompQuestion;
import org.uva.sea.ql.ast.formelements.Form;
import org.uva.sea.ql.ast.formelements.FormElement;
import org.uva.sea.ql.ast.formelements.IfThen;
import org.uva.sea.ql.ast.formelements.IfThenElse;
import org.uva.sea.ql.ast.formelements.Question;
import org.uva.sea.ql.visitors.interfaces.IElementVisitor;

public class Renderer implements IElementVisitor{
	
	private final JPanel panel;
	private final State state;
	private final Map<String, Value> env ;
	private final ExprEvaluator exprevaluator;
	
	public static JPanel render(FormElement element, State state) {
		Renderer r = new Renderer(state);
		element.accept(r);
		return r.getPanel();
	}
	
	private JPanel getPanel() {
		return panel;
	}
	
	public Renderer(State state) {
		this.state = state;
		this.panel = new JPanel(new MigLayout());
		this.env = new HashMap<String,Value>();
		this.exprevaluator = new ExprEvaluator(env);
	}

	@Override
	public void visit(Block element) {
		for (FormElement elem : element.getBlock()) {
			elem.accept(this);
		}
	}

	@Override
	public void visit(CompQuestion element) {
	//	Value val = element.getQuestionExpr().accept(exprevaluator);
		JComponent component = createControl(element, false);
		JLabel labelElement = new JLabel(element.getQuestionLabel().getValue() );
		panel.add(labelElement);
		panel.add(component, "wrap");
	//	registerComputedDeps(stat, ctl);
	//	registerPropagator(stat);
	//	initValue(stat, ctl);
	}

	@Override
	public void visit(Form element) {
		JPanel formPanel = render( element.getFormBody(), state );
		panel.add( formPanel );
		panel.setName( element.getFormName().getName() );
	}

	@Override
	public void visit(IfThen element) {
		boolean condition = ( (BoolLiteral) element.getCondition().accept(exprevaluator)).getValue();
		JPanel tru = render(element.getThenBody(), state);
		tru.setVisible(condition);
		panel.add(tru, "wrap");
	}

	@Override
	public void visit(IfThenElse element) {
		boolean condition = ( (BoolLiteral) element.getCondition().accept(exprevaluator)).getValue();
		JPanel tru = render(element.getThenBody(), state);
		JPanel fls = render(element.getElseBody(), state);
//		registerConditionDeps(element.getCondition(), tru, fls);
		tru.setVisible(condition);
		fls.setVisible(!condition);
		panel.add(tru, "wrap");
		panel.add(fls, "wrap");
	}

	@Override
	public void visit(Question element) {
		JComponent component = createControl(element, true);
		JLabel labelElement = new JLabel(element.getQuestionLabel().getValue() );
		panel.add(labelElement);
		panel.add(component, "wrap");
		valueInitializer(element);
	//	registerHandler(stat, ctl);
	}
	
	private JComponent createControl(Question question, boolean enabled) {
		
		if (question.getQuestionType().isCompatibleToBoolType()) {
			JComponent input = new JCheckBox();
			input.setEnabled( enabled );
			return  input;
		}
		if (question.getQuestionType().isCompatibleToStringType()) {
			JComponent input = new JTextField(5);
			input.setEnabled( enabled );
			return input;
		}
		if (question.getQuestionType().isCompatibleToMoneyType()) {
			JComponent input = new JTextField(5);
			input.setEnabled( enabled );
			return input;
		}
		if (question.getQuestionType().isCompatibleToIntType()) {
			JComponent input = new JTextField(5);
			input.setEnabled( enabled );
			return input;
		}
		return null;
	}

	private void valueInitializer(Question question) {
		if (question.getQuestionType().isCompatibleToBoolType()){
			env.put(question.getQuestionName().getName(), new BoolLiteral(false));
		}
		if (question.getQuestionType().isCompatibleToStringType()) {
			env.put(question.getQuestionName().getName(), new StringLiteral(""));
		}
		if (question.getQuestionType().isCompatibleToMoneyType()) {
			env.put(question.getQuestionName().getName(), new MoneyLiteral(0.00));
		}
		if (question.getQuestionType().isCompatibleToIntType()) {
			env.put(question.getQuestionName().getName(), new IntLiteral(0));
		}
	}

}
