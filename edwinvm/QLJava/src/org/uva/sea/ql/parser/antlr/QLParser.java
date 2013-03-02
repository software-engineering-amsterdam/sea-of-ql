// $ANTLR 3.4 C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g 2013-03-02 20:12:44

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.forms.*;
import org.uva.sea.ql.ast.expressions.*;
import org.uva.sea.ql.ast.expressions.arithmetic.*;
import org.uva.sea.ql.ast.expressions.logical.*;
import org.uva.sea.ql.ast.expressions.relational.*;
import org.uva.sea.ql.ast.statements.conditions.*;
import org.uva.sea.ql.ast.statements.questions.*;
import org.uva.sea.ql.ast.statements.*;
import org.uva.sea.ql.ast.values.*;
import org.uva.sea.ql.ast.types.*;
import java.util.ArrayList;
import java.util.List;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class QLParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Bool", "COMMENT", "Identifier", "Int", "Money", "String", "WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", "'/'", "':'", "'<'", "'<='", "'='", "'=='", "'>'", "'>='", "'boolean'", "'else'", "'form'", "'if'", "'integer'", "'money'", "'string'", "'{'", "'||'", "'}'"
    };

    public static final int EOF=-1;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int Bool=4;
    public static final int COMMENT=5;
    public static final int Identifier=6;
    public static final int Int=7;
    public static final int Money=8;
    public static final int String=9;
    public static final int WS=10;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public QLParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public QLParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
        this.state.ruleMemo = new HashMap[45+1];
         

    }

    public String[] getTokenNames() { return QLParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g"; }



    // $ANTLR start "form"
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:27:1: form returns [Form result] : 'form' Identifier '{' statementBody '}' ;
    public final Form form() throws RecognitionException {
        Form result = null;

        int form_StartIndex = input.index();

        Token Identifier1=null;
        StatementBody statementBody2 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:28:5: ( 'form' Identifier '{' statementBody '}' )
            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:28:9: 'form' Identifier '{' statementBody '}'
            {
            match(input,29,FOLLOW_29_in_form50); if (state.failed) return result;

            Identifier1=(Token)match(input,Identifier,FOLLOW_Identifier_in_form52); if (state.failed) return result;

            match(input,34,FOLLOW_34_in_form54); if (state.failed) return result;

            pushFollow(FOLLOW_statementBody_in_form56);
            statementBody2=statementBody();

            state._fsp--;
            if (state.failed) return result;

            match(input,36,FOLLOW_36_in_form58); if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new Form(new Identifier((Identifier1!=null?Identifier1.getText():null)), statementBody2); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 1, form_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "form"



    // $ANTLR start "formStatement"
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:31:1: formStatement returns [FormStatement result] : ( question | conditionBlock );
    public final FormStatement formStatement() throws RecognitionException {
        FormStatement result = null;

        int formStatement_StartIndex = input.index();

        Question question3 =null;

        ConditionBlock conditionBlock4 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:32:5: ( question | conditionBlock )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==String) ) {
                alt1=1;
            }
            else if ( (LA1_0==30) ) {
                alt1=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;

            }
            switch (alt1) {
                case 1 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:32:9: question
                    {
                    pushFollow(FOLLOW_question_in_formStatement83);
                    question3=question();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = question3; }

                    }
                    break;
                case 2 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:33:9: conditionBlock
                    {
                    pushFollow(FOLLOW_conditionBlock_in_formStatement101);
                    conditionBlock4=conditionBlock();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = conditionBlock4; }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 2, formStatement_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "formStatement"



    // $ANTLR start "question"
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:36:1: question returns [Question result] : (label= questionLabel variable= questionVariable ':' type |label= questionLabel variable= questionVariable '=' expression );
    public final Question question() throws RecognitionException {
        Question result = null;

        int question_StartIndex = input.index();

        QuestionLabel label =null;

        QuestionVariable variable =null;

        Type type5 =null;

        Expression expression6 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:37:5: (label= questionLabel variable= questionVariable ':' type |label= questionLabel variable= questionVariable '=' expression )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==String) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==Identifier) ) {
                    int LA2_2 = input.LA(3);

                    if ( (LA2_2==20) ) {
                        alt2=1;
                    }
                    else if ( (LA2_2==23) ) {
                        alt2=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return result;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 2, 2, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return result;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }
            switch (alt2) {
                case 1 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:37:9: label= questionLabel variable= questionVariable ':' type
                    {
                    pushFollow(FOLLOW_questionLabel_in_question130);
                    label=questionLabel();

                    state._fsp--;
                    if (state.failed) return result;

                    pushFollow(FOLLOW_questionVariable_in_question136);
                    variable=questionVariable();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,20,FOLLOW_20_in_question138); if (state.failed) return result;

                    pushFollow(FOLLOW_type_in_question140);
                    type5=type();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new AnswerableQuestion(label, variable, type5); }

                    }
                    break;
                case 2 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:38:9: label= questionLabel variable= questionVariable '=' expression
                    {
                    pushFollow(FOLLOW_questionLabel_in_question160);
                    label=questionLabel();

                    state._fsp--;
                    if (state.failed) return result;

                    pushFollow(FOLLOW_questionVariable_in_question166);
                    variable=questionVariable();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,23,FOLLOW_23_in_question168); if (state.failed) return result;

                    pushFollow(FOLLOW_expression_in_question170);
                    expression6=expression();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new ComputedQuestion(label, variable, expression6); }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 3, question_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "question"



    // $ANTLR start "questionLabel"
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:41:1: questionLabel returns [QuestionLabel result] : String ;
    public final QuestionLabel questionLabel() throws RecognitionException {
        QuestionLabel result = null;

        int questionLabel_StartIndex = input.index();

        Token String7=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:42:5: ( String )
            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:42:9: String
            {
            String7=(Token)match(input,String,FOLLOW_String_in_questionLabel195); if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new QuestionLabel(new org.uva.sea.ql.ast.values.Str((String7!=null?String7.getText():null).replace("\"", ""))); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 4, questionLabel_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "questionLabel"



    // $ANTLR start "questionVariable"
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:45:1: questionVariable returns [QuestionVariable result] : Identifier ;
    public final QuestionVariable questionVariable() throws RecognitionException {
        QuestionVariable result = null;

        int questionVariable_StartIndex = input.index();

        Token Identifier8=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:46:5: ( Identifier )
            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:46:9: Identifier
            {
            Identifier8=(Token)match(input,Identifier,FOLLOW_Identifier_in_questionVariable224); if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new QuestionVariable(new Identifier((Identifier8!=null?Identifier8.getText():null))); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 5, questionVariable_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "questionVariable"



    // $ANTLR start "conditionBlock"
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:49:1: conditionBlock returns [ConditionBlock result] : ( 'if' '(' condition= expression ')' ifBody= statementBody 'else' elseBody= statementBody | 'if' '(' condition= expression ')' ifBody= statementBody );
    public final ConditionBlock conditionBlock() throws RecognitionException {
        ConditionBlock result = null;

        int conditionBlock_StartIndex = input.index();

        Expression condition =null;

        StatementBody ifBody =null;

        StatementBody elseBody =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:50:5: ( 'if' '(' condition= expression ')' ifBody= statementBody 'else' elseBody= statementBody | 'if' '(' condition= expression ')' ifBody= statementBody )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==30) ) {
                int LA3_1 = input.LA(2);

                if ( (synpred3_QL()) ) {
                    alt3=1;
                }
                else if ( (true) ) {
                    alt3=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return result;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }
            switch (alt3) {
                case 1 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:50:9: 'if' '(' condition= expression ')' ifBody= statementBody 'else' elseBody= statementBody
                    {
                    match(input,30,FOLLOW_30_in_conditionBlock249); if (state.failed) return result;

                    match(input,14,FOLLOW_14_in_conditionBlock251); if (state.failed) return result;

                    pushFollow(FOLLOW_expression_in_conditionBlock255);
                    condition=expression();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,15,FOLLOW_15_in_conditionBlock257); if (state.failed) return result;

                    pushFollow(FOLLOW_statementBody_in_conditionBlock261);
                    ifBody=statementBody();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,28,FOLLOW_28_in_conditionBlock263); if (state.failed) return result;

                    pushFollow(FOLLOW_statementBody_in_conditionBlock267);
                    elseBody=statementBody();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new IfThenElseStatement(condition, ifBody, elseBody); }

                    }
                    break;
                case 2 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:52:9: 'if' '(' condition= expression ')' ifBody= statementBody
                    {
                    match(input,30,FOLLOW_30_in_conditionBlock287); if (state.failed) return result;

                    match(input,14,FOLLOW_14_in_conditionBlock289); if (state.failed) return result;

                    pushFollow(FOLLOW_expression_in_conditionBlock293);
                    condition=expression();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,15,FOLLOW_15_in_conditionBlock295); if (state.failed) return result;

                    pushFollow(FOLLOW_statementBody_in_conditionBlock299);
                    ifBody=statementBody();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new IfThenStatement(condition, ifBody); }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 6, conditionBlock_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "conditionBlock"



    // $ANTLR start "statementBody"
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:56:1: statementBody returns [StatementBody result] : ( '{' (statement= formStatement )+ '}' | (statement= formStatement )+ );
    public final StatementBody statementBody() throws RecognitionException {
        StatementBody result = null;

        int statementBody_StartIndex = input.index();

        FormStatement statement =null;


         StatementBody statements = new StatementBody(); 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:59:5: ( '{' (statement= formStatement )+ '}' | (statement= formStatement )+ )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==34) ) {
                alt6=1;
            }
            else if ( (LA6_0==String||LA6_0==30) ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;

            }
            switch (alt6) {
                case 1 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:59:9: '{' (statement= formStatement )+ '}'
                    {
                    match(input,34,FOLLOW_34_in_statementBody348); if (state.failed) return result;

                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:59:13: (statement= formStatement )+
                    int cnt4=0;
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==String||LA4_0==30) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:59:14: statement= formStatement
                    	    {
                    	    pushFollow(FOLLOW_formStatement_in_statementBody353);
                    	    statement=formStatement();

                    	    state._fsp--;
                    	    if (state.failed) return result;

                    	    if ( state.backtracking==0 ) { statements.add(statement); }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt4 >= 1 ) break loop4;
                    	    if (state.backtracking>0) {state.failed=true; return result;}
                                EarlyExitException eee =
                                    new EarlyExitException(4, input);
                                throw eee;
                        }
                        cnt4++;
                    } while (true);


                    match(input,36,FOLLOW_36_in_statementBody359); if (state.failed) return result;

                    }
                    break;
                case 2 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:60:13: (statement= formStatement )+
                    {
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:60:13: (statement= formStatement )+
                    int cnt5=0;
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==String) ) {
                            int LA5_2 = input.LA(2);

                            if ( (synpred6_QL()) ) {
                                alt5=1;
                            }


                        }
                        else if ( (LA5_0==30) ) {
                            int LA5_3 = input.LA(2);

                            if ( (synpred6_QL()) ) {
                                alt5=1;
                            }


                        }


                        switch (alt5) {
                    	case 1 :
                    	    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:60:14: statement= formStatement
                    	    {
                    	    pushFollow(FOLLOW_formStatement_in_statementBody376);
                    	    statement=formStatement();

                    	    state._fsp--;
                    	    if (state.failed) return result;

                    	    if ( state.backtracking==0 ) { statements.add(statement); }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt5 >= 1 ) break loop5;
                    	    if (state.backtracking>0) {state.failed=true; return result;}
                                EarlyExitException eee =
                                    new EarlyExitException(5, input);
                                throw eee;
                        }
                        cnt5++;
                    } while (true);


                    }
                    break;

            }
            if ( state.backtracking==0 ) { result = statements; }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 7, statementBody_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "statementBody"



    // $ANTLR start "primary"
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:63:1: primary returns [Expression result] : ( Int | Bool | Money | String | Identifier | '(' e= expression ')' );
    public final Expression primary() throws RecognitionException {
        Expression result = null;

        int primary_StartIndex = input.index();

        Token Int9=null;
        Token Bool10=null;
        Token Money11=null;
        Token String12=null;
        Token Identifier13=null;
        Expression e =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:64:5: ( Int | Bool | Money | String | Identifier | '(' e= expression ')' )
            int alt7=6;
            switch ( input.LA(1) ) {
            case Int:
                {
                alt7=1;
                }
                break;
            case Bool:
                {
                alt7=2;
                }
                break;
            case Money:
                {
                alt7=3;
                }
                break;
            case String:
                {
                alt7=4;
                }
                break;
            case Identifier:
                {
                alt7=5;
                }
                break;
            case 14:
                {
                alt7=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;

            }

            switch (alt7) {
                case 1 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:64:9: Int
                    {
                    Int9=(Token)match(input,Int,FOLLOW_Int_in_primary403); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.values.Int(Integer.parseInt((Int9!=null?Int9.getText():null))); }

                    }
                    break;
                case 2 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:65:9: Bool
                    {
                    Bool10=(Token)match(input,Bool,FOLLOW_Bool_in_primary422); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.values.Bool(Boolean.parseBoolean((Bool10!=null?Bool10.getText():null))); }

                    }
                    break;
                case 3 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:66:9: Money
                    {
                    Money11=(Token)match(input,Money,FOLLOW_Money_in_primary440); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.values.Money(Double.parseDouble((Money11!=null?Money11.getText():null).replace(',', '.'))); }

                    }
                    break;
                case 4 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:67:9: String
                    {
                    String12=(Token)match(input,String,FOLLOW_String_in_primary457); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.values.Str((String12!=null?String12.getText():null).replace("\"", "")); }

                    }
                    break;
                case 5 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:68:9: Identifier
                    {
                    Identifier13=(Token)match(input,Identifier,FOLLOW_Identifier_in_primary473); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Identifier((Identifier13!=null?Identifier13.getText():null)); }

                    }
                    break;
                case 6 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:69:9: '(' e= expression ')'
                    {
                    match(input,14,FOLLOW_14_in_primary485); if (state.failed) return result;

                    pushFollow(FOLLOW_expression_in_primary489);
                    e=expression();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,15,FOLLOW_15_in_primary491); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = e; }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 8, primary_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "primary"



    // $ANTLR start "unaryExpression"
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:72:1: unaryExpression returns [Expression result] : ( '+' e= unaryExpression | '-' e= unaryExpression | '!' e= unaryExpression |e= primary );
    public final Expression unaryExpression() throws RecognitionException {
        Expression result = null;

        int unaryExpression_StartIndex = input.index();

        Expression e =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:73:5: ( '+' e= unaryExpression | '-' e= unaryExpression | '!' e= unaryExpression |e= primary )
            int alt8=4;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt8=1;
                }
                break;
            case 18:
                {
                alt8=2;
                }
                break;
            case 11:
                {
                alt8=3;
                }
                break;
            case Bool:
            case Identifier:
            case Int:
            case Money:
            case String:
            case 14:
                {
                alt8=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;

            }

            switch (alt8) {
                case 1 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:73:9: '+' e= unaryExpression
                    {
                    match(input,17,FOLLOW_17_in_unaryExpression519); if (state.failed) return result;

                    pushFollow(FOLLOW_unaryExpression_in_unaryExpression523);
                    e=unaryExpression();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new PositiveExpression(e); }

                    }
                    break;
                case 2 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:74:9: '-' e= unaryExpression
                    {
                    match(input,18,FOLLOW_18_in_unaryExpression535); if (state.failed) return result;

                    pushFollow(FOLLOW_unaryExpression_in_unaryExpression539);
                    e=unaryExpression();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new NegativeExpression(e); }

                    }
                    break;
                case 3 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:75:9: '!' e= unaryExpression
                    {
                    match(input,11,FOLLOW_11_in_unaryExpression551); if (state.failed) return result;

                    pushFollow(FOLLOW_unaryExpression_in_unaryExpression555);
                    e=unaryExpression();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new NegationalExpression(e); }

                    }
                    break;
                case 4 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:76:9: e= primary
                    {
                    pushFollow(FOLLOW_primary_in_unaryExpression569);
                    e=primary();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = e; }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 9, unaryExpression_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "unaryExpression"



    // $ANTLR start "multiplicationExpression"
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:79:1: multiplicationExpression returns [Expression result] : leftHandSide= unaryExpression (op= ( '*' | '/' ) rightHandSide= unaryExpression )* ;
    public final Expression multiplicationExpression() throws RecognitionException {
        Expression result = null;

        int multiplicationExpression_StartIndex = input.index();

        Token op=null;
        Expression leftHandSide =null;

        Expression rightHandSide =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:80:5: (leftHandSide= unaryExpression (op= ( '*' | '/' ) rightHandSide= unaryExpression )* )
            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:80:9: leftHandSide= unaryExpression (op= ( '*' | '/' ) rightHandSide= unaryExpression )*
            {
            pushFollow(FOLLOW_unaryExpression_in_multiplicationExpression619);
            leftHandSide=unaryExpression();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = leftHandSide; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:80:69: (op= ( '*' | '/' ) rightHandSide= unaryExpression )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==16||LA9_0==19) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:80:71: op= ( '*' | '/' ) rightHandSide= unaryExpression
            	    {
            	    op=(Token)input.LT(1);

            	    if ( input.LA(1)==16||input.LA(1)==19 ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_unaryExpression_in_multiplicationExpression650);
            	    rightHandSide=unaryExpression();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { 
            	            if ((op!=null?op.getText():null).equals("*")) { result = new Multiplication(leftHandSide, rightHandSide); }
            	            if ((op!=null?op.getText():null).equals("/")) { result = new Division(leftHandSide,       rightHandSide); }
            	        }

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 10, multiplicationExpression_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "multiplicationExpression"



    // $ANTLR start "additionExpression"
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:88:1: additionExpression returns [Expression result] : leftHandSide= multiplicationExpression (op= ( '+' | '-' ) rightHandSide= multiplicationExpression )* ;
    public final Expression additionExpression() throws RecognitionException {
        Expression result = null;

        int additionExpression_StartIndex = input.index();

        Token op=null;
        Expression leftHandSide =null;

        Expression rightHandSide =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:89:5: (leftHandSide= multiplicationExpression (op= ( '+' | '-' ) rightHandSide= multiplicationExpression )* )
            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:89:9: leftHandSide= multiplicationExpression (op= ( '+' | '-' ) rightHandSide= multiplicationExpression )*
            {
            pushFollow(FOLLOW_multiplicationExpression_in_additionExpression691);
            leftHandSide=multiplicationExpression();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = leftHandSide; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:89:78: (op= ( '+' | '-' ) rightHandSide= multiplicationExpression )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0 >= 17 && LA10_0 <= 18)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:89:80: op= ( '+' | '-' ) rightHandSide= multiplicationExpression
            	    {
            	    op=(Token)input.LT(1);

            	    if ( (input.LA(1) >= 17 && input.LA(1) <= 18) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_multiplicationExpression_in_additionExpression722);
            	    rightHandSide=multiplicationExpression();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { 
            	            if ((op!=null?op.getText():null).equals("+")) { result = new Addition(leftHandSide,    rightHandSide); }
            	            if ((op!=null?op.getText():null).equals("-")) { result = new Subtraction(leftHandSide, rightHandSide); }
            	        }

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 11, additionExpression_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "additionExpression"



    // $ANTLR start "relationalExpression"
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:97:1: relationalExpression returns [Expression result] : leftHandSide= additionExpression (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rightHandSide= additionExpression )* ;
    public final Expression relationalExpression() throws RecognitionException {
        Expression result = null;

        int relationalExpression_StartIndex = input.index();

        Token op=null;
        Expression leftHandSide =null;

        Expression rightHandSide =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:98:5: (leftHandSide= additionExpression (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rightHandSide= additionExpression )* )
            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:98:9: leftHandSide= additionExpression (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rightHandSide= additionExpression )*
            {
            pushFollow(FOLLOW_additionExpression_in_relationalExpression760);
            leftHandSide=additionExpression();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = leftHandSide; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:98:72: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rightHandSide= additionExpression )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==12||(LA11_0 >= 21 && LA11_0 <= 22)||(LA11_0 >= 24 && LA11_0 <= 26)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:98:74: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rightHandSide= additionExpression
            	    {
            	    op=(Token)input.LT(1);

            	    if ( input.LA(1)==12||(input.LA(1) >= 21 && input.LA(1) <= 22)||(input.LA(1) >= 24 && input.LA(1) <= 26) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_additionExpression_in_relationalExpression797);
            	    rightHandSide=additionExpression();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { 
            	            if ((op!=null?op.getText():null).equals("<"))  { result = new LessThanExpression(leftHandSide,             rightHandSide); }
            	            if ((op!=null?op.getText():null).equals("<=")) { result = new LessThanOrEqualToExpression(leftHandSide,    rightHandSide); }
            	            if ((op!=null?op.getText():null).equals(">"))  { result = new GreaterThanExpression(leftHandSide,          rightHandSide); }
            	            if ((op!=null?op.getText():null).equals(">=")) { result = new GreaterThanOrEqualToExpression(leftHandSide, rightHandSide); }
            	            if ((op!=null?op.getText():null).equals("==")) { result = new EqualToExpression(leftHandSide,              rightHandSide); }
            	            if ((op!=null?op.getText():null).equals("!=")) { result = new NotEqualToExpression(leftHandSide,           rightHandSide); }
            	        }

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 12, relationalExpression_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "relationalExpression"



    // $ANTLR start "logicallyEquivalentExpression"
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:110:1: logicallyEquivalentExpression returns [Expression result] : leftHandSide= relationalExpression ( '&&' rightHandSide= relationalExpression )* ;
    public final Expression logicallyEquivalentExpression() throws RecognitionException {
        Expression result = null;

        int logicallyEquivalentExpression_StartIndex = input.index();

        Expression leftHandSide =null;

        Expression rightHandSide =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:111:5: (leftHandSide= relationalExpression ( '&&' rightHandSide= relationalExpression )* )
            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:111:9: leftHandSide= relationalExpression ( '&&' rightHandSide= relationalExpression )*
            {
            pushFollow(FOLLOW_relationalExpression_in_logicallyEquivalentExpression838);
            leftHandSide=relationalExpression();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = leftHandSide; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:111:74: ( '&&' rightHandSide= relationalExpression )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==13) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:111:76: '&&' rightHandSide= relationalExpression
            	    {
            	    match(input,13,FOLLOW_13_in_logicallyEquivalentExpression844); if (state.failed) return result;

            	    pushFollow(FOLLOW_relationalExpression_in_logicallyEquivalentExpression859);
            	    rightHandSide=relationalExpression();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { result = new LogicallyEquivalentExpression(leftHandSide, rightHandSide); }

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 13, logicallyEquivalentExpression_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "logicallyEquivalentExpression"



    // $ANTLR start "logicallyEquivalentOrNotExpression"
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:115:1: logicallyEquivalentOrNotExpression returns [Expression result] : leftHandSide= logicallyEquivalentExpression ( '||' rightHandSide= logicallyEquivalentExpression )* ;
    public final Expression logicallyEquivalentOrNotExpression() throws RecognitionException {
        Expression result = null;

        int logicallyEquivalentOrNotExpression_StartIndex = input.index();

        Expression leftHandSide =null;

        Expression rightHandSide =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:116:5: (leftHandSide= logicallyEquivalentExpression ( '||' rightHandSide= logicallyEquivalentExpression )* )
            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:116:9: leftHandSide= logicallyEquivalentExpression ( '||' rightHandSide= logicallyEquivalentExpression )*
            {
            pushFollow(FOLLOW_logicallyEquivalentExpression_in_logicallyEquivalentOrNotExpression896);
            leftHandSide=logicallyEquivalentExpression();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = leftHandSide; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:116:83: ( '||' rightHandSide= logicallyEquivalentExpression )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==35) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:116:85: '||' rightHandSide= logicallyEquivalentExpression
            	    {
            	    match(input,35,FOLLOW_35_in_logicallyEquivalentOrNotExpression902); if (state.failed) return result;

            	    pushFollow(FOLLOW_logicallyEquivalentExpression_in_logicallyEquivalentOrNotExpression917);
            	    rightHandSide=logicallyEquivalentExpression();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { result = new LogicallyEquivalentOrNotExpression(leftHandSide, rightHandSide); }

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 14, logicallyEquivalentOrNotExpression_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "logicallyEquivalentOrNotExpression"



    // $ANTLR start "expression"
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:120:1: expression returns [Expression result] : getExpression= logicallyEquivalentOrNotExpression ;
    public final Expression expression() throws RecognitionException {
        Expression result = null;

        int expression_StartIndex = input.index();

        Expression getExpression =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:121:5: (getExpression= logicallyEquivalentOrNotExpression )
            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:121:9: getExpression= logicallyEquivalentOrNotExpression
            {
            pushFollow(FOLLOW_logicallyEquivalentOrNotExpression_in_expression947);
            getExpression=logicallyEquivalentOrNotExpression();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = getExpression; }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 15, expression_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "expression"



    // $ANTLR start "type"
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:124:1: type returns [Type result] : ( 'integer' | 'string' | 'boolean' | 'money' );
    public final Type type() throws RecognitionException {
        Type result = null;

        int type_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:125:5: ( 'integer' | 'string' | 'boolean' | 'money' )
            int alt14=4;
            switch ( input.LA(1) ) {
            case 31:
                {
                alt14=1;
                }
                break;
            case 33:
                {
                alt14=2;
                }
                break;
            case 27:
                {
                alt14=3;
                }
                break;
            case 32:
                {
                alt14=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;

            }

            switch (alt14) {
                case 1 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:125:9: 'integer'
                    {
                    match(input,31,FOLLOW_31_in_type972); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.types.Int();   }

                    }
                    break;
                case 2 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:126:9: 'string'
                    {
                    match(input,33,FOLLOW_33_in_type984); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.types.Str();   }

                    }
                    break;
                case 3 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:127:9: 'boolean'
                    {
                    match(input,27,FOLLOW_27_in_type997); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.types.Bool();  }

                    }
                    break;
                case 4 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:128:9: 'money'
                    {
                    match(input,32,FOLLOW_32_in_type1009); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.types.Money(); }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 16, type_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "type"

    // $ANTLR start synpred3_QL
    public final void synpred3_QL_fragment() throws RecognitionException {
        Expression condition =null;

        StatementBody ifBody =null;

        StatementBody elseBody =null;


        // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:50:9: ( 'if' '(' condition= expression ')' ifBody= statementBody 'else' elseBody= statementBody )
        // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:50:9: 'if' '(' condition= expression ')' ifBody= statementBody 'else' elseBody= statementBody
        {
        match(input,30,FOLLOW_30_in_synpred3_QL249); if (state.failed) return ;

        match(input,14,FOLLOW_14_in_synpred3_QL251); if (state.failed) return ;

        pushFollow(FOLLOW_expression_in_synpred3_QL255);
        condition=expression();

        state._fsp--;
        if (state.failed) return ;

        match(input,15,FOLLOW_15_in_synpred3_QL257); if (state.failed) return ;

        pushFollow(FOLLOW_statementBody_in_synpred3_QL261);
        ifBody=statementBody();

        state._fsp--;
        if (state.failed) return ;

        match(input,28,FOLLOW_28_in_synpred3_QL263); if (state.failed) return ;

        pushFollow(FOLLOW_statementBody_in_synpred3_QL267);
        elseBody=statementBody();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred3_QL

    // $ANTLR start synpred6_QL
    public final void synpred6_QL_fragment() throws RecognitionException {
        FormStatement statement =null;


        // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:60:14: (statement= formStatement )
        // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:60:14: statement= formStatement
        {
        pushFollow(FOLLOW_formStatement_in_synpred6_QL376);
        statement=formStatement();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred6_QL

    // Delegated rules

    public final boolean synpred6_QL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_QL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_QL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_QL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_29_in_form50 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_Identifier_in_form52 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_form54 = new BitSet(new long[]{0x0000000440000200L});
    public static final BitSet FOLLOW_statementBody_in_form56 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_form58 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_question_in_formStatement83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditionBlock_in_formStatement101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_questionLabel_in_question130 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_questionVariable_in_question136 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_question138 = new BitSet(new long[]{0x0000000388000000L});
    public static final BitSet FOLLOW_type_in_question140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_questionLabel_in_question160 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_questionVariable_in_question166 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_question168 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_expression_in_question170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_String_in_questionLabel195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_questionVariable224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_conditionBlock249 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_conditionBlock251 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_expression_in_conditionBlock255 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_conditionBlock257 = new BitSet(new long[]{0x0000000440000200L});
    public static final BitSet FOLLOW_statementBody_in_conditionBlock261 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_conditionBlock263 = new BitSet(new long[]{0x0000000440000200L});
    public static final BitSet FOLLOW_statementBody_in_conditionBlock267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_conditionBlock287 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_conditionBlock289 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_expression_in_conditionBlock293 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_conditionBlock295 = new BitSet(new long[]{0x0000000440000200L});
    public static final BitSet FOLLOW_statementBody_in_conditionBlock299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_statementBody348 = new BitSet(new long[]{0x0000000040000200L});
    public static final BitSet FOLLOW_formStatement_in_statementBody353 = new BitSet(new long[]{0x0000001040000200L});
    public static final BitSet FOLLOW_36_in_statementBody359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_formStatement_in_statementBody376 = new BitSet(new long[]{0x0000000040000202L});
    public static final BitSet FOLLOW_Int_in_primary403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Bool_in_primary422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Money_in_primary440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_String_in_primary457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_primary473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_primary485 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_expression_in_primary489 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_primary491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_unaryExpression519 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpression523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_unaryExpression535 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpression539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_unaryExpression551 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpression555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_unaryExpression569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplicationExpression619 = new BitSet(new long[]{0x0000000000090002L});
    public static final BitSet FOLLOW_set_in_multiplicationExpression629 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplicationExpression650 = new BitSet(new long[]{0x0000000000090002L});
    public static final BitSet FOLLOW_multiplicationExpression_in_additionExpression691 = new BitSet(new long[]{0x0000000000060002L});
    public static final BitSet FOLLOW_set_in_additionExpression701 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_multiplicationExpression_in_additionExpression722 = new BitSet(new long[]{0x0000000000060002L});
    public static final BitSet FOLLOW_additionExpression_in_relationalExpression760 = new BitSet(new long[]{0x0000000007601002L});
    public static final BitSet FOLLOW_set_in_relationalExpression770 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_additionExpression_in_relationalExpression797 = new BitSet(new long[]{0x0000000007601002L});
    public static final BitSet FOLLOW_relationalExpression_in_logicallyEquivalentExpression838 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_logicallyEquivalentExpression844 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_relationalExpression_in_logicallyEquivalentExpression859 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_logicallyEquivalentExpression_in_logicallyEquivalentOrNotExpression896 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_logicallyEquivalentOrNotExpression902 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_logicallyEquivalentExpression_in_logicallyEquivalentOrNotExpression917 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_logicallyEquivalentOrNotExpression_in_expression947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_type972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_type984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_type997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_type1009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_synpred3_QL249 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_synpred3_QL251 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_expression_in_synpred3_QL255 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_synpred3_QL257 = new BitSet(new long[]{0x0000000440000200L});
    public static final BitSet FOLLOW_statementBody_in_synpred3_QL261 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_synpred3_QL263 = new BitSet(new long[]{0x0000000440000200L});
    public static final BitSet FOLLOW_statementBody_in_synpred3_QL267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_formStatement_in_synpred6_QL376 = new BitSet(new long[]{0x0000000000000002L});

}