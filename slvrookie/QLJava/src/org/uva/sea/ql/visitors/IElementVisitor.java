package org.uva.sea.ql.visitors;

import org.uva.sea.ql.ast.formelements.Block;
import org.uva.sea.ql.ast.formelements.CompQuestion;
import org.uva.sea.ql.ast.formelements.Form;
import org.uva.sea.ql.ast.formelements.IfThen;
import org.uva.sea.ql.ast.formelements.IfThenElse;
import org.uva.sea.ql.ast.formelements.Question;

public interface IElementVisitor {
	
	void visit(Block element);
	void visit(CompQuestion element);
	void visit(Form element);
	void visit(IfThen element);
	void visit(IfThenElse element);
	void visit(Question element);

}
