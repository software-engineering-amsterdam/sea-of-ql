package org.uva.sea.ql.main;

import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.parser.IParser;
import org.uva.sea.ql.parser.impl.ANTLRParser;
import org.uva.sea.ql.visitor.impl.StatementWidgetVisitor;

import javax.swing.*;
import java.io.IOException;

public class QLMainApp
{

    private static JPanel createPanel2() throws IOException
    {
        final IParser parser = new ANTLRParser();
        // TODO check why cast is needed !!!
        final Statement node = (Statement)parser.parseFormFromFile("/Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/resources/test.ql");
        final StatementWidgetVisitor statementVisitor = new StatementWidgetVisitor();
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
                frame = new JFrame("QL Main Application");
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

    private static JFrame frame;

    public static JFrame getFrame()
    {
        return frame;
    }

}
