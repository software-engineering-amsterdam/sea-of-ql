package org.uva.sea.ql.main;

import net.miginfocom.swing.MigLayout;
import org.uva.sea.ql.ast.FormNode;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.ast.statement.BlockNode;
import org.uva.sea.ql.parser.IParser;
import org.uva.sea.ql.parser.impl.ANTLRParser;
import org.uva.sea.ql.variable.VariableState;
import org.uva.sea.ql.visitor.impl.StatementWidgetVisitor;

import javax.swing.*;
import java.io.IOException;
import java.util.Collection;

public class QLMainApp
{

    public static void main(String[] args) throws IOException
    {
        final IParser parser = new ANTLRParser();
        final String qlFilename = "/Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/resources/test.ql";
        final FormNode formNode= parser.parseFormFromFile(qlFilename);
        final BlockNode blockNode = formNode.getBlockNode();
        final Collection<Statement> statements = blockNode.getStatements();
        final VariableState variableState = new VariableState();

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

                final JFrame frame = new JFrame(formNode.getFormName());
                final JPanel mainPanel = new JPanel(new MigLayout("hidemode 3"));

                // render statements widget
                for(final Statement statement : statements)
                {
                    StatementWidgetVisitor.render(frame, mainPanel, statement, variableState);
                }

                frame.getContentPane().add(mainPanel);
                frame.pack();
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }

}
