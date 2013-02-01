package org.uva.sea.ql.launcher;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.JPanel;

import org.antlr.runtime.ANTLRFileStream;
import org.uva.sea.ql.interpreter.SwingVisitor;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.test.ParseError;
import org.uva.sea.ql.swing.Renderer;

public class Main {

	public static void main(String[] args) {

		final String path = "src/org/uva/sea/ql/launcher/SampleCode.ql";
		File filePath = new File(path);

		try {
			ANTLRFileStream charStream = new ANTLRFileStream(filePath.getAbsolutePath());
			ANTLRParser parser = new ANTLRParser();
			List<JPanel> panelList=SwingVisitor.generate(parser.parseForm(charStream.toString()));
			Renderer render=new Renderer(panelList);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseError e) {
			e.printStackTrace();
		}
		

	}

}
