package org.uva.sea.ql.visitor.codegeneration;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.QLStatement;
import org.uva.sea.ql.ast.SourceCodeInformation;
import org.uva.sea.ql.ast.primary.Ident;
import org.uva.sea.ql.ast.primary.Int;
import org.uva.sea.ql.ast.primary.Str;
import org.uva.sea.ql.ast.primary.typeClasses.BooleanType;
import org.uva.sea.ql.ast.primary.typeClasses.IntegerType;
import org.uva.sea.ql.ast.statement.Computation;
import org.uva.sea.ql.ast.statement.Question;

public class WebAppGeneratingVisitorTest {

    private WebAppGeneratingVisitor webAppGeneratingVisitor;

    private SourceCodeInformation sourceCodeInformation;

    @Before
    public void init() {
        this.webAppGeneratingVisitor = new WebAppGeneratingVisitor();
        this.sourceCodeInformation = new SourceCodeInformation(0, 0);
    }

    @Test
    public void testWebAppPageGeneration() {
        List<QLStatement> statements = new ArrayList<QLStatement>();

        Question openQuestion = new Question(new Ident("age", sourceCodeInformation), new Str("How old are you?", sourceCodeInformation), new IntegerType());
        Question closedQuestion = new Question(new Ident("male", sourceCodeInformation), new Str("Are you male?", sourceCodeInformation), new BooleanType());
        Computation computation = new Computation(new Ident("alwaysTen", sourceCodeInformation), new Str("Always 10:", sourceCodeInformation), new Int(10,
                sourceCodeInformation));

        statements.add(openQuestion);
        statements.add(closedQuestion);
        statements.add(computation);

        Form form = new Form("QLForm", statements);
        String code = webAppGeneratingVisitor.generateQLCodeForForm(form);
    }
}
