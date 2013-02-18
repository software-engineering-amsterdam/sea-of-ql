package org.uva.sea.ql.ast.interfaces;

import org.uva.sea.ql.interpretation.TreeVisitor;

public interface TreeNode {
    public void accept(TreeVisitor v);
}
