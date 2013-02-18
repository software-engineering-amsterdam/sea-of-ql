package org.uva.sea.ql.visitors;

import org.uva.sea.ql.ast.formelements.Block;
import org.uva.sea.ql.ast.formelements.CompQuestion;
import org.uva.sea.ql.ast.formelements.Form;
import org.uva.sea.ql.ast.formelements.IfThen;
import org.uva.sea.ql.ast.formelements.IfThenElse;
import org.uva.sea.ql.ast.formelements.Question;

public interface IElementVisitor {
	
	void visit(Block block);
	void visit(CompQuestion compQuestion);
	void visit(Form form);
	void visit(IfThen ifThen);
	void visit(IfThenElse ifThenElse);
	void visit(Question question);

}
