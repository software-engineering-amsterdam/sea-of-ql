package org.uva.sea.ql.gui;

import java.awt.Button;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.ScrollPane;
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
import org.uva.sea.ql.gui.widget.ObserverComputed;
import org.uva.sea.ql.gui.widget.ObserverConditionIf;
import org.uva.sea.ql.gui.widget.ObserverConditionIfElse;
import org.uva.sea.ql.gui.widget.Widget;
import org.uva.sea.ql.gui.widget.WidgetChangeHandler;
import org.uva.sea.ql.gui.widget.WidgetComputed;
import org.uva.sea.ql.gui.widget.WidgetObserver;
import org.uva.sea.ql.interpreter.VisitorExpressionIdentifiers;
import org.uva.sea.ql.util.Environment;

public class VisitorRenderStatement implements IVisitorStatement<Component> {

	private Environment environment;
	
	private VisitorRenderStatement(Environment environment){
		this.environment= environment;
	}
	
	
	private GridLayout vertical(int rows){
		return new GridLayout(rows, 1);
	}
	
	
	private GridLayout horizontal(int columns){
		return new GridLayout(1, columns);
	}
	
	
	private Panel verticalPanel(int rows){
		Panel panel = new Panel();
		//panel.setLayout(vertical(rows));

		return panel;
	}
	
	
	private Panel horizontalPanel(int columns){
		Panel panel = new Panel();
		//panel.setLayout(horizontal(columns));
		return panel;
	}
	
	
	private void registerObservers(Expr expr, WidgetObserver observer){
		
		List<Ident> identifiers = expr.accept(new VisitorExpressionIdentifiers());
		
		for(Ident i: identifiers){
			environment.addObserver(i, observer);
		}
	
		observer.evaluate();
	}
	
	
	private void registerWidgetChangeHandler(Ident ident, Widget widget){
		WidgetChangeHandler observable = new WidgetChangeHandler(ident, widget, environment);
		environment.putObservable(ident, observable);
	}

	@Override
	public Component visit(Form form) {
		
		ScrollPane pane = new ScrollPane(ScrollPane.SCROLLBARS_AS_NEEDED);
	
		Panel panel = new Panel();
		Button button = new Button("submit");
		
		panel.add(form.getBlock().accept(this));
		panel.add(button);
				
		pane.add(panel);
		return pane;
	}
	
	@Override
	public Component visit(Block block) {
		Environment subEnvironment = environment.branchEnvironment();
		
		VisitorRenderStatement renderer = new VisitorRenderStatement(subEnvironment);
		
		Panel panel = verticalPanel(block.getStatements().size());
		
		for(Statement s: block.getStatements())
			panel.add(s.accept(renderer));

		return panel;
	}

	@Override
	public Component visit(IfThen branch) {
		
		Panel panel = verticalPanel(1);
		
		Component ifBlock = branch.getIfBlock().accept(this);
		
		panel.add(ifBlock);
		
		ObserverConditionIf observer = 
				new ObserverConditionIf(branch.getIfCondition(), ifBlock, environment); 
		
		registerObservers(branch.getIfCondition(), observer);
		
		return panel;
	}

	@Override
	public Component visit(IfThenElse branch) {
		
		Panel panel = verticalPanel(2);
		
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
		Panel panel = horizontalPanel(2);
		
		IVisitorType<Widget> visitor = new VisitorRenderType(); 
		Widget widget = question.typeOf(environment).accept(visitor);
		
		registerWidgetChangeHandler(question.getIdentifier(), widget);
		
		panel.add(new Label(question.getQuestion()));
		panel.add(widget.getComponent());
		
		return panel;
	}
	
	@Override
	public Component visit(QuestionComputed question) {
		Panel panel = horizontalPanel(2);
		
		WidgetComputed widget = new WidgetComputed();
		
		registerWidgetChangeHandler(question.getIdentifier(), widget);
		
		panel.add(new Label(question.getQuestion()));
		panel.add(widget.getComponent());
		
		ObserverComputed observer = new ObserverComputed(question, widget, environment); 
		registerObservers(question.getValue(), observer);

		return panel;
	}
	
	
	public static void Render(Form form){
		VisitorRenderStatement renderer = new VisitorRenderStatement(new Environment());
		Component cmp = renderer.visit(form);
		
		CloseableFrame frame = new CloseableFrame(form.getName(), 500, 500);
		
		frame.add(cmp);	
		
	}

}
