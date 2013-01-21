package org.uva.sea.ql.semantic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.uva.sea.ql.ast.ConditionalStatement;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.expr.grouping.Expr;
import org.uva.sea.ql.ast.expr.value.Ident;
import org.uva.sea.ql.error.ErrorHandler;
import org.uva.sea.ql.error.QLError;
import org.uva.sea.ql.symbol.Symbol;
import org.uva.sea.ql.symbol.SymbolTable;
import org.uva.sea.ql.symbol.VariableSeeker;

public class DependencyChecker {
	
	private SymbolTable table;
	private ErrorHandler errorHandler;
	private static DependencyChecker instance;
	
	public static DependencyChecker newInstance(SymbolTable table, ErrorHandler errorHandler) {
		instance = new DependencyChecker();
		instance.table = table;
		instance.errorHandler = errorHandler;
		return instance;
	}
	
	public void checkDependencies() {
		Iterator<Entry<String, Symbol>> iterator = table.getSymbols().entrySet().iterator();
		while(iterator.hasNext()) {
			Symbol currentSymbol = iterator.next().getValue();
			if(hasCyclicDependency(currentSymbol)) {
				errorHandler.addError(new QLError("Cyclic dependency found for: " + currentSymbol.getDeclarationPoint().getName()));
			}
		}
	}
	
	private boolean hasCyclicDependency(Symbol node) {
		for(Ident ident: getDependenciesForSymbol(node)) {
			Symbol dependent = table.getSymbol(ident.getName());
			if(isDependentOnNode(dependent, node)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isDependentOnNode(Symbol dependent, Symbol node) {
		List<Ident> dependencies = getDependenciesForSymbol(dependent);
		for(Ident ident : dependencies) {
			if (ident.getName().equalsIgnoreCase(node.getDeclarationPoint().getName())) {
				return true;
			}
		}
		return false;
	}
	
	private List<Ident> getDependenciesForSymbol(Symbol node) {
		List<Ident> dependencies = new ArrayList<Ident>();
		VariableSeeker seeker = new VariableSeeker(dependencies);
		for(Statement statement: node.getDependantOn()) {
			if(statement instanceof ConditionalStatement) { // TODO attempt clean-up, pass expressions
				Expr expr = ((ConditionalStatement)statement).getExpression();
				expr.accept(seeker);
			}
		}
		return dependencies;
	}

}
