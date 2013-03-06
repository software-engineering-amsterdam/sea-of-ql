package org.uva.sea.ql.parser.antlr;

import net.miginfocom.swing.MigLayout;
import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.expression.Expr;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.statement.Block;
import org.uva.sea.ql.ast.statement.ObservableStatement;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.value.Value;
import org.uva.sea.ql.visitor.statement.Renderer;
import org.uva.sea.ql.visitor.statement.StatementDependencyAnalyzer;
import org.uva.sea.ql.visitor.statement.StatementValidator;

import javax.swing.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ANTLRParser implements IParse {

    @Override
    public Expr parse(String src) throws ParseError {
        ANTLRStringStream stream = new ANTLRStringStream(src);
        CommonTokenStream tokens = new CommonTokenStream();
        tokens.setTokenSource(new QLLexer(stream));
        QLParser parser = new QLParser(tokens);
        try {
            return parser.orExpression().result;
        } catch (RecognitionException e) {
            throw new ParseError(e.getMessage());
        }
    }

    @Override
    public ASTNode parseForm(String src) throws ParseError {
        ANTLRStringStream stream = new ANTLRStringStream(src);
        CommonTokenStream tokens = new CommonTokenStream();
        tokens.setTokenSource(new QLLexer(stream));
        QLParser parser = new QLParser(tokens);
        try {
            return parser.form().node;
        } catch (RecognitionException e) {
            throw new ParseError(e.getMessage());
        }
    }

    public static void main(String[] args) throws RecognitionException, IOException {
        ANTLRStringStream stream = new ANTLRFileStream(args[0]);
        CommonTokenStream tokens = new CommonTokenStream();
        tokens.setTokenSource(new QLLexer(stream));
        QLParser parser = new QLParser(tokens);
        try {
            Block block = parser.form().node;

            // variable map
            Map<Ident, Value> variables = new HashMap<Ident, Value>();
            Map<Ident, List<ObservableStatement>> observableMap = new HashMap<Ident, List<ObservableStatement>>();

            StatementDependencyAnalyzer statementDependencyAnalyzer = new StatementDependencyAnalyzer(variables, observableMap);
            StatementValidator statementValidator = new StatementValidator();

            // validate statement
            block.accept(statementValidator);

            // check dependency
            block.accept(statementDependencyAnalyzer);

            // generate GUI
            if (statementValidator.getErrors().isEmpty()) {
                renderGUI(block, variables, observableMap);
            } else {
                // error founds - no need to generate GUI
                System.out.println(statementValidator.getErrors());
                System.exit(1);
            }

        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }

    private static void renderGUI(final Block block, final Map<Ident, Value> variables, final Map<Ident, List<ObservableStatement>> observableStatementMap) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                final JFrame frame = new JFrame("QL Test");
                final JPanel mainPanel = new JPanel(new MigLayout("hidemode 3"));
                renderWidget(frame, mainPanel, block, variables, observableStatementMap);
                frame.getContentPane().add(mainPanel);
                frame.pack();
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }

    private static void renderWidget(final JFrame frame, final JPanel mainPanel, final Block block, final Map<Ident, Value> variables, final Map<Ident, List<ObservableStatement>> observableStatementMap) {
        // render statements control
        for (final Statement statement : block.getStatements()) {
            Renderer.render(frame, mainPanel, statement, variables, observableStatementMap);
        }
    }

}
