package nl.stgm.ql.interpreter;

import nl.stgm.ql.ast.form.*;
import nl.stgm.ql.inspectors.*;

public class Interpreter extends RunnableVisitor
{
	public static void main(String[] args)
	{
		Document document = parseDocument("canonical.qldoc");
		ApplicationController app = new ApplicationController(document);
		app.run();
	}
}
