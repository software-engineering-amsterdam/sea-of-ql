package org.uva.sea.ql.gui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.parser.antlr.FormParser;
import org.uva.sea.ql.parser.antlr.ParseError;

import net.miginfocom.swing.MigLayout;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public MainWindow() {
		initUI();
		render();
	}
	
	public final void initUI() {
		setTitle("Window title, woohoo!");
		setSize(300, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
	
	public void render() {
		FormParser formParser = new FormParser();
		
		Form form;
		try {
			form = formParser.parse("form a { }");
			this.add(Renderer.render(form, new State()));
		} catch (ParseError e) {
			JOptionPane.showMessageDialog(this, "Parse Error!");
		}
	}
}
