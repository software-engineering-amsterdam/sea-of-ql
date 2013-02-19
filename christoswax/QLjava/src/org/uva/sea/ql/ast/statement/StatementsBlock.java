package org.uva.sea.ql.ast.statement;
import org.uva.sea.ql.ast.*;
import java.util.ArrayList;

public class StatementsBlock extends Statement {
	private final ArrayList<Statement> block = new ArrayList<Statement>();

	public void addStatement(Statement statement) {
		block.add(statement);
	}
}
