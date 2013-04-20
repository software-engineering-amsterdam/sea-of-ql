package nl.stgm.ql.interpreter;

import nl.stgm.ql.inspectors.*;
import nl.stgm.ql.ast.form.Document;

public class Interpreter extends RunnableVisitor
{
	private Document astDocument;
	private InterpreterViewManager manager;
	private InterpreterController controller;
	
	public Interpreter(Document astDocument)
	{
		this.astDocument = astDocument;
		this.controller = new InterpreterController(astDocument);
	}
	
	public void run()
	{
		controller.run();
	}

	public static void main(String[] args)
	{
		Document document = parseDocument("elaborate.qldoc");
		Interpreter app = new Interpreter(document);
		app.run();
	}
}
