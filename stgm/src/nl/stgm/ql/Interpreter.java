package nl.stgm.ql;

import nl.stgm.ql.ast.form.Document;
import nl.stgm.ql.interpreter.*;

public class Interpreter
{
	public static void main(String[] args)
	{
		Loader loader = new Loader();
		Document document = loader.parseDocument("elaborate.qldoc");
		PagedInterpreter app = new PagedInterpreter(document);
		app.run();
	}
}
