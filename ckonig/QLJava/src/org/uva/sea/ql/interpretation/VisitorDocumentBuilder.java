package org.uva.sea.ql.interpretation;

import org.uva.sea.ql.ast.elements.Block;
import org.uva.sea.ql.ast.elements.AbstractBlockElement;
import org.uva.sea.ql.ast.elements.Form;
import org.uva.sea.ql.ast.elements.IfStatement;
import org.uva.sea.ql.ast.elements.Question;
import org.uva.sea.ql.common.ElementVisitor;
import org.uva.sea.ql.common.QLDocument;
import org.uva.sea.ql.common.QLException;

public final class VisitorDocumentBuilder implements ElementVisitor {

    private QLDocument document;

    public VisitorDocumentBuilder(QLDocument doc) {
        this.document = doc;
    }

    @Override
    public final void visit(Form form) throws QLException {
        this.document.setHeading(form.getName());
        form.getBlock().accept(this);
        this.document.create();
    }

    @Override
    public final void visit(Block block) throws QLException {
        for (AbstractBlockElement e : block.getContent()) {
            e.accept(this);
        }
    }

    @Override
    public final void visit(Question question) throws QLException {
        this.document.appendQuestion(question);
    }

    @Override
    public final void visit(IfStatement ifStatement) throws QLException {
        this.document.beginIf(ifStatement);
        ifStatement.getContent().accept(this);
        this.document.endIf();
    }

    public final Object getOutput() {
        return this.document.getOutput();
    }

}
