package org.uva.sea.ql.visitor.impl;

import net.miginfocom.swing.MigLayout;
import org.uva.sea.ql.VariableState;
import org.uva.sea.ql.ast.statement.AssignmentNode;
import org.uva.sea.ql.ast.statement.BlockNode;
import org.uva.sea.ql.ast.statement.IfNode;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.main.QLMainApp;
import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.value.Value;
import org.uva.sea.ql.value.impl.BooleanValue;
import org.uva.sea.ql.visitor.StatementVisitor;

import javax.swing.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class StatementWidgetVisitor implements StatementVisitor, Observer
{
    public static final String CONSTRAINTS = "right, gapright 12";
    private final JPanel panel;
    private final VariableState variableState;
    private final ConcurrentMap<String, IfNode> ifNodes;

    public StatementWidgetVisitor()
    {
        this.panel = new JPanel(new MigLayout());
        this.variableState = new VariableState();
        variableState.addObserver(this);
        this.ifNodes = new ConcurrentHashMap<>();
    }

    @Override
    public void visit(final AssignmentNode assignmentNode)
    {
        final String question = assignmentNode.getQuestion();
        final Type type = assignmentNode.getType();
        this.panel.add(new JLabel(question), CONSTRAINTS);
        type.accept(new TypeWidgetVisitor(this.panel, assignmentNode.getIdentifier(), this.variableState));
    }

    @Override
    public void visit(final BlockNode blockNode)
    {
        Collection<Statement> statements = blockNode.getStatements();
        for(Statement statement : statements)
        {
            statement.accept(this);
        }
    }

    @Override
    public void visit(IfNode ifNode)
    {
        System.out.println("Visiting ifNode");
        IfNode ifNode1 = this.ifNodes.putIfAbsent(ifNode.toString(), ifNode);

        final List<IfNode.Branch> branches = ifNode.getBranches();
        for(final IfNode.Branch branch : branches)
        {
            Value value = branch.evaluateExpression();
            // TODO check if casting is necessary here !!!
            BooleanValue value1 = ((BooleanValue) value);
            if(value1!=null && value1.getValue())
            {
                visit((BlockNode)(branch.getBlock()));
                panel.revalidate();
                panel.repaint();
                QLMainApp.getFrame().pack();
                return;
            }
        }
    }

    public JPanel getPanel()
    {
        return panel;
    }

    @Override
    public void update(Observable o, Object arg)
    {
        System.out.println("add variable: " +arg);
        Map<String, Value> variableMap = VariableState.getVariableMap();
        for(Map.Entry<String, Value> stringValueEntry : variableMap.entrySet())
        {
            System.out.println("stringValueEntry = " + stringValueEntry);
        }

        for(Map.Entry<String, IfNode> stringIfNodeEntry : ifNodes.entrySet())
        {
            visit(stringIfNodeEntry.getValue());
        }
    }
}
