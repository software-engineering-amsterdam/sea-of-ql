package visitor;
import java.awt.*;
import java.util.Iterator;

import javax.swing.*;

import visitor.checker.ExpressionChecker;
import ast.Form;
import ast.Statement;
import ast.expression.Value;
import ast.statement.Assignment;
import ast.statement.Block;
import ast.statement.Else;
import ast.statement.If;
import ast.statement.QuestionComputed;
import ast.statement.QuestionVar;
import ast.statement.Var;
import ast.statement.Visitor;

public class UIVisitor extends JFrame implements Visitor {
	GridLayout flo = new GridLayout(10,1,10,10);
	private Environment environment;
	
    public UIVisitor(Environment environment) {
        super("QL");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setLayout(flo);
    }
    
    public void generate(){
        pack();
        setVisible(true);
    }
    
    
    
    private void inputField(Value value){
    	inputField(value, false);
    }
    
    private void inputField(Value value, boolean disabled){
    	JTextArea field = new JTextArea(8, 40);
    	field.setEditable(!disabled);
    	field.setText((String) value.getValue());
        add(field);
    }
    
    private void checkBox(String str, boolean checked){
    	checkBox(str,checked,false);
    }
    
    private void checkBox(String str, boolean checked, boolean disabled){
        JCheckBox field = new JCheckBox(str, checked);
        field.setEnabled(!disabled);
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
		if(ast.getCondition().accept(new ExpressionChecker(environment))){
			ast.getBlock().accept(this);
		}
		return null;
	}

	@Override
	public Object visit(QuestionVar ast) {
		//if(environment.getIdent(ast.getIdent()).getType() instanceof ast.type.Bool)
		//{
		//	checkBox(ast.getLabel().getValue(), (boolean) environment.getIdent(ast.getIdent()).getValue().getValue());
		//}
        JCheckBox field = new JCheckBox(ast.getLabel().getValue(), true);    
		add(field);
		return null;
	}

	@Override
	public Object visit(QuestionComputed ast) {
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
    
    
    
    
}
