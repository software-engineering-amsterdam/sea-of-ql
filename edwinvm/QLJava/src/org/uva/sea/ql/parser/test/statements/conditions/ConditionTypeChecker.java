package org.uva.sea.ql.parser.test.statements.conditions;

import org.uva.sea.ql.parser.antlr.check.ANTLRParserConditionBlocks;
import org.uva.sea.ql.parser.test.statements.StatementTypeChecker;

public class ConditionTypeChecker extends StatementTypeChecker {
	
	public ConditionTypeChecker() {
		super(new ANTLRParserConditionBlocks());
	}
	
}