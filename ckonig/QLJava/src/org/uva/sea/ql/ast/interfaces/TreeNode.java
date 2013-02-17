package org.uva.sea.ql.ast.interfaces;

import org.uva.sea.ql.common.interfaces.TreeVisitor;

public interface TreeNode {
    public void accept(TreeVisitor v);
}
