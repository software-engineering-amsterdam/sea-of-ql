// $ANTLR 3.4 /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g 2013-02-05 22:27:15

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expr.*;
import org.uva.sea.ql.ast.expr.binary.*;
import org.uva.sea.ql.ast.expr.binary.algebraic.*;
import org.uva.sea.ql.ast.expr.binary.bool.*;
import org.uva.sea.ql.ast.expr.unary.*;
import org.uva.sea.ql.ast.form.*;
import org.uva.sea.ql.ast.types.*;
import org.uva.sea.ql.ast.expr.values.*;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class QLParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "BOOLEAN", "BoolLit", "COMMENT", "Decimal", "INTEGER", "Ident", "Int", "MONEY", "STRING", "StringLit", "WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", "'/'", "':'", "'<'", "'<='", "'=='", "'>'", "'>='", "'else'", "'form'", "'if'", "'{'", "'||'", "'}'"
    };

    public static final int EOF=-1;
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
    public static final int BOOLEAN=4;
    public static final int BoolLit=5;
    public static final int COMMENT=6;
    public static final int Decimal=7;
    public static final int INTEGER=8;
    public static final int Ident=9;
    public static final int Int=10;
    public static final int MONEY=11;
    public static final int STRING=12;
    public static final int StringLit=13;
    public static final int WS=14;

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
        this.state.ruleMemo = new HashMap[41+1];
         

    }

    public String[] getTokenNames() { return QLParser.tokenNames; }
    public String getGrammarFileName() { return "/home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g"; }



    // $ANTLR start "type"
    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:27:1: type returns [Type result] : ( INTEGER | BOOLEAN | STRING | MONEY );
    public final Type type() throws RecognitionException {
        Type result = null;

        int type_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:28:2: ( INTEGER | BOOLEAN | STRING | MONEY )
            int alt1=4;
            switch ( input.LA(1) ) {
            case INTEGER:
                {
                alt1=1;
                }
                break;
            case BOOLEAN:
                {
                alt1=2;
                }
                break;
            case STRING:
                {
                alt1=3;
                }
                break;
            case MONEY:
                {
                alt1=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;

            }

            switch (alt1) {
                case 1 :
                    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:28:3: INTEGER
                    {
                    match(input,INTEGER,FOLLOW_INTEGER_in_type46); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new IntType();}

                    }
                    break;
                case 2 :
                    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:29:3: BOOLEAN
                    {
                    match(input,BOOLEAN,FOLLOW_BOOLEAN_in_type53); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new BoolType();}

                    }
                    break;
                case 3 :
                    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:30:3: STRING
                    {
                    match(input,STRING,FOLLOW_STRING_in_type60); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new StringType();}

                    }
                    break;
                case 4 :
                    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:31:3: MONEY
                    {
                    match(input,MONEY,FOLLOW_MONEY_in_type66); if (state.failed) return result;

                    if ( state.backtracking==0 ) {result = new MoneyType();}

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
            if ( state.backtracking>0 ) { memoize(input, 1, type_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "type"



    // $ANTLR start "form"
    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:36:1: form returns [Form result] : 'form' Ident '{' body '}' EOF ;
    public final Form form() throws RecognitionException {
        Form result = null;

        int form_StartIndex = input.index();

        Token Ident1=null;
        Body body2 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:37:2: ( 'form' Ident '{' body '}' EOF )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:37:3: 'form' Ident '{' body '}' EOF
            {
            match(input,31,FOLLOW_31_in_form86); if (state.failed) return result;

            Ident1=(Token)match(input,Ident,FOLLOW_Ident_in_form88); if (state.failed) return result;

            match(input,33,FOLLOW_33_in_form91); if (state.failed) return result;

            pushFollow(FOLLOW_body_in_form93);
            body2=body();

            state._fsp--;
            if (state.failed) return result;

            match(input,35,FOLLOW_35_in_form95); if (state.failed) return result;

            match(input,EOF,FOLLOW_EOF_in_form97); if (state.failed) return result;

            if ( state.backtracking==0 ) {result = new Form(new Ident((Ident1!=null?Ident1.getText():null)),body2);}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 2, form_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "form"



    // $ANTLR start "body"
    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:44:2: body returns [Body result] : ( element )* ;
    public final Body body() throws RecognitionException {
        Body result = null;

        int body_StartIndex = input.index();

        BodyElement element3 =null;


         Body body= new Body();  
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:46:3: ( ( element )* )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:46:4: ( element )*
            {
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:46:4: ( element )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==Ident||LA2_0==32) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:46:5: element
            	    {
            	    pushFollow(FOLLOW_element_in_body132);
            	    element3=element();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { body.addElement(element3) ; }

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            if ( state.backtracking==0 ) {result =body;}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 3, body_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "body"



    // $ANTLR start "element"
    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:50:1: element returns [BodyElement result] : ( conditionalElement | question | computedQuestion );
    public final BodyElement element() throws RecognitionException {
        BodyElement result = null;

        int element_StartIndex = input.index();

        ConditionalElement conditionalElement4 =null;

        Question question5 =null;

        ComputedQuestion computedQuestion6 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:51:3: ( conditionalElement | question | computedQuestion )
            int alt3=3;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==32) ) {
                alt3=1;
            }
            else if ( (LA3_0==Ident) ) {
                int LA3_2 = input.LA(2);

                if ( (LA3_2==24) ) {
                    int LA3_3 = input.LA(3);

                    if ( (LA3_3==StringLit) ) {
                        switch ( input.LA(4) ) {
                        case INTEGER:
                            {
                            int LA3_5 = input.LA(5);

                            if ( (LA3_5==EOF||LA3_5==Ident||LA3_5==32||LA3_5==35) ) {
                                alt3=2;
                            }
                            else if ( (LA3_5==18) ) {
                                alt3=3;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return result;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 3, 5, input);

                                throw nvae;

                            }
                            }
                            break;
                        case BOOLEAN:
                            {
                            int LA3_6 = input.LA(5);

                            if ( (LA3_6==EOF||LA3_6==Ident||LA3_6==32||LA3_6==35) ) {
                                alt3=2;
                            }
                            else if ( (LA3_6==18) ) {
                                alt3=3;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return result;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 3, 6, input);

                                throw nvae;

                            }
                            }
                            break;
                        case STRING:
                            {
                            int LA3_7 = input.LA(5);

                            if ( (LA3_7==EOF||LA3_7==Ident||LA3_7==32||LA3_7==35) ) {
                                alt3=2;
                            }
                            else if ( (LA3_7==18) ) {
                                alt3=3;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return result;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 3, 7, input);

                                throw nvae;

                            }
                            }
                            break;
                        case MONEY:
                            {
                            int LA3_8 = input.LA(5);

                            if ( (LA3_8==EOF||LA3_8==Ident||LA3_8==32||LA3_8==35) ) {
                                alt3=2;
                            }
                            else if ( (LA3_8==18) ) {
                                alt3=3;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return result;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 3, 8, input);

                                throw nvae;

                            }
                            }
                            break;
                        default:
                            if (state.backtracking>0) {state.failed=true; return result;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 3, 4, input);

                            throw nvae;

                        }

                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return result;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 3, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return result;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 2, input);

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
                    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:51:4: conditionalElement
                    {
                    pushFollow(FOLLOW_conditionalElement_in_element159);
                    conditionalElement4=conditionalElement();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) {result =conditionalElement4;}

                    }
                    break;
                case 2 :
                    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:52:4: question
                    {
                    pushFollow(FOLLOW_question_in_element166);
                    question5=question();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) {result =question5;}

                    }
                    break;
                case 3 :
                    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:53:4: computedQuestion
                    {
                    pushFollow(FOLLOW_computedQuestion_in_element173);
                    computedQuestion6=computedQuestion();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) {result =computedQuestion6;}

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
            if ( state.backtracking>0 ) { memoize(input, 4, element_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "element"



    // $ANTLR start "question"
    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:57:1: question returns [Question result] : Ident ':' StringLit type ;
    public final Question question() throws RecognitionException {
        Question result = null;

        int question_StartIndex = input.index();

        Token Ident7=null;
        Token StringLit8=null;
        Type type9 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:58:3: ( Ident ':' StringLit type )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:58:5: Ident ':' StringLit type
            {
            Ident7=(Token)match(input,Ident,FOLLOW_Ident_in_question194); if (state.failed) return result;

            match(input,24,FOLLOW_24_in_question196); if (state.failed) return result;

            StringLit8=(Token)match(input,StringLit,FOLLOW_StringLit_in_question198); if (state.failed) return result;

            pushFollow(FOLLOW_type_in_question200);
            type9=type();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) {result =new Question(new Ident((Ident7!=null?Ident7.getText():null)),new StringLit((StringLit8!=null?StringLit8.getText():null)),type9);}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 5, question_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "question"



    // $ANTLR start "computedQuestion"
    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:60:1: computedQuestion returns [ComputedQuestion result] : Ident ':' StringLit type '(' expr= orExpr ')' ;
    public final ComputedQuestion computedQuestion() throws RecognitionException {
        ComputedQuestion result = null;

        int computedQuestion_StartIndex = input.index();

        Token Ident10=null;
        Token StringLit11=null;
        Expr expr =null;

        Type type12 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:61:3: ( Ident ':' StringLit type '(' expr= orExpr ')' )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:61:5: Ident ':' StringLit type '(' expr= orExpr ')'
            {
            Ident10=(Token)match(input,Ident,FOLLOW_Ident_in_computedQuestion218); if (state.failed) return result;

            match(input,24,FOLLOW_24_in_computedQuestion220); if (state.failed) return result;

            StringLit11=(Token)match(input,StringLit,FOLLOW_StringLit_in_computedQuestion222); if (state.failed) return result;

            pushFollow(FOLLOW_type_in_computedQuestion224);
            type12=type();

            state._fsp--;
            if (state.failed) return result;

            match(input,18,FOLLOW_18_in_computedQuestion226); if (state.failed) return result;

            pushFollow(FOLLOW_orExpr_in_computedQuestion230);
            expr=orExpr();

            state._fsp--;
            if (state.failed) return result;

            match(input,19,FOLLOW_19_in_computedQuestion232); if (state.failed) return result;

            if ( state.backtracking==0 ) {result =new ComputedQuestion(new Ident((Ident10!=null?Ident10.getText():null)),new StringLit((StringLit11!=null?StringLit11.getText():null)),type12,expr);}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 6, computedQuestion_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "computedQuestion"



    // $ANTLR start "conditionalElement"
    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:64:1: conditionalElement returns [ConditionalElement result] : ( 'if' '(' expr= orExpr ')' '{' b1= body '}' 'else' '{' b2= body '}' | 'if' '(' expr= orExpr ')' '{' body '}' );
    public final ConditionalElement conditionalElement() throws RecognitionException {
        ConditionalElement result = null;

        int conditionalElement_StartIndex = input.index();

        Expr expr =null;

        Body b1 =null;

        Body b2 =null;

        Body body13 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:65:2: ( 'if' '(' expr= orExpr ')' '{' b1= body '}' 'else' '{' b2= body '}' | 'if' '(' expr= orExpr ')' '{' body '}' )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==32) ) {
                int LA4_1 = input.LA(2);

                if ( (synpred7_QL()) ) {
                    alt4=1;
                }
                else if ( (true) ) {
                    alt4=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return result;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }
            switch (alt4) {
                case 1 :
                    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:65:3: 'if' '(' expr= orExpr ')' '{' b1= body '}' 'else' '{' b2= body '}'
                    {
                    match(input,32,FOLLOW_32_in_conditionalElement251); if (state.failed) return result;

                    match(input,18,FOLLOW_18_in_conditionalElement253); if (state.failed) return result;

                    pushFollow(FOLLOW_orExpr_in_conditionalElement257);
                    expr=orExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,19,FOLLOW_19_in_conditionalElement259); if (state.failed) return result;

                    match(input,33,FOLLOW_33_in_conditionalElement261); if (state.failed) return result;

                    pushFollow(FOLLOW_body_in_conditionalElement264);
                    b1=body();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,35,FOLLOW_35_in_conditionalElement265); if (state.failed) return result;

                    match(input,30,FOLLOW_30_in_conditionalElement267); if (state.failed) return result;

                    match(input,33,FOLLOW_33_in_conditionalElement269); if (state.failed) return result;

                    pushFollow(FOLLOW_body_in_conditionalElement273);
                    b2=body();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,35,FOLLOW_35_in_conditionalElement274); if (state.failed) return result;

                    if ( state.backtracking==0 ) {result =new IfThenElse(expr,b1,b2);}

                    }
                    break;
                case 2 :
                    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:66:3: 'if' '(' expr= orExpr ')' '{' body '}'
                    {
                    match(input,32,FOLLOW_32_in_conditionalElement281); if (state.failed) return result;

                    match(input,18,FOLLOW_18_in_conditionalElement283); if (state.failed) return result;

                    pushFollow(FOLLOW_orExpr_in_conditionalElement287);
                    expr=orExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,19,FOLLOW_19_in_conditionalElement289); if (state.failed) return result;

                    match(input,33,FOLLOW_33_in_conditionalElement291); if (state.failed) return result;

                    pushFollow(FOLLOW_body_in_conditionalElement293);
                    body13=body();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,35,FOLLOW_35_in_conditionalElement294); if (state.failed) return result;

                    if ( state.backtracking==0 ) {result =new IfThen(expr,body13);}

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
            if ( state.backtracking>0 ) { memoize(input, 7, conditionalElement_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "conditionalElement"



    // $ANTLR start "primary"
    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:72:1: primary returns [Expr result] : ( Decimal | Int | StringLit | BoolLit | Ident | '(' x= orExpr ')' );
    public final Expr primary() throws RecognitionException {
        Expr result = null;

        int primary_StartIndex = input.index();

        Token Decimal14=null;
        Token Int15=null;
        Token StringLit16=null;
        Token BoolLit17=null;
        Token Ident18=null;
        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:73:3: ( Decimal | Int | StringLit | BoolLit | Ident | '(' x= orExpr ')' )
            int alt5=6;
            switch ( input.LA(1) ) {
            case Decimal:
                {
                alt5=1;
                }
                break;
            case Int:
                {
                alt5=2;
                }
                break;
            case StringLit:
                {
                alt5=3;
                }
                break;
            case BoolLit:
                {
                alt5=4;
                }
                break;
            case Ident:
                {
                alt5=5;
                }
                break;
            case 18:
                {
                alt5=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }

            switch (alt5) {
                case 1 :
                    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:73:5: Decimal
                    {
                    Decimal14=(Token)match(input,Decimal,FOLLOW_Decimal_in_primary317); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new DecimalLit(Float.parseFloat((Decimal14!=null?Decimal14.getText():null))); }

                    }
                    break;
                case 2 :
                    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:74:5: Int
                    {
                    Int15=(Token)match(input,Int,FOLLOW_Int_in_primary325); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new IntegerLit(Integer.parseInt((Int15!=null?Int15.getText():null))); }

                    }
                    break;
                case 3 :
                    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:75:5: StringLit
                    {
                    StringLit16=(Token)match(input,StringLit,FOLLOW_StringLit_in_primary333); if (state.failed) return result;

                    if ( state.backtracking==0 ) {result = new StringLit((StringLit16!=null?StringLit16.getText():null));}

                    }
                    break;
                case 4 :
                    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:76:5: BoolLit
                    {
                    BoolLit17=(Token)match(input,BoolLit,FOLLOW_BoolLit_in_primary341); if (state.failed) return result;

                    if ( state.backtracking==0 ) {result = new BoolLit(Boolean.parseBoolean((BoolLit17!=null?BoolLit17.getText():null)));}

                    }
                    break;
                case 5 :
                    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:77:5: Ident
                    {
                    Ident18=(Token)match(input,Ident,FOLLOW_Ident_in_primary350); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Ident((Ident18!=null?Ident18.getText():null)); }

                    }
                    break;
                case 6 :
                    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:78:5: '(' x= orExpr ')'
                    {
                    match(input,18,FOLLOW_18_in_primary358); if (state.failed) return result;

                    pushFollow(FOLLOW_orExpr_in_primary362);
                    x=orExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,19,FOLLOW_19_in_primary364); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = x; }

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



    // $ANTLR start "unExpr"
    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:84:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
    public final Expr unExpr() throws RecognitionException {
        Expr result = null;

        int unExpr_StartIndex = input.index();

        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:85:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
            int alt6=4;
            switch ( input.LA(1) ) {
            case 21:
                {
                alt6=1;
                }
                break;
            case 22:
                {
                alt6=2;
                }
                break;
            case 15:
                {
                alt6=3;
                }
                break;
            case BoolLit:
            case Decimal:
            case Ident:
            case Int:
            case StringLit:
            case 18:
                {
                alt6=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;

            }

            switch (alt6) {
                case 1 :
                    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:85:8: '+' x= unExpr
                    {
                    match(input,21,FOLLOW_21_in_unExpr392); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr396);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Pos(x); }

                    }
                    break;
                case 2 :
                    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:86:8: '-' x= unExpr
                    {
                    match(input,22,FOLLOW_22_in_unExpr407); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr411);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Neg(x); }

                    }
                    break;
                case 3 :
                    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:87:8: '!' x= unExpr
                    {
                    match(input,15,FOLLOW_15_in_unExpr422); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr426);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Not(x); }

                    }
                    break;
                case 4 :
                    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:88:8: x= primary
                    {
                    pushFollow(FOLLOW_primary_in_unExpr439);
                    x=primary();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = x; }

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
            if ( state.backtracking>0 ) { memoize(input, 9, unExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "unExpr"



    // $ANTLR start "mulExpr"
    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:91:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
    public final Expr mulExpr() throws RecognitionException {
        Expr result = null;

        int mulExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:92:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:92:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
            {
            pushFollow(FOLLOW_unExpr_in_mulExpr477);
            lhs=unExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:92:45: (op= ( '*' | '/' ) rhs= unExpr )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==20||LA7_0==23) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:92:47: op= ( '*' | '/' ) rhs= unExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( input.LA(1)==20||input.LA(1)==23 ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_unExpr_in_mulExpr497);
            	    rhs=unExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { 
            	          if ((op!=null?op.getText():null).equals("*")) {
            	            result = new Mul(result, rhs);
            	          }
            	          if ((op!=null?op.getText():null).equals("/")) {
            	            result = new Div(result, rhs);     
            	          }
            	        }

            	    }
            	    break;

            	default :
            	    break loop7;
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
            if ( state.backtracking>0 ) { memoize(input, 10, mulExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "mulExpr"



    // $ANTLR start "addExpr"
    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:104:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
    public final Expr addExpr() throws RecognitionException {
        Expr result = null;

        int addExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:105:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:105:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
            {
            pushFollow(FOLLOW_mulExpr_in_addExpr538);
            lhs=mulExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:105:46: (op= ( '+' | '-' ) rhs= mulExpr )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0 >= 21 && LA8_0 <= 22)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:105:48: op= ( '+' | '-' ) rhs= mulExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( (input.LA(1) >= 21 && input.LA(1) <= 22) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_mulExpr_in_addExpr556);
            	    rhs=mulExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { 
            	          if ((op!=null?op.getText():null).equals("+")) {
            	            result = new Add(result, rhs);
            	          }
            	          if ((op!=null?op.getText():null).equals("-")) {
            	            result = new Sub(result, rhs);      
            	          }
            	        }

            	    }
            	    break;

            	default :
            	    break loop8;
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
            if ( state.backtracking>0 ) { memoize(input, 11, addExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "addExpr"



    // $ANTLR start "relExpr"
    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:116:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
    public final Expr relExpr() throws RecognitionException {
        Expr result = null;

        int relExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }

            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:117:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:117:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            {
            pushFollow(FOLLOW_addExpr_in_relExpr591);
            lhs=addExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:117:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==16||(LA9_0 >= 25 && LA9_0 <= 29)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:117:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( input.LA(1)==16||(input.LA(1) >= 25 && input.LA(1) <= 29) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_addExpr_in_relExpr615);
            	    rhs=addExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { 
            	          if ((op!=null?op.getText():null).equals("<")) {
            	            result = new LT(result, rhs);
            	          }
            	          if ((op!=null?op.getText():null).equals("<=")) {
            	            result = new LEq(result, rhs);      
            	          }
            	          if ((op!=null?op.getText():null).equals(">")) {
            	            result = new GT(result, rhs);
            	          }
            	          if ((op!=null?op.getText():null).equals(">=")) {
            	            result = new GEq(result, rhs);      
            	          }
            	          if ((op!=null?op.getText():null).equals("==")) {
            	            result = new Eq(result, rhs);
            	          }
            	          if ((op!=null?op.getText():null).equals("!=")) {
            	            result = new NEq(result, rhs);
            	          }
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
            if ( state.backtracking>0 ) { memoize(input, 12, relExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "relExpr"



    // $ANTLR start "andExpr"
    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:140:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
    public final Expr andExpr() throws RecognitionException {
        Expr result = null;

        int andExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return result; }

            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:141:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:141:9: lhs= relExpr ( '&&' rhs= relExpr )*
            {
            pushFollow(FOLLOW_relExpr_in_andExpr653);
            lhs=relExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:141:46: ( '&&' rhs= relExpr )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==17) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:141:48: '&&' rhs= relExpr
            	    {
            	    match(input,17,FOLLOW_17_in_andExpr659); if (state.failed) return result;

            	    pushFollow(FOLLOW_relExpr_in_andExpr663);
            	    rhs=relExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { result = new And(result, rhs); }

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
            if ( state.backtracking>0 ) { memoize(input, 13, andExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "andExpr"



    // $ANTLR start "orExpr"
    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:145:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
    public final Expr orExpr() throws RecognitionException {
        Expr result = null;

        int orExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return result; }

            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:146:5: (lhs= andExpr ( '||' rhs= andExpr )* )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:146:9: lhs= andExpr ( '||' rhs= andExpr )*
            {
            pushFollow(FOLLOW_andExpr_in_orExpr698);
            lhs=andExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = lhs; }

            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:146:48: ( '||' rhs= andExpr )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==34) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:146:50: '||' rhs= andExpr
            	    {
            	    match(input,34,FOLLOW_34_in_orExpr704); if (state.failed) return result;

            	    pushFollow(FOLLOW_andExpr_in_orExpr708);
            	    rhs=andExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { result = new Or(result, rhs); }

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
            if ( state.backtracking>0 ) { memoize(input, 14, orExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "orExpr"

    // $ANTLR start synpred7_QL
    public final void synpred7_QL_fragment() throws RecognitionException {
        Expr expr =null;

        Body b1 =null;

        Body b2 =null;


        // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:65:3: ( 'if' '(' expr= orExpr ')' '{' b1= body '}' 'else' '{' b2= body '}' )
        // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:65:3: 'if' '(' expr= orExpr ')' '{' b1= body '}' 'else' '{' b2= body '}'
        {
        match(input,32,FOLLOW_32_in_synpred7_QL251); if (state.failed) return ;

        match(input,18,FOLLOW_18_in_synpred7_QL253); if (state.failed) return ;

        pushFollow(FOLLOW_orExpr_in_synpred7_QL257);
        expr=orExpr();

        state._fsp--;
        if (state.failed) return ;

        match(input,19,FOLLOW_19_in_synpred7_QL259); if (state.failed) return ;

        match(input,33,FOLLOW_33_in_synpred7_QL261); if (state.failed) return ;

        pushFollow(FOLLOW_body_in_synpred7_QL264);
        b1=body();

        state._fsp--;
        if (state.failed) return ;

        match(input,35,FOLLOW_35_in_synpred7_QL265); if (state.failed) return ;

        match(input,30,FOLLOW_30_in_synpred7_QL267); if (state.failed) return ;

        match(input,33,FOLLOW_33_in_synpred7_QL269); if (state.failed) return ;

        pushFollow(FOLLOW_body_in_synpred7_QL273);
        b2=body();

        state._fsp--;
        if (state.failed) return ;

        match(input,35,FOLLOW_35_in_synpred7_QL274); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred7_QL

    // Delegated rules

    public final boolean synpred7_QL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_QL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_INTEGER_in_type46 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_type53 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_type60 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MONEY_in_type66 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_form86 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_Ident_in_form88 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_form91 = new BitSet(new long[]{0x0000000900000200L});
    public static final BitSet FOLLOW_body_in_form93 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_form95 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_form97 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_element_in_body132 = new BitSet(new long[]{0x0000000100000202L});
    public static final BitSet FOLLOW_conditionalElement_in_element159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_question_in_element166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_computedQuestion_in_element173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_question194 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_question196 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_StringLit_in_question198 = new BitSet(new long[]{0x0000000000001910L});
    public static final BitSet FOLLOW_type_in_question200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_computedQuestion218 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_computedQuestion220 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_StringLit_in_computedQuestion222 = new BitSet(new long[]{0x0000000000001910L});
    public static final BitSet FOLLOW_type_in_computedQuestion224 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_computedQuestion226 = new BitSet(new long[]{0x000000000064A6A0L});
    public static final BitSet FOLLOW_orExpr_in_computedQuestion230 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_computedQuestion232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_conditionalElement251 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_conditionalElement253 = new BitSet(new long[]{0x000000000064A6A0L});
    public static final BitSet FOLLOW_orExpr_in_conditionalElement257 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_conditionalElement259 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_conditionalElement261 = new BitSet(new long[]{0x0000000900000200L});
    public static final BitSet FOLLOW_body_in_conditionalElement264 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_conditionalElement265 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_conditionalElement267 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_conditionalElement269 = new BitSet(new long[]{0x0000000900000200L});
    public static final BitSet FOLLOW_body_in_conditionalElement273 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_conditionalElement274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_conditionalElement281 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_conditionalElement283 = new BitSet(new long[]{0x000000000064A6A0L});
    public static final BitSet FOLLOW_orExpr_in_conditionalElement287 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_conditionalElement289 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_conditionalElement291 = new BitSet(new long[]{0x0000000900000200L});
    public static final BitSet FOLLOW_body_in_conditionalElement293 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_conditionalElement294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Decimal_in_primary317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Int_in_primary325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLit_in_primary333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BoolLit_in_primary341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_primary350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_primary358 = new BitSet(new long[]{0x000000000064A6A0L});
    public static final BitSet FOLLOW_orExpr_in_primary362 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_primary364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_unExpr392 = new BitSet(new long[]{0x000000000064A6A0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_unExpr407 = new BitSet(new long[]{0x000000000064A6A0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_unExpr422 = new BitSet(new long[]{0x000000000064A6A0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_unExpr439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr477 = new BitSet(new long[]{0x0000000000900002L});
    public static final BitSet FOLLOW_set_in_mulExpr485 = new BitSet(new long[]{0x000000000064A6A0L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr497 = new BitSet(new long[]{0x0000000000900002L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr538 = new BitSet(new long[]{0x0000000000600002L});
    public static final BitSet FOLLOW_set_in_addExpr546 = new BitSet(new long[]{0x000000000064A6A0L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr556 = new BitSet(new long[]{0x0000000000600002L});
    public static final BitSet FOLLOW_addExpr_in_relExpr591 = new BitSet(new long[]{0x000000003E010002L});
    public static final BitSet FOLLOW_set_in_relExpr599 = new BitSet(new long[]{0x000000000064A6A0L});
    public static final BitSet FOLLOW_addExpr_in_relExpr615 = new BitSet(new long[]{0x000000003E010002L});
    public static final BitSet FOLLOW_relExpr_in_andExpr653 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_andExpr659 = new BitSet(new long[]{0x000000000064A6A0L});
    public static final BitSet FOLLOW_relExpr_in_andExpr663 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_andExpr_in_orExpr698 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_34_in_orExpr704 = new BitSet(new long[]{0x000000000064A6A0L});
    public static final BitSet FOLLOW_andExpr_in_orExpr708 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_32_in_synpred7_QL251 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_synpred7_QL253 = new BitSet(new long[]{0x000000000064A6A0L});
    public static final BitSet FOLLOW_orExpr_in_synpred7_QL257 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_synpred7_QL259 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_synpred7_QL261 = new BitSet(new long[]{0x0000000900000200L});
    public static final BitSet FOLLOW_body_in_synpred7_QL264 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_synpred7_QL265 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_synpred7_QL267 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_synpred7_QL269 = new BitSet(new long[]{0x0000000900000200L});
    public static final BitSet FOLLOW_body_in_synpred7_QL273 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_synpred7_QL274 = new BitSet(new long[]{0x0000000000000002L});

}