package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.statements.Block;
import org.uva.sea.ql.ast.statements.ComQuestion;
import org.uva.sea.ql.ast.statements.IfThen;
import org.uva.sea.ql.ast.statements.IfThenElse;
import org.uva.sea.ql.ast.statements.SimpleQuestion;

public interface IStatementVisitor {

	public void visit(Form form);

	public void visit(ComQuestion comQuestion);

	public void visit(IfThen ifThen);

	public void visit(IfThenElse ifThenElse);

	public void visit(SimpleQuestion simpleQuestion);

	public void visit(Block block);

}
