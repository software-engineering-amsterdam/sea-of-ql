package org.uva.sea.ql.interpreter;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.uva.sea.ql.ast.statement.Form;
import org.uva.sea.ql.gui.Renderer;
import org.uva.sea.ql.parser.jacc.JACCParser;
import org.uva.sea.ql.parser.test.IParse;
import org.uva.sea.ql.parser.test.ParseError;
import org.uva.sea.ql.typechecker.CheckStatement;
import org.uva.sea.ql.typechecker.Message;
import org.uva.sea.ql.typechecker.TypeEnvironment;

public class Questionnaire extends JFrame {

	private static final long serialVersionUID = 4400094493031598350L;
	private Form form;
	
	public static void main(String[] args) throws ParseError, IOException {
		new Questionnaire("test.ql");
	}
	
	public Questionnaire(String qlSourcePath) throws ParseError, IOException {
		String source = readQLSourceFile(qlSourcePath);
		form = parseForm(source);
		// TODO Doet dit wel iets?
		CheckStatement.check(form, new TypeEnvironment(), new ArrayList<Message>());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		render();
	}
	
	private Form parseForm(String source) throws ParseError {
		IParse parser = new JACCParser();
		return (Form) parser.parse(source);
	}
	
	private static String readQLSourceFile(String path) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File(path).getAbsolutePath()));
		String source = "";
		String line = br.readLine();
		while (line != null) {
		   source += line + " \n";
		   line = br.readLine();
		}
		br.close();
		return source;
	}
	
	public void render() {
		State state = new State();
		JPanel formPanel = Renderer.render(form, state);
		getContentPane().add(formPanel, BorderLayout.CENTER);
		pack();
		setVisible(true);
	}
	
}
