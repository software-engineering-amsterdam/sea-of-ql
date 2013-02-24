package org.uva.sea.ql.interpretation.components.content;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JTextField;

import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.Money;
import org.uva.sea.ql.ast.types.NullType;
import org.uva.sea.ql.ast.types.StrType;
import org.uva.sea.ql.common.TypeVisitor;

public final class SwingInputComponentFactory {

    private final static int LENGTH = 10;
    private final SwingInputComponentFactoryVisitor visitor;

    private SwingInputComponentFactory(QuestionPanel q) {
        this.visitor = new SwingInputComponentFactoryVisitor(q);
        q.getQuestion().getType().accept(this.visitor);
    }

    public static final JComponent getInputComponent(QuestionPanel q) {
        return new SwingInputComponentFactory(q).getComponent();
    }

    private JComponent getComponent() {
        return this.visitor.getInputComponent();
    }

    private class SwingInputComponentFactoryVisitor implements TypeVisitor {
        private JComponent input;
        private QuestionPanel questionPanel;

        public SwingInputComponentFactoryVisitor(QuestionPanel q) {
            this.questionPanel = q;
        }

        final JComponent getInputComponent() {
            return this.input;
        }

        @Override
        public final void visit(BooleanType b) {
            this.input = new JCheckBox();
            this.input.setEnabled(!this.questionPanel.hasAutoValue());
        }

        @Override
        public final void visit(Money m) {
            setInputAsTextField();
        }

        @Override
        public final void visit(StrType s) {
            setInputAsTextField();
        }

        @Override
        public final void visit(IntType i) {
            setInputAsTextField();
        }

        @Override
        public void visit(NullType n) {
            // do nothing
        }

        private void setInputAsTextField() {
            this.input = new JTextField(LENGTH);
            ((JTextField) this.input).setEditable(!this.questionPanel
                    .hasAutoValue());
        }

    }

}
