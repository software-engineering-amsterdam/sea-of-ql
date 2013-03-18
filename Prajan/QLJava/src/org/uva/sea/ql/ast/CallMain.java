package org.uva.sea.ql.ast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.gen.TypeError;
import org.uva.sea.ql.gui.Renderer;
import org.uva.sea.ql.gui.State;
import org.uva.sea.ql.parser.antlr.QLLexer;
import org.uva.sea.ql.parser.antlr.QLParser;
import org.uva.sea.ql.parser.test.ParseError;
import org.uva.sea.ql.visitor.CheckForm;

public class CallMain extends JFrame {

	/**
	 * @param args
	 * @throws RecognitionException
	 * @throws IOException
	 * @throws ParseError
	 */

	public static void main(String[] args) throws IOException, RecognitionException, ParseError {

		// gets AST from grammar
		Form questionForm = loadForm(args[0]);

		Map<Ident, Type> mp = new HashMap<Ident, Type>();
		List<TypeError> messages = new ArrayList<TypeError>();
		State state = new State();

		CheckForm checkForm = new CheckForm(mp, state, messages);
		questionForm.accept(checkForm);

		JPanel panel;
		if (messages.size() == 0) {
			panel = Renderer.render(questionForm, state);

		} else {
			panel = new JPanel();
			for (TypeError typeError : messages) {
				JLabel label = new JLabel();
				label.setText(typeError.getTypeErrorMessage());
				panel.add(label);
			}
		}

		Draw(panel, questionForm.getFormname());

	}

	private static void Draw(JPanel panel, String title) {

		// draw and display the GUI
		JFrame frame = new JFrame();
		frame.setTitle(title);
		frame.setContentPane(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 500);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

	private static Form loadForm(String path) throws IOException, RecognitionException {

		// returns AST from the grammar
		CharStream charStream = new ANTLRFileStream(path);
		QLLexer lexer = new QLLexer(charStream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		QLParser parser = new QLParser(tokenStream);
		return parser.form();
	}
}
