package org.uva.sea.ql.interpretation.swing;

import org.uva.sea.ql.interpretation.swing.components.QuestionPanel;
import org.uva.sea.ql.interpretation.swing.visitors.ListenerFactory;


public class AutoValueSetter {
    private QuestionPanel questionPanel;
    private SwingRegistry registry;

    public AutoValueSetter(SwingRegistry reg, QuestionPanel panel) {
        this.registry = reg;
        this.questionPanel = panel;
    }

    public final void createListeners() {
        final ListenerFactory v = new ListenerFactory(this.questionPanel, this.registry);
        this.questionPanel.getQuestion().getType().accept(v);
    }
    
}
