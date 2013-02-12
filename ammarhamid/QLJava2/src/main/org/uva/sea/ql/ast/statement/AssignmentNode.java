package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.VariableScope;
import org.uva.sea.ql.ast.Node;
import org.uva.sea.ql.ast.expression.ExprNode;
import org.uva.sea.ql.value.Value;

public class AssignmentNode implements Node
{
    private final String identifier;
    private final Value value;
    private final VariableScope variableScope;

    public AssignmentNode(final String identifier, final ExprNode exprNode, final VariableScope variableScope)
    {
        this.identifier = identifier;
        this.variableScope = variableScope;
        this.value = exprNode.evaluate();
        this.variableScope.assign(this.identifier, this.value);
    }

    // TODO move this code to GUI interpreter
//    public Value evaluate()
//    {
//        this.variableScope.assign(this.identifier, this.value);
//        return null;
//    }

//    @Override
//    public String toTreeString(final String indent)
//    {
//        return '\n' + this.identifier + " = " +this.value.toTreeString(" ");
//    }
}
