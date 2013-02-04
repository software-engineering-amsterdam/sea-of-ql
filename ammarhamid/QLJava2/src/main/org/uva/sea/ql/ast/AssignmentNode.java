package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.value.Value;

public class AssignmentNode implements Node
{
    private final String identifier;
    private final Value value;
    private final VariableScope variableScope;

    public AssignmentNode(final String identifier, final Node value, final VariableScope variableScope)
    {
        this.identifier = identifier;
        // TODO check this casting !!
        this.value = (Value) value;
        this.variableScope = variableScope;
    }

    // TODO move this code to GUI interpreter
    public Value evaluate()
    {
        this.variableScope.assign(this.identifier, this.value);

        return null;
    }

    @Override
    public String toTreeString(final String indent)
    {
        return '\n' + this.identifier + " = " +this.value.toTreeString(" ");
    }
}
