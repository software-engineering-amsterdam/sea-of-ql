package org.uva.sea.ql.gui;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.statement.Block;
import org.uva.sea.ql.ast.statement.Form;
import org.uva.sea.ql.ast.statement.IfThen;
import org.uva.sea.ql.ast.statement.IfThenElse;
import org.uva.sea.ql.ast.statement.QuestionAnswerable;
import org.uva.sea.ql.ast.statement.QuestionComputed;
import org.uva.sea.ql.interfaces.IVisitorStatement;
import org.uva.sea.ql.interfaces.IVisitorType;
import org.uva.sea.ql.observers.AnswerableObservable;
import org.uva.sea.ql.util.Environment;

public class VisitorRenderStatement implements IVisitorStatement<Component> {

	private Environment environment;
	
	private VisitorRenderStatement(Environment environment){
		this.environment= environment;
	}
	
	
	@Override
	public Component visit(Form form) {
		Panel panel = new Panel();
		
		panel.add(form.getBlock().accept(this));
		return panel;
	}

	@Override
	public Component visit(Block block) {
		Environment subEnvironment = environment.branchEnvironment();
		
		VisitorRenderStatement renderer = new VisitorRenderStatement(subEnvironment);
		
		int rows = block.getStatements().size();
		
		Panel panel = new Panel();
		panel.setLayout(new GridLayout(rows,1));
		
		for(Statement s: block.getStatements())
			panel.add(s.accept(renderer));
		
		return panel;
	}

	@Override
	public Component visit(IfThen branch) {
		
		Panel panel = new Panel();
		panel.add(branch.getIfBlock().accept(this));
		
		return panel;
	}

	@Override
	public Component visit(IfThenElse branch) {
		
		Panel panel = new Panel();
		panel.add(branch.getIfBlock().accept(this));
		panel.add(branch.getElseBlock().accept(this));
		
		return panel;
	}

	@Override
	public Component visit(QuestionAnswerable question) {
		Panel panel = new Panel();
		panel.setLayout(new GridLayout(1,2));
		
		IVisitorType<Widget> visitor = new VisitorRenderType(); 
		Widget widget = question.typeOf(environment).accept(visitor);
		
		panel.add(new Label(question.getQuestion()));
		panel.add(widget.getComponent());
		
		AnswerableObservable observable = new AnswerableObservable(widget);
		environment.putObservable(question.getIdentifier(), observable);
		
		return panel;
	}

	@Override
	public Component visit(QuestionComputed question) {
		Panel panel = new Panel();
		panel.setLayout(new GridLayout(1,2));
		
		panel.add(new Label(question.getQuestion()));
		panel.add(new Label("to do") );
		
		return panel;
	}
	
	
	public static void Render(Form form){
		VisitorRenderStatement renderer = new VisitorRenderStatement(new Environment());
		Component cmp = renderer.visit(form);
		
		CloseableFrame frame = new CloseableFrame("render test", 500, 500);
		frame.add(cmp);
	}

}
