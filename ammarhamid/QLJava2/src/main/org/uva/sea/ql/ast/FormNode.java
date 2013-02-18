package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.statement.impl.BlockNode;

public class FormNode implements Node
{
    private final String formName;
    private final BlockNode blockNode;

    public FormNode(String formName, BlockNode blockNode)
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
