package org.uva.sea.ql.ast.statement;

import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.message.Message;

public abstract class Statement implements ASTNode{

	public abstract List<Message> checkType (Map<Ident, Type> typeEnv);
	
}
