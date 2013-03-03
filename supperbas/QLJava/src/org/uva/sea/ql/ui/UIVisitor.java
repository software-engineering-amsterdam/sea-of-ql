package org.uva.sea.ql.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Observer;

import javax.swing.*;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.Value;
import org.uva.sea.ql.ast.statement.*;
import org.uva.sea.ql.ast.type.Bool;
import org.uva.sea.ql.ast.type.Int;
import org.uva.sea.ql.ast.type.Str;
import org.uva.sea.ql.evaluator.Environment;
import org.uva.sea.ql.evaluator.ExpressionEvaluator;
import org.uva.sea.ql.ui.wrapper.*;


@SuppressWarnings("serial")
public class UIVisitor extends JFrame implements org.uva.sea.ql.ast.statement.Visitor<Void>, org.uva.sea.ql.ast.type.Visitor<Wrapper> {
	private Environment environment;
	private JPanel panel;

	public UIVisitor(Environment environment) {
		this.environment = environment;
		panel = new JPanel();
	}

	public UIVisitor(Environment environment, Block ast) {
		panel = new JPanel();
		GridLayout flo = new GridLayout(0, 2);
		panel.setLayout(flo);
		this.environment = environment;
		
		for (Statement i : ast.getStatements())
			i.accept(this);
	}

	public JPanel getPanel() {
		this.pack();
		return panel;
	}

	public void generate() {
		GridLayout flo = new GridLayout(0, 1);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton button = new JButton();
		button.setText("Generate JSON");
		button.setSize(50, 20);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				environment.printVariablesJSON();
			}
		});
		add(button);
		setLayout(flo);
		pack();
		setVisible(true);
	}

	@Override
	public Void visit(Form ast) {
		JPanel panel = new UIVisitor(environment, ast.getContent()).getPanel();
		this.setName(ast.getIdent().getValue());
		panel.setVisible(true);
		add(panel);

		generate();
		return null;
	}

	@Override
	public Void visit(If ast) {
		org.uva.sea.ql.ast.expression.value.Bool value = (org.uva.sea.ql.ast.expression.value.Bool) ast.getCondition().accept(new ExpressionEvaluator(environment));
		boolean visible = value.isDefined() && value.getValue();
		JPanel tru = new UIVisitor(environment, ast.getTrueBlock()).getPanel();
		tru.setVisible(visible);
		panel.add(tru);
		
		JPanel fls = new UIVisitor(environment, ast.getFalseBlock()).getPanel();
		// resolve issues when falseblock is empty
		if (ast.getFalseBlock().getStatements().size() == 0)
			fls = new JPanel();

		fls.setVisible(!visible);
		panel.add(fls);

		Observer ob = new ConditionalObserver(tru, fls, environment, ast);
		for (Ident i : ast.getCondition().getIdents())
			environment.addObserver(i, ob);
		return null;
	}

	@Override
	public Void visit(final QuestionVar ast) {
		ast.getVar().accept(this);
		
		Wrapper wrap = environment.getIdent(ast.getIdent()).getType().accept(this);
		wrap.setLabel(ast.getLabel().getValue());
		wrap.setVisible(true);
		wrap.setValue(environment.getIdent(ast.getIdent()).getValueToString());
		WrapperEventListener listener = new WrapperEventListener() {
			@Override
			public void change(WrapperEvent event) {
				environment.setVal(ast.getIdent(), castValue(ast.getType(), event.getWrap().getValue()));
				environment.notifyObservers(ast.getIdent());
			}
		};
		wrap.addListener(listener);

		panel.add(wrap.getLabel());
		panel.add(wrap.getComponent());
		return null;
	}

	@Override
	public Void visit(QuestionComputed ast) {
		Wrapper wrap = environment.getIdent(ast.getIdent()).getType().accept(this);
		wrap.setEnabled(false);
		wrap.setLabel(ast.getLabel().getValue());
		wrap.setVisible(true);
		wrap.setValue(environment.getIdent(ast.getIdent()).getValueToString());
		
		ComputedObserver ob = new ComputedObserver(wrap, environment, ast);
		for (Ident i : ast.getExpression().getIdents())
			environment.addObserver(i, ob);
		
		panel.add(wrap.getLabel());
		panel.add(wrap.getComponent());
		return null;
	}

	@Override
	public Void visit(Var ast) {
		return null;
	}

	@Override
	public Void visit(Block ast) {
		for (Statement i : ast.getStatements())
			i.accept(this);
		return null;
	}

	public Value castValue(org.uva.sea.ql.ast.Type type, String str) {
		if (type instanceof org.uva.sea.ql.ast.type.Str)
			return new org.uva.sea.ql.ast.expression.value.Str(str);
		if (type instanceof org.uva.sea.ql.ast.type.Int)
			return new org.uva.sea.ql.ast.expression.value.Int(Integer.parseInt(str));
		if (type instanceof org.uva.sea.ql.ast.type.Bool)
			return new org.uva.sea.ql.ast.expression.value.Bool(Boolean.parseBoolean(str));
		return null;
	}

	@Override
	public Wrapper visit(Bool ast) {
		return new JCheckBoxWrap();
	}

	@Override
	public Wrapper visit(Str ast) {
		return new JTextFieldWrap();
	}

	@Override
	public Wrapper visit(Int ast) {
		return new JTextFieldWrap();
	}
}
