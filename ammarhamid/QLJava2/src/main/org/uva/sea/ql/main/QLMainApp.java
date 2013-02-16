package org.uva.sea.ql.main;

import net.miginfocom.swing.MigLayout;
import org.uva.sea.ql.ast.statement.AssignmentNode;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.parser.IParser;
import org.uva.sea.ql.parser.impl.ANTLRParser;
import org.uva.sea.ql.type.impl.BooleanType;
import org.uva.sea.ql.type.impl.StringType;
import org.uva.sea.ql.visitor.impl.StatementWidgetVisitor;

import javax.swing.*;
import java.io.IOException;

public class QLMainApp
{

    private static JPanel createPanel()
    {
        final JPanel panel = new JPanel(new MigLayout());
        final AssignmentNode assignmentNode = new AssignmentNode("When you sold it?", "time", new StringType());
        final AssignmentNode assignmentNode2 = new AssignmentNode("really", "time", new BooleanType());
        final AssignmentNode assignmentNode3 = new AssignmentNode("Owww iya taa", "time", new BooleanType());
        final AssignmentNode assignmentNode4 = new AssignmentNode("Mosok seee??", "time", new StringType());
        final StatementWidgetVisitor statementVisitor = new StatementWidgetVisitor(panel);
        assignmentNode.accept(statementVisitor);
        assignmentNode2.accept(statementVisitor);
        assignmentNode3.accept(statementVisitor);
        assignmentNode4.accept(statementVisitor);
        return statementVisitor.getPanel();
    }

    private static JPanel createPanel2() throws IOException
    {
        final JPanel panel = new JPanel(new MigLayout());
        final IParser parser = new ANTLRParser();
        // TODO check why cast is needed !!!
        final Statement node = (Statement)parser.parseFormFromFile("/Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/resources/test.ql");
        final StatementWidgetVisitor statementVisitor = new StatementWidgetVisitor(panel);
        node.accept(statementVisitor);

        return statementVisitor.getPanel();
    }

    public static void main(String[] args)
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

                // TODO title from the form name ??
                JFrame frame = new JFrame("QL Main Application");
                try
                {
                    frame.getContentPane().add(createPanel2());
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
                frame.pack();
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }

}
