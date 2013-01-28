package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.value.ValueNode;

public class AssignmentNode implements Node
{
    private final String identifier;
    private final ValueNode valueNode;
    private final VariableScope variableScope;

    public AssignmentNode(final String identifier, final Node node, final VariableScope variableScope)
    {
        this.identifier = identifier;
        // TODO check this casting !!
        this.valueNode = (ValueNode) node;
        this.variableScope = variableScope;
    }

    @Override
    public ValueNode evaluate()
    {
        this.variableScope.assign(this.identifier, this.valueNode);

        return ValueNode.VOID;
    }

    @Override
    public String toTreeString(String indent)
    {
        return '\n' + this.identifier + " = " +this.valueNode.toTreeString(" ");
    }
}
