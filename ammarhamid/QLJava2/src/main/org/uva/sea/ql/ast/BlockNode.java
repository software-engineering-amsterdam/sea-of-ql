package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.value.ValueNode;

import java.util.ArrayList;
import java.util.List;

public class BlockNode implements Node
{
    private final List<Node> statements;

    public BlockNode()
    {
        this.statements = new ArrayList<>();
    }

    public void addStatement(final Node statement)
    {
        this.statements.add(statement);
    }

    @Override
    public ValueNode evaluate()
    {
        for(final Node statement : statements)
        {
            statement.evaluate();
        }
        return ValueNode.VOID;
    }

    @Override
    public String toTreeString(String indent)
    {
        final StringBuilder stringBuilder = new StringBuilder();
        for(final Node statement : statements)
        {
            stringBuilder.append(statement.toTreeString(" ")).append("\n");
        }
        return stringBuilder.toString();
    }
}
