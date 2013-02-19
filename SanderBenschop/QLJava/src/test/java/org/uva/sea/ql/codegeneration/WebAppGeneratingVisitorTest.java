package org.uva.sea.ql.codegeneration;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.QLStatement;
import org.uva.sea.ql.ast.binary.Multiply;
import org.uva.sea.ql.ast.primary.Ident;
import org.uva.sea.ql.ast.primary.Int;
import org.uva.sea.ql.ast.primary.Str;
import org.uva.sea.ql.ast.type.BooleanType;
import org.uva.sea.ql.ast.type.IntegerType;
import org.uva.sea.ql.ast.type.StringType;
import org.uva.sea.ql.ast.sourcecodeinformation.SourceCodeInformation;
import org.uva.sea.ql.ast.sourcecodeinformation.SourceCodeInformationImpl;
import org.uva.sea.ql.ast.statement.Computation;
import org.uva.sea.ql.ast.statement.IfElseStatement;
import org.uva.sea.ql.ast.statement.IfStatement;
import org.uva.sea.ql.ast.statement.Question;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class WebAppGeneratingVisitorTest {

    private WebAppCodeGeneratingVisitor webAppGeneratingVisitor;

    private SourceCodeInformation sourceCodeInformation;

    @Before
    public void init() {
        this.webAppGeneratingVisitor = new WebAppCodeGeneratingVisitor();
        this.sourceCodeInformation = new SourceCodeInformationImpl(0, 0);
    }

    @Test
    public void testWebAppPageGeneration() throws IOException {
        List<QLStatement> statements = new ArrayList<QLStatement>();

        Question openQuestion = new Question(new Ident("age", sourceCodeInformation), new Str("How old are you?", sourceCodeInformation), new IntegerType());
        Question closedQuestion = new Question(new Ident("male", sourceCodeInformation), new Str("Are you male?", sourceCodeInformation), new BooleanType());
        Multiply twoTimesAge = new Multiply(new Int(2, sourceCodeInformation), new Ident("age", sourceCodeInformation), sourceCodeInformation);
        Computation computation = new Computation(new Ident("twoTimesAge", sourceCodeInformation), new Str("Two times age:", sourceCodeInformation), twoTimesAge);

        List<QLStatement> maleQuestions = new ArrayList<QLStatement>();
        maleQuestions.add(new Question(new Ident("likeBeer", sourceCodeInformation), new Str("Do you like beer?", sourceCodeInformation), new BooleanType()));
        IfStatement ifStatement = new IfStatement(new Ident("male", sourceCodeInformation), maleQuestions);

        List<QLStatement> liveInNetherlands = new ArrayList<QLStatement>();
        liveInNetherlands.add(new Question(new Ident("howLongNetherlands", sourceCodeInformation), new Str("How many years have you lived in the Netherlands?", sourceCodeInformation), new IntegerType()));
        List<QLStatement> noLiveInNetherlands = new ArrayList<QLStatement>();
        noLiveInNetherlands.add(new Question(new Ident("whereLive", sourceCodeInformation), new Str("Where do you live?", sourceCodeInformation), new StringType()));
        IfElseStatement ifElseStatement = new IfElseStatement(new Ident("male", sourceCodeInformation), liveInNetherlands, noLiveInNetherlands);


        statements.add(openQuestion);
        statements.add(closedQuestion);
        statements.add(computation);
        statements.add(ifStatement);
        statements.add(ifElseStatement);

        Form form = new Form("QLForm", statements);
        String code = webAppGeneratingVisitor.generateQLCode(form);
        String assertionCode = FileUtils.readFileToString(new File("src/test/resources/generatedQLCode.html"));
        assertEquals(assertionCode.replaceAll(" ", ""), code.replaceAll(" ", ""));
    }
}
