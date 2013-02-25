package org.uva.sea.ql.interpretation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.ast.elements.Question;
import org.uva.sea.ql.ast.literals.StringLiteral;
import org.uva.sea.ql.common.QLException;
import org.uva.sea.ql.interpretation.components.content.IfStatementPanel;
import org.uva.sea.ql.interpretation.components.content.QuestionPanel;
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

    public final void updateIfPanelVisibilities() {
        System.out.println("update visibilities");
        try {
            for (IfStatementPanel isp : this.ifStatements) {
                try {
                    isp.updateVisibility(this);
                } catch (EvaluationException ex) {
                    isp.setVisible(false);
                }
                isp.repaint();
            }
        } catch (QLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public final void updateAutoValues()  {
        for (QuestionPanel q : this.questions) {
            if (q.hasAutoValue()) {
                try {
                    q.setAutoValue(this);
                } catch (QLException e) {
                    e.printStackTrace();
                }
            }
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

    public final List<Question> getQuestionsAst() {
        final List<Question> ret = new ArrayList<Question>();
        for (QuestionPanel qp : this.getQuestions()) {
            ret.add(qp.getQuestion());
        }
        return ret;
    }

    public final boolean isValid() {
        for (QuestionPanel qp : this.questions) {
            if (!qp.isValidInput()) {
                return false;
            }
        }
        return true;
    }

    public final Map<String, Object> getInput() {
        final Map<String, Object> ret = new HashMap<String, Object>();
        for (QuestionPanel q : this.getQuestions()) {
            ret.put(q.getIdentName().getValue(), q.getUserInput());
        }
        return ret;
    }
}
