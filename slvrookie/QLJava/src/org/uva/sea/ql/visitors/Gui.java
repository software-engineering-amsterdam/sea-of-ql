package org.uva.sea.ql.visitors;

import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import org.antlr.runtime.ANTLRFileStream;
import org.uva.sea.ql.ast.formelements.Form;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.antlr.IParse;
import org.uva.sea.ql.parser.antlr.ParseError;

public class Gui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 168935475998687670L;
	private Form ast;
	final private IParse parser = new ANTLRParser();
	final String path = "src/org/uva/sea/ql/tests/TestQL.ql";
	final State state = new State();
	
	public static void main(String[] args) {
		new Gui();
	}
	
	public Gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new MigLayout());
		setSize(500, 500);
		setVisible(true);
		File filePath = new File(path);
		ANTLRFileStream charStream;
		try {
			charStream = new ANTLRFileStream(filePath.getAbsolutePath());
			System.out.println(charStream);
			ast = parser.parseForm(charStream.toString());
			ElementChecker.check(ast);
			getContentPane().add(Renderer.render(ast, state));
			getContentPane().validate();
			getContentPane().repaint();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseError e) {
			e.printStackTrace();
		}
	}

}
