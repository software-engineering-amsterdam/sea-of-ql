package org.uva.sea.ql.interpretation.swing;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.ast.elements.Question;
import org.uva.sea.ql.interpretation.exception.EvaluationException;

public class SwingRegistry {
    private List<QuestionPanel> questions;
    private List<IfStatementPanel> ifStatements;

    public SwingRegistry() {
        this.questions = new ArrayList<>();
        this.ifStatements = new ArrayList<>();
    }

    public final void addQuestion(QuestionPanel q) {
        this.questions.add(q);
    }

    public final void addIfStatement(IfStatementPanel i) {
        this.ifStatements.add(i);
    }

    public final List<QuestionPanel> getQuestions() {
        return this.questions;
    }

    public final List<IfStatementPanel> getIfStatements() {
        return this.ifStatements;
    }

    public final void evaluateFunctions() {

        for (IfStatementPanel isp : this.ifStatements) {
            try {
                isp.eval(this);
            } catch (EvaluationException ex) {
                isp.setVisible(false);
            }
            isp.repaint();
        }
    }

    public final QuestionPanel getQuestionPanelByIdent(Ident i) {
        for (QuestionPanel qp : this.questions) {
            if (qp.getIdentName().equals(i.getName())) {
                return qp;
            }
        }
        return null;
    }

    public List<Question> getQuestionsAst() {
        List<Question> questions = new ArrayList();
        for (QuestionPanel qp : getQuestions()) {
            questions.add(qp.getQuestion());
        }
        return questions;
    }
}
