package org.uva.sea.ql.gui;

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
import org.uva.sea.ql.gui.control.Applet;
import org.uva.sea.ql.gui.control.Button;
import org.uva.sea.ql.gui.control.Control;
import org.uva.sea.ql.gui.control.Label;
import org.uva.sea.ql.gui.control.Panel;
import org.uva.sea.ql.gui.control.ScrollPane;
import org.uva.sea.ql.gui.widget.Widget;
import org.uva.sea.ql.gui.widget.WidgetChangeHandler;
import org.uva.sea.ql.gui.widget.WidgetComputed;
import org.uva.sea.ql.gui.widget.WidgetObserver;
import org.uva.sea.ql.gui.widget.WidgetObserverComputed;
import org.uva.sea.ql.gui.widget.WidgetObserverConditionIf;
import org.uva.sea.ql.gui.widget.WidgetObserverConditionIfElse;
import org.uva.sea.ql.util.Environment;

public class VisitorRenderStatement implements IVisitorStatement<Control> {

	private Environment environment;
	
	private VisitorRenderStatement(Environment environment){
		this.environment= environment;
	}
	
	
	private Panel panel(){
		return new Panel("hidemode 2, fillx");
	}
	
	
	private Button submitButton(String formName){
		Button button = new Button("Submit");
		button.addActionListener(new FormSubmissionHandler(formName, environment));
		return button;
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
	public Control visit(Form form) {

		Panel panel = panel();
		Button button = submitButton(form.getName());
		
		panel.add(form.getBlock().accept(this), "wrap");	
		panel.add(button);
		
		return new ScrollPane(panel);
	}
	
	@Override
	public Control visit(Block block) {
		Environment subEnvironment = environment.branchEnvironment();
		
		VisitorRenderStatement renderer = new VisitorRenderStatement(subEnvironment);
		
		Panel panel = panel();
		
		for(Statement s: block.getStatements())
			panel.add(s.accept(renderer), "wrap");

		return panel;
	}

	@Override
	public Control visit(IfThen branch) {
		
		Panel panel = panel();
		
		Control ifBlock = branch.getIfBlock().accept(this);
		
		panel.add(ifBlock);
		
		WidgetObserverConditionIf observer = 
				new WidgetObserverConditionIf(branch.getIfCondition(), ifBlock, environment); 
		
		registerObservers(branch.getIfCondition(), observer);
		
		return panel;
	}

	@Override
	public Control visit(IfThenElse branch) {
		
		Panel panel = panel();
		
		Control ifBlock = branch.getIfBlock().accept(this);
		Control elseBlock = branch.getElseBlock().accept(this);
		
		panel.add(ifBlock);
		panel.add(elseBlock);
		
		WidgetObserverConditionIfElse observer = 
				new WidgetObserverConditionIfElse(branch.getIfCondition(), ifBlock, elseBlock, environment); 
		
		registerObservers(branch.getIfCondition(), observer);
		
		return panel;
	}
	
	@Override
	public Control visit(QuestionAnswerable question) {
		Panel panel = panel();
		
		IVisitorType<Widget> visitor = new VisitorRenderType(); 
		Widget widget = question.typeOf(environment).accept(visitor);
		
		registerWidgetChangeHandler(question.getIdentifier(), widget);
		
		panel.add(new Label(question.getQuestion()));
		panel.add(widget.getControl(), "width 100");
		
		return panel;
	}
	
	@Override
	public Control visit(QuestionComputed question) {
		Panel panel = panel();
		
		WidgetComputed widget = new WidgetComputed();
		
		registerWidgetChangeHandler(question.getIdentifier(), widget);
		
		panel.add(new Label(question.getQuestion()));
		panel.add(widget.getControl());
		
		WidgetObserverComputed observer = new WidgetObserverComputed(question, widget, environment); 
		registerObservers(question.getValue(), observer);

		return panel;
	}
	
	
	public static void Render(final Form form, final int width, final int height){
		final VisitorRenderStatement renderer = new VisitorRenderStatement(new Environment());
		final Control ctrl = renderer.visit(form);

		new Applet(ctrl, form.getName(), width, height);
	}

}
