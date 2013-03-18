package org.uva.sea.ql.interpreter;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.types.AType;
import org.uva.sea.ql.checker.FormChecker;
import org.uva.sea.ql.evaluator.values.AValue;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.test.ParseError;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ApplicationFrame {
	private static JFrame frame;
	private static JPanel panel;
	private static String formString;
	private static State state;
	private static Form form;
	private static ANTLRParser parser;
	private static List<String> errMsgs;
	private static Map<Ident, AType> typeEnv;
	
	public ApplicationFrame(String formStr) {
		frame = new JFrame("Questionnaire");
		formString = formStr;
		state = new State();
		parser = new ANTLRParser();
		errMsgs = new ArrayList<String>();
		typeEnv = new HashMap<Ident, AType>();
	}

	public void showFrame() throws ParseError {
		
		form = parser.parseForm(formString);	
		boolean isValid = FormChecker.check(form, typeEnv, errMsgs);
		
		if (isValid) {
			renderFrame();
		}
		else {
			for (String errM:errMsgs) {
				System.out.println(errM);
			}
		}
	}
	
	public void renderFrame() {
		panel = Renderer.render(form.getBlStmts(), state);
		panel.setVisible(true);
	
		frame.getContentPane().setLayout(new FlowLayout());
		frame.add(panel);
		
		JButton saveBtn = new JButton("Save in XML");
		saveBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				writeXML();					
			}
		});
		frame.add(saveBtn);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,400);
		frame.setVisible(true);
	}
	
	public void writeXML() {
		
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("form");
			rootElement.setAttribute("identifier", form.getIdent().getName());
			doc.appendChild(rootElement);
			
			for (Map.Entry<Ident, AValue> mapEntry : state .valEnv.entrySet()) {
				Element question = doc.createElement("question");
				question.setAttribute("identifier", mapEntry.getKey().getName());
				question.setAttribute("value", mapEntry.getValue().getValue().toString());
				rootElement.appendChild(question);
			}
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("C:\\form.xml"));
			
			transformer.transform(source, result);
		}
		catch (Exception e) {
			System.out.println("File not saved.");
		}
	}
}