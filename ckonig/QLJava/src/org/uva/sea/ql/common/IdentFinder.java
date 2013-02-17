package org.uva.sea.ql.common;

import java.util.ArrayList;
import java.util.List;
import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.ast.expressions.BinaryExpr;
import org.uva.sea.ql.ast.expressions.UnaryExpr;
import org.uva.sea.ql.ast.interfaces.TreeNode;
import org.uva.sea.ql.ast.literal.IntLiteral;
import org.uva.sea.ql.ast.literal.StringLiteral;

public class IdentFinder implements TreeVisitor {
    private List<Ident> idents;
    
    public IdentFinder(){
        this.idents = new ArrayList<Ident>();
    }

    public List<Ident> getIdents() {
        return idents;
    }

    @Override
    public void visit(Ident i) {
        idents.add(i);
    }

    @Override
    public void visit(BinaryExpr b) {
        IdentFinder i = new IdentFinder();
        ((TreeNode) b.getLeft()).accept(i);
        idents.addAll(i.getIdents());
        i = new IdentFinder();
        ((TreeNode) b.getRight()).accept(i);
        idents.addAll(i.getIdents());
    }

    @Override
    public void visit(UnaryExpr u) {
        IdentFinder i = new IdentFinder();
        ((TreeNode) u.getAdjacent()).accept(i);
        idents.addAll(i.getIdents());
    }

    @Override
    public void visit(IntLiteral i) {
      
    }

    @Override
    public void visit(StringLiteral s) {
        
    }

}
