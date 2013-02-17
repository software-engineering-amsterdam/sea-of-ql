package org.uva.sea.ql.common;

import org.uva.sea.ql.ast.elements.Block;
import org.uva.sea.ql.ast.elements.BlockElement;
import org.uva.sea.ql.ast.elements.Form;
import org.uva.sea.ql.ast.elements.IfStatement;
import org.uva.sea.ql.ast.elements.Question;
import org.uva.sea.ql.common.interfaces.ElementVisitor;
import org.uva.sea.ql.common.interfaces.QLDocument;

public class VisitorDocumentBuilder implements ElementVisitor {

    private QLDocument document;

    public VisitorDocumentBuilder(QLDocument doc) {
        this.document = doc;
    }

    @Override
    public final void visit(Form form) throws VisitorException {
        this.document.setHeading(form.getName());
        form.getBlock().accept(this);
        this.document.create();
    }

    @Override
    public final void visit(Block block) throws VisitorException {
        for (BlockElement e : block.getContent()) {
            e.accept(this);
        }
    }

    @Override
    public final void visit(Question question) throws VisitorException {
        this.document.appendQuestion(question);
    }

    @Override
    public final void visit(IfStatement ifStatement) throws VisitorException {
        this.document.beginIf(ifStatement);
        ifStatement.getContent().accept(this);
        this.document.endIf();
    }

    public final Object getOutput() {
        return this.document.getOutput();
    }

}
