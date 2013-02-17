package org.uva.sea.ql.ast.traversal.typechecking.base;

import java.io.PrintStream;

import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.traversal.typechecking.SymbolTable;

public interface ITypeChecker {
	boolean checkFormErrors(final Form form);
	int getErrorCount();
	void writeErrorLog(final PrintStream stream);
	SymbolTable getSymbolTable();
}
