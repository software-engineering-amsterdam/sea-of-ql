package org.uva.sea.ql.common;

import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.ast.expressions.BinaryExpr;
import org.uva.sea.ql.ast.expressions.UnaryExpr;
import org.uva.sea.ql.ast.literal.IntLiteral;
import org.uva.sea.ql.ast.literal.StringLiteral;

public interface TreeVisitor {
    public void visit(Ident i);

    public void visit(BinaryExpr b);

    public void visit(UnaryExpr u);

    public void visit(IntLiteral i);

    public void visit(StringLiteral s);
}
