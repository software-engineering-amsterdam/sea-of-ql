package org.uva.sea.ql.form.input;

import java.awt.Container;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import org.uva.sea.ql.form.gui.state.State;
import org.uva.sea.ql.form.input.listener.InterpreterActionListener;
import org.uva.sea.ql.form.input.listener.TypeCheckActionListener;
import org.uva.sea.ql.form.input.listener.ParseASTTreeActionListener;

public class InputForm extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JTextArea textArea;
	private JTextArea consoleArea;
	private State state;
	private TypeCheckActionListener checkListener;
	private ParseASTTreeActionListener parseListener;
	private InterpreterActionListener interpretListener;
	private InputState inputState = new InputState();
	
	public InputForm(int w, int h){
		this.InitForm(w,h);
		this.InitTextAreas();
	}
	
	private void InitTextAreas(){
		this.textArea = new JTextArea();
		this.consoleArea = new JTextArea();
		
		JButton btn_parse = new JButton("Parse Input content");
		JButton btn_check = new JButton("Check Parsed AST");
		JButton btn_show  = new JButton("Interpret AST");
		
		btn_check.setEnabled(false);
		btn_show.setEnabled(false);
		
		this.parseListener 		= new ParseASTTreeActionListener(inputState, textArea, consoleArea, btn_check);
		this.checkListener 		= new TypeCheckActionListener(inputState, consoleArea, btn_show);
		this.interpretListener 	= new InterpreterActionListener(inputState, state, this);
		
		btn_parse.addActionListener(parseListener);
		btn_check.addActionListener(checkListener);
		btn_show.addActionListener(interpretListener);
		
		String all = getDefaultAssignmentQL();
		
		textArea.setText(all);
		Container container = this.getContentPane();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		container.add(textArea);
		container.add(consoleArea);
		
		container.add(btn_parse);
		container.add(btn_check);
		container.add(btn_show);
		this.pack();
		this.setVisible(true);
	}
	
	private void InitForm(int w, int h){
		setTitle("QL Parser Input Form");
	    setSize(w,h);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	InputForm input = new InputForm(600,800);
                input.setVisible(true);
            }
        });
    }
	
	private String getDefaultAssignmentQL(){
		String all = "form Box1HouseOwning { \n"+
			     "    hasSoldHouse: \"Did you sell a house in 2010 ?\" boolean \n"+
				 "    hasBoughtHouse: \"Did you by a house in 2010 ?\" boolean \n"+
				 "    hasMaintLoan: \"Did you enter a loan for maintenance ?\" boolean \n"+
				 "    if (hasSoldHouse) { \n"+
				 "        sellingPrice: \"Price the house was sold for:\" money \n"+
				 "        privateDebt: \"Private debts for the sold house:\" money \n"+
				 "        valueResidue: \"Value residue:\" money(sellingPrice - privateDebt) \n"+
				 "    } \n"+
				 "} \n";
		return all;
	}
}