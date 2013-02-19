package org.uva.sea.ql.interpretation.swing.visitors;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.Money;
import org.uva.sea.ql.ast.types.NullType;
import org.uva.sea.ql.ast.types.StrType;
import org.uva.sea.ql.interpretation.TypeVisitor;
import org.uva.sea.ql.interpretation.swing.components.QuestionPanel;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class UserInputReader {

    private Object ret;

    public UserInputReader(QuestionPanel qp) {

        qp.getQuestion().getType().accept(new UserInputReaderVisitor(qp));
    }

    public final Object getUserInput() {
        return this.ret;
    }

    private class UserInputReaderVisitor implements TypeVisitor {

        private final QuestionPanel questionPanel;

        public UserInputReaderVisitor(QuestionPanel qp) {
            this.questionPanel = qp;
        }

        @Override
        public final void visit(BooleanType b) {
            ret = ((JCheckBox) this.questionPanel.getInput()).isSelected();
        }

        @Override
        public final void visit(Money m) {
            ret = ((JTextField) this.questionPanel.getInput()).getText();
        }

        @Override
        public final void visit(StrType s) {
            ret = ((JTextField) this.questionPanel.getInput()).getText();
        }

        @Override
        public final void visit(IntType i) {
            ret = ((JTextField) this.questionPanel.getInput()).getText();
        }

        @Override
        public void visit(NullType n) {
            throw new NotImplementedException();
        }
    }
}
