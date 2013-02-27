package org.uva.sea.form.ql.input;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.uva.sea.form.ql.output.visitor.QLFormVisitor;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.nodes.statements.Statement;
import org.uva.sea.ql.parser.antlr.QLLexer;
import org.uva.sea.ql.parser.antlr.QLParser;
import org.uva.sea.ql.type.checker.visitor.QLCheckVisitor;


public class InputForm extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JTextArea textArea;
	private JTextArea consoleArea;
	private Expr parsedResult;
	
	public InputForm(int w, int h){
		InitForm(w,h);
		InitTextArea();
	}
	
	private void InitTextArea(){
		textArea = new JTextArea();
		consoleArea = new JTextArea();
		JButton btn_parse = new JButton("Parse TextArea content");
		JButton btn_check = new JButton("Check TextArea content");
		JButton btn_show = new JButton("Show Generated QL Form");
		
		btn_parse.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e) {
            	ANTLRStringStream stream = new ANTLRStringStream(textArea.getText());
        		CommonTokenStream tokens = new CommonTokenStream();
        		tokens.setTokenSource(new QLLexer(stream));
        		QLParser parser = new QLParser(tokens);
        		parsedResult = null;
        		try {
        			parsedResult = parser.start();
        			consoleArea.setBackground(Color.green);
        			consoleArea.setText("Parsing successfull !");
        			consoleArea.repaint();
        		} catch (RecognitionException re) {
        			consoleArea.setBackground(Color.red);
        			consoleArea.setText(re.getMessage());
        			consoleArea.repaint();
        		}
            }
        });      
		
		btn_check.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e) {
            	if(parsedResult != null){
            		QLCheckVisitor bcv = new QLCheckVisitor();
            		Statement statement = (Statement)parsedResult;
            		statement.accept(bcv);
            		consoleArea.setBackground(Color.green);
        			consoleArea.setText("Check successfull !");
        			consoleArea.repaint();
            	}
            }
        });
		
		btn_show.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e) {
            	if(parsedResult != null){
            		QLFormVisitor bcv = new QLFormVisitor();
            		Statement statement = (Statement)parsedResult;
            		statement.accept(bcv);
            		JFrame form = bcv.getGeneratedForm();
            		form.setVisible(true);
            	}
            }
        });
		
		String all = "form Box1HouseOwning { \n"+
				     "    hasSoldHouse: \"Did you sell a house in 2010?\" boolean \n"+
					 "    hasBoughtHouse: \"Did you by a house in 2010?\" boolean \n"+
					 "    hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean \n"+
					 "    if (hasSoldHouse) { \n"+
					 "        sellingPrice: \"Price the house was sold for:\" money \n"+
					 "        privateDebt: \"Private debts for the sold house:\" money \n"+
					 "        valueResidue: \"Value residue:\" money(sellingPrice - privateDebt) \n"+
					 "    } \n"+
				     "} \n";
		
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
            	InputForm input = new InputForm(400,600);
                input.setVisible(true);
            }
        });
    }
}
