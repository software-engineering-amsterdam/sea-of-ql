package org.uva.sea.ql.ast.interfaces;

import org.uva.sea.ql.common.identfinder.RecursiveIdentVisitor;

public interface TreeNode {
    public void accept(RecursiveIdentVisitor v);
}
