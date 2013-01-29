package org.uva.sea.ql.interpretation.swing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.uva.sea.ql.ast.elements.Form;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.common.IOHelper;
import org.uva.sea.ql.common.VisitorDocumentBuilder;
import org.uva.sea.ql.common.VisitorException;
import org.uva.sea.ql.generation.html.HTMLDocument;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.validation.AstValidationError;
import org.uva.sea.ql.validation.Validator;

public class SwingHelper {
	private String fileContent;
	private Expr ast;
	private JTextArea log;
	private JButton buttonGenerate;
	private JPanel centerPanel;

	public SwingHelper(Expr ast, JTextArea log, JButton buttonGenerate,
			JPanel centerPanel) {
		this.ast = ast;
		this.log = log;
		this.buttonGenerate = buttonGenerate;
		this.centerPanel = centerPanel;
	}

	public void openFile(File file) {
		try {
			fileContent = IOHelper.read(file);
			log.append("file opened\n");
			parseFile();
		} catch (IOException ex) {
			log.append("error reading file");
		}
	}

	private void parseFile() {
		if (fileContent != null) {
			IParse p = new ANTLRParser();
			try {
				ast = p.parseDefaultFile();
				log.append("File parsed\n");
				validateAst();
			} catch (ParseError e) {
				log.append(e.getMessage());
			}
		}
	}

	private void validateAst() {
		Validator v = new Validator();
		try {
			v.validate(ast);
			log.append("AST validated\n");
			interpretAst();
			buttonGenerate.setEnabled(true);
		} catch (AstValidationError ex) {
			log.append(ex.getMessage() + "\n");
		} catch (IOException e1) {
			log.append(e1.getMessage() + "\n");
		}
	}

	private void interpretAst() {
		VisitorDocumentBuilder visitor = new VisitorDocumentBuilder(
				new SwingDocument());
		if (ast != null && ast instanceof Form) {
			try {
				((Form) ast).accept(visitor);
				JPanel result = (JPanel) visitor.getOutput();
				centerPanel.add(result);
				result.setVisible(true);
				centerPanel.repaint();
				log.append("interpretation finished\n");
			} catch (VisitorException ex) {
				log.append(ex.getMessage() + "\n");
			}

		} else {
			log.append("AST INVALID\n");
		}
	}

	public void generateHtml() {

		if (ast != null && ast instanceof Form) {
			try {
				VisitorDocumentBuilder visitor = new VisitorDocumentBuilder(
						new HTMLDocument());
				Form f = (Form) ast;
				f.accept(visitor);
				String output = (String) visitor.getOutput();
				IOHelper.write(IOHelper.OUT_PATH + f.getName() + ".html",
						output);
				log.append(IOHelper.OUT_PATH + f.getName() + " created\n");
			} catch (VisitorException ex) {
				log.append(ex.getMessage());
			} catch (FileNotFoundException ex) {
				log.append(ex.getMessage());
			}
		} else {
			log.append("invalid AST\n");
		}

	}

}
