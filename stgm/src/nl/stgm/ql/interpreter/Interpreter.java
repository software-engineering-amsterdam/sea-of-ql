package nl.stgm.ql.interpreter;

import nl.stgm.ql.inspectors.*;
import nl.stgm.ql.ast.form.Document;

public class Interpreter extends RunnableVisitor
{
	public static void main(String[] args)
	{
		Document document = parseDocument("elaborate.qldoc");
		InterpreterController app = new InterpreterController(document);
		app.run();
	}
}
