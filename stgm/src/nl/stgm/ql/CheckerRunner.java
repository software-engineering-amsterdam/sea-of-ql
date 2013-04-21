package nl.stgm.ql;

import nl.stgm.ql.ast.form.Document;
import nl.stgm.ql.checker.*;

public class CheckerRunner
{
	public static void main(String[] args)
	{
		CheckerErrorList errors = new CheckerErrorList();
		Checker checker = new Checker(errors);

		Loader loader = new Loader();
		Document document = loader.parseDocument("errors.qldoc");

		document.accept(checker);
		errors.printList();
	}
}
