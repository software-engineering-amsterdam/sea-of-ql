package org.uva.sea.ql.visitor.ui;

import java.io.IOException;

import javax.swing.JFrame;

import org.apache.commons.io.IOUtils;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.jacc.JaccQLParser;

public class PanelTestMain {

	public static void main(String[] args) throws ParseError, IOException {
		JaccQLParser parser = new JaccQLParser();
		Form qlForm = parser.parseForm(readResource("simpleQLForm1.ql"));

		
		FormGeneratorVisitor formGeneratorVisitor = new FormGeneratorVisitor();
		formGeneratorVisitor.visit(qlForm);
		
		JFrame jframe = new JFrame();
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jframe.setContentPane(formGeneratorVisitor.getPanel());
		jframe.pack();
		jframe.setLocationRelativeTo(null); // centers frame on screen
		jframe.setVisible(true);
	}

	private static String readResource(final String resourceName) throws IOException {
		return IOUtils.toString(PanelTestMain.class.getResourceAsStream(resourceName));
	}
}
