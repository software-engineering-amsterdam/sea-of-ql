package org.uva.sea.ql.visitor.statement;

import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.statement.*;
import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.value.Value;
import org.uva.sea.ql.visitor.type.RenderType;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: dimashifni
 * Date: 2/28/13
 * Time: 12:47 AM
 * To change this template use File | Settings | File Templates.
 */
public class Renderer implements StatementVisitor<Void> {

    private final JFrame frame;
    private final JPanel panel;
    private final Statement statement;
    private final Map<Ident, Value> variables;
    private final Map<Ident, List<ObservableStatement>> observableMap;

    private Renderer(JFrame frame, JPanel panel, Statement statement, Map<Ident, Value> variables, Map<Ident, List<ObservableStatement>> observableMap) {
        this.frame = frame;
        this.panel = panel;
        this.statement = statement;
        this.variables = variables;
        this.observableMap = observableMap;
    }

    public static JPanel render(JFrame frame, JPanel panel, Statement statement, Map<Ident, Value> variables, Map<Ident, List<ObservableStatement>> observableMap) {
        Renderer renderer = new Renderer(frame, panel, statement, variables, observableMap);
        statement.accept(renderer);
        return panel;
    }

    @Override
    public Void visit(Assignment node) {
        final String question = node.getQuestion();
        final JPanel questionPanel = new JPanel();
        questionPanel.add(new JLabel(question));

        final JPanel typePanel = new JPanel();
        final Type type = node.getType();
        type.accept(new RenderType(typePanel, node.getIdent(), this.variables, true));

        addQuestionPanel(questionPanel);
        addTypePanel(typePanel);

        return null;
    }

    private void addQuestionPanel(final Component question)
    {
        this.panel.add(question, "left, gapright 10");
    }

    private void addTypePanel(final Component type)
    {
        this.panel.add(type, "left, span");
    }

    @Override
    public Void visit(IfStatement node) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Void visit(Block node) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Void visit(ObservableStatement node) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
