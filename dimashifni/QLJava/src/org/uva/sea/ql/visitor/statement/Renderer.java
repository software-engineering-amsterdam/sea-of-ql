package org.uva.sea.ql.visitor.statement;

import org.uva.sea.ql.ast.expression.Expr;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.statement.*;
import org.uva.sea.ql.control.Control;
import org.uva.sea.ql.observer.ComputedAssignmentObserver;
import org.uva.sea.ql.observer.IfConditionObserver;
import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.value.Value;
import org.uva.sea.ql.visitor.type.RenderType;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
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
    private final Map<Ident, Value> variables;
    private final Map<Ident, List<ObservableStatement>> observableMap;

    private Renderer(JFrame frame, JPanel panel, Map<Ident, Value> variables, Map<Ident, List<ObservableStatement>> observableMap) {
        this.frame = frame;
        this.panel = panel;
        this.variables = variables;
        this.observableMap = observableMap;
    }

    public static JPanel render(JFrame frame, JPanel panel, Statement statement, Map<Ident, Value> variables, Map<Ident, List<ObservableStatement>> observableMap) {
        Renderer renderer = new Renderer(frame, panel, variables, observableMap);
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
        type.accept(new RenderType(typePanel, node.getIdent(), this.variables, this.observableMap, true));

        addQuestionPanel(questionPanel);
        addTypePanel(typePanel);

        return null;
    }

    @Override
    public Void visit(IfStatement node) {
        Block ifBlock = node.getIfBlock();
        Block elseBlock = node.getElseBlock();

        // handle if block
        final List<Component> ifComponents = new ArrayList<Component>();
        handleBlock(ifBlock, ifComponents);

        // handle else block
        final List<Component> elseComponents = new ArrayList<Component>();
        if(elseBlock != null)
        {
            handleBlock(elseBlock, elseComponents);
        }

        // register condition observer
        registerConditionObserver(node, ifComponents, elseComponents);

        return null;
    }

    @Override
    public Void visit(ComputedAssignment node) {
        final String question = node.getQuestion();
        final JPanel questionPanel = new JPanel();
        questionPanel.add(new JLabel(question));
        addQuestionPanel(questionPanel);

        final JPanel typePanel = new JPanel();
        final Type type = node.getType();
        final RenderType renderType = new RenderType(typePanel, node.getIdent(), this.variables, this.observableMap, false);
        Control control = type.accept(renderType);
        addTypePanel(typePanel);

        registerComputedObserver(node, control);

        return null;
    }

    @Override
    public Void visit(Block node) {
        List<Statement> statements = node.getStatements();
        for (Statement s : statements) {
            s.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ObservableStatement node) {
        node.accept(this);
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

    private void handleBlock(Block ifBlock, List<Component> ifComponents) {
        for(final Statement statement : ifBlock.getStatements())
        {
            final JPanel jPanel = render(this.frame, new JPanel(), statement, this.variables, this.observableMap);

            final Component question = jPanel.getComponent(0);
            final Component type = jPanel.getComponent(1);

            ifComponents.add(question);
            ifComponents.add(type);

            addQuestionPanel(question);
            addTypePanel(type);
        }
    }

    private void registerConditionObserver(IfStatement ifStatement, List<Component> ifComponents, List<Component> elseComponents) {
        IfConditionObserver observer = new IfConditionObserver(this.frame, ifStatement.getOrExpression(), ifComponents, elseComponents, this.variables);
        ifStatement.addObserver(observer);

        // trigger observer
        observer.update(null, null);
    }

    private void registerComputedObserver(ComputedAssignment computedAssignment, Control control)
    {
        final ComputedAssignmentObserver observer = new ComputedAssignmentObserver(computedAssignment.getExpr(), control, this.variables);
        computedAssignment.addObserver(observer);
    }
}
