package org.uva.sea.ql.interpretation.swing.visitors;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JTextField;

import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.Money;
import org.uva.sea.ql.ast.types.NullType;
import org.uva.sea.ql.ast.types.StrType;
import org.uva.sea.ql.interpretation.TypeVisitor;
import org.uva.sea.ql.interpretation.swing.components.QuestionPanel;

public class SwingInputComponentFactory {

    private final static int LENGTH = 10;
    private JComponent input;
    private QuestionPanel questionPanel;

    public SwingInputComponentFactory(QuestionPanel q) {
        this.questionPanel = q;
        questionPanel.getQuestion().getType().accept(new SwingInputComponentFactoryVisitor());
    }

    private class SwingInputComponentFactoryVisitor implements TypeVisitor {
        @Override
        public final void visit(BooleanType b) {
            input = new JCheckBox();
        }

        @Override
        public final void visit(Money m) {
            input = new JTextField(LENGTH);
            if (questionPanel.getQuestion().getExpr() != null) {
                ((JTextField) input).setEditable(false);
            }
        }

        @Override
        public final void visit(StrType s) {
            input = new JTextField(LENGTH);
        }

        @Override
        public final void visit(IntType i) {
            input = new JTextField(LENGTH);
        }

        @Override
        public void visit(NullType n) {
            // TODO Auto-generated method stub
        }

    }

    public final JComponent getInputComponent() {
        return this.input;
    }

}
