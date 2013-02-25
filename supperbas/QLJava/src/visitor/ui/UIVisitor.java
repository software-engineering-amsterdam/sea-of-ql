package visitor.ui;

import java.awt.*;
import java.util.Iterator;
import java.util.Observer;

import javax.swing.*;

import visitor.Environment;
import visitor.evaluator.ExpressionEvaluator;
import visitor.ui.wrapper.JCheckBoxWrap;
import visitor.ui.wrapper.JTextFieldWrap;
import visitor.ui.wrapper.Wrapper;
import visitor.ui.wrapper.WrapperEvent;
import visitor.ui.wrapper.WrapperEventListener;
import ast.Form;
import ast.Statement;
import ast.expression.Ident;
import ast.expression.Value;
import ast.statement.*;
import ast.type.Bool;
import ast.type.Int;
import ast.type.Str;

@SuppressWarnings("serial")
public class UIVisitor extends JFrame implements ast.statement.Visitor, ast.type.Visitor {
	private Environment environment;
	private JPanel panel;

	public UIVisitor(Environment environment) {
		this.environment = environment;
		panel = new JPanel();
	}

	public UIVisitor(Environment environment, Block ast) {
		panel = new JPanel();
		GridLayout flo = new GridLayout(0, 1);
		panel.setLayout(flo);
		this.environment = environment;
		for (Statement i : ast.getStatements())
			i.accept(this);
	}

	public JPanel getPanel() {
		return panel;
	}

	public void generate() {
		GridLayout flo = new GridLayout(0, 1);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(flo);
		pack();
		setVisible(true);
	}

	@Override
	public Object visit(Assignment ast) {
		return null;
	}

	@Override
	public Object visit(Form ast) {
		JPanel panel = new UIVisitor(environment, ast.getContent()).getPanel();
		this.setName(ast.getIdent().getValue());
		panel.setVisible(true);
		add(panel);
		generate();
		return null;
	}

	@Override
	public Object visit(If ast) {
		System.out.println("AA"+environment);
		ast.expression.value.Bool value = ast.getCondition().accept(new ExpressionEvaluator(environment));
		boolean visible = value.isDefined() && value.getValue();
		JPanel tru = new UIVisitor(environment, ast.getTrueBlock()).getPanel();
		JPanel fls = new UIVisitor(environment, ast.getFalseBlock()).getPanel();
		tru.setVisible(visible);
		
		panel.add(tru);
		if(ast.getFalseBlock().getStatements().size()==0)
			fls = new JPanel();
		
		fls.setVisible(!visible);
		
		Observer ob = new ConditionalObserver(tru, fls, environment, ast);
		for (Iterator<Ident> i = ast.getCondition().getIdents().iterator(); i.hasNext();)
			environment.addObserver(i.next(), ob);
		return null;
	}

	@Override
	public Object visit(final QuestionVar ast) {
		ast.getVar().accept(this);
		Wrapper wrap = environment.getIdent(ast.getIdent()).getType().accept(this);
		wrap.setLabel(ast.getLabel().getValue());
		wrap.setVisible(true);
		wrap.setValue(environment.getIdent(ast.getIdent()).getValue().getValue().toString());
		WrapperEventListener listener = new WrapperEventListener() {
			@Override
			public void change(WrapperEvent event) {
				environment.setVal(ast.getIdent(), castValue(ast.getType(), event.getWrap().getValue()));
				environment.notifyObservers(ast.getIdent());
			}
		};
		// listener.setEnv(environment);
		wrap.addListener(listener);

		panel.add(wrap.getLabel());
		panel.add(wrap.getComponent()); System.out.println(wrap.getClass());
		return null;
	}

	@Override
	public Object visit(QuestionComputed ast) {
		Wrapper wrap = environment.getIdent(ast.getIdent()).getType().accept(this);
		wrap.setEnabled(false);
		wrap.setLabel(ast.getLabel().getValue());
		wrap.setVisible(true);
		wrap.setValue(environment.getIdent(ast.getIdent()).getValue().getValue().toString());
		panel.add(wrap.getLabel());
		panel.add(wrap.getComponent()); System.out.println(wrap.getClass());
		return null;
	}

	@Override
	public Object visit(Var ast) {
		return null;
	}

	@Override
	public Object visit(Block ast) {
		for (Statement i : ast.getStatements())
			i.accept(this);
		return null;
	}

	public Value castValue(ast.Type type, String str) {
		if (type instanceof ast.type.Str)
			return new ast.expression.value.Str(str);
		if (type instanceof ast.type.Int)
			return new ast.expression.value.Int(Integer.getInteger(str));
		if (type instanceof ast.type.Bool)
			return new ast.expression.value.Bool(Boolean.parseBoolean(str));
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
