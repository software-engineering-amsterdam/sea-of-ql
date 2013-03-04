package org.uva.sea.ql.gui;

import java.awt.Container;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;

import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.statements.Form;
import org.uva.sea.ql.ast.types.literals.QLValue;
import org.uva.sea.ql.ast.visitors.StatementCheckingVisitor;
import org.uva.sea.ql.ast.visitors.StatementRenderingVisitor;
import org.uva.sea.ql.ast.visitors.TypeDefaultValueVisitor;
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

	private Form parseStringFromFile(String filePath) {
		Form form = new Form(new ArrayList<Statement>());
		try {
			FormParser parser = new FormParser();
			form = (Form) parser.parseFromFile(filePath);
		} catch (IOException exception) {

		} catch (ParseException exception) {

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

	public void renderForm(Map<Identifier, QLValue> identifierValueMap) {

		StatementRenderingVisitor statementRenderingVisitor = new StatementRenderingVisitor(
				this, this.identifierTypeMap, identifierValueMap);

		this.form.accept(statementRenderingVisitor);

		this.setSize(600, 1000);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.show();
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

	public void resetContainer() {
		Container container = this.getContentPane();
		container.removeAll();
		container.invalidate();
		container.validate();
	}

}
