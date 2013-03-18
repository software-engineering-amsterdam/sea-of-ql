package org.uva.sea.ql.type.checker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.nodes.expressions.Ident;
import org.uva.sea.ql.ast.nodes.statements.Statement;
import org.uva.sea.ql.type.checker.visitor.QLStatementTypeCheckVisitor;
import org.uva.sea.ql.types.Type;

public class QLTypeChecker {
	
	private final Map<Ident, Type> typeEnv;
	private final List<QLErrorMessage> errorMessages;
	
	public QLTypeChecker(){
		this.typeEnv = new HashMap<Ident, Type>();
		this.errorMessages = new ArrayList<QLErrorMessage>();
	}
	
	public List<QLErrorMessage> check(Statement statement){
		QLStatementTypeCheckVisitor.check(statement,typeEnv,errorMessages);
		return errorMessages;
	}
}