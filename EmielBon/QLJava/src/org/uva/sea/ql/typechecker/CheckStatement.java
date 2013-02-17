package org.uva.sea.ql.typechecker;

import java.util.List;
import java.util.Map;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.type.*;
import org.uva.sea.ql.visitor.*;

public class CheckStatement implements StatementVisitor<Boolean> {

	private final Map<Identifier, Type> typeEnv;
	private final List<Message> messages;
	
	private CheckStatement(Map<Identifier, Type> typeEnv, List<Message> messages) {
		this.typeEnv = typeEnv;
		this.messages = messages;
	}
	
	public static boolean check(Statement stat, Map<Identifier, Type> typeEnv, List<Message> errs) {
		CheckStatement check = new CheckStatement(typeEnv, errs);
		return stat.accept(check);
	}
	
	public Boolean visit(Statements stat) {
		return null;
	}

	public Boolean visit(ComputedQuestion stat) {
		return null;
	}

	public Boolean visit(IfBlock stat) {
		return null;
	}

	public Boolean visit(Question stat) {
		
		return true;
	}
	
}
