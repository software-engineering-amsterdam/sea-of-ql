package org.uva.sea.ql.interpretation.swing;

import java.awt.BorderLayout;

import javax.swing.AbstractButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.uva.sea.ql.ast.elements.Question;
import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.Money;
import org.uva.sea.ql.ast.types.StrType;

public class QuestionPanel extends JPanel {
    private static final long serialVersionUID = -8537987318519877345L;
    private Question question;
    private JComponent input;

    public QuestionPanel(Question q) {
        this.question = q;
        this.setLayout(new BorderLayout());
        this.add(new JLabel(question.getContent().getValue()),
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
        final AbstractButton abstractButton = (AbstractButton) this.input;
        return abstractButton.getModel().isSelected();
    }

    public final String getStringValue() {
        final JTextField t = (JTextField) input;
        return t.getText();
    }

    private void createInputElement() {
        if (this.question.getType() instanceof BooleanType) {
            this.input = new JCheckBox();
            this.add(this.input, BorderLayout.LINE_END);
        }
        if (this.question.getType() instanceof StrType) {
            input = new JTextField(10);
            this.add(this.input, BorderLayout.LINE_END);
        }
        if (this.question.getType() instanceof Money) {
            input = new JTextField(10);
            Money m = (Money) this.question.getType();
            if (m.getExpr() != null) {
                ((JTextField) this.input).setEditable(false);
            }
            this.add(this.input, BorderLayout.LINE_END);
        }
    }
}
