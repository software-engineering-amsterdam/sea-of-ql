package org.uva.sea.ql.visitor.statement;

import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.statement.*;
import org.uva.sea.ql.value.Value;
import org.uva.sea.ql.visitor.expression.ExpressionDefaultValue;
import org.uva.sea.ql.visitor.expression.ExpressionDependencyAnalyzer;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: dimashifni
 * Date: 3/3/13
 * Time: 3:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class StatementDependencyAnalyzer implements StatementVisitor<Void> {
    private final Map<Ident, Value> variables;
    private Map<Ident, List<ObservableStatement>> observableMap;

    public StatementDependencyAnalyzer(Map<Ident, Value> variables, Map<Ident, List<ObservableStatement>> observableMap) {
        this.variables = variables;
        this.observableMap = observableMap;
    }

    @Override
    public Void visit(Assignment node) {
        // default value
        ExpressionDefaultValue expressionDefaultValue = new ExpressionDefaultValue(variables);
        node.getIdent().accept(expressionDefaultValue);

        return null;
    }

    @Override
    public Void visit(IfStatement node) {
        final ExpressionDependencyAnalyzer expressionDependencyAnalyzer = new ExpressionDependencyAnalyzer(node, this.observableMap);
        node.getOrExpression().accept(expressionDependencyAnalyzer);
        node.getIfBlock().accept(this);
        if(node.getElseBlock() != null) {
            node.getElseBlock().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(Block node) {
        List<Statement> statements = node.getStatements();
        for (Statement statement : statements) {
            statement.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ObservableStatement node) {
        return node.accept(this);
    }
}
