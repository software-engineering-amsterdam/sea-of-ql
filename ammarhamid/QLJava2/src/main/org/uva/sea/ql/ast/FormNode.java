package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.statement.BlockNode;

public class FormNode implements Node
{
    private final String formName;
    private final BlockNode blockNode;

    public FormNode(final String formName, final BlockNode blockNode)
    {
        this.formName = formName;
        this.blockNode = blockNode;
    }

    public String getFormName()
    {
        return formName;
    }

    public BlockNode getBlockNode()
    {
        return blockNode;
    }

}
