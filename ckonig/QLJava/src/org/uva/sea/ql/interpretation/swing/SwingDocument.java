package org.uva.sea.ql.interpretation.swing;

import java.util.List;
import java.util.Stack;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.ast.elements.IfStatement;
import org.uva.sea.ql.ast.elements.Question;
import org.uva.sea.ql.common.QLDocument;

public class SwingDocument implements QLDocument {
    private final JPanel panel;
    private Stack<JPanel> history;
    private SwingRegistry registry;

    public SwingDocument() {
        this.panel = new JPanel();
        this.history = new Stack<>();
        this.history.push(this.panel);
        this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));
        this.registry = new SwingRegistry();
    }

    @Override
    public final Object getOutput() {
        return this.panel;
    }

    @Override
    public void setHeading(String content) {
        // TODO Auto-generated method stub
    }

    @Override
    public final void appendQuestion(Question question) {
        final QuestionPanel p = new QuestionPanel(question);
        this.history.peek().add(p);
        this.registry.addQuestion(p);
    }

    @Override
    public final void beginIf(IfStatement ifStatement) {
        final IfStatementPanel p = new IfStatementPanel(ifStatement);
        p.setVisible(false);
        this.history.peek().add(p);
        this.history.push(p);
        this.registry.addIfStatement(p);

    }

    @Override
    public final void endIf() {
        this.history.pop();
    }

    @Override
    public final void create() {
        for (QuestionPanel questionPanel : this.registry.getQuestions()) {
            new AutoValueSetter(this.registry, questionPanel).createListeners();
        }
        final QuestionListener questionListener = new QuestionListener(
                this.registry);
        for (IfStatementPanel ifPanel : this.registry.getIfStatements()) {
            final IfStatement ifStatement = ifPanel.getIfStatement();
            final List<Ident> idents = ifStatement.getIdents();
            for (Ident ident : idents) {
                questionListener.addIdentListener(ident);
            }
        }
    }

}
