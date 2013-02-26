package org.uva.sea.ql.gui;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.gui.misc.ValueState;
import org.uva.sea.ql.parser.antlr.FormParser;
import org.uva.sea.ql.parser.antlr.ParseError;
import org.uva.sea.ql.parser.typechecker.TypeCheckerState;
import org.uva.sea.ql.parser.typechecker.FormTypeChecker;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	public MainWindow(String fileName) {
		initUI();
		render(fileName);
	}

	private final void initUI() {
		setTitle("QL Form 5000");
		setSize(300, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void render(String fileName) {
		FormParser formParser = new FormParser();
		TypeCheckerState environment = new TypeCheckerState();
		FormTypeChecker typeChecker = new FormTypeChecker(environment);
		String syntaxErrorsString = "";

		String sourceText = loadFileContents(fileName);

		if (sourceText != null) {
			try {
				/* stream to collect error output */
				ByteArrayOutputStream errorStream = new ByteArrayOutputStream();

				/* parse */
				Form form = formParser.parse(sourceText, errorStream);

				/* get syntax errors, if any */
				syntaxErrorsString = errorStream.toString();

				if (form.accept(typeChecker)) {
					JPanel mainPanel = Renderer.render(form, new ValueState());
					this.add(mainPanel);
				} else {
					typeErrors(environment.getErrorsString());
				}
			} catch (ParseError e) {
				syntaxErrors(syntaxErrorsString);
			}
		}
	}

	private void syntaxErrors(String errors) {
		String message = "Syntax errors were found:\n" + errors;
		JOptionPane.showMessageDialog(this, message, "Invalid syntax",
				JOptionPane.ERROR_MESSAGE);
	}

	private void typeErrors(String errors) {
		String message = "Type errors were found:\n" + errors;
		JOptionPane.showMessageDialog(this, message, "Type error(s)",
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
			JOptionPane.showMessageDialog(this, "File \"" + file
					+ "\" not found!");
			text = null;
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this,
					"IO exception while reading file");
			text = null;
		}

		return text;
	}
}
