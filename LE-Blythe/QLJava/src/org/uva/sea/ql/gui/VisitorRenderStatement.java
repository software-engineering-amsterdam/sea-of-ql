package org.uva.sea.ql.gui;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import net.miginfocom.swing.MigLayout;

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

public class VisitorRenderStatement implements IVisitorStatement<JComponent> {

	private Environment environment;
	
	private VisitorRenderStatement(Environment environment){
		this.environment= environment;
	}
	
	
	private JPanel panel(){
		return new JPanel(new MigLayout("hidemode 2, fillx"));
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
	public JComponent visit(Form form) {

		JPanel panel = panel();
		JButton button = new JButton("submit");
		
		panel.add(form.getBlock().accept(this), "wrap");	
		panel.add(button);
		
		return new JScrollPane(panel);
	}
	
	@Override
	public JComponent visit(Block block) {
		Environment subEnvironment = environment.branchEnvironment();
		
		VisitorRenderStatement renderer = new VisitorRenderStatement(subEnvironment);
		
		JPanel panel = panel();
		
		for(Statement s: block.getStatements())
			panel.add(s.accept(renderer), "wrap");

		return panel;
	}

	@Override
	public JComponent visit(IfThen branch) {
		
		JPanel panel = panel();
		
		JComponent ifBlock = branch.getIfBlock().accept(this);
		
		panel.add(ifBlock);
		
		ObserverConditionIf observer = 
				new ObserverConditionIf(branch.getIfCondition(), ifBlock, environment); 
		
		registerObservers(branch.getIfCondition(), observer);
		
		return panel;
	}

	@Override
	public JComponent visit(IfThenElse branch) {
		
		JPanel panel = panel();
		
		JComponent ifBlock = branch.getIfBlock().accept(this);
		JComponent elseBlock = branch.getElseBlock().accept(this);
		
		panel.add(ifBlock);
		panel.add(elseBlock);
		
		ObserverConditionIfElse observer = 
				new ObserverConditionIfElse(branch.getIfCondition(), ifBlock, elseBlock, environment); 
		
		registerObservers(branch.getIfCondition(), observer);
		
		return panel;
	}
	
	@Override
	public JComponent visit(QuestionAnswerable question) {
		JPanel panel = panel();
		
		IVisitorType<Widget> visitor = new VisitorRenderType(); 
		Widget widget = question.typeOf(environment).accept(visitor);
		
		registerWidgetChangeHandler(question.getIdentifier(), widget);
		
		panel.add(new JLabel(question.getQuestion()));
		panel.add(widget.getComponent(), "width 100");
		
		return panel;
	}
	
	@Override
	public JComponent visit(QuestionComputed question) {
		JPanel panel = panel();
		
		WidgetComputed widget = new WidgetComputed();
		
		registerWidgetChangeHandler(question.getIdentifier(), widget);
		
		panel.add(new JLabel(question.getQuestion()));
		panel.add(widget.getComponent());
		
		ObserverComputed observer = new ObserverComputed(question, widget, environment); 
		registerObservers(question.getValue(), observer);

		return panel;
	}
	
	
	public static void Render(final Form form, final int width, final int height){
		final VisitorRenderStatement renderer = new VisitorRenderStatement(new Environment());
		final JComponent cmp = renderer.visit(form);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	JFrame frame = new CloseableFrame(form.getName(), width, height); 
                frame.getContentPane().add(cmp);
            }
         });
	}

}
