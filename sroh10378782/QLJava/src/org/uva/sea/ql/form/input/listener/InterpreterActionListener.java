package org.uva.sea.ql.form.input.listener;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

import org.uva.sea.ql.ast.nodes.expressions.Ident;
import org.uva.sea.ql.ast.nodes.statements.Form;
import org.uva.sea.ql.ast.nodes.statements.Statement;
import org.uva.sea.ql.form.gui.state.State;
import org.uva.sea.ql.form.input.InputState;
import org.uva.sea.ql.form.output.visitor.QLFormVisitor;

public class InterpreterActionListener implements ActionListener {
	
	private State state;
	private InputState inputState;
	private Ident ident;
	
	public InterpreterActionListener(InputState inputState, State state, JFrame inputForm){
		this.state = state;
		this.inputState = inputState;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Statement stat = this.inputState.getParsedStatement();
		if(stat != null){
			// @TODO outsource Form creation
    		this.state = new State();
    		JFrame form = new JFrame(); 
    		Form f = (Form)stat;
    		this.ident = f.getIdent();	
    		Container container = form.getContentPane();
    		container.add(QLFormVisitor.render(stat, state));
    		form.setTitle(ident.getValue());
    		form.setSize(600, 300);
    		form.setVisible(true);
    		JButton save = new JButton("Save");
    		save.setBounds(500, 350, 50, 25);
    		String path = "C:\\";
    		save.addActionListener(new SaveActionListener(state, ident, path));
    		container.add(save, BorderLayout.PAGE_END);
    	}
	}
}
