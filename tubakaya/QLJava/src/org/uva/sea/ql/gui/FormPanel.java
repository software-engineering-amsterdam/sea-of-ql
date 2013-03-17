package org.uva.sea.ql.gui;

import java.awt.Container;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.literals.QLValue;
import org.uva.sea.ql.ast.statements.Form;
import org.uva.sea.ql.ast.visitors.StatementCheckingVisitor;
import org.uva.sea.ql.ast.visitors.StatementRenderingVisitor;
import org.uva.sea.ql.ast.visitors.TypeDefaultValueVisitor;
import org.uva.sea.ql.gui.listeners.SaveButtonListener;
import org.uva.sea.ql.parsers.FormParser;
import org.uva.sea.ql.parsers.exceptions.ParseException;
import org.uva.sea.ql.parsers.exceptions.QLException;

public class FormPanel extends JFrame {

	private static final long serialVersionUID = 1L;

	private Form form;
	private Map<Identifier, org.uva.sea.ql.ast.types.Type> identifierTypeMap;

	public FormPanel() {
		String filePath = "C:\\Tubis\\School\\Software Construction\\QLTest.txt";
		this.form = this.parseStringFromFile(filePath);
		this.identifierTypeMap = this.checkForm(this.form);
	}

	public static void main(String[] args) throws IOException {
		FormPanel rootFrame = new FormPanel();
		Map<Identifier, QLValue> identifierValueMapWithDefaultValues = rootFrame
				.generateIdentifierValueMapWithDefaultValues();
		rootFrame.renderForm(identifierValueMapWithDefaultValues);
	}

	public void renderForm(Map<Identifier, QLValue> identifierValueMap) {

		StatementRenderingVisitor statementRenderingVisitor = new StatementRenderingVisitor(
				this, this.identifierTypeMap, identifierValueMap);

		this.form.accept(statementRenderingVisitor);
		
		JPanel panel = new JPanel(new MigLayout());
		ArrayList<JPanel> renderList=statementRenderingVisitor.getRenderList();
		
		for (int i = 0; i < renderList.size(); i++) {
			panel.add(renderList.get(i), "wrap");
		}
		
		this.addButtons(identifierValueMap,panel);
		JScrollPane scrollPane = new JScrollPane(panel);
		this.add(scrollPane);
		
		int numberOfRows = renderList.size();
		this.setSize(825, numberOfRows * 120);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void resetContainer() {
		Container container = this.getContentPane();
		container.removeAll();
		container.invalidate();
		container.validate();
	}

	private Form parseStringFromFile(String filePath) {
		Form form = new Form(new ArrayList<Statement>());
		try {
			FormParser parser = new FormParser();
			form = (Form) parser.parseFromFile(filePath);
		} catch (IOException exception) {
			System.out.println("An error occurred during reading file. " + exception);
		} catch (ParseException exception) {
			System.out.println("An error occurred during parsing. " + exception);
		}
		return form;
	}

	private Map<Identifier, org.uva.sea.ql.ast.types.Type> checkForm(Form form) {
		StatementCheckingVisitor statementVisitor = new StatementCheckingVisitor();
		form.accept(statementVisitor);

		List<QLException> statementExceptions = new ArrayList<QLException>(
				statementVisitor.getExceptions());
		printException(statementExceptions);

		return statementVisitor.getIdentifierTypeMap();
	}

	private static void printException(List<QLException> exceptions) {
		for (QLException exception : exceptions) {
			System.out.println(exception.ToString());
		}
	}

	private Map<Identifier, QLValue> generateIdentifierValueMapWithDefaultValues() {
		Map<Identifier, QLValue> valueList = new HashMap<Identifier, QLValue>();
		TypeDefaultValueVisitor typeDefaultValueVisitor = new TypeDefaultValueVisitor();

		for (Map.Entry<Identifier, org.uva.sea.ql.ast.types.Type> typeListEntry : this.identifierTypeMap
				.entrySet()) {
			valueList.put(typeListEntry.getKey(), typeListEntry.getValue()
					.accept(typeDefaultValueVisitor));
		}
		return valueList;
	}

	private void addButtons(Map<Identifier, QLValue> identifierValueMap, JPanel panel) {
		JLabel wrapLabel = new JLabel(" ");
		panel.add(wrapLabel, "wrap");
		JButton saveButton = new JButton("Save");
		JPanel auxPanel = new JPanel(new MigLayout());
		auxPanel.add(saveButton, "align center"); 
		saveButton.addActionListener(new SaveButtonListener(identifierValueMap));
		panel.add(auxPanel);
	}
}
