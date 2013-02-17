package org.uva.sea.ql.interpretation.swing;


public class AutoValueSetter {
    private QuestionPanel questionPanel;
    private SwingRegistry registry;

    public AutoValueSetter(SwingRegistry reg, QuestionPanel panel) {
        this.registry = reg;
        this.questionPanel = panel;
    }

    public final void createListeners() {
        ListenerTypeVisitor v = new ListenerTypeVisitor(this.questionPanel, this.registry);
        this.questionPanel.getQuestion().getType().accept(v);
    }
    
}
