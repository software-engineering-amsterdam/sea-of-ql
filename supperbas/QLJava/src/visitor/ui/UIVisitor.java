package visitor.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observer;

import javax.swing.*;

import visitor.Environment;
import visitor.evaluator.ExpressionEvaluator;
import visitor.ui.wrapper.*;
import ast.Form;
import ast.Statement;
import ast.expression.Ident;
import ast.expression.Value;
import ast.statement.*;
import ast.type.Bool;
import ast.type.Int;
import ast.type.Str;

@SuppressWarnings("serial")
public class UIVisitor extends JFrame implements ast.statement.Visitor<Object>, ast.type.Visitor<Wrapper> {
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
		
		// we reverse the list here so we get a properly generated UI
		ArrayList<Statement> statements = reverseList(ast.getStatements());
		for (Statement i : statements)
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
		ast.expression.value.Bool value = (ast.expression.value.Bool) ast.getCondition().accept(new ExpressionEvaluator(environment));
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
	public Object visit(QuestionComputed ast) {
		ast.getAssignment().accept(this);
		
		Wrapper wrap = environment.getIdent(ast.getIdent()).getType().accept(this);
		wrap.setEnabled(false);
		wrap.setLabel(ast.getLabel().getValue());
		wrap.setVisible(true);
		wrap.setValue(environment.getIdent(ast.getIdent()).getValueToString());
		
		ComputedObserver ob = new ComputedObserver(wrap, environment, ast);
		for (Iterator<Ident> i = ast.getAssignment().getExpression().getIdents().iterator(); i.hasNext();)
			environment.addObserver(i.next(), ob);
		
		panel.add(wrap.getLabel());
		panel.add(wrap.getComponent());
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
			return new ast.expression.value.Int(Integer.parseInt(str));
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
	
	public ArrayList<Statement> reverseList(List<Statement> list){
		ArrayList<Statement> reversedList = new ArrayList<Statement>();
		for (int i = list.size() - 1; i >= 0; i--)
			reversedList.add(list.get(i));
		return reversedList;
	}
}
