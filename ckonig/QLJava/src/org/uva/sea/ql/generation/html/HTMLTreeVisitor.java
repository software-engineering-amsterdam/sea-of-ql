package org.uva.sea.ql.generation.html;

import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.ast.expressions.BinaryExpr;
import org.uva.sea.ql.ast.expressions.UnaryExpr;
import org.uva.sea.ql.ast.interfaces.TreeNode;
import org.uva.sea.ql.ast.literal.IntLiteral;
import org.uva.sea.ql.ast.literal.StringLiteral;
import org.uva.sea.ql.common.TreeVisitor;

public class HTMLTreeVisitor implements TreeVisitor {
    private StringBuilder ret;

    public String getRet() {
        return ret.toString();
    }

    public HTMLTreeVisitor() {
        this.ret = new StringBuilder();
    }

    @Override
    public void visit(Ident i) {
        ret.append(i.getName());
        ret.append("()");
    }

    @Override
    public void visit(BinaryExpr b) {
        ret.append("(");
        HTMLTreeVisitor v = new HTMLTreeVisitor();
        ((TreeNode) b.getLeft()).accept(v);
        ret.append(v.getRet());
        ret.append(b.toString());
        v = new HTMLTreeVisitor();
        ((TreeNode) b.getRight()).accept(v);
        ret.append(v.getRet());
        ret.append(")");
    }

    @Override
    public void visit(UnaryExpr u) {
        ret.append("(");
        ret.append(u.toString());
        HTMLTreeVisitor v = new HTMLTreeVisitor();
        ((TreeNode) u.getAdjacent()).accept(v);
        ret.append(v.getRet());
        ret.append(")");
    }

    @Override
    public void visit(IntLiteral i) {
        ret.append((i).getValue());
    }

    @Override
    public void visit(StringLiteral s) {
        ret.append((s).getValue());

    }

}
