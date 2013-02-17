package org.uva.sea.ql.common.interfaces;

import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.ast.expressions.BinaryExpr;
import org.uva.sea.ql.ast.expressions.UnaryExpr;
import org.uva.sea.ql.ast.literals.IntLiteral;
import org.uva.sea.ql.ast.literals.StringLiteral;

public interface TreeVisitor {
    public void visit(Ident i);

    public void visit(BinaryExpr b);

    public void visit(UnaryExpr u);

    public void visit(IntLiteral i);

    public void visit(StringLiteral s);
}
