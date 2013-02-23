// $ANTLR 3.4 C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g 2013-02-23 23:52:39

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.forms.*;
import org.uva.sea.ql.ast.expressions.*;
import org.uva.sea.ql.ast.expressions.binary.arithmetic.*;
import org.uva.sea.ql.ast.expressions.binary.logical.*;
import org.uva.sea.ql.ast.expressions.binary.relational.*;
import org.uva.sea.ql.ast.expressions.literal.*;
import org.uva.sea.ql.ast.expressions.unary.*;
import org.uva.sea.ql.ast.statements.conditions.*;
import org.uva.sea.ql.ast.statements.questions.*;
import org.uva.sea.ql.ast.statements.*;
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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Bool", "COMMENT", "Ident", "Int", "Money", "String", "WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", "'/'", "':'", "'<'", "'<='", "'='", "'=='", "'>'", "'>='", "'boolean'", "'else'", "'form'", "'if'", "'integer'", "'money'", "'string'", "'{'", "'||'", "'}'"
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
    public static final int Ident=6;
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
        this.state.ruleMemo = new HashMap[44+1];
         

    }

    public String[] getTokenNames() { return QLParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g"; }



    // $ANTLR start "form"
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:28:1: form returns [Form result] : 'form' Ident '{' statementBody '}' ;
    public final Form form() throws RecognitionException {
        Form result = null;

        int form_StartIndex = input.index();

        Token Ident1=null;
        StatementBody statementBody2 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:29:5: ( 'form' Ident '{' statementBody '}' )
            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:29:9: 'form' Ident '{' statementBody '}'
            {
            match(input,29,FOLLOW_29_in_form50); if (state.failed) return result;

            Ident1=(Token)match(input,Ident,FOLLOW_Ident_in_form52); if (state.failed) return result;

            match(input,34,FOLLOW_34_in_form54); if (state.failed) return result;

            pushFollow(FOLLOW_statementBody_in_form56);
            statementBody2=statementBody();

            state._fsp--;
            if (state.failed) return result;

            match(input,36,FOLLOW_36_in_form58); if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new Form(new Ident((Ident1!=null?Ident1.getText():null)), statementBody2); }

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
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:32:1: formStatement returns [FormStatement result] : ( question | conditionBlock );
    public final FormStatement formStatement() throws RecognitionException {
        FormStatement result = null;

        int formStatement_StartIndex = input.index();

        Question question3 =null;

        ConditionBlock conditionBlock4 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:33:5: ( question | conditionBlock )
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
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:33:9: question
                    {
                    pushFollow(FOLLOW_question_in_formStatement83);
                    question3=question();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = question3; }

                    }
                    break;
                case 2 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:34:9: conditionBlock
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
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:37:1: question returns [Question result] : ( questionLabel Ident ':' type | questionLabel Ident '=' expression );
    public final Question question() throws RecognitionException {
        Question result = null;

        int question_StartIndex = input.index();

        Token Ident6=null;
        Token Ident9=null;
        QuestionLabel questionLabel5 =null;

        Type type7 =null;

        QuestionLabel questionLabel8 =null;

        Expression expression10 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:38:5: ( questionLabel Ident ':' type | questionLabel Ident '=' expression )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==String) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==Ident) ) {
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
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:38:9: questionLabel Ident ':' type
                    {
                    pushFollow(FOLLOW_questionLabel_in_question126);
                    questionLabel5=questionLabel();

                    state._fsp--;
                    if (state.failed) return result;

                    Ident6=(Token)match(input,Ident,FOLLOW_Ident_in_question128); if (state.failed) return result;

                    match(input,20,FOLLOW_20_in_question130); if (state.failed) return result;

                    pushFollow(FOLLOW_type_in_question132);
                    type7=type();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new AnswerableQuestion(questionLabel5, new Ident((Ident6!=null?Ident6.getText():null)), type7); }

                    }
                    break;
                case 2 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:39:9: questionLabel Ident '=' expression
                    {
                    pushFollow(FOLLOW_questionLabel_in_question148);
                    questionLabel8=questionLabel();

                    state._fsp--;
                    if (state.failed) return result;

                    Ident9=(Token)match(input,Ident,FOLLOW_Ident_in_question150); if (state.failed) return result;

                    match(input,23,FOLLOW_23_in_question152); if (state.failed) return result;

                    pushFollow(FOLLOW_expression_in_question154);
                    expression10=expression();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new ComputedQuestion(questionLabel8, new Ident((Ident9!=null?Ident9.getText():null)), expression10); }

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
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:42:1: questionLabel returns [QuestionLabel result] : String ;
    public final QuestionLabel questionLabel() throws RecognitionException {
        QuestionLabel result = null;

        int questionLabel_StartIndex = input.index();

        Token String11=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:43:5: ( String )
            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:43:9: String
            {
            String11=(Token)match(input,String,FOLLOW_String_in_questionLabel179); if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new QuestionLabel(new org.uva.sea.ql.ast.expressions.literal.Str((String11!=null?String11.getText():null))); }

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



    // $ANTLR start "conditionBlock"
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:46:1: conditionBlock returns [ConditionBlock result] : ( 'if' '(' condition= expression ')' ifBody= statementBody 'else' elseBody= statementBody | 'if' '(' condition= expression ')' ifBody= statementBody );
    public final ConditionBlock conditionBlock() throws RecognitionException {
        ConditionBlock result = null;

        int conditionBlock_StartIndex = input.index();

        Expression condition =null;

        StatementBody ifBody =null;

        StatementBody elseBody =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:47:5: ( 'if' '(' condition= expression ')' ifBody= statementBody 'else' elseBody= statementBody | 'if' '(' condition= expression ')' ifBody= statementBody )
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
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:47:9: 'if' '(' condition= expression ')' ifBody= statementBody 'else' elseBody= statementBody
                    {
                    match(input,30,FOLLOW_30_in_conditionBlock204); if (state.failed) return result;

                    match(input,14,FOLLOW_14_in_conditionBlock206); if (state.failed) return result;

                    pushFollow(FOLLOW_expression_in_conditionBlock210);
                    condition=expression();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,15,FOLLOW_15_in_conditionBlock212); if (state.failed) return result;

                    pushFollow(FOLLOW_statementBody_in_conditionBlock216);
                    ifBody=statementBody();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,28,FOLLOW_28_in_conditionBlock218); if (state.failed) return result;

                    pushFollow(FOLLOW_statementBody_in_conditionBlock222);
                    elseBody=statementBody();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new IfThenElseStatement(condition, ifBody, elseBody); }

                    }
                    break;
                case 2 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:49:9: 'if' '(' condition= expression ')' ifBody= statementBody
                    {
                    match(input,30,FOLLOW_30_in_conditionBlock242); if (state.failed) return result;

                    match(input,14,FOLLOW_14_in_conditionBlock244); if (state.failed) return result;

                    pushFollow(FOLLOW_expression_in_conditionBlock248);
                    condition=expression();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,15,FOLLOW_15_in_conditionBlock250); if (state.failed) return result;

                    pushFollow(FOLLOW_statementBody_in_conditionBlock254);
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
            if ( state.backtracking>0 ) { memoize(input, 5, conditionBlock_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "conditionBlock"



    // $ANTLR start "statementBody"
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:53:1: statementBody returns [StatementBody result] : ( '{' (statement= formStatement )+ '}' | (statement= formStatement )+ );
    public final StatementBody statementBody() throws RecognitionException {
        StatementBody result = null;

        int statementBody_StartIndex = input.index();

        FormStatement statement =null;


         StatementBody statements = new StatementBody(); 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:56:5: ( '{' (statement= formStatement )+ '}' | (statement= formStatement )+ )
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
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:56:9: '{' (statement= formStatement )+ '}'
                    {
                    match(input,34,FOLLOW_34_in_statementBody303); if (state.failed) return result;

                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:56:13: (statement= formStatement )+
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
                    	    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:56:14: statement= formStatement
                    	    {
                    	    pushFollow(FOLLOW_formStatement_in_statementBody308);
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


                    match(input,36,FOLLOW_36_in_statementBody314); if (state.failed) return result;

                    }
                    break;
                case 2 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:57:13: (statement= formStatement )+
                    {
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:57:13: (statement= formStatement )+
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
                    	    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:57:14: statement= formStatement
                    	    {
                    	    pushFollow(FOLLOW_formStatement_in_statementBody331);
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
            if ( state.backtracking>0 ) { memoize(input, 6, statementBody_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "statementBody"



    // $ANTLR start "primary"
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:60:1: primary returns [Expression result] : ( Int | Bool | Money | String | Ident | '(' e= expression ')' );
    public final Expression primary() throws RecognitionException {
        Expression result = null;

        int primary_StartIndex = input.index();

        Token Int12=null;
        Token Bool13=null;
        Token Money14=null;
        Token String15=null;
        Token Ident16=null;
        Expression e =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:61:5: ( Int | Bool | Money | String | Ident | '(' e= expression ')' )
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
            case Ident:
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
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:61:9: Int
                    {
                    Int12=(Token)match(input,Int,FOLLOW_Int_in_primary358); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.expressions.literal.Int(Integer.parseInt((Int12!=null?Int12.getText():null))); }

                    }
                    break;
                case 2 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:62:9: Bool
                    {
                    Bool13=(Token)match(input,Bool,FOLLOW_Bool_in_primary373); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.expressions.literal.Bool(Boolean.parseBoolean((Bool13!=null?Bool13.getText():null))); }

                    }
                    break;
                case 3 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:63:9: Money
                    {
                    Money14=(Token)match(input,Money,FOLLOW_Money_in_primary387); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.expressions.literal.Money(Double.parseDouble((Money14!=null?Money14.getText():null).replace(',', '.'))); }

                    }
                    break;
                case 4 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:64:9: String
                    {
                    String15=(Token)match(input,String,FOLLOW_String_in_primary400); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.expressions.literal.Str((String15!=null?String15.getText():null)); }

                    }
                    break;
                case 5 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:65:9: Ident
                    {
                    Ident16=(Token)match(input,Ident,FOLLOW_Ident_in_primary412); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Ident((Ident16!=null?Ident16.getText():null)); }

                    }
                    break;
                case 6 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:66:9: '(' e= expression ')'
                    {
                    match(input,14,FOLLOW_14_in_primary425); if (state.failed) return result;

                    pushFollow(FOLLOW_expression_in_primary429);
                    e=expression();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,15,FOLLOW_15_in_primary431); if (state.failed) return result;

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
            if ( state.backtracking>0 ) { memoize(input, 7, primary_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "primary"



    // $ANTLR start "unaryExpression"
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:69:1: unaryExpression returns [Expression result] : ( '+' e= unaryExpression | '-' e= unaryExpression | '!' e= unaryExpression |e= primary );
    public final Expression unaryExpression() throws RecognitionException {
        Expression result = null;

        int unaryExpression_StartIndex = input.index();

        Expression e =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:70:5: ( '+' e= unaryExpression | '-' e= unaryExpression | '!' e= unaryExpression |e= primary )
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
            case Ident:
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
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:70:9: '+' e= unaryExpression
                    {
                    match(input,17,FOLLOW_17_in_unaryExpression459); if (state.failed) return result;

                    pushFollow(FOLLOW_unaryExpression_in_unaryExpression463);
                    e=unaryExpression();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new PositiveExpression(e); }

                    }
                    break;
                case 2 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:71:9: '-' e= unaryExpression
                    {
                    match(input,18,FOLLOW_18_in_unaryExpression475); if (state.failed) return result;

                    pushFollow(FOLLOW_unaryExpression_in_unaryExpression479);
                    e=unaryExpression();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new NegativeExpression(e); }

                    }
                    break;
                case 3 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:72:9: '!' e= unaryExpression
                    {
                    match(input,11,FOLLOW_11_in_unaryExpression491); if (state.failed) return result;

                    pushFollow(FOLLOW_unaryExpression_in_unaryExpression495);
                    e=unaryExpression();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new NegationalExpression(e); }

                    }
                    break;
                case 4 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:73:9: e= primary
                    {
                    pushFollow(FOLLOW_primary_in_unaryExpression509);
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
            if ( state.backtracking>0 ) { memoize(input, 8, unaryExpression_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "unaryExpression"



    // $ANTLR start "multiplicationExpression"
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:76:1: multiplicationExpression returns [Expression result] : leftHandSide= unaryExpression (op= ( '*' | '/' ) rightHandSide= unaryExpression )* ;
    public final Expression multiplicationExpression() throws RecognitionException {
        Expression result = null;

        int multiplicationExpression_StartIndex = input.index();

        Token op=null;
        Expression leftHandSide =null;

        Expression rightHandSide =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:77:5: (leftHandSide= unaryExpression (op= ( '*' | '/' ) rightHandSide= unaryExpression )* )
            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:77:9: leftHandSide= unaryExpression (op= ( '*' | '/' ) rightHandSide= unaryExpression )*
            {
            pushFollow(FOLLOW_unaryExpression_in_multiplicationExpression559);
            leftHandSide=unaryExpression();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = leftHandSide; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:77:69: (op= ( '*' | '/' ) rightHandSide= unaryExpression )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==16||LA9_0==19) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:77:71: op= ( '*' | '/' ) rightHandSide= unaryExpression
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


            	    pushFollow(FOLLOW_unaryExpression_in_multiplicationExpression590);
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
            if ( state.backtracking>0 ) { memoize(input, 9, multiplicationExpression_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "multiplicationExpression"



    // $ANTLR start "additionExpression"
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:85:1: additionExpression returns [Expression result] : leftHandSide= multiplicationExpression (op= ( '+' | '-' ) rightHandSide= multiplicationExpression )* ;
    public final Expression additionExpression() throws RecognitionException {
        Expression result = null;

        int additionExpression_StartIndex = input.index();

        Token op=null;
        Expression leftHandSide =null;

        Expression rightHandSide =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:86:5: (leftHandSide= multiplicationExpression (op= ( '+' | '-' ) rightHandSide= multiplicationExpression )* )
            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:86:9: leftHandSide= multiplicationExpression (op= ( '+' | '-' ) rightHandSide= multiplicationExpression )*
            {
            pushFollow(FOLLOW_multiplicationExpression_in_additionExpression631);
            leftHandSide=multiplicationExpression();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = leftHandSide; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:86:78: (op= ( '+' | '-' ) rightHandSide= multiplicationExpression )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0 >= 17 && LA10_0 <= 18)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:86:80: op= ( '+' | '-' ) rightHandSide= multiplicationExpression
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


            	    pushFollow(FOLLOW_multiplicationExpression_in_additionExpression662);
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
            if ( state.backtracking>0 ) { memoize(input, 10, additionExpression_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "additionExpression"



    // $ANTLR start "relationalExpression"
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:94:1: relationalExpression returns [Expression result] : leftHandSide= additionExpression (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rightHandSide= additionExpression )* ;
    public final Expression relationalExpression() throws RecognitionException {
        Expression result = null;

        int relationalExpression_StartIndex = input.index();

        Token op=null;
        Expression leftHandSide =null;

        Expression rightHandSide =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:95:5: (leftHandSide= additionExpression (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rightHandSide= additionExpression )* )
            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:95:9: leftHandSide= additionExpression (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rightHandSide= additionExpression )*
            {
            pushFollow(FOLLOW_additionExpression_in_relationalExpression700);
            leftHandSide=additionExpression();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = leftHandSide; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:95:72: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rightHandSide= additionExpression )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==12||(LA11_0 >= 21 && LA11_0 <= 22)||(LA11_0 >= 24 && LA11_0 <= 26)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:95:74: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rightHandSide= additionExpression
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


            	    pushFollow(FOLLOW_additionExpression_in_relationalExpression737);
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
            if ( state.backtracking>0 ) { memoize(input, 11, relationalExpression_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "relationalExpression"



    // $ANTLR start "logicallyEquivalentExpression"
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:107:1: logicallyEquivalentExpression returns [Expression result] : leftHandSide= relationalExpression ( '&&' rightHandSide= relationalExpression )* ;
    public final Expression logicallyEquivalentExpression() throws RecognitionException {
        Expression result = null;

        int logicallyEquivalentExpression_StartIndex = input.index();

        Expression leftHandSide =null;

        Expression rightHandSide =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:108:5: (leftHandSide= relationalExpression ( '&&' rightHandSide= relationalExpression )* )
            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:108:9: leftHandSide= relationalExpression ( '&&' rightHandSide= relationalExpression )*
            {
            pushFollow(FOLLOW_relationalExpression_in_logicallyEquivalentExpression778);
            leftHandSide=relationalExpression();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = leftHandSide; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:108:74: ( '&&' rightHandSide= relationalExpression )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==13) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:108:76: '&&' rightHandSide= relationalExpression
            	    {
            	    match(input,13,FOLLOW_13_in_logicallyEquivalentExpression784); if (state.failed) return result;

            	    pushFollow(FOLLOW_relationalExpression_in_logicallyEquivalentExpression799);
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
            if ( state.backtracking>0 ) { memoize(input, 12, logicallyEquivalentExpression_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "logicallyEquivalentExpression"



    // $ANTLR start "logicallyNotEquivalentExpression"
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:113:1: logicallyNotEquivalentExpression returns [Expression result] : leftHandSide= logicallyEquivalentExpression ( '||' rightHandSide= logicallyEquivalentExpression )* ;
    public final Expression logicallyNotEquivalentExpression() throws RecognitionException {
        Expression result = null;

        int logicallyNotEquivalentExpression_StartIndex = input.index();

        Expression leftHandSide =null;

        Expression rightHandSide =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:114:5: (leftHandSide= logicallyEquivalentExpression ( '||' rightHandSide= logicallyEquivalentExpression )* )
            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:114:9: leftHandSide= logicallyEquivalentExpression ( '||' rightHandSide= logicallyEquivalentExpression )*
            {
            pushFollow(FOLLOW_logicallyEquivalentExpression_in_logicallyNotEquivalentExpression837);
            leftHandSide=logicallyEquivalentExpression();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = leftHandSide; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:114:83: ( '||' rightHandSide= logicallyEquivalentExpression )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==35) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:114:85: '||' rightHandSide= logicallyEquivalentExpression
            	    {
            	    match(input,35,FOLLOW_35_in_logicallyNotEquivalentExpression843); if (state.failed) return result;

            	    pushFollow(FOLLOW_logicallyEquivalentExpression_in_logicallyNotEquivalentExpression858);
            	    rightHandSide=logicallyEquivalentExpression();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { result = new LogicallyNotEquivalentExpression(leftHandSide, rightHandSide); }

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
            if ( state.backtracking>0 ) { memoize(input, 13, logicallyNotEquivalentExpression_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "logicallyNotEquivalentExpression"



    // $ANTLR start "expression"
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:118:1: expression returns [Expression result] : getExpression= logicallyNotEquivalentExpression ;
    public final Expression expression() throws RecognitionException {
        Expression result = null;

        int expression_StartIndex = input.index();

        Expression getExpression =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:119:5: (getExpression= logicallyNotEquivalentExpression )
            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:119:9: getExpression= logicallyNotEquivalentExpression
            {
            pushFollow(FOLLOW_logicallyNotEquivalentExpression_in_expression888);
            getExpression=logicallyNotEquivalentExpression();

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
            if ( state.backtracking>0 ) { memoize(input, 14, expression_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "expression"



    // $ANTLR start "type"
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:122:1: type returns [Type result] : ( 'integer' | 'string' | 'boolean' | 'money' );
    public final Type type() throws RecognitionException {
        Type result = null;

        int type_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:123:5: ( 'integer' | 'string' | 'boolean' | 'money' )
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
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:123:9: 'integer'
                    {
                    match(input,31,FOLLOW_31_in_type913); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.types.Int();   }

                    }
                    break;
                case 2 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:124:9: 'string'
                    {
                    match(input,33,FOLLOW_33_in_type925); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.types.Str();   }

                    }
                    break;
                case 3 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:125:9: 'boolean'
                    {
                    match(input,27,FOLLOW_27_in_type938); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.types.Bool();  }

                    }
                    break;
                case 4 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:126:9: 'money'
                    {
                    match(input,32,FOLLOW_32_in_type950); if (state.failed) return result;

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
            if ( state.backtracking>0 ) { memoize(input, 15, type_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "type"

    // $ANTLR start synpred3_QL
    public final void synpred3_QL_fragment() throws RecognitionException {
        Expression condition =null;

        StatementBody ifBody =null;

        StatementBody elseBody =null;


        // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:47:9: ( 'if' '(' condition= expression ')' ifBody= statementBody 'else' elseBody= statementBody )
        // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:47:9: 'if' '(' condition= expression ')' ifBody= statementBody 'else' elseBody= statementBody
        {
        match(input,30,FOLLOW_30_in_synpred3_QL204); if (state.failed) return ;

        match(input,14,FOLLOW_14_in_synpred3_QL206); if (state.failed) return ;

        pushFollow(FOLLOW_expression_in_synpred3_QL210);
        condition=expression();

        state._fsp--;
        if (state.failed) return ;

        match(input,15,FOLLOW_15_in_synpred3_QL212); if (state.failed) return ;

        pushFollow(FOLLOW_statementBody_in_synpred3_QL216);
        ifBody=statementBody();

        state._fsp--;
        if (state.failed) return ;

        match(input,28,FOLLOW_28_in_synpred3_QL218); if (state.failed) return ;

        pushFollow(FOLLOW_statementBody_in_synpred3_QL222);
        elseBody=statementBody();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred3_QL

    // $ANTLR start synpred6_QL
    public final void synpred6_QL_fragment() throws RecognitionException {
        FormStatement statement =null;


        // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:57:14: (statement= formStatement )
        // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:57:14: statement= formStatement
        {
        pushFollow(FOLLOW_formStatement_in_synpred6_QL331);
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
    public static final BitSet FOLLOW_Ident_in_form52 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_form54 = new BitSet(new long[]{0x0000000440000200L});
    public static final BitSet FOLLOW_statementBody_in_form56 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_form58 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_question_in_formStatement83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditionBlock_in_formStatement101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_questionLabel_in_question126 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_Ident_in_question128 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_question130 = new BitSet(new long[]{0x0000000388000000L});
    public static final BitSet FOLLOW_type_in_question132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_questionLabel_in_question148 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_Ident_in_question150 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_question152 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_expression_in_question154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_String_in_questionLabel179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_conditionBlock204 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_conditionBlock206 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_expression_in_conditionBlock210 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_conditionBlock212 = new BitSet(new long[]{0x0000000440000200L});
    public static final BitSet FOLLOW_statementBody_in_conditionBlock216 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_conditionBlock218 = new BitSet(new long[]{0x0000000440000200L});
    public static final BitSet FOLLOW_statementBody_in_conditionBlock222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_conditionBlock242 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_conditionBlock244 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_expression_in_conditionBlock248 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_conditionBlock250 = new BitSet(new long[]{0x0000000440000200L});
    public static final BitSet FOLLOW_statementBody_in_conditionBlock254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_statementBody303 = new BitSet(new long[]{0x0000000040000200L});
    public static final BitSet FOLLOW_formStatement_in_statementBody308 = new BitSet(new long[]{0x0000001040000200L});
    public static final BitSet FOLLOW_36_in_statementBody314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_formStatement_in_statementBody331 = new BitSet(new long[]{0x0000000040000202L});
    public static final BitSet FOLLOW_Int_in_primary358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Bool_in_primary373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Money_in_primary387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_String_in_primary400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_primary412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_primary425 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_expression_in_primary429 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_primary431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_unaryExpression459 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpression463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_unaryExpression475 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpression479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_unaryExpression491 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpression495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_unaryExpression509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplicationExpression559 = new BitSet(new long[]{0x0000000000090002L});
    public static final BitSet FOLLOW_set_in_multiplicationExpression569 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplicationExpression590 = new BitSet(new long[]{0x0000000000090002L});
    public static final BitSet FOLLOW_multiplicationExpression_in_additionExpression631 = new BitSet(new long[]{0x0000000000060002L});
    public static final BitSet FOLLOW_set_in_additionExpression641 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_multiplicationExpression_in_additionExpression662 = new BitSet(new long[]{0x0000000000060002L});
    public static final BitSet FOLLOW_additionExpression_in_relationalExpression700 = new BitSet(new long[]{0x0000000007601002L});
    public static final BitSet FOLLOW_set_in_relationalExpression710 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_additionExpression_in_relationalExpression737 = new BitSet(new long[]{0x0000000007601002L});
    public static final BitSet FOLLOW_relationalExpression_in_logicallyEquivalentExpression778 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_logicallyEquivalentExpression784 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_relationalExpression_in_logicallyEquivalentExpression799 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_logicallyEquivalentExpression_in_logicallyNotEquivalentExpression837 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_logicallyNotEquivalentExpression843 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_logicallyEquivalentExpression_in_logicallyNotEquivalentExpression858 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_logicallyNotEquivalentExpression_in_expression888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_type913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_type925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_type938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_type950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_synpred3_QL204 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_synpred3_QL206 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_expression_in_synpred3_QL210 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_synpred3_QL212 = new BitSet(new long[]{0x0000000440000200L});
    public static final BitSet FOLLOW_statementBody_in_synpred3_QL216 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_synpred3_QL218 = new BitSet(new long[]{0x0000000440000200L});
    public static final BitSet FOLLOW_statementBody_in_synpred3_QL222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_formStatement_in_synpred6_QL331 = new BitSet(new long[]{0x0000000000000002L});

}