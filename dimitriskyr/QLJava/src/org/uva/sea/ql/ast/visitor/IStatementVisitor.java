package org.uva.sea.ql.ast.visitor;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.statements.Block;
import org.uva.sea.ql.ast.statements.ComQuestion;
import org.uva.sea.ql.ast.statements.IfThen;
import org.uva.sea.ql.ast.statements.IfThenElse;
import org.uva.sea.ql.ast.statements.QuestionElement;
import org.uva.sea.ql.ast.statements.SimpleQuestion;
import org.uva.sea.ql.ast.statements.StatementElement;

public interface IStatementVisitor {
	
		public void visit (Form form);
		public void visit (ComQuestion comquestions);
		public void visit (IfThen ifthen);
		public void visit (IfThenElse ifThenElse);
		public void visit (SimpleQuestion simpleQuestion);
		public void visit (QuestionElement questionElement);
		public void visit(Block block);
		public void visit(StatementElement statementElement);

}
