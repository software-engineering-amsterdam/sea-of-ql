package org.uva.sea.ql.interpretation.swing.components;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.AbstractButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.uva.sea.ql.ast.elements.Question;
import org.uva.sea.ql.ast.types.AbstractType;
import org.uva.sea.ql.interpretation.swing.visitors.SwingInputComponentFactory;
import org.uva.sea.ql.interpretation.swing.visitors.UserInputReader;

public class QuestionPanel extends JPanel {
    private static final long serialVersionUID = -8537987318519877345L;
    private Question question;
    private JComponent input;
    private boolean invalid;
    private Color original;

    public QuestionPanel(Question q) {
        this.invalid = false;
        this.question = q;
        this.setLayout(new BorderLayout());
        this.add(new JLabel(this.question.getContent().getValue()),
                BorderLayout.LINE_START);
        createInputElement();
        this.original = this.getBackground();
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

    public final Object getUserInput() {
        final UserInputReader v = new UserInputReader(this);
        final AbstractType t = this.question.getType();
        return v.getUserInput();
    }

    public final boolean getBoolValue() {
        return ((AbstractButton) this.input).getModel().isSelected();
    }

    public final String getStringValue() {
        final JTextField t = (JTextField) this.input;
        return t.getText();
    }

    public final void setValid(boolean val) {
        this.invalid = !val;
        if (val) {
            this.setBackground(this.original);
        } else {
            this.setBackground(Color.red);
        }
        this.repaint();
    }
    
    public final boolean isValidInput(){
        return !this.invalid;
    }

    private void createInputElement() {
        final SwingInputComponentFactory v = new SwingInputComponentFactory(this);
        this.input = v.getInputComponent();
        this.add(this.input, BorderLayout.LINE_END);
    }

}
