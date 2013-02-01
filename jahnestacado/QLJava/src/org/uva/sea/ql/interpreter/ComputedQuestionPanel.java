package org.uva.sea.ql.interpreter;

import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.ast.expr.values.Value;
import org.uva.sea.ql.ast.form.ComputedQuestion;

public class ComputedQuestionPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ComputedQuestionPanel(final ComputedQuestion qlElement,Value expr,Map<String,Value> declaredVar){
		this.setLayout(new MigLayout("","[right][][]","[]"));
		JLabel label=new JLabel(qlElement.getId().getName());
		JButton input=new JButton("ok");
		input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                System.out.println(qlElement.getId().getName());
            }
        });
		JTextField input2=new JTextField(expr.getValue().toString());
		this.add(label,"align right");
		this.add(input);
		this.add(input2,"wrap");
	}
	
	public JPanel getPanel(){
		return this;
	}

}
