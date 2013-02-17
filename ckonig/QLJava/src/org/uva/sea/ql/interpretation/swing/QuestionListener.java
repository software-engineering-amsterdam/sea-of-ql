package org.uva.sea.ql.interpretation.swing;

import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.interpretation.swing.components.QuestionPanel;
import org.uva.sea.ql.interpretation.swing.visitors.QuestionListenerTypeVisitor;

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
        final QuestionListenerTypeVisitor v = new QuestionListenerTypeVisitor(questionPanel, registry);
        questionPanel.getQuestion().getType().accept(v);
    }

}
