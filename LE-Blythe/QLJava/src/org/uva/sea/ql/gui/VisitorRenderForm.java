package org.uva.sea.ql.gui;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.IVisitorStatement;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.statement.Block;
import org.uva.sea.ql.ast.statement.IfThen;
import org.uva.sea.ql.ast.statement.IfThenElse;
import org.uva.sea.ql.ast.statement.QuestionAnswerable;
import org.uva.sea.ql.ast.statement.QuestionComputed;
import org.uva.sea.ql.ast.type.IVisitorType;
import org.uva.sea.ql.gui.control.Applet;
import org.uva.sea.ql.gui.widget.Widget;
import org.uva.sea.ql.gui.widget.WidgetChangeHandler;
import org.uva.sea.ql.gui.widget.WidgetComputed;
import org.uva.sea.ql.gui.widget.WidgetObserver;
import org.uva.sea.ql.gui.widget.WidgetObserverComputed;
import org.uva.sea.ql.gui.widget.WidgetObserverConditionIf;
import org.uva.sea.ql.gui.widget.WidgetObserverConditionIfElse;

public class VisitorRenderForm implements IVisitorStatement<JComponent> {

	private State state;	
	
	private VisitorRenderForm(State state){
		this.state = state;
	}
	
	
	private JPanel createPanel(){
		return new JPanel(new MigLayout("hidemode 2, fillx"));
	}
	
	
	private JButton createSubmitButton(String formName){
		JButton button = new JButton("Submit");
		button.addActionListener(new FormSubmissionHandler(formName, state.getValues()));
		return button;
	}
	
	
	private void registerObservers(Expr expr, WidgetObserver observer){
		
		List<Ident> identifiers = expr.accept(new VisitorExpressionIdentifiers());
		
		for(Ident i: identifiers){
			state.addObserver(i, observer);
		}
	
		observer.evaluate();
	}
	
	
	private void registerWidgetChangeHandler(Ident ident, Widget widget){
		WidgetChangeHandler observable = new WidgetChangeHandler(ident, widget, state.getValues());
		state.putObservable(ident, observable);
	}

	@Override
	public JComponent visit(Form form) {

		JPanel panel = createPanel();
		JButton button = createSubmitButton(form.getName());
		
		panel.add(form.getBlock().accept(this), "wrap");	
		panel.add(button);
		
		return new JScrollPane(panel);
	}
	
	@Override
	public JComponent visit(Block block) {
		State branchedState = state.branchState();
		
		VisitorRenderForm renderer = new VisitorRenderForm(branchedState);
		
		JPanel panel = createPanel();
		
		for(Statement s: block.getStatements())
			panel.add(s.accept(renderer), "wrap");

		return panel;
	}

	@Override
	public JComponent visit(IfThen branch) {
		
		JPanel panel = createPanel();
		
		JComponent ifBlock = branch.getIfBlock().accept(this);
		
		panel.add(ifBlock);
		
		WidgetObserverConditionIf observer = 
				new WidgetObserverConditionIf(branch.getIfCondition(), ifBlock, state.getValues()); 
		
		registerObservers(branch.getIfCondition(), observer);
		
		return panel;
	}

	@Override
	public JComponent visit(IfThenElse branch) {
		
		JPanel panel = createPanel();
		
		JComponent ifBlock = branch.getIfBlock().accept(this);
		JComponent elseBlock = branch.getElseBlock().accept(this);
		
		panel.add(ifBlock);
		panel.add(elseBlock);
		
		WidgetObserverConditionIfElse observer = 
				new WidgetObserverConditionIfElse(branch.getIfCondition(), ifBlock, elseBlock, state.getValues()); 
		
		registerObservers(branch.getIfCondition(), observer);
		
		return panel;
	}
	
	@Override
	public JComponent visit(QuestionAnswerable question) {
		JPanel panel = createPanel();
		
		IVisitorType<Widget> typeToWidget = new VisitorTypeToWidget(); 
		Widget widget = question.getType().accept(typeToWidget);
		
		registerWidgetChangeHandler(question.getIdentifier(), widget);
		
		panel.add(new JLabel(question.getQuestion()));
		panel.add(widget.getControl(), "width 100");
		
		return panel;
	}
	
	@Override
	public JComponent visit(QuestionComputed question) {
		JPanel panel = createPanel();
		
		WidgetComputed widget = new WidgetComputed();
		
		registerWidgetChangeHandler(question.getIdentifier(), widget);
		
		panel.add(new JLabel(question.getQuestion()));
		panel.add(widget.getControl());
		
		WidgetObserverComputed observer = new WidgetObserverComputed(question, widget, state.getValues()); 
		registerObservers(question.getExpression(), observer);

		return panel;
	}
	
	
	public static Applet render(final Form form, final int width, final int height){
		final VisitorRenderForm renderer = new VisitorRenderForm(new State());
		final JComponent ctrl = renderer.visit(form);

		return new Applet(ctrl, form.getName(), width, height);
	}

}
