package org.uva.sea.ql.interpretation.listeners;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.Money;
import org.uva.sea.ql.ast.types.NullType;
import org.uva.sea.ql.ast.types.StrType;
import org.uva.sea.ql.common.TypeVisitor;
import org.uva.sea.ql.interpretation.components.content.QuestionPanel;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class UserInputReader {

    private UserInputReaderVisitor visitor;

    public UserInputReader(QuestionPanel qp) {
        this.visitor = new UserInputReaderVisitor(qp);
        qp.getQuestionType().accept(this.visitor);
    }

    public final Object getUserInput() {
        return this.visitor.getUserInput();
    }

    private class UserInputReaderVisitor implements TypeVisitor {
        private Object ret;
        private final QuestionPanel questionPanel;

        public UserInputReaderVisitor(QuestionPanel qp) {
            this.questionPanel = qp;
        }

        final Object getUserInput() {
            return this.ret;
        }

        @Override
        public final void visit(BooleanType b) {
            this.ret = ((JCheckBox) this.questionPanel.getInput()).isSelected();
        }

        @Override
        public final void visit(Money m) {
            this.ret = ((JTextField) this.questionPanel.getInput()).getText();
        }

        @Override
        public final void visit(StrType s) {
            this.ret = ((JTextField) this.questionPanel.getInput()).getText();
        }

        @Override
        public final void visit(IntType i) {
            this.ret = ((JTextField) this.questionPanel.getInput()).getText();
        }

        @Override
        public void visit(NullType n) {
            throw new NotImplementedException();
        }
    }
}
