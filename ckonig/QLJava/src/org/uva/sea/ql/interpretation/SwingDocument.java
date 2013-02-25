package org.uva.sea.ql.interpretation;

import java.util.Stack;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.uva.sea.ql.ast.elements.IfStatement;
import org.uva.sea.ql.ast.elements.Question;
import org.uva.sea.ql.interpretation.components.PanelDimensions;
import org.uva.sea.ql.interpretation.components.content.IfStatementPanel;
import org.uva.sea.ql.interpretation.components.content.QuestionPanel;
import org.uva.sea.ql.interpretation.listeners.ListenerService;

public class SwingDocument implements QLDocument {
    private final JPanel panel;
    private Stack<JPanel> panelStack;
    private SwingRegistry registry;

    public SwingDocument() {
        this.panel = new JPanel();
        this.panelStack = new Stack<>();
        this.panelStack.push(this.panel);
        this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));
        this.registry = new SwingRegistry();
    }

    @Override
    public final Object getOutput() {
        return this.panel;
    }

    @Override
    public final void setHeading(String content) {
        final JLabel lbl = new JLabel(content);
        lbl.setFont(PanelDimensions.getFont());
        this.panelStack.peek().add(lbl);
    }

    @Override
    public final void appendQuestion(Question question) {
        final QuestionPanel p = new QuestionPanel(question);
        this.panelStack.peek().add(p);
        this.registry.addQuestion(p);
    }

    @Override
    public final void beginIf(IfStatement ifStatement) {
        final IfStatementPanel p = new IfStatementPanel(ifStatement);
        p.setVisible(false);
        this.panelStack.peek().add(p);
        this.panelStack.push(p);
        this.registry.addIfStatement(p);

    }

    @Override
    public final void endIf() {
        this.panelStack.pop();
    }

    @Override
    public final void create() {        
        for (QuestionPanel questionPanel : this.registry.getQuestions()) {
            ListenerService.createListeners(questionPanel, this.registry);
        }
    }

    public final SwingRegistry getRegistry() {
        return this.registry;
    }

}
