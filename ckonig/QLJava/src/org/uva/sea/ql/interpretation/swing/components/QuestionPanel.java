package org.uva.sea.ql.interpretation.swing.components;

import java.awt.BorderLayout;

import javax.swing.AbstractButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.uva.sea.ql.ast.elements.Question;
import org.uva.sea.ql.interpretation.swing.visitors.SwingInputTypeVisitor;

public class QuestionPanel extends JPanel {
    private static final long serialVersionUID = -8537987318519877345L;
    private Question question;
    private JComponent input;

    public QuestionPanel(Question q) {
        this.question = q;
        this.setLayout(new BorderLayout());
        this.add(new JLabel(this.question.getContent().getValue()),
                BorderLayout.LINE_START);
        createInputElement();
    }

    public final String getIdentName() {
        return this.question.getIdentName();
    }

    public final Question getQuestion() {
        return this.question;
    }

    public final JComponent getInput() {
        return this.input;
    }

    public final boolean getBoolValue() {
        return ((AbstractButton) this.input).getModel().isSelected();
    }

    public final String getStringValue() {
        final JTextField t = (JTextField) input;
        return t.getText();
    }

    private void createInputElement() {
        final SwingInputTypeVisitor v = new SwingInputTypeVisitor();
        this.question.getType().accept(v);
        this.input = v.getInput();
        this.add(this.input, BorderLayout.LINE_END);
    }
}
