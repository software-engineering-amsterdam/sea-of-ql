package org.uva.sea.ql.gui;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.util.List;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.statement.Block;
import org.uva.sea.ql.ast.statement.Form;
import org.uva.sea.ql.ast.statement.IfThen;
import org.uva.sea.ql.ast.statement.IfThenElse;
import org.uva.sea.ql.ast.statement.QuestionAnswerable;
import org.uva.sea.ql.ast.statement.QuestionComputed;
import org.uva.sea.ql.ast.visitor.IVisitorStatement;
import org.uva.sea.ql.ast.visitor.IVisitorType;
import org.uva.sea.ql.gui.widget.ObservableWidget;
import org.uva.sea.ql.gui.widget.ObserverComputed;
import org.uva.sea.ql.gui.widget.ObserverConditionIf;
import org.uva.sea.ql.gui.widget.ObserverConditionIfElse;
import org.uva.sea.ql.gui.widget.VisitorExpressionIdentifiers;
import org.uva.sea.ql.gui.widget.Widget;
import org.uva.sea.ql.gui.widget.WidgetComputed;
import org.uva.sea.ql.gui.widget.WidgetObserver;
import org.uva.sea.ql.util.Environment;

public class VisitorRenderStatement implements IVisitorStatement<Component> {

	private Environment environment;
	
	private VisitorRenderStatement(Environment environment){
		this.environment= environment;
	}
	
	
	private void registerObservers(Expr expr, WidgetObserver observer){
		
		List<Ident> identifiers = expr.accept(new VisitorExpressionIdentifiers());
		
		for(Ident i: identifiers){
			environment.addObserver(i, observer);
		}
	
		observer.evaluate();
	}
	
	
	private void registerObservableWidget(Ident ident, Widget widget){
		ObservableWidget observable = new ObservableWidget(ident, widget, environment);
		environment.putObservable(ident, observable);
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
		Component ifBlock = branch.getIfBlock().accept(this);
		
		panel.add(ifBlock);
		
		ObserverConditionIf observer = 
				new ObserverConditionIf(branch.getIfCondition(), ifBlock, environment); 
		
		registerObservers(branch.getIfCondition(), observer);
		
		return panel;
	}

	@Override
	public Component visit(IfThenElse branch) {
		
		Panel panel = new Panel();
		panel.setLayout(new GridLayout(2,1));
		
		Component ifBlock = branch.getIfBlock().accept(this);
		Component elseBlock = branch.getElseBlock().accept(this);
		
		panel.add(ifBlock);
		panel.add(elseBlock);
		
		ObserverConditionIfElse observer = 
				new ObserverConditionIfElse(branch.getIfCondition(), ifBlock, elseBlock, environment); 
		
		registerObservers(branch.getIfCondition(), observer);
		
		return panel;
	}
	
	@Override
	public Component visit(QuestionAnswerable question) {
		Panel panel = new Panel();
		panel.setLayout(new GridLayout(1,2));
		
		IVisitorType<Widget> visitor = new VisitorRenderType(); 
		Widget widget = question.typeOf(environment).accept(visitor);
		
		registerObservableWidget(question.getIdentifier(), widget);
		
		panel.add(new Label(question.getQuestion()));
		panel.add(widget.getComponent());
		
		return panel;
	}
	
	@Override
	public Component visit(QuestionComputed question) {
		Panel panel = new Panel();
		panel.setLayout(new GridLayout(1,2));
		
		WidgetComputed widget = new WidgetComputed();
		
		registerObservableWidget(question.getIdentifier(), widget);
		
		panel.add(new Label(question.getQuestion()));
		panel.add(widget.getComponent());
		
		ObserverComputed observer = new ObserverComputed(question, widget, environment); 
		registerObservers(question.getValue(), observer);
		
		return panel;
	}
	
	
	public static void Render(Form form){
		VisitorRenderStatement renderer = new VisitorRenderStatement(new Environment());
		Component cmp = renderer.visit(form);
		
		CloseableFrame frame = new CloseableFrame("render test", 500, 500);
		frame.add(cmp);
	}

}
