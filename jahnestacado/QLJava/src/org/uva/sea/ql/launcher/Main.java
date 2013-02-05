package org.uva.sea.ql.launcher;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.antlr.runtime.ANTLRFileStream;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.interpreter.SwingVisitor;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.test.ParseError;
import org.uva.sea.ql.swing.Renderer;
import org.uva.sea.ql.visitor.checkers.ElementChecker;

public class Main {

	public static void main(String[] args) {

		final String path = "src/org/uva/sea/ql/launcher/SampleCode.ql";
		File filePath = new File(path);

		try {
			ANTLRFileStream charStream = new ANTLRFileStream(filePath.getAbsolutePath());
			ANTLRParser parser = new ANTLRParser();
			Form parsedForm=parser.parseForm(charStream.toString());
			if(ElementChecker.checkQL(parsedForm)){

			List<JPanel> panelList=SwingVisitor.generate(parsedForm);

			
			new Renderer(panelList);
			
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseError e) {
			e.printStackTrace();
		}
		

	}

}
