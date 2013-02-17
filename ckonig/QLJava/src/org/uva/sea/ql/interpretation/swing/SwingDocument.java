package org.uva.sea.ql.interpretation.swing;

import java.awt.Font;
import java.util.List;
import java.util.Stack;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.ast.elements.IfStatement;
import org.uva.sea.ql.ast.elements.Question;
import org.uva.sea.ql.ast.interfaces.TreeNode;
import org.uva.sea.ql.common.IdentFinder;
import org.uva.sea.ql.common.interfaces.QLDocument;
import org.uva.sea.ql.interpretation.swing.components.IfStatementPanel;
import org.uva.sea.ql.interpretation.swing.components.QuestionPanel;
import org.uva.sea.ql.interpretation.swing.components.Sizes;

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
        lbl.setFont(new Font("Times New Roman", 0, Sizes.HEADING_FONT_SIZE));
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
            new AutoValueSetter(this.registry, questionPanel).createListeners();
        }
        final QuestionListener listener = new QuestionListener(this.registry);
        for (IfStatementPanel ifPanel : this.registry.getIfStatements()) {
            addIdentListener(listener, ifPanel);
        }
    }

    private static void addIdentListener(QuestionListener questionListener,
            IfStatementPanel ifPanel) {
        final IfStatement ifStatement = ifPanel.getIfStatement();
        final IdentFinder finder = new IdentFinder();
        final TreeNode  n = ((TreeNode) ifStatement.getCondition());
        n.accept(finder);
        final List<Ident> idents = finder.getIdents();
        for (Ident ident : idents) {
            questionListener.addIdentListener(ident);
        }
    }
}
