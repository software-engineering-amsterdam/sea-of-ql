// $ANTLR 3.4 /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g 2013-01-21 14:59:29

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.form.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class QLParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "BooleanType", "COMMENT", "Ident", "Int", "IntType", "String", "StringType", "WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", "'/'", "':'", "'<'", "'<='", "'=='", "'>'", "'>='", "'else'", "'form'", "'if'", "'{'", "'||'", "'}'"
    };

    public static final int EOF=-1;
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
    public static final int BooleanType=4;
    public static final int COMMENT=5;
    public static final int Ident=6;
    public static final int Int=7;
    public static final int IntType=8;
    public static final int String=9;
    public static final int StringType=10;
    public static final int WS=11;

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
        this.state.ruleMemo = new HashMap[37+1];
         

    }

    public String[] getTokenNames() { return QLParser.tokenNames; }
    public String getGrammarFileName() { return "/Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g"; }



    // $ANTLR start "form"
    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:16:1: form returns [Form result] : 'form' Ident '{' formItem '}' ;
    public final Form form() throws RecognitionException {
        Form result = null;

        int form_StartIndex = input.index();

        Token Ident2=null;
        List<FormItem> formItem1 =null;


         List<FormItem> formItems = new ArrayList(); 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:18:3: ( 'form' Ident '{' formItem '}' )
            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:18:5: 'form' Ident '{' formItem '}'
            {
            match(input,28,FOLLOW_28_in_form51); if (state.failed) return result;

            Ident2=(Token)match(input,Ident,FOLLOW_Ident_in_form53); if (state.failed) return result;

            match(input,30,FOLLOW_30_in_form55); if (state.failed) return result;

            pushFollow(FOLLOW_formItem_in_form61);
            formItem1=formItem();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { formItems.addAll(formItem1); }

            match(input,32,FOLLOW_32_in_form69); if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new Form((Ident2!=null?Ident2.getText():null), formItems); }

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



    // $ANTLR start "formItem"
    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:24:1: formItem returns [List<FormItem> result] : (ie= ifElseStatement |i= ifStatement |cq= computedQuestion |q= question )+ ;
    public final List<FormItem> formItem() throws RecognitionException {
        List<FormItem> result = null;

        int formItem_StartIndex = input.index();

        IfElseStatement ie =null;

        IfStatement i =null;

        ComputedQuestion cq =null;

        Question q =null;


         List<FormItem> formItems = new ArrayList(); 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:26:3: ( (ie= ifElseStatement |i= ifStatement |cq= computedQuestion |q= question )+ )
            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:26:5: (ie= ifElseStatement |i= ifStatement |cq= computedQuestion |q= question )+
            {
            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:26:5: (ie= ifElseStatement |i= ifStatement |cq= computedQuestion |q= question )+
            int cnt1=0;
            loop1:
            do {
                int alt1=5;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==29) ) {
                    int LA1_2 = input.LA(2);

                    if ( (synpred1_QL()) ) {
                        alt1=1;
                    }
                    else if ( (synpred2_QL()) ) {
                        alt1=2;
                    }


                }
                else if ( (LA1_0==Ident) ) {
                    int LA1_3 = input.LA(2);

                    if ( (synpred3_QL()) ) {
                        alt1=3;
                    }
                    else if ( (synpred4_QL()) ) {
                        alt1=4;
                    }


                }


                switch (alt1) {
            	case 1 :
            	    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:26:7: ie= ifElseStatement
            	    {
            	    pushFollow(FOLLOW_ifElseStatement_in_formItem98);
            	    ie=ifElseStatement();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { formItems.add(ie); }

            	    }
            	    break;
            	case 2 :
            	    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:27:7: i= ifStatement
            	    {
            	    pushFollow(FOLLOW_ifStatement_in_formItem110);
            	    i=ifStatement();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { formItems.add(i); }

            	    }
            	    break;
            	case 3 :
            	    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:28:7: cq= computedQuestion
            	    {
            	    pushFollow(FOLLOW_computedQuestion_in_formItem123);
            	    cq=computedQuestion();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { formItems.add(cq); }

            	    }
            	    break;
            	case 4 :
            	    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:29:7: q= question
            	    {
            	    pushFollow(FOLLOW_question_in_formItem136);
            	    q=question();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { formItems.add(q); }

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
            	    if (state.backtracking>0) {state.failed=true; return result;}
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            if ( state.backtracking==0 ) { result = formItems; }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 2, formItem_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "formItem"



    // $ANTLR start "ifElseStatement"
    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:33:1: ifElseStatement returns [IfElseStatement result] : 'if' '(' orExpr ')' '{' ifBody= formItem '}' 'else' '{' elseBody= formItem '}' ;
    public final IfElseStatement ifElseStatement() throws RecognitionException {
        IfElseStatement result = null;

        int ifElseStatement_StartIndex = input.index();

        List<FormItem> ifBody =null;

        List<FormItem> elseBody =null;

        Expr orExpr3 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:34:3: ( 'if' '(' orExpr ')' '{' ifBody= formItem '}' 'else' '{' elseBody= formItem '}' )
            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:34:5: 'if' '(' orExpr ')' '{' ifBody= formItem '}' 'else' '{' elseBody= formItem '}'
            {
            match(input,29,FOLLOW_29_in_ifElseStatement167); if (state.failed) return result;

            match(input,15,FOLLOW_15_in_ifElseStatement169); if (state.failed) return result;

            pushFollow(FOLLOW_orExpr_in_ifElseStatement171);
            orExpr3=orExpr();

            state._fsp--;
            if (state.failed) return result;

            match(input,16,FOLLOW_16_in_ifElseStatement173); if (state.failed) return result;

            match(input,30,FOLLOW_30_in_ifElseStatement175); if (state.failed) return result;

            pushFollow(FOLLOW_formItem_in_ifElseStatement179);
            ifBody=formItem();

            state._fsp--;
            if (state.failed) return result;

            match(input,32,FOLLOW_32_in_ifElseStatement181); if (state.failed) return result;

            match(input,27,FOLLOW_27_in_ifElseStatement187); if (state.failed) return result;

            match(input,30,FOLLOW_30_in_ifElseStatement189); if (state.failed) return result;

            pushFollow(FOLLOW_formItem_in_ifElseStatement193);
            elseBody=formItem();

            state._fsp--;
            if (state.failed) return result;

            match(input,32,FOLLOW_32_in_ifElseStatement195); if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new IfElseStatement(orExpr3, ifBody, elseBody); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 3, ifElseStatement_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "ifElseStatement"



    // $ANTLR start "ifStatement"
    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:39:1: ifStatement returns [IfStatement result] : 'if' '(' orExpr ')' '{' ifBody= formItem '}' ;
    public final IfStatement ifStatement() throws RecognitionException {
        IfStatement result = null;

        int ifStatement_StartIndex = input.index();

        List<FormItem> ifBody =null;

        Expr orExpr4 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:40:3: ( 'if' '(' orExpr ')' '{' ifBody= formItem '}' )
            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:40:5: 'if' '(' orExpr ')' '{' ifBody= formItem '}'
            {
            match(input,29,FOLLOW_29_in_ifStatement221); if (state.failed) return result;

            match(input,15,FOLLOW_15_in_ifStatement223); if (state.failed) return result;

            pushFollow(FOLLOW_orExpr_in_ifStatement225);
            orExpr4=orExpr();

            state._fsp--;
            if (state.failed) return result;

            match(input,16,FOLLOW_16_in_ifStatement227); if (state.failed) return result;

            match(input,30,FOLLOW_30_in_ifStatement229); if (state.failed) return result;

            pushFollow(FOLLOW_formItem_in_ifStatement233);
            ifBody=formItem();

            state._fsp--;
            if (state.failed) return result;

            match(input,32,FOLLOW_32_in_ifStatement235); if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new IfStatement(orExpr4, ifBody); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 4, ifStatement_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "ifStatement"



    // $ANTLR start "computedQuestion"
    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:44:1: computedQuestion returns [ComputedQuestion result] : Ident ':' String questionType '(' orExpr ')' ;
    public final ComputedQuestion computedQuestion() throws RecognitionException {
        ComputedQuestion result = null;

        int computedQuestion_StartIndex = input.index();

        Token Ident5=null;
        Token String6=null;
        QLParser.questionType_return questionType7 =null;

        Expr orExpr8 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:45:3: ( Ident ':' String questionType '(' orExpr ')' )
            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:45:5: Ident ':' String questionType '(' orExpr ')'
            {
            Ident5=(Token)match(input,Ident,FOLLOW_Ident_in_computedQuestion260); if (state.failed) return result;

            match(input,21,FOLLOW_21_in_computedQuestion262); if (state.failed) return result;

            String6=(Token)match(input,String,FOLLOW_String_in_computedQuestion264); if (state.failed) return result;

            pushFollow(FOLLOW_questionType_in_computedQuestion266);
            questionType7=questionType();

            state._fsp--;
            if (state.failed) return result;

            match(input,15,FOLLOW_15_in_computedQuestion268); if (state.failed) return result;

            pushFollow(FOLLOW_orExpr_in_computedQuestion270);
            orExpr8=orExpr();

            state._fsp--;
            if (state.failed) return result;

            match(input,16,FOLLOW_16_in_computedQuestion272); if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new ComputedQuestion((Ident5!=null?Ident5.getText():null), (String6!=null?String6.getText():null), (questionType7!=null?input.toString(questionType7.start,questionType7.stop):null), orExpr8); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 5, computedQuestion_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "computedQuestion"



    // $ANTLR start "question"
    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:49:1: question returns [Question result] : Ident ':' String questionType ;
    public final Question question() throws RecognitionException {
        Question result = null;

        int question_StartIndex = input.index();

        Token Ident9=null;
        Token String10=null;
        QLParser.questionType_return questionType11 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:50:3: ( Ident ':' String questionType )
            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:50:5: Ident ':' String questionType
            {
            Ident9=(Token)match(input,Ident,FOLLOW_Ident_in_question298); if (state.failed) return result;

            match(input,21,FOLLOW_21_in_question300); if (state.failed) return result;

            String10=(Token)match(input,String,FOLLOW_String_in_question302); if (state.failed) return result;

            pushFollow(FOLLOW_questionType_in_question304);
            questionType11=questionType();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new Question((Ident9!=null?Ident9.getText():null), (String10!=null?String10.getText():null), (questionType11!=null?input.toString(questionType11.start,questionType11.stop):null)); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 6, question_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "question"


    public static class questionType_return extends ParserRuleReturnScope {
    };


    // $ANTLR start "questionType"
    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:53:1: questionType : ( BooleanType | IntType | StringType );
    public final QLParser.questionType_return questionType() throws RecognitionException {
        QLParser.questionType_return retval = new QLParser.questionType_return();
        retval.start = input.LT(1);

        int questionType_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return retval; }

            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:54:3: ( BooleanType | IntType | StringType )
            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:
            {
            if ( input.LA(1)==BooleanType||input.LA(1)==IntType||input.LA(1)==StringType ) {
                input.consume();
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 7, questionType_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "questionType"



    // $ANTLR start "primary"
    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:59:1: primary returns [Expr result] : ( Int | Ident | '(' x= orExpr ')' );
    public final Expr primary() throws RecognitionException {
        Expr result = null;

        int primary_StartIndex = input.index();

        Token Int12=null;
        Token Ident13=null;
        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:60:3: ( Int | Ident | '(' x= orExpr ')' )
            int alt2=3;
            switch ( input.LA(1) ) {
            case Int:
                {
                alt2=1;
                }
                break;
            case Ident:
                {
                alt2=2;
                }
                break;
            case 15:
                {
                alt2=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }

            switch (alt2) {
                case 1 :
                    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:60:5: Int
                    {
                    Int12=(Token)match(input,Int,FOLLOW_Int_in_primary348); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Int(Integer.parseInt((Int12!=null?Int12.getText():null))); }

                    }
                    break;
                case 2 :
                    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:61:5: Ident
                    {
                    Ident13=(Token)match(input,Ident,FOLLOW_Ident_in_primary358); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Ident((Ident13!=null?Ident13.getText():null)); }

                    }
                    break;
                case 3 :
                    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:62:5: '(' x= orExpr ')'
                    {
                    match(input,15,FOLLOW_15_in_primary366); if (state.failed) return result;

                    pushFollow(FOLLOW_orExpr_in_primary370);
                    x=orExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,16,FOLLOW_16_in_primary372); if (state.failed) return result;

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
    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:65:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
    public final Expr unExpr() throws RecognitionException {
        Expr result = null;

        int unExpr_StartIndex = input.index();

        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:66:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
            int alt3=4;
            switch ( input.LA(1) ) {
            case 18:
                {
                alt3=1;
                }
                break;
            case 19:
                {
                alt3=2;
                }
                break;
            case 12:
                {
                alt3=3;
                }
                break;
            case Ident:
            case Int:
            case 15:
                {
                alt3=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }

            switch (alt3) {
                case 1 :
                    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:66:8: '+' x= unExpr
                    {
                    match(input,18,FOLLOW_18_in_unExpr397); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr401);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Pos(x); }

                    }
                    break;
                case 2 :
                    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:67:8: '-' x= unExpr
                    {
                    match(input,19,FOLLOW_19_in_unExpr412); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr416);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Neg(x); }

                    }
                    break;
                case 3 :
                    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:68:8: '!' x= unExpr
                    {
                    match(input,12,FOLLOW_12_in_unExpr427); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr431);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Not(x); }

                    }
                    break;
                case 4 :
                    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:69:8: x= primary
                    {
                    pushFollow(FOLLOW_primary_in_unExpr444);
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
    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:72:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
    public final Expr mulExpr() throws RecognitionException {
        Expr result = null;

        int mulExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:73:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:73:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
            {
            pushFollow(FOLLOW_unExpr_in_mulExpr482);
            lhs=unExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:73:45: (op= ( '*' | '/' ) rhs= unExpr )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==17||LA4_0==20) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:73:47: op= ( '*' | '/' ) rhs= unExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( input.LA(1)==17||input.LA(1)==20 ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_unExpr_in_mulExpr502);
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
            	    break loop4;
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
    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:85:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
    public final Expr addExpr() throws RecognitionException {
        Expr result = null;

        int addExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:86:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:86:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
            {
            pushFollow(FOLLOW_mulExpr_in_addExpr543);
            lhs=mulExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:86:46: (op= ( '+' | '-' ) rhs= mulExpr )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0 >= 18 && LA5_0 <= 19)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:86:48: op= ( '+' | '-' ) rhs= mulExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( (input.LA(1) >= 18 && input.LA(1) <= 19) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_mulExpr_in_addExpr561);
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
            	    break loop5;
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
    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:97:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
    public final Expr relExpr() throws RecognitionException {
        Expr result = null;

        int relExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }

            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:98:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:98:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            {
            pushFollow(FOLLOW_addExpr_in_relExpr596);
            lhs=addExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:98:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==13||(LA6_0 >= 22 && LA6_0 <= 26)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:98:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( input.LA(1)==13||(input.LA(1) >= 22 && input.LA(1) <= 26) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_addExpr_in_relExpr620);
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
            	    break loop6;
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
    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:121:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
    public final Expr andExpr() throws RecognitionException {
        Expr result = null;

        int andExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return result; }

            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:122:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:122:9: lhs= relExpr ( '&&' rhs= relExpr )*
            {
            pushFollow(FOLLOW_relExpr_in_andExpr658);
            lhs=relExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:122:46: ( '&&' rhs= relExpr )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==14) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:122:48: '&&' rhs= relExpr
            	    {
            	    match(input,14,FOLLOW_14_in_andExpr664); if (state.failed) return result;

            	    pushFollow(FOLLOW_relExpr_in_andExpr668);
            	    rhs=relExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { result = new And(result, rhs); }

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
            if ( state.backtracking>0 ) { memoize(input, 13, andExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "andExpr"



    // $ANTLR start "orExpr"
    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:126:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
    public final Expr orExpr() throws RecognitionException {
        Expr result = null;

        int orExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return result; }

            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:127:5: (lhs= andExpr ( '||' rhs= andExpr )* )
            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:127:9: lhs= andExpr ( '||' rhs= andExpr )*
            {
            pushFollow(FOLLOW_andExpr_in_orExpr703);
            lhs=andExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = lhs; }

            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:127:48: ( '||' rhs= andExpr )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==31) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:127:50: '||' rhs= andExpr
            	    {
            	    match(input,31,FOLLOW_31_in_orExpr709); if (state.failed) return result;

            	    pushFollow(FOLLOW_andExpr_in_orExpr713);
            	    rhs=andExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { result = new Or(result, rhs); }

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
            if ( state.backtracking>0 ) { memoize(input, 14, orExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "orExpr"

    // $ANTLR start synpred1_QL
    public final void synpred1_QL_fragment() throws RecognitionException {
        IfElseStatement ie =null;


        // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:26:7: (ie= ifElseStatement )
        // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:26:7: ie= ifElseStatement
        {
        pushFollow(FOLLOW_ifElseStatement_in_synpred1_QL98);
        ie=ifElseStatement();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred1_QL

    // $ANTLR start synpred2_QL
    public final void synpred2_QL_fragment() throws RecognitionException {
        IfStatement i =null;


        // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:27:7: (i= ifStatement )
        // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:27:7: i= ifStatement
        {
        pushFollow(FOLLOW_ifStatement_in_synpred2_QL110);
        i=ifStatement();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred2_QL

    // $ANTLR start synpred3_QL
    public final void synpred3_QL_fragment() throws RecognitionException {
        ComputedQuestion cq =null;


        // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:28:7: (cq= computedQuestion )
        // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:28:7: cq= computedQuestion
        {
        pushFollow(FOLLOW_computedQuestion_in_synpred3_QL123);
        cq=computedQuestion();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred3_QL

    // $ANTLR start synpred4_QL
    public final void synpred4_QL_fragment() throws RecognitionException {
        Question q =null;


        // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:29:7: (q= question )
        // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:29:7: q= question
        {
        pushFollow(FOLLOW_question_in_synpred4_QL136);
        q=question();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred4_QL

    // Delegated rules

    public final boolean synpred2_QL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_QL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_QL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_QL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
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


 

    public static final BitSet FOLLOW_28_in_form51 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_Ident_in_form53 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_form55 = new BitSet(new long[]{0x0000000020000040L});
    public static final BitSet FOLLOW_formItem_in_form61 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_form69 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifElseStatement_in_formItem98 = new BitSet(new long[]{0x0000000020000042L});
    public static final BitSet FOLLOW_ifStatement_in_formItem110 = new BitSet(new long[]{0x0000000020000042L});
    public static final BitSet FOLLOW_computedQuestion_in_formItem123 = new BitSet(new long[]{0x0000000020000042L});
    public static final BitSet FOLLOW_question_in_formItem136 = new BitSet(new long[]{0x0000000020000042L});
    public static final BitSet FOLLOW_29_in_ifElseStatement167 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ifElseStatement169 = new BitSet(new long[]{0x00000000000C90C0L});
    public static final BitSet FOLLOW_orExpr_in_ifElseStatement171 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ifElseStatement173 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ifElseStatement175 = new BitSet(new long[]{0x0000000020000040L});
    public static final BitSet FOLLOW_formItem_in_ifElseStatement179 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ifElseStatement181 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ifElseStatement187 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ifElseStatement189 = new BitSet(new long[]{0x0000000020000040L});
    public static final BitSet FOLLOW_formItem_in_ifElseStatement193 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ifElseStatement195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ifStatement221 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ifStatement223 = new BitSet(new long[]{0x00000000000C90C0L});
    public static final BitSet FOLLOW_orExpr_in_ifStatement225 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ifStatement227 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ifStatement229 = new BitSet(new long[]{0x0000000020000040L});
    public static final BitSet FOLLOW_formItem_in_ifStatement233 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ifStatement235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_computedQuestion260 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_computedQuestion262 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_String_in_computedQuestion264 = new BitSet(new long[]{0x0000000000000510L});
    public static final BitSet FOLLOW_questionType_in_computedQuestion266 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_computedQuestion268 = new BitSet(new long[]{0x00000000000C90C0L});
    public static final BitSet FOLLOW_orExpr_in_computedQuestion270 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_computedQuestion272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_question298 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_question300 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_String_in_question302 = new BitSet(new long[]{0x0000000000000510L});
    public static final BitSet FOLLOW_questionType_in_question304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Int_in_primary348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_primary358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_primary366 = new BitSet(new long[]{0x00000000000C90C0L});
    public static final BitSet FOLLOW_orExpr_in_primary370 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_primary372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_unExpr397 = new BitSet(new long[]{0x00000000000C90C0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_unExpr412 = new BitSet(new long[]{0x00000000000C90C0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_unExpr427 = new BitSet(new long[]{0x00000000000C90C0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_unExpr444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr482 = new BitSet(new long[]{0x0000000000120002L});
    public static final BitSet FOLLOW_set_in_mulExpr490 = new BitSet(new long[]{0x00000000000C90C0L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr502 = new BitSet(new long[]{0x0000000000120002L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr543 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_set_in_addExpr551 = new BitSet(new long[]{0x00000000000C90C0L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr561 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_addExpr_in_relExpr596 = new BitSet(new long[]{0x0000000007C02002L});
    public static final BitSet FOLLOW_set_in_relExpr604 = new BitSet(new long[]{0x00000000000C90C0L});
    public static final BitSet FOLLOW_addExpr_in_relExpr620 = new BitSet(new long[]{0x0000000007C02002L});
    public static final BitSet FOLLOW_relExpr_in_andExpr658 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_andExpr664 = new BitSet(new long[]{0x00000000000C90C0L});
    public static final BitSet FOLLOW_relExpr_in_andExpr668 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_andExpr_in_orExpr703 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_orExpr709 = new BitSet(new long[]{0x00000000000C90C0L});
    public static final BitSet FOLLOW_andExpr_in_orExpr713 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_ifElseStatement_in_synpred1_QL98 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStatement_in_synpred2_QL110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_computedQuestion_in_synpred3_QL123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_question_in_synpred4_QL136 = new BitSet(new long[]{0x0000000000000002L});

}