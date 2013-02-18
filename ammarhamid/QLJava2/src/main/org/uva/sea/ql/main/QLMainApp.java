package org.uva.sea.ql.main;

import org.uva.sea.ql.VariableState;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.parser.IParser;
import org.uva.sea.ql.parser.impl.ANTLRParser;
import org.uva.sea.ql.visitor.impl.StatementWidgetVisitor;

import javax.swing.*;
import java.io.IOException;

public class QLMainApp
{
    private static JFrame frame;

    public static void main(String[] args) throws IOException
    {
        final IParser parser = new ANTLRParser();
        final String qlFilename = "/Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/resources/test.ql";
        // TODO check why cast is needed !!!
        final Statement statement = (Statement)parser.parseFormFromFile(qlFilename);

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
                frame = new JFrame("QL Main Application");
                final JPanel jPanel = StatementWidgetVisitor.render(statement, new VariableState());
                frame.getContentPane().add(jPanel);
                frame.pack();
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }

    public static JFrame getFrame()
    {
        return frame;
    }

}
