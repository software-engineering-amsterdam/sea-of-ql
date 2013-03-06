package org.uva.sea.ql.form.input;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.uva.sea.ql.ast.nodes.expressions.Ident;
import org.uva.sea.ql.ast.nodes.statements.Form;
import org.uva.sea.ql.ast.nodes.statements.Statement;
import org.uva.sea.ql.form.gui.state.State;
import org.uva.sea.ql.form.output.visitor.QLFormVisitor;
import org.uva.sea.ql.parser.antlr.QLLexer;
import org.uva.sea.ql.parser.antlr.QLParser;
import org.uva.sea.ql.type.checker.QLErrorMessage;
import org.uva.sea.ql.type.checker.QLTypeChecker;
import org.uva.sea.ql.values.Value;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class InputForm extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JTextArea textArea;
	private JTextArea consoleArea;
	private Statement parsedResult;
	private State state;
	private Ident ident;
	
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
            		QLTypeChecker checker = new QLTypeChecker();
            		List<QLErrorMessage> errors = checker.check(parsedResult);
            		if(errors.isEmpty()){
            			consoleArea.setBackground(Color.green);
            			consoleArea.setText("Check successfull !");
            		} else {
            			consoleArea.setBackground(Color.red);
            			consoleArea.setText("Type Check Failed ! \n");
            			for(QLErrorMessage err : errors){
            				consoleArea.append(err.getError() + "\n");
            			}
            		}
            		consoleArea.repaint();
            	}
            }
        });
		
		btn_show.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e) {
            	if(parsedResult != null){
            		state = new State();
            		JFrame form = new JFrame(); 
            		Form f = (Form)parsedResult;
            		ident = f.getIdent();	
            		Container container = form.getContentPane();
            		container.add(QLFormVisitor.render(parsedResult, state));
            		form.setTitle(ident.getValue());
            		form.setSize(600, 300);
            		form.setVisible(true);
            		JButton save = new JButton("Save");
            		save.setBounds(500, 350, 50, 25);
            		save.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							saveValueEnvironment(state, ident);
						}
					});
            		container.add(save, BorderLayout.PAGE_END);
            	}
            }
        });
		
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
	
	private void saveValueEnvironment(State state, Ident formident){
		State tmpState = state;
		Date now = new Date();
		String filename = "C:\\" + formident.getValue() + "_Questionaire_" + now.getTime() + "_QLJava.xml";
		try {
			 
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	 
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("QLVALUES");
			doc.appendChild(rootElement);
			Map<Ident, Value> map = tmpState.getValueEnv();
			for(Ident i : map.keySet()){
				Element id = doc.createElement("IDENT");
				rootElement.appendChild(id);
				
				Attr attr = doc.createAttribute("identifier");
				attr.setValue(i.getValue());
				id.setAttributeNode(attr);
				
				Element val = doc.createElement("VALUE");
				val.appendChild(doc.createTextNode(map.get(i).toString()));
				id.appendChild(val);
			}
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(filename));
	 		transformer.transform(source, result);
	 		
		  } catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		  } catch (TransformerException tfe) {
			tfe.printStackTrace();
		  }
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
