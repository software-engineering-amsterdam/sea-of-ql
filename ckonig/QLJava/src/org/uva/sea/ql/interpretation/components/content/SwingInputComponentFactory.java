package org.uva.sea.ql.interpretation.components.content;

import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.Money;
import org.uva.sea.ql.ast.types.NullType;
import org.uva.sea.ql.ast.types.StrType;
import org.uva.sea.ql.common.TypeVisitor;
import org.uva.sea.ql.interpretation.components.input.CheckBox;
import org.uva.sea.ql.interpretation.components.input.QLInput;
import org.uva.sea.ql.interpretation.components.input.TextBox;

public final class SwingInputComponentFactory {

    private final static int LENGTH = 10;
    private final SwingInputComponentFactoryVisitor visitor;

    private SwingInputComponentFactory(QuestionPanel q) {
        this.visitor = new SwingInputComponentFactoryVisitor(q);
        q.getQuestionType().accept(this.visitor);
    }

    public static final QLInput getInputComponent(QuestionPanel q) {
        return new SwingInputComponentFactory(q).getComponent();
    }

    private QLInput getComponent() {
        return this.visitor.getInputComponent();
    }

    private class SwingInputComponentFactoryVisitor implements TypeVisitor {
        private QLInput input;
        private QuestionPanel questionPanel;

        public SwingInputComponentFactoryVisitor(QuestionPanel q) {
            this.questionPanel = q;
        }

        final QLInput getInputComponent() {
            this.input.setInputPossible(!this.questionPanel.hasAutoValue());
            return this.input;
        }

        @Override
        public final void visit(BooleanType b) {
            this.input = new CheckBox();
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
            this.input = new TextBox(LENGTH);
        }

    }

}
