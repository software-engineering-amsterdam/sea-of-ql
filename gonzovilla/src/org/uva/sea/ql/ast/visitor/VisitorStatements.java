package org.uva.sea.ql.ast.visitor;

import org.uva.sea.ql.ast.stat.Block;
import org.uva.sea.ql.ast.stat.ComputedQuestion;
import org.uva.sea.ql.ast.stat.Form;
import org.uva.sea.ql.ast.stat.IfElseStatement;
import org.uva.sea.ql.ast.stat.IfStatement;
import org.uva.sea.ql.ast.stat.Question;

public interface VisitorStatements <T> {

	T visit(Form form);
	T visit(ComputedQuestion computedQuestion);
	T visit(Question question);
	T visit(IfStatement ifStatement);
	T visit(IfElseStatement ifElseStatement);
	T visit(Block block);

}