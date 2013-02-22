package org.uva.sea.ql.codegeneration;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.SourceCodeInformation;
import org.uva.sea.ql.ast.expression.binary.Multiply;
import org.uva.sea.ql.ast.expression.primary.Ident;
import org.uva.sea.ql.ast.expression.primary.Int;
import org.uva.sea.ql.ast.expression.primary.Str;
import org.uva.sea.ql.ast.statement.Computation;
import org.uva.sea.ql.ast.statement.Question;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.ast.type.BooleanType;
import org.uva.sea.ql.ast.type.IntegerType;
import org.uva.sea.ql.ast.type.StringType;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class WebAppGeneratingVisitorTest {

    private WebAppCodeGenerator webAppCodeGenerator;

    private SourceCodeInformation sourceCodeInformation;

    @Before
    public void init() {
        this.webAppCodeGenerator = new WebAppCodeGenerator();
        this.sourceCodeInformation = new SourceCodeInformation(0, 0);
    }

    @Test
    public void testWebAppPageGeneration() throws IOException {
        List<Statement> statements = new ArrayList<Statement>();

        Question openQuestion = new Question(new Ident("age", sourceCodeInformation), new Str("How old are you?", sourceCodeInformation), new IntegerType());
        Question closedQuestion = new Question(new Ident("male", sourceCodeInformation), new Str("Are you male?", sourceCodeInformation), new BooleanType());
        Multiply twoTimesAge = new Multiply(new Int(2, sourceCodeInformation), new Ident("age", sourceCodeInformation), sourceCodeInformation);
        Computation computation = new Computation(new Ident("twoTimesAge", sourceCodeInformation), new Str("Two times age:", sourceCodeInformation), twoTimesAge);

        List<Statement> maleQuestions = new ArrayList<Statement>();
        maleQuestions.add(new Question(new Ident("likeBeer", sourceCodeInformation), new Str("Do you like beer?", sourceCodeInformation), new BooleanType()));

        List<Statement> liveInNetherlands = new ArrayList<Statement>();
        liveInNetherlands.add(new Question(new Ident("howLongNetherlands", sourceCodeInformation), new Str("How many years have you lived in the Netherlands?", sourceCodeInformation), new IntegerType()));
        List<Statement> noLiveInNetherlands = new ArrayList<Statement>();
        noLiveInNetherlands.add(new Question(new Ident("whereLive", sourceCodeInformation), new Str("Where do you live?", sourceCodeInformation), new StringType()));

        statements.add(openQuestion);
        statements.add(closedQuestion);
        statements.add(computation);

        Form form = new Form("QLForm", statements);
        String code = webAppCodeGenerator.generateCode(form);
        String assertionCode = FileUtils.readFileToString(new File("src/test/resources/generatedQLCode.html"));
        assertEquals(assertionCode.replaceAll("\\s", ""), code.replaceAll("\\s", ""));
    }


}
