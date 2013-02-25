package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expression.impl.IdentifierNode;
import org.uva.sea.ql.ast.statement.BlockNode;
import org.uva.sea.ql.value.Value;

import java.util.Map;

public class FormNode implements Node
{
    private final String formName;
    private final BlockNode blockNode;
    private final Map<IdentifierNode, Value> variables;

    public FormNode(final String formName, final BlockNode blockNode, final Map<IdentifierNode, Value> variables)
    {
        this.formName = formName;
        this.blockNode = blockNode;
        this.variables = variables;
    }

    public String getFormName()
    {
        return formName;
    }

    public BlockNode getBlockNode()
    {
        return blockNode;
    }

    public Map<IdentifierNode, Value> getVariables()
    {
        return variables;
    }
}
