package org.uva.sea.ql.form.input.listener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTextArea;
import org.uva.sea.ql.ast.nodes.statements.Statement;
import org.uva.sea.ql.form.input.InputState;
import org.uva.sea.ql.type.checker.QLErrorMessage;
import org.uva.sea.ql.type.checker.QLTypeChecker;

public class TypeCheckActionListener implements ActionListener {
	
	private final JTextArea output;
	private InputState state;
	private JButton show;
	
	public TypeCheckActionListener(InputState state, JTextArea area, JButton show){
		this.output = area;
		this.state = state;
		this.show = show;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Statement stat = this.state.getParsedStatement();
		if(stat != null){
			QLTypeChecker checker = new QLTypeChecker();
    		List<QLErrorMessage> errors = checker.check(stat);
    		if(errors.isEmpty()){
    			this.show.setEnabled(true);
    			output.setBackground(Color.green);
    			output.setText("Check successfull !");
    		} else {
    			output.setBackground(Color.red);
    			output.setText("Type Check Failed ! \n");
    			for(QLErrorMessage err : errors){
    				output.append(err.getError() + "\n");
    			}
    		}
    		output.repaint();
    	}
	}
}
