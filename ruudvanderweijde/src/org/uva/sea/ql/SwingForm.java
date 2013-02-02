package org.uva.sea.ql;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.stmt.Statement;
import org.uva.sea.ql.ast.stmt.question.ComputedQuestion;
import org.uva.sea.ql.ast.stmt.question.NormalQuestion;

@SuppressWarnings("serial")
public class SwingForm extends JFrame {

    public SwingForm(Form form) {
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		MigLayout layout = new MigLayout("wrap 3","[] [grow] []","[] [grow] [grow] [grow] []");
		setLayout(layout);

		
		//put all the panels together
		JPanel p = new JPanel(new MigLayout("", "[right]"));

		for (Statement stmt : form.getStatements()) {
			if (stmt instanceof ComputedQuestion) {
				p.add(new JLabel(((ComputedQuestion) stmt).getLabel()), "gap 10");
				p.add(new JTextField(""), "span, growx");
			}
			if (stmt instanceof NormalQuestion) {
				p.add(new JLabel(((NormalQuestion) stmt).getLabel()), "gap 10");
				p.add(new JTextField(""), "span, growx");
			}
		}
		
		p.add(new JButton("OK"));
		p.add(new JButton("Clear"));
        pack();
        setVisible(true);
        
        add(p,"grow");
    }
}