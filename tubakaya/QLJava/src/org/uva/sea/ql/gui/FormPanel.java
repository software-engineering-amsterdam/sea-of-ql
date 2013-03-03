package org.uva.sea.ql.gui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

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

	public FormPanel() {
	}

	public static void main(String[] args) throws IOException {
		FormPanel rootFrame = new FormPanel();
		String filePath = "C:\\Tubis\\School\\Software Construction\\QLTest.txt";

		Form form = rootFrame.parseStringFromFile(filePath);
		Map<Identifier, org.uva.sea.ql.ast.types.Type> identifierTypeMap = rootFrame
				.checkForm(form);

		rootFrame.renderForm(form, identifierTypeMap);
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

	private void renderForm(Form form,
			Map<Identifier, org.uva.sea.ql.ast.types.Type> identifierTypeMap) {

		JPanel rootPanel = new JPanel();
		Map<Identifier, QLValue> identifierValueMapWithDefaultValues = generateIdentifierValueMapWithDefaultValues(identifierTypeMap);

		StatementRenderingVisitor statementRenderingVisitor = new StatementRenderingVisitor(
				rootPanel, identifierTypeMap,
				identifierValueMapWithDefaultValues);

		form.accept(statementRenderingVisitor);

		JScrollPane scrollPane = new JScrollPane(rootPanel);
		this.add(scrollPane);
		this.setSize(825, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.show();
	}

	private Map<Identifier, QLValue> generateIdentifierValueMapWithDefaultValues(
			Map<Identifier, org.uva.sea.ql.ast.types.Type> identifierTypeMap) {
		Map<Identifier, QLValue> valueList = new HashMap<Identifier, QLValue>();
		TypeDefaultValueVisitor typeDefaultValueVisitor = new TypeDefaultValueVisitor();

		for (Map.Entry<Identifier, org.uva.sea.ql.ast.types.Type> typeListEntry : identifierTypeMap
				.entrySet()) {
			valueList.put(typeListEntry.getKey(), typeListEntry.getValue()
					.accept(typeDefaultValueVisitor));
		}
		return valueList;
	}

}
