package org.uva.sea.ql.gui;

import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.statements.*;
import org.uva.sea.ql.ast.statements.types.*;
import org.uva.sea.ql.ast.value.BoolValue;
import org.uva.sea.ql.ast.value.Value;
import org.uva.sea.ql.gui.components.FormFrame;
import org.uva.sea.ql.gui.components.GUICheckbox;
import org.uva.sea.ql.gui.components.GUITextfield;
import org.uva.sea.ql.gui.eventlisteners.CheckboxEventListener;
import org.uva.sea.ql.gui.eventlisteners.TextboxEventListener;
import org.uva.sea.ql.gui.observers.IfStatBoolValueObserver;
import org.uva.sea.ql.gui.observers.ValueExpressionObserver;
import org.uva.sea.ql.visitor.IFormVisitor;

public class FormRenderer implements IFormVisitor<JComponent> {
	private FormFrame frame;
	private JPanel panel;
	private Environment environment;
	
	public FormRenderer() {
		frame = new FormFrame();
		panel = new JPanel(new MigLayout());
		environment = new Environment();
	}

	@Override
	public JComponent visit(Form f) {
		for(Statement s : f.getStatements())
			s.accept(this);

		frame.add(panel);
		frame.setVisible(true);
		
		return null;
	}

	@Override
	public JComponent visit(ComputableQuestion q) {
		addValueObserverToExpression(q.getExpression(), q.getValue());
		
		return addGuiComponent(q);
	}

	@Override
	public JComponent visit(AnswerableQuestion q) {
		return addGuiComponent(q);
	}

	@Override
	public JComponent visit(IfStatement ifStat) {
		BoolValue val = (BoolValue)ifStat.getValue();
		ArrayList<JComponent> listComps = new ArrayList<JComponent>();
		
		for(Statement s : ifStat.getStatements())
			listComps.add(s.accept(this));
		
		addValueObserverToExpression(ifStat.getCondition(), val);
		val.addObserver(new IfStatBoolValueObserver(listComps));
		
		val.setValue(false);
		
		return null;
	}
	
	public JComponent addGuiComponent(Question q) {
		JLabel lbl = new JLabel(q.getQuestionString().toString());
		Value<?> val = q.getValue();
		
		environment.put(q.getIdent(), q);
		panel.add(lbl);
		
		if (q.getType().equals(new BoolType())) {
			GUICheckbox cb = new GUICheckbox();
			cb.addActionListener(new CheckboxEventListener(val));
			panel.add(cb,"wrap");
			val.addObserver(cb);
			return cb;
		}
		else {
			GUITextfield tf = new GUITextfield("<empty>");
			tf.addActionListener(new TextboxEventListener(val));
			panel.add(tf,"wrap");
			val.addObserver(tf);
			return tf;
		}
	}

	private void addValueObserverToExpression(Expr expression, Value<?> value) {
		ValueExpressionObserver veo = new  ValueExpressionObserver(environment, value, expression );
		
		expression.accept(veo);
	}

}
