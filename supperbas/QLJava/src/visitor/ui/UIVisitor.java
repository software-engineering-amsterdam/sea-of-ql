package visitor.ui;

import java.awt.*;
import java.util.Iterator;
import java.util.Observer;

import javax.swing.*;

import visitor.Environment;
import visitor.checker.ExpressionChecker;
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
	private static Environment environment;
	private static JPanel panel = new JPanel();

	public UIVisitor(Environment environment) {
		UIVisitor.environment = environment;
	}

	public UIVisitor(Environment environment, Statement stat) {
		UIVisitor.environment = environment;
		stat.accept(this);
	}

	public JPanel getPanel() {
		return panel;
	}

	public void generate() {
		GridLayout flo = new GridLayout(0, 2);
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
		ast.getContent().accept(this);
		this.setName(ast.getIdent().getValue());
		generate();
		return null;
	}

	@Override
	public Object visit(If ast) {
		boolean cond = ast.getCondition().accept(new ExpressionChecker(environment));
		JPanel tru = new UIVisitor(environment, ast.getTrueBlock()).getPanel();
		JPanel fls = new UIVisitor(environment, ast.getFalseBlock()).getPanel();
		tru.setVisible(cond);
		fls.setVisible(!cond);
		add(tru);
		add(fls);
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
		System.out.println(environment.getIdent(ast.getIdent()).getValue().getValue().toString());
		wrap.setValue(environment.getIdent(ast.getIdent()).getValue().getValue().toString());
		WrapperEventListener listener = new WrapperEventListener() {
			@Override
			public void change(WrapperEvent event) {
				System.out.println(event.getWrap().getEnv().getValEnv());
				System.out.println(event.getWrap().getValue());
				System.out.println(castValue(ast.getType(), event.getWrap().getValue()));
				System.out.println(UIVisitor.environment.getValEnv());
				System.exit(0);
				environment.setVal(ast.getIdent(), castValue(ast.getType(), event.getWrap().getValue()));
				environment.notifyObservers(ast.getIdent());
			}
		};
		wrap.addListener(listener);

		add(wrap.getLabel());
		add(wrap.getComponent());
		return null;
	}

	@Override
	public Object visit(QuestionComputed ast) {
		ast.getAssignment().accept(this);
		Wrapper wrap = environment.getIdent(ast.getIdent()).getType().accept(this);
		wrap.setEnabled(false);
		wrap.setLabel(ast.getLabel().getValue());
		wrap.setVisible(true);
		wrap.setValue(environment.getIdent(ast.getIdent()).getValue().getValue().toString());
		add(wrap.getLabel());
		add(wrap.getComponent());
		return null;
	}

	@Override
	public Object visit(Var ast) {
		return null;
	}

	@Override
	public Object visit(Block ast) {
		for (Iterator<Statement> i = ast.iterator(); i.hasNext();)
			i.next().accept(this);
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
		return new JCheckBoxWrap(environment);
	}

	@Override
	public Wrapper visit(Str ast) {
		return new JTextFieldWrap(environment);
	}

	@Override
	public Wrapper visit(Int ast) {
		return new JTextFieldWrap(environment);
	}
}
