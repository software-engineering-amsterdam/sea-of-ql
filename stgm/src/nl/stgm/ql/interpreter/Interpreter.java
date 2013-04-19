package nl.stgm.ql.interpreter;

import nl.stgm.ql.ast.form.Document;
import nl.stgm.ql.inspectors.*;
import nl.stgm.ql.interpreter.awtui.*;

public class Interpreter extends RunnableVisitor
{
	public static void main(String[] args)
	{
		Document document = parseDocument("elaborate.qldoc");
		InterpreterApplication app = new InterpreterApplication(document);
		PagedUIController ui = new AWTUIController(app);
		app.run(ui);
	}
}
