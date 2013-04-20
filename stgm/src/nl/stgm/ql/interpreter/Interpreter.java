package nl.stgm.ql.interpreter;

import nl.stgm.ql.inspectors.*;
import nl.stgm.ql.ast.form.Document;
import nl.stgm.ql.interpreter.awtui.*;

public class Interpreter extends RunnableVisitor
{
	private Document astDocument;
	private PagedUIController ui;
	private InterpreterViewManager manager;
	
	public Interpreter(Document astDocument)
	{
		this.astDocument = astDocument;
		this.ui = new AWTUIController();
		this.manager = new InterpreterViewManager(astDocument, ui);
	}
	
	public void run()
	{
		ui.show();
	}

	public static void main(String[] args)
	{
		Document document = parseDocument("elaborate.qldoc");
		Interpreter app = new Interpreter(document);
		app.run();
	}
}
