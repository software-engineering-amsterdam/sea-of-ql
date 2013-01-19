package org.uva.sea.ql.ast.nodetypes.formelement;

import java.util.Collections;
import java.util.List;

import org.uva.sea.ql.ast.QLExpression;
import org.uva.sea.ql.ast.QLStatement;
import org.uva.sea.ql.parser.visitor.ASTNodeVisitor;

public class Conditional extends QLStatement {

	private final QLExpression condition;
	private final List<QLStatement> successBlock;
	private final List<QLStatement> failureBlock;

	public Conditional(QLExpression condition, List<QLStatement> successBlock) {

		this.condition = condition;
		this.successBlock = successBlock;
		this.failureBlock = Collections.emptyList();
	}

	public Conditional(QLExpression condition, List<QLStatement> successBlock, List<QLStatement> failureBlock) {

		this.condition = condition;
		this.successBlock = successBlock;
		this.failureBlock = failureBlock;
	}

	public QLExpression getCondition() {
		
		return condition;
	}

	public List<QLStatement> getSuccessBlock() {
		
		return successBlock;
	}
	
	public List<QLStatement> getFailureBlock() {
		
		return failureBlock;
	}

    @Override
    public void accept(ASTNodeVisitor visitor) {
        condition.accept(visitor);

        for (QLStatement qlStatement : successBlock) {
            qlStatement.accept(visitor);
        }

        for(QLStatement qlStatement : failureBlock) {
            qlStatement.accept(visitor);
        }

        visitor.visitConditional(this);
    }
}
