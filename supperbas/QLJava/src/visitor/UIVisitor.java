package visitor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.util.Iterator;
import java.util.Map;

import javax.swing.*;

import visitor.checker.ExpressionChecker;
import visitor.evaluator.Bindable;
import ast.Form;
import ast.Statement;
import ast.expression.Ident;
import ast.expression.Value;
import ast.statement.*;

public class UIVisitor extends JFrame implements Visitor, ActionListener {
	GridLayout flo = new GridLayout(0, 1);
	private static Environment environment;

	public UIVisitor(Environment environment) {
		super("QL");
		System.out.println(environment.getValEnv().entrySet());
		this.environment = environment;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(flo);
	}

	public void generate() {
		pack();
		setVisible(true);
	}

	private void inputField(String str, Ident ident, Value value) {
		inputField(str, ident, value, false);
	}

	private void inputField(String str, final Ident ident, Value value, boolean disabled) {
		JLabel label = new JLabel(str);
		label.setSize(100, 20);
		add(label);
		JTextField field = new JTextField(value.getValue().toString());
		field.setEditable(!disabled);
		field.addActionListener(new ActionListener(){
	        @Override
	        public void actionPerformed(ActionEvent evt) {
	            final Environment env = environment;
	            Bindable bind = env.getIdent(ident);
	            JTextField source = (JTextField) evt.getSource();
	            System.out.println(env.getValEnv());
	            System.out.println(environment.getValEnv().keySet());
	            System.exit(0);
	            bind.setValue(castValue(bind.getType(),source.getText()));
	            Iterator it = env.getValEnv().entrySet().iterator();
	    		while(it.hasNext())
	    		{
	    			Map.Entry tmp = (Map.Entry)it.next();
	    	        System.out.println(tmp.getKey() + " = "+((Bindable) tmp.getValue()).getType() + "("+ ((Bindable) tmp.getValue()).getValue() + ")");
	    	        it.remove();
	    		}
	        }
	    });
		add(field);
	}

	private void checkBox(String str, final Ident ident, boolean checked) {
		checkBox(str, ident, checked, false);
	}

	private void checkBox(String str, final Ident ident, boolean checked, boolean disabled) {
		JCheckBox field = new JCheckBox(str, checked);
		field.setEnabled(!disabled);
		field.addActionListener(new ActionListener(){
	        @Override
	        public void actionPerformed(ActionEvent evt) {
	            Environment env = environment;
	            Bindable bind = env.getIdent(ident);
	            JTextField source = (JTextField) evt.getSource();
	            bind.setValue(castValue(bind.getType(),source.getText()));
	            Iterator it = env.getValEnv().entrySet().iterator();
	    		while(it.hasNext())
	    		{
	    			Map.Entry tmp = (Map.Entry)it.next();
	    	        System.out.println(tmp.getKey() + " = "+((Bindable) tmp.getValue()).getType() + "("+ ((Bindable) tmp.getValue()).getValue() + ")");
	    	        it.remove();
	    		}
	        }
	    });
		add(field);
	}

	@Override
	public Object visit(Assignment ast) {
		return null;
	}

	@Override
	public Object visit(Else ast) {
		return null;
	}

	@Override
	public Object visit(Form ast) {
		ast.getContent().accept(this);
		generate();
		return null;
	}

	@Override
	public Object visit(If ast) {
		if (ast.getCondition().accept(new ExpressionChecker(environment))) {
			ast.getBlock().accept(this);
		}
		return null;
	}

	@Override
	public Object visit(QuestionVar ast) {
		if (environment.getIdent(ast.getIdent()).getType() instanceof ast.type.Bool)
			checkBox(ast.getLabel().getValue(), ast.getIdent(),
					(boolean) environment.getIdent(ast.getIdent()).getValue()
							.getValue());
		else
			inputField(ast.getLabel().getValue(), ast.getIdent(),
					environment.getIdent(ast.getIdent()).getValue());
		return null;
	}

	@Override
	public Object visit(QuestionComputed ast) {
		if (environment.getIdent(ast.getIdent()).getType() instanceof ast.type.Bool)
			checkBox(ast.getLabel().getValue(), ast.getIdent(),
					(boolean) environment.getIdent(ast.getIdent()).getValue()
							.getValue(), true);
		else
			inputField(ast.getLabel().getValue(), ast.getIdent(),
					environment.getIdent(ast.getIdent()).getValue(), true);
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
	
	public void test(){
		System.out.print("test"+this.environment.getValEnv().keySet());
	}

	public void actionPerformed(ActionEvent ae) {
		Environment environment = UIVisitor.environment;
		this.test();
		System.out.println(UIVisitor.environment.getValEnv().keySet());
		if(ae.getSource() instanceof JTextField){
			System.out.println(environment.getValEnv().entrySet());
			JTextField source = (JTextField) ae.getSource();
			System.out.println(source.getText());
		}else{
			System.out.println("B");
		}
		//JTextField source = (JTextField) ae.getSource();
		System.out.println("X");
		//source.transferFocus(); // Note: triggers focus lost event
	}

	public void focusGained(FocusEvent fe) {
		System.out.println("X");
	}

	public void focusLost(FocusEvent fe) {
		System.out.println("X");
		// The Error dialog, when invoked, causes a temporary lost of focus.
		// Exit now (otherwise an infinite loop results).
		if (fe.isTemporary())
			return;

		// if reached here, source must be a JTextField

		JTextField source = (JTextField) fe.getSource();
/*
		if (source == messageInput)
			update();
		else if (validate(source))
			update();
			*/
	}

	
	public Value castValue(ast.Type type, String str){
		if(type instanceof ast.type.Str)
			return new ast.expression.value.Str(str);
		if(type instanceof ast.type.Int)
			return new ast.expression.value.Int(Integer.getInteger(str));
		if(type instanceof ast.type.Bool)
			return new ast.expression.value.Bool(Boolean.getBoolean(str));
		return null;
	}
}
