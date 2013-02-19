package org.uva.sea.ql.parser.test.statements;

import org.uva.sea.ql.parser.antlr.check.ANTLRParserConditionBlocks;

public class ConditionTypeChecker extends StatementTypeChecker {
	
	public ConditionTypeChecker() {
		super(new ANTLRParserConditionBlocks());
	}
	
}