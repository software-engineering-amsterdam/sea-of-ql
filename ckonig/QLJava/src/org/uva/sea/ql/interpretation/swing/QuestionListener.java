package org.uva.sea.ql.interpretation.swing;

import org.uva.sea.ql.ast.elements.Ident;

public class QuestionListener {
    private final SwingRegistry registry;

    public QuestionListener(SwingRegistry reg) {
        this.registry = reg;
    }

    public final void addIdentListener(Ident ident) {
        final QuestionPanel qp = this.registry.getQuestionPanelByIdent(ident);
        addListeners(qp);
    }

    private void addListeners(QuestionPanel questionPanel) {
        QuestionListenerTypeVisitor v = new QuestionListenerTypeVisitor(questionPanel, registry);
        questionPanel.getQuestion().getType().accept(v);
    }

}
