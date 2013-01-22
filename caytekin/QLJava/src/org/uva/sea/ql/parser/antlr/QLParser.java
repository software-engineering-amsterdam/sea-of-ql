// $ANTLR 3.4 C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g 2013-01-21 13:51:28

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class QLParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "BooleanType", "COMMENT", "ElseRW", "FalseRW", "Ident", "IfRW", "Int", "IntegerType", "SINGLE_LINE_COMMENT", "StringLiteral", "StringType", "ThenRW", "TrueRW", "WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", "'/'", "':'", "'<'", "'<='", "'=='", "'>'", "'>='", "'{'", "'||'", "'}'"
    };

    public static final int EOF=-1;
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
    public static final int BooleanType=4;
    public static final int COMMENT=5;
    public static final int ElseRW=6;
    public static final int FalseRW=7;
    public static final int Ident=8;
    public static final int IfRW=9;
    public static final int Int=10;
    public static final int IntegerType=11;
    public static final int SINGLE_LINE_COMMENT=12;
    public static final int StringLiteral=13;
    public static final int StringType=14;
    public static final int ThenRW=15;
    public static final int TrueRW=16;
    public static final int WS=17;

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
        this.state.ruleMemo = new HashMap[48+1];
         

    }

    public String[] getTokenNames() { return QLParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g"; }



    // $ANTLR start "form"
    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:17:1: form : Ident '{' ( allStatements )* '}' ;
    public final void form() throws RecognitionException {
        int form_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return ; }

            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:18:2: ( Ident '{' ( allStatements )* '}' )
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:18:4: Ident '{' ( allStatements )* '}'
            {
            match(input,Ident,FOLLOW_Ident_in_form43); if (state.failed) return ;

            match(input,33,FOLLOW_33_in_form45); if (state.failed) return ;

            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:18:14: ( allStatements )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= Ident && LA1_0 <= IfRW)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:18:15: allStatements
            	    {
            	    pushFollow(FOLLOW_allStatements_in_form48);
            	    allStatements();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            match(input,35,FOLLOW_35_in_form52); if (state.failed) return ;

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
        return ;
    }
    // $ANTLR end "form"



    // $ANTLR start "allStatements"
    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:22:1: allStatements : ( questionStatement | conditionalStatement );
    public final void allStatements() throws RecognitionException {
        int allStatements_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return ; }

            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:23:2: ( questionStatement | conditionalStatement )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==Ident) ) {
                alt2=1;
            }
            else if ( (LA2_0==IfRW) ) {
                alt2=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }
            switch (alt2) {
                case 1 :
                    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:23:4: questionStatement
                    {
                    pushFollow(FOLLOW_questionStatement_in_allStatements66);
                    questionStatement();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:24:4: conditionalStatement
                    {
                    pushFollow(FOLLOW_conditionalStatement_in_allStatements71);
                    conditionalStatement();

                    state._fsp--;
                    if (state.failed) return ;

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
            if ( state.backtracking>0 ) { memoize(input, 2, allStatements_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "allStatements"



    // $ANTLR start "questionStatement"
    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:28:1: questionStatement returns [ QuestionStatement result] : (q= question |cq= computedQuestion );
    public final QuestionStatement questionStatement() throws RecognitionException {
        QuestionStatement result = null;

        int questionStatement_StartIndex = input.index();

        Question q =null;

        ComputedQuestion cq =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:29:2: (q= question |cq= computedQuestion )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==Ident) ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==27) ) {
                    int LA3_2 = input.LA(3);

                    if ( (LA3_2==StringLiteral) ) {
                        switch ( input.LA(4) ) {
                        case BooleanType:
                            {
                            int LA3_4 = input.LA(5);

                            if ( (LA3_4==EOF||(LA3_4 >= Ident && LA3_4 <= IfRW)||LA3_4==35) ) {
                                alt3=1;
                            }
                            else if ( (LA3_4==21) ) {
                                alt3=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return result;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 3, 4, input);

                                throw nvae;

                            }
                            }
                            break;
                        case IntegerType:
                            {
                            int LA3_5 = input.LA(5);

                            if ( (LA3_5==EOF||(LA3_5 >= Ident && LA3_5 <= IfRW)||LA3_5==35) ) {
                                alt3=1;
                            }
                            else if ( (LA3_5==21) ) {
                                alt3=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return result;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 3, 5, input);

                                throw nvae;

                            }
                            }
                            break;
                        case StringType:
                            {
                            int LA3_6 = input.LA(5);

                            if ( (LA3_6==EOF||(LA3_6 >= Ident && LA3_6 <= IfRW)||LA3_6==35) ) {
                                alt3=1;
                            }
                            else if ( (LA3_6==21) ) {
                                alt3=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return result;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 3, 6, input);

                                throw nvae;

                            }
                            }
                            break;
                        default:
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
                    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:29:4: q= question
                    {
                    pushFollow(FOLLOW_question_in_questionStatement94);
                    q=question();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = q; }

                    }
                    break;
                case 2 :
                    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:30:4: cq= computedQuestion
                    {
                    pushFollow(FOLLOW_computedQuestion_in_questionStatement106);
                    cq=computedQuestion();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = cq; }

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
            if ( state.backtracking>0 ) { memoize(input, 3, questionStatement_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "questionStatement"



    // $ANTLR start "conditionalStatement"
    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:34:1: conditionalStatement returns [ConditionalStatement result] : (stmt1= ifThenStatement |stmt2= ifThenElseStatement );
    public final ConditionalStatement conditionalStatement() throws RecognitionException {
        ConditionalStatement result = null;

        int conditionalStatement_StartIndex = input.index();

        IfThenStatement stmt1 =null;

        IfThenElseStatement stmt2 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:35:2: (stmt1= ifThenStatement |stmt2= ifThenElseStatement )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==IfRW) ) {
                int LA4_1 = input.LA(2);

                if ( (synpred4_QL()) ) {
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
                    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:35:4: stmt1= ifThenStatement
                    {
                    pushFollow(FOLLOW_ifThenStatement_in_conditionalStatement129);
                    stmt1=ifThenStatement();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = stmt1; }

                    }
                    break;
                case 2 :
                    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:36:4: stmt2= ifThenElseStatement
                    {
                    pushFollow(FOLLOW_ifThenElseStatement_in_conditionalStatement140);
                    stmt2=ifThenElseStatement();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = stmt2; }

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
            if ( state.backtracking>0 ) { memoize(input, 4, conditionalStatement_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "conditionalStatement"



    // $ANTLR start "ifThenStatement"
    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:40:1: ifThenStatement returns [IfThenStatement result] : 'if' e= orExpr 'then' '{' (qs= questionStatement )* '}' ;
    public final IfThenStatement ifThenStatement() throws RecognitionException {
        IfThenStatement result = null;

        int ifThenStatement_StartIndex = input.index();

        Expr e =null;

        QuestionStatement qs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:41:2: ( 'if' e= orExpr 'then' '{' (qs= questionStatement )* '}' )
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:41:4: 'if' e= orExpr 'then' '{' (qs= questionStatement )* '}'
            {
            match(input,IfRW,FOLLOW_IfRW_in_ifThenStatement160); if (state.failed) return result;

            pushFollow(FOLLOW_orExpr_in_ifThenStatement166);
            e=orExpr();

            state._fsp--;
            if (state.failed) return result;

            match(input,ThenRW,FOLLOW_ThenRW_in_ifThenStatement168); if (state.failed) return result;

            match(input,33,FOLLOW_33_in_ifThenStatement170); if (state.failed) return result;

            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:41:31: (qs= questionStatement )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==Ident) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:41:32: qs= questionStatement
            	    {
            	    pushFollow(FOLLOW_questionStatement_in_ifThenStatement175);
            	    qs=questionStatement();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            match(input,35,FOLLOW_35_in_ifThenStatement179); if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new IfThenStatement(e, qs); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 5, ifThenStatement_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "ifThenStatement"



    // $ANTLR start "ifThenElseStatement"
    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:45:1: ifThenElseStatement returns [IfThenElseStatement result] : 'if' e= orExpr 'then' '{' (qsThen= questionStatement )* '}' 'else' '{' (qsElse= questionStatement )* '}' ;
    public final IfThenElseStatement ifThenElseStatement() throws RecognitionException {
        IfThenElseStatement result = null;

        int ifThenElseStatement_StartIndex = input.index();

        Expr e =null;

        QuestionStatement qsThen =null;

        QuestionStatement qsElse =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:46:2: ( 'if' e= orExpr 'then' '{' (qsThen= questionStatement )* '}' 'else' '{' (qsElse= questionStatement )* '}' )
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:46:4: 'if' e= orExpr 'then' '{' (qsThen= questionStatement )* '}' 'else' '{' (qsElse= questionStatement )* '}'
            {
            match(input,IfRW,FOLLOW_IfRW_in_ifThenElseStatement201); if (state.failed) return result;

            pushFollow(FOLLOW_orExpr_in_ifThenElseStatement207);
            e=orExpr();

            state._fsp--;
            if (state.failed) return result;

            match(input,ThenRW,FOLLOW_ThenRW_in_ifThenElseStatement210); if (state.failed) return result;

            match(input,33,FOLLOW_33_in_ifThenElseStatement212); if (state.failed) return result;

            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:47:13: (qsThen= questionStatement )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==Ident) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:47:14: qsThen= questionStatement
            	    {
            	    pushFollow(FOLLOW_questionStatement_in_ifThenElseStatement219);
            	    qsThen=questionStatement();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            match(input,35,FOLLOW_35_in_ifThenElseStatement223); if (state.failed) return result;

            match(input,ElseRW,FOLLOW_ElseRW_in_ifThenElseStatement226); if (state.failed) return result;

            match(input,33,FOLLOW_33_in_ifThenElseStatement228); if (state.failed) return result;

            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:48:13: (qsElse= questionStatement )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==Ident) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:48:14: qsElse= questionStatement
            	    {
            	    pushFollow(FOLLOW_questionStatement_in_ifThenElseStatement235);
            	    qsElse=questionStatement();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            match(input,35,FOLLOW_35_in_ifThenElseStatement239); if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new IfThenElseStatement(e, qsThen, qsElse); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 6, ifThenElseStatement_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "ifThenElseStatement"



    // $ANTLR start "computedQuestion"
    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:52:1: computedQuestion returns [ComputedQuestion result] : Ident ':' StringLiteral t= type '(' e= orExpr ')' ;
    public final ComputedQuestion computedQuestion() throws RecognitionException {
        ComputedQuestion result = null;

        int computedQuestion_StartIndex = input.index();

        Token Ident1=null;
        Token StringLiteral2=null;
        Type t =null;

        Expr e =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:53:2: ( Ident ':' StringLiteral t= type '(' e= orExpr ')' )
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:53:4: Ident ':' StringLiteral t= type '(' e= orExpr ')'
            {
            Ident1=(Token)match(input,Ident,FOLLOW_Ident_in_computedQuestion260); if (state.failed) return result;

            match(input,27,FOLLOW_27_in_computedQuestion262); if (state.failed) return result;

            StringLiteral2=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_computedQuestion264); if (state.failed) return result;

            pushFollow(FOLLOW_type_in_computedQuestion268);
            t=type();

            state._fsp--;
            if (state.failed) return result;

            match(input,21,FOLLOW_21_in_computedQuestion270); if (state.failed) return result;

            pushFollow(FOLLOW_orExpr_in_computedQuestion274);
            e=orExpr();

            state._fsp--;
            if (state.failed) return result;

            match(input,22,FOLLOW_22_in_computedQuestion276); if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new ComputedQuestion((Ident1!=null?Ident1.getText():null), (StringLiteral2!=null?StringLiteral2.getText():null), t, e); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 7, computedQuestion_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "computedQuestion"



    // $ANTLR start "question"
    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:58:1: question returns [Question result] : Ident ':' StringLiteral t= type ;
    public final Question question() throws RecognitionException {
        Question result = null;

        int question_StartIndex = input.index();

        Token Ident3=null;
        Token StringLiteral4=null;
        Type t =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:59:3: ( Ident ':' StringLiteral t= type )
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:59:5: Ident ':' StringLiteral t= type
            {
            Ident3=(Token)match(input,Ident,FOLLOW_Ident_in_question298); if (state.failed) return result;

            match(input,27,FOLLOW_27_in_question300); if (state.failed) return result;

            StringLiteral4=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_question302); if (state.failed) return result;

            pushFollow(FOLLOW_type_in_question306);
            t=type();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new Question((Ident3!=null?Ident3.getText():null), (StringLiteral4!=null?StringLiteral4.getText():null), t); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 8, question_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "question"



    // $ANTLR start "type"
    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:64:1: type returns [Type result] : ( BooleanType | IntegerType | StringType );
    public final Type type() throws RecognitionException {
        Type result = null;

        int type_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:65:4: ( BooleanType | IntegerType | StringType )
            int alt8=3;
            switch ( input.LA(1) ) {
            case BooleanType:
                {
                alt8=1;
                }
                break;
            case IntegerType:
                {
                alt8=2;
                }
                break;
            case StringType:
                {
                alt8=3;
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
                    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:65:6: BooleanType
                    {
                    match(input,BooleanType,FOLLOW_BooleanType_in_type335); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new BooleanType(); }

                    }
                    break;
                case 2 :
                    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:66:6: IntegerType
                    {
                    match(input,IntegerType,FOLLOW_IntegerType_in_type344); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new IntegerType(); }

                    }
                    break;
                case 3 :
                    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:67:6: StringType
                    {
                    match(input,StringType,FOLLOW_StringType_in_type353); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new StringType(); }

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
            if ( state.backtracking>0 ) { memoize(input, 9, type_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "type"



    // $ANTLR start "reservedWord"
    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:70:1: reservedWord returns [ReservedWord result] : ( TrueRW | FalseRW | IfRW | ThenRW | ElseRW );
    public final ReservedWord reservedWord() throws RecognitionException {
        ReservedWord result = null;

        int reservedWord_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:71:2: ( TrueRW | FalseRW | IfRW | ThenRW | ElseRW )
            int alt9=5;
            switch ( input.LA(1) ) {
            case TrueRW:
                {
                alt9=1;
                }
                break;
            case FalseRW:
                {
                alt9=2;
                }
                break;
            case IfRW:
                {
                alt9=3;
                }
                break;
            case ThenRW:
                {
                alt9=4;
                }
                break;
            case ElseRW:
                {
                alt9=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;

            }

            switch (alt9) {
                case 1 :
                    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:71:4: TrueRW
                    {
                    match(input,TrueRW,FOLLOW_TrueRW_in_reservedWord371); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new TrueRW(); }

                    }
                    break;
                case 2 :
                    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:72:4: FalseRW
                    {
                    match(input,FalseRW,FOLLOW_FalseRW_in_reservedWord378); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new FalseRW(); }

                    }
                    break;
                case 3 :
                    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:73:4: IfRW
                    {
                    match(input,IfRW,FOLLOW_IfRW_in_reservedWord385); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new IfRW(); }

                    }
                    break;
                case 4 :
                    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:74:4: ThenRW
                    {
                    match(input,ThenRW,FOLLOW_ThenRW_in_reservedWord392); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new ThenRW(); }

                    }
                    break;
                case 5 :
                    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:75:4: ElseRW
                    {
                    match(input,ElseRW,FOLLOW_ElseRW_in_reservedWord399); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new ElseRW(); }

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
            if ( state.backtracking>0 ) { memoize(input, 10, reservedWord_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "reservedWord"



    // $ANTLR start "primary"
    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:80:1: primary returns [Expr result] : ( Int | Ident | StringLiteral | '(' x= orExpr ')' );
    public final Expr primary() throws RecognitionException {
        Expr result = null;

        int primary_StartIndex = input.index();

        Token Int5=null;
        Token Ident6=null;
        Token StringLiteral7=null;
        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:81:3: ( Int | Ident | StringLiteral | '(' x= orExpr ')' )
            int alt10=4;
            switch ( input.LA(1) ) {
            case Int:
                {
                alt10=1;
                }
                break;
            case Ident:
                {
                alt10=2;
                }
                break;
            case StringLiteral:
                {
                alt10=3;
                }
                break;
            case 21:
                {
                alt10=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;

            }

            switch (alt10) {
                case 1 :
                    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:81:5: Int
                    {
                    Int5=(Token)match(input,Int,FOLLOW_Int_in_primary421); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Int(Integer.parseInt((Int5!=null?Int5.getText():null))); }

                    }
                    break;
                case 2 :
                    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:82:5: Ident
                    {
                    Ident6=(Token)match(input,Ident,FOLLOW_Ident_in_primary431); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Ident((Ident6!=null?Ident6.getText():null)); }

                    }
                    break;
                case 3 :
                    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:83:5: StringLiteral
                    {
                    StringLiteral7=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_primary439); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new StringLiteral((StringLiteral7!=null?StringLiteral7.getText():null)); }

                    }
                    break;
                case 4 :
                    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:84:5: '(' x= orExpr ')'
                    {
                    match(input,21,FOLLOW_21_in_primary447); if (state.failed) return result;

                    pushFollow(FOLLOW_orExpr_in_primary451);
                    x=orExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,22,FOLLOW_22_in_primary453); if (state.failed) return result;

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
            if ( state.backtracking>0 ) { memoize(input, 11, primary_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "primary"



    // $ANTLR start "unExpr"
    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:88:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
    public final Expr unExpr() throws RecognitionException {
        Expr result = null;

        int unExpr_StartIndex = input.index();

        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }

            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:89:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
            int alt11=4;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt11=1;
                }
                break;
            case 25:
                {
                alt11=2;
                }
                break;
            case 18:
                {
                alt11=3;
                }
                break;
            case Ident:
            case Int:
            case StringLiteral:
            case 21:
                {
                alt11=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;

            }

            switch (alt11) {
                case 1 :
                    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:89:7: '+' x= unExpr
                    {
                    match(input,24,FOLLOW_24_in_unExpr478); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr482);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Pos(x); }

                    }
                    break;
                case 2 :
                    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:90:7: '-' x= unExpr
                    {
                    match(input,25,FOLLOW_25_in_unExpr492); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr496);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Neg(x); }

                    }
                    break;
                case 3 :
                    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:91:7: '!' x= unExpr
                    {
                    match(input,18,FOLLOW_18_in_unExpr506); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr510);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Not(x); }

                    }
                    break;
                case 4 :
                    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:92:7: x= primary
                    {
                    pushFollow(FOLLOW_primary_in_unExpr522);
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
            if ( state.backtracking>0 ) { memoize(input, 12, unExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "unExpr"



    // $ANTLR start "mulExpr"
    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:96:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
    public final Expr mulExpr() throws RecognitionException {
        Expr result = null;

        int mulExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return result; }

            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:97:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:97:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
            {
            pushFollow(FOLLOW_unExpr_in_mulExpr558);
            lhs=unExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:97:45: (op= ( '*' | '/' ) rhs= unExpr )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==23||LA12_0==26) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:97:47: op= ( '*' | '/' ) rhs= unExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( input.LA(1)==23||input.LA(1)==26 ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_unExpr_in_mulExpr578);
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
            if ( state.backtracking>0 ) { memoize(input, 13, mulExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "mulExpr"



    // $ANTLR start "addExpr"
    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:109:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
    public final Expr addExpr() throws RecognitionException {
        Expr result = null;

        int addExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return result; }

            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:110:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:110:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
            {
            pushFollow(FOLLOW_mulExpr_in_addExpr619);
            lhs=mulExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:110:46: (op= ( '+' | '-' ) rhs= mulExpr )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0 >= 24 && LA13_0 <= 25)) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:110:48: op= ( '+' | '-' ) rhs= mulExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( (input.LA(1) >= 24 && input.LA(1) <= 25) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_mulExpr_in_addExpr637);
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
            if ( state.backtracking>0 ) { memoize(input, 14, addExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "addExpr"



    // $ANTLR start "relExpr"
    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:121:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
    public final Expr relExpr() throws RecognitionException {
        Expr result = null;

        int relExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return result; }

            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:122:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:122:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            {
            pushFollow(FOLLOW_addExpr_in_relExpr672);
            lhs=addExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:122:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==19||(LA14_0 >= 28 && LA14_0 <= 32)) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:122:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( input.LA(1)==19||(input.LA(1) >= 28 && input.LA(1) <= 32) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_addExpr_in_relExpr696);
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
            	    break loop14;
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
            if ( state.backtracking>0 ) { memoize(input, 15, relExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "relExpr"



    // $ANTLR start "andExpr"
    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:145:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
    public final Expr andExpr() throws RecognitionException {
        Expr result = null;

        int andExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return result; }

            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:146:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:146:9: lhs= relExpr ( '&&' rhs= relExpr )*
            {
            pushFollow(FOLLOW_relExpr_in_andExpr734);
            lhs=relExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:146:46: ( '&&' rhs= relExpr )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==20) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:146:48: '&&' rhs= relExpr
            	    {
            	    match(input,20,FOLLOW_20_in_andExpr740); if (state.failed) return result;

            	    pushFollow(FOLLOW_relExpr_in_andExpr744);
            	    rhs=relExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { result = new And(result, rhs); }

            	    }
            	    break;

            	default :
            	    break loop15;
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
            if ( state.backtracking>0 ) { memoize(input, 16, andExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "andExpr"



    // $ANTLR start "orExpr"
    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:150:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
    public final Expr orExpr() throws RecognitionException {
        Expr result = null;

        int orExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return result; }

            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:151:5: (lhs= andExpr ( '||' rhs= andExpr )* )
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:151:9: lhs= andExpr ( '||' rhs= andExpr )*
            {
            pushFollow(FOLLOW_andExpr_in_orExpr779);
            lhs=andExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = lhs; }

            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:151:48: ( '||' rhs= andExpr )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==34) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:151:50: '||' rhs= andExpr
            	    {
            	    match(input,34,FOLLOW_34_in_orExpr785); if (state.failed) return result;

            	    pushFollow(FOLLOW_andExpr_in_orExpr789);
            	    rhs=andExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { result = new Or(result, rhs); }

            	    }
            	    break;

            	default :
            	    break loop16;
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
            if ( state.backtracking>0 ) { memoize(input, 17, orExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "orExpr"

    // $ANTLR start synpred4_QL
    public final void synpred4_QL_fragment() throws RecognitionException {
        IfThenStatement stmt1 =null;


        // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:35:4: (stmt1= ifThenStatement )
        // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:35:4: stmt1= ifThenStatement
        {
        pushFollow(FOLLOW_ifThenStatement_in_synpred4_QL129);
        stmt1=ifThenStatement();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred4_QL

    // Delegated rules

    public final boolean synpred4_QL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_QL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_Ident_in_form43 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_form45 = new BitSet(new long[]{0x0000000800000300L});
    public static final BitSet FOLLOW_allStatements_in_form48 = new BitSet(new long[]{0x0000000800000300L});
    public static final BitSet FOLLOW_35_in_form52 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_questionStatement_in_allStatements66 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditionalStatement_in_allStatements71 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_question_in_questionStatement94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_computedQuestion_in_questionStatement106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifThenStatement_in_conditionalStatement129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifThenElseStatement_in_conditionalStatement140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IfRW_in_ifThenStatement160 = new BitSet(new long[]{0x0000000003242500L});
    public static final BitSet FOLLOW_orExpr_in_ifThenStatement166 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_ThenRW_in_ifThenStatement168 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ifThenStatement170 = new BitSet(new long[]{0x0000000800000100L});
    public static final BitSet FOLLOW_questionStatement_in_ifThenStatement175 = new BitSet(new long[]{0x0000000800000100L});
    public static final BitSet FOLLOW_35_in_ifThenStatement179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IfRW_in_ifThenElseStatement201 = new BitSet(new long[]{0x0000000003242500L});
    public static final BitSet FOLLOW_orExpr_in_ifThenElseStatement207 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_ThenRW_in_ifThenElseStatement210 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ifThenElseStatement212 = new BitSet(new long[]{0x0000000800000100L});
    public static final BitSet FOLLOW_questionStatement_in_ifThenElseStatement219 = new BitSet(new long[]{0x0000000800000100L});
    public static final BitSet FOLLOW_35_in_ifThenElseStatement223 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ElseRW_in_ifThenElseStatement226 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ifThenElseStatement228 = new BitSet(new long[]{0x0000000800000100L});
    public static final BitSet FOLLOW_questionStatement_in_ifThenElseStatement235 = new BitSet(new long[]{0x0000000800000100L});
    public static final BitSet FOLLOW_35_in_ifThenElseStatement239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_computedQuestion260 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_computedQuestion262 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_StringLiteral_in_computedQuestion264 = new BitSet(new long[]{0x0000000000004810L});
    public static final BitSet FOLLOW_type_in_computedQuestion268 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_computedQuestion270 = new BitSet(new long[]{0x0000000003242500L});
    public static final BitSet FOLLOW_orExpr_in_computedQuestion274 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_computedQuestion276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_question298 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_question300 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_StringLiteral_in_question302 = new BitSet(new long[]{0x0000000000004810L});
    public static final BitSet FOLLOW_type_in_question306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BooleanType_in_type335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IntegerType_in_type344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringType_in_type353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TrueRW_in_reservedWord371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FalseRW_in_reservedWord378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IfRW_in_reservedWord385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ThenRW_in_reservedWord392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ElseRW_in_reservedWord399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Int_in_primary421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_primary431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_primary439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_primary447 = new BitSet(new long[]{0x0000000003242500L});
    public static final BitSet FOLLOW_orExpr_in_primary451 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_primary453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_unExpr478 = new BitSet(new long[]{0x0000000003242500L});
    public static final BitSet FOLLOW_unExpr_in_unExpr482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_unExpr492 = new BitSet(new long[]{0x0000000003242500L});
    public static final BitSet FOLLOW_unExpr_in_unExpr496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_unExpr506 = new BitSet(new long[]{0x0000000003242500L});
    public static final BitSet FOLLOW_unExpr_in_unExpr510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_unExpr522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr558 = new BitSet(new long[]{0x0000000004800002L});
    public static final BitSet FOLLOW_set_in_mulExpr566 = new BitSet(new long[]{0x0000000003242500L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr578 = new BitSet(new long[]{0x0000000004800002L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr619 = new BitSet(new long[]{0x0000000003000002L});
    public static final BitSet FOLLOW_set_in_addExpr627 = new BitSet(new long[]{0x0000000003242500L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr637 = new BitSet(new long[]{0x0000000003000002L});
    public static final BitSet FOLLOW_addExpr_in_relExpr672 = new BitSet(new long[]{0x00000001F0080002L});
    public static final BitSet FOLLOW_set_in_relExpr680 = new BitSet(new long[]{0x0000000003242500L});
    public static final BitSet FOLLOW_addExpr_in_relExpr696 = new BitSet(new long[]{0x00000001F0080002L});
    public static final BitSet FOLLOW_relExpr_in_andExpr734 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_andExpr740 = new BitSet(new long[]{0x0000000003242500L});
    public static final BitSet FOLLOW_relExpr_in_andExpr744 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_andExpr_in_orExpr779 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_34_in_orExpr785 = new BitSet(new long[]{0x0000000003242500L});
    public static final BitSet FOLLOW_andExpr_in_orExpr789 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_ifThenStatement_in_synpred4_QL129 = new BitSet(new long[]{0x0000000000000002L});

}