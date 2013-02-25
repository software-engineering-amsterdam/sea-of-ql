package org.uva.sea.ql.interpretation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.ast.elements.IfStatement;
import org.uva.sea.ql.ast.elements.Question;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.types.AbstractType;
import org.uva.sea.ql.common.QLException;
import org.uva.sea.ql.common.Registry;
import org.uva.sea.ql.common.returnfinder.ReturnFinder;
import org.uva.sea.ql.interpretation.components.content.IfStatementPanel;
import org.uva.sea.ql.interpretation.components.content.QuestionPanel;
import org.uva.sea.ql.interpretation.exception.EvaluationException;

public class SwingRegistry implements Registry {
    private List<QuestionPanel> questions;
    private List<IfStatementPanel> ifStatements;

    public SwingRegistry() {
        this.questions = new ArrayList<>();
        this.ifStatements = new ArrayList<>();
    }

    public final void addQuestionPanel(QuestionPanel q) {
        this.questions.add(q);
    }

    public final void addIfStatementPanel(IfStatementPanel i) {
        this.ifStatements.add(i);
    }

    public final List<QuestionPanel> getQuestionPanels() {
        return this.questions;
    }

    public final List<IfStatementPanel> getIfStatementPanels() {
        return this.ifStatements;
    }

    public final void updateIfPanelVisibilities() {
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

    public final void updateAutoValues() {
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
        for (QuestionPanel q : this.getQuestionPanels()) {
            ret.put(q.getIdentName().getValue(), q.getUserInput());
        }
        return ret;
    }

    @Override
    public final List<IfStatement> getIfStatements() {
        final List<IfStatement> ret = new ArrayList<IfStatement>();
        for (IfStatementPanel panel : this.getIfStatementPanels()) {
            ret.add(panel.getIfStatement());
        }

        return ret;
    }

    @Override
    public final boolean returnTypeEquals(Expr e, AbstractType type)
            throws QLException {
        return ReturnFinder.returnTypeEquals(this.getQuestions(), e, type);
    }

    @Override
    public final List<Question> getQuestions() {
        final List<Question> ret = new ArrayList<Question>();
        for (QuestionPanel qp : this.getQuestionPanels()) {
            ret.add(qp.getQuestion());
        }

        return ret;
    }
}
