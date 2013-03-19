package org.uva.sea.ql.typechecker;

import java.util.ArrayList;
import org.uva.sea.ql.ast.statement.Statement;

public class TypeChecker {

	public static boolean check(Statement statement) {
		ArrayList<Error> errors = new ArrayList<Error>();
		StatementChecker.check(statement, new TypeEnvironment(), errors);
		if (errors.isEmpty()) {
			return true;
		}
		for(Error error : errors) {
			System.err.println(error);
		}
		return false;
	}
	
}
