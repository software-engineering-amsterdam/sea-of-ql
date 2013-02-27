package org.uva.sea.ql.gui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.statements.Form;
import org.uva.sea.ql.ast.visitors.StatementCheckingVisitor;
import org.uva.sea.ql.ast.visitors.StatementVisitorForRendering;
import org.uva.sea.ql.parsers.FormParser;
import org.uva.sea.ql.parsers.exceptions.ParseException;
import org.uva.sea.ql.parsers.exceptions.QLException;

public class FormPanel extends JFrame {

	private static final long serialVersionUID = 1L;

	public FormPanel() {
	}

	public static void main(String[] args) throws IOException {
		FormPanel rootFrame = new FormPanel();
		try {
			String filePath = "C:\\Tubis\\School\\Software Construction\\QLTest.txt";
			FormParser parser = new FormParser();
			Form rootNode = (Form)parser.parseFromFile(filePath);			
			ValidateIdentifierDefinitions(rootNode);
			
			JPanel rootPanel=new JPanel();
			AddFormOnRootPanel(rootPanel,rootNode);
		
			JScrollPane scrollPane = new JScrollPane(rootPanel);
			rootFrame.add(scrollPane);
			rootFrame.setSize(825, 300);
			rootFrame.setVisible(true);
			rootFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			rootFrame.show();
			
		} catch (ParseException parseException) {
			return;
		}
	}

	private static void ValidateIdentifierDefinitions(Form form){
		StatementCheckingVisitor statementVisitor = new StatementCheckingVisitor();
		form.accept(statementVisitor);		
		
		List<QLException> statementExceptions= new ArrayList<QLException>(statementVisitor.getExceptions());
		printException(statementExceptions);
	}	
	
	private static void printException(List<QLException> exceptions) {		
		for(QLException exception: exceptions){
			System.out.println(exception.ToString());
		}		
	}

	private static void AddFormOnRootPanel(JPanel rootPanel,Form rootNode){
		StatementVisitorForRendering statementVisitor=new StatementVisitorForRendering(rootPanel);
		
		rootNode.accept(statementVisitor);		
	}
}
