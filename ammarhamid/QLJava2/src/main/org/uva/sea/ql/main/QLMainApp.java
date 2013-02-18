package org.uva.sea.ql.main;

import org.uva.sea.ql.VariableState;
import org.uva.sea.ql.ast.FormNode;
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
        final FormNode formNode= parser.parseFormFromFile(qlFilename);
        final Statement statement = formNode.getBlockNode();

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

                frame = new JFrame(formNode.getFormName());
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
