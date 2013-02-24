package org.uva.sea.ql.gui;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.ast.form.Body;
import org.uva.sea.ql.ast.form.Computed;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.form.IfElseStatement;
import org.uva.sea.ql.ast.form.IfStatement;
import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.ast.visitor.FormVisitor;

public class Renderer implements FormVisitor<Void> {
	private JPanel panel;
	private State state;
	
	private Renderer(State state) {
		this.panel = new JPanel(new MigLayout());
		this.state = state;
	}
	
	public JPanel getPanel() {
		return panel;
	}
	
	public State getState() {
		return state;
	}

	public static JPanel render(Form form, State state) {
		Renderer renderer = new Renderer(state);
		form.accept(renderer);
		return renderer.getPanel();
	}
	
	@Override
	public Void visit(Form ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(Body ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(IfStatement ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(IfElseStatement ast) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Void visit(Question ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(Computed ast) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
