package org.uva.sea.ql.gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.gui.control.display.StringProducer;
import org.uva.sea.ql.gui.misc.ValueState;
import org.uva.sea.ql.parser.antlr.FormParser;
import org.uva.sea.ql.parser.antlr.ParseError;
import org.uva.sea.ql.parser.evaluator.result.Value;
import org.uva.sea.ql.parser.typechecker.TypeCheckerState;
import org.uva.sea.ql.parser.typechecker.FormTypeChecker;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class MainWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	private ValueState valueState;
	private String formName;
	private String outputFile;
	private String inputFile;
	
	public MainWindow(String inputFile, String outputFile) {
		this.inputFile = inputFile;
		this.outputFile = outputFile;
		
		initUI();
		render();
	}

	private String getFormName() {
		return formName;
	}
	
	private void setFormName(String formName) {
		this.formName = formName;
	}
	
	private ValueState getValueState() {
		return valueState;
	}

	private void setValueState(ValueState valueState) {
		this.valueState = valueState;
	}
	
	private String getOutputFile() {
		return outputFile;
	}
	
	private String getInputFile() {
		return inputFile;
	}

	private void initUI() {
		setTitle("QL Form 5000");
		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent e) {
		       writeXML(getOutputFile());
		    }
		});
	}
	
	private void render() {
		FormParser formParser = new FormParser();
		TypeCheckerState environment = new TypeCheckerState();
		FormTypeChecker typeChecker = new FormTypeChecker(environment);
		String syntaxErrorsString = "";

		String sourceText = loadFileContents(getInputFile());

		if (sourceText != null) {
			try {
				/* stream to collect error output */
				OutputStream errorStream = new ByteArrayOutputStream();

				/* parse */
				Form form = formParser.parse(sourceText, errorStream);

				setFormName(form.getName());
						
				/* get syntax errors, if any */
				syntaxErrorsString = errorStream.toString();
				
				setValueState(new ValueState());

				if (form.accept(typeChecker)) {
					JPanel mainPanel = Renderer.render(form, getValueState());
					this.add(mainPanel);
				} else {
					typeErrors(environment.getErrorsString());
				}
			} catch (ParseError e) {
				syntaxErrors(syntaxErrorsString);
			}
		}
	}

	private void writeXML(String fileName) {
		DocumentBuilderFactory docFactory =
				DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = null;
		
		try {
			docBuilder = docFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			writeError(e.getMessage());
		}
		
		Map<Ident, Value> symbolTable = getValueState().getSymbolTable();
		
		// root elements
		Document doc = docBuilder.newDocument();
		
		Element root = doc.createElement("form");
		root.setAttribute("name", getFormName());
		
		doc.appendChild(root);
		
		for (Map.Entry<Ident, Value> symbol : symbolTable.entrySet()) {
			Element question = doc.createElement("question");
			question.setAttribute("id", symbol.getKey().getName());
			question.setAttribute("value", StringProducer.toString(symbol.getValue()));
			root.appendChild(question);
		}
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = null;
		try {
			transformer = transformerFactory.newTransformer();
		} catch (TransformerConfigurationException e) {
			writeError(e.getMessage());
			return;
		}
		
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(fileName));
		
		try {
			transformer.transform(source, result);
		} catch (TransformerException e) {
			writeError(e.getMessage());
		}
		
	}

	private void writeError(String message) {
		displayError("Error", "Error saving XML file:\n" + message);
	}
	
	private void syntaxErrors(String errors) {
		displayError("Invalid syntax", "Syntax errors were found:\n" + errors);
	}

	private void typeErrors(String errors) {
		displayError("Invalid error(s)", "Type errors were found:\n" + errors);
	}
	
	private void displayError(String title, String message) {
		JOptionPane.showMessageDialog(this, message, title,
				JOptionPane.ERROR_MESSAGE);
	}

	private String loadFileContents(String fileName) {
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		File file = new File(fileName);
		InputStream inputStream;
		String text;
		byte[] temp;
		int read;

		try {
			inputStream = new FileInputStream(fileName);
			temp = new byte[1024];
			while ((read = inputStream.read(temp)) >= 0) {
				buffer.write(temp, 0, read);
			}
			text = new String(buffer.toByteArray());
		} catch (FileNotFoundException e) {
			displayError("File not found", "File \"" + file + "\" not found");
			text = null;
		} catch (IOException e) {
			displayError("IO Error", "IO Exception while reading file");
			text = null;
		}

		return text;
	}
}
