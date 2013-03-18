package org.uva.sea.ql.form.input.listener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTextArea;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.uva.sea.ql.ast.nodes.statements.Statement;
import org.uva.sea.ql.form.input.InputState;
import org.uva.sea.ql.parser.antlr.QLLexer;
import org.uva.sea.ql.parser.antlr.QLParser;
import org.uva.sea.ql.parser.antlr.error.ANTLRError;

public class ParseASTTreeActionListener implements ActionListener {
	
	private final JTextArea input;
	private final JTextArea output;
	private JButton check;
	private InputState state;
	
	public ParseASTTreeActionListener(InputState inputState, JTextArea inputarea, JTextArea outputarea, JButton check){
		this.input = inputarea;
		this.output = outputarea;
		this.check = check;
		this.state = inputState;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ANTLRStringStream stream = new ANTLRStringStream(this.input.getText());
		CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(new QLLexer(stream));
		QLParser parser = new QLParser(tokens);
		Statement stat = null;
		this.check.setEnabled(false);
		try {
			stat = parser.start();
			List<ANTLRError> error = parser.getErrors();
			if(stat != null && error.isEmpty() ){
				this.output.setBackground(Color.green);
				this.output.setText("Parsing successfull !");
				this.state.setParsedStatement(stat);
				this.check.setEnabled(true);
			} else {
				this.output.setText("Parsing failed !");
				this.output.setBackground(Color.red);
				for(ANTLRError err : error){
					this.output.setText(err.toString());
				}
			}
		} catch (RecognitionException re) {
			this.output.setBackground(Color.red);
			this.output.setText("PareseException : " + re.getMessage());
		}
	}
}
