package org.uva.sea.ql.main;

import net.miginfocom.swing.MigLayout;
import org.uva.sea.ql.Message;
import org.uva.sea.ql.ast.FormNode;
import org.uva.sea.ql.ast.statement.BlockNode;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.parser.IParser;
import org.uva.sea.ql.parser.impl.ANTLRParser;
import org.uva.sea.ql.variable.VariableState;
import org.uva.sea.ql.visitor.StatementVisitor;
import org.uva.sea.ql.visitor.impl.StatementCheckVisitor;
import org.uva.sea.ql.visitor.impl.StatementDependencyVisitor;
import org.uva.sea.ql.visitor.impl.StatementWidgetVisitor;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class QLMainApp
{
    private static final String QL_FILENAME = "/Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/resources/test.ql";
    public static final String LAYOUT_CONSTRAINTS = "hidemode 3";

    public static void main(String[] args) throws IOException
    {
        // parsing QL program
        final IParser parser = new ANTLRParser();
        final FormNode formNode = parser.parseFormFromFile(QL_FILENAME);
        final BlockNode blockNode = formNode.getBlockNode();
        final Collection<Statement> statements = blockNode.getStatements();

        final VariableState variableState = new VariableState(formNode.getVariables());
        final Collection<Message> errors = new ArrayList<>();

        // statement validation check
        validateStatement(statements, errors);

        // statement dependency analysis
        analyzeStatementDependency(statements, variableState);

        // render GUI
        renderGUI(formNode.getFormName(), statements, variableState);
    }

    private static void renderWidget(final JFrame frame, final JPanel mainPanel, final Collection<Statement> statements, final VariableState variableState)
    {
        // render statements widget
        for(final Statement statement : statements)
        {
            StatementWidgetVisitor.render(frame, mainPanel, statement, variableState);
        }
    }

    private static void validateStatement(final Collection<Statement> statements, final Collection<Message> errors)
    {
        final StatementVisitor statementCheckVisitor = new StatementCheckVisitor(errors);
        for(final Statement statement : statements)
        {
            statement.accept(statementCheckVisitor);
        }

        if(!errors.isEmpty())
        {
            System.out.println("Semantic errors found:");
            for(final Message error : errors)
            {
                System.out.println(error);
            }
        }

        if(!errors.isEmpty())
        {
            // there is no point going forward, exit the application
            System.exit(1);
        }
    }

    private static void analyzeStatementDependency(final Collection<Statement> statements, final VariableState variableState)
    {
        final StatementVisitor statementVisitor = new StatementDependencyVisitor(variableState);
        for(final Statement statement : statements)
        {
            statement.accept(statementVisitor);
        }
    }

    private static void renderGUI(final String formName, final Collection<Statement> statements, final VariableState variableState)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                try
                {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }

                final JFrame frame = new JFrame(formName);
                final JPanel mainPanel = new JPanel(new MigLayout(LAYOUT_CONSTRAINTS));
                renderWidget(frame, mainPanel, statements, variableState);
                frame.getContentPane().add(mainPanel);
                frame.pack();
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }

}
