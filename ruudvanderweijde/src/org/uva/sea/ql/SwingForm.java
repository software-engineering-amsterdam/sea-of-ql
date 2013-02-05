package org.uva.sea.ql;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.stmt.Statement;
import org.uva.sea.ql.ast.stmt.question.ComputedQuestion;
import org.uva.sea.ql.ast.stmt.question.NormalQuestion;
import org.uva.sea.ql.type.BooleanType;


@SuppressWarnings("serial")
public class SwingForm extends JFrame {
	private Form form;
	
    public SwingForm(Form form) {
    	this.form = form;
    }
    
    public void buildForm () {
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
		MigLayout layout = new MigLayout("wrap 3","[] [grow] []","[] [grow] [grow] [grow] []");
		setLayout(layout);
		pack();
		
		//put all the panels together
		JPanel p = new JPanel(new MigLayout("", "[right]"));

		for (Statement stmt : form.getStatements()) {
			if (stmt instanceof ComputedQuestion) {
				p.add(new JLabel(((ComputedQuestion) stmt).getLabel()), "gap 10");
				org.uva.sea.ql.type.Type type = ((ComputedQuestion) stmt).getType();
				if (type instanceof BooleanType) {
					JCheckBox field = new JCheckBox("");
					p.add(field, "span, growx");
				} else {
					p.add(new JTextField(((ComputedQuestion) stmt).getId().getName()), "span, growx");
				}
			}
			if (stmt instanceof NormalQuestion) {
				p.add(new JLabel(((NormalQuestion) stmt).getLabel()), "gap 10");
				JTextField field = new JTextField(((NormalQuestion) stmt).getId().getName());
				field.setEditable(false);
				p.add(field, "span, growx");
			}
		}
		
		p.add(new JButton("Submit form"), "span, growx");
        setVisible(true);
        
        add(p,"grow");
        pack();
    }
}