// $ANTLR 3.4 /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g 2013-01-17 11:19:58

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Boolean", "COMMENT", "Ident", "Int", "Money", "String", "WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", "'/'", "':'", "'<'", "'<='", "'=='", "'>'", "'>='", "'form'", "'if'", "'{'", "'||'", "'}'"
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
    public static final int Boolean=4;
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
        this.state.ruleMemo = new HashMap[32+1];
         

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
            match(input,26,FOLLOW_26_in_form51); if (state.failed) return result;

            Ident2=(Token)match(input,Ident,FOLLOW_Ident_in_form53); if (state.failed) return result;

            match(input,28,FOLLOW_28_in_form55); if (state.failed) return result;

            pushFollow(FOLLOW_formItem_in_form61);
            formItem1=formItem();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) {formItems.addAll(formItem1);}

            match(input,30,FOLLOW_30_in_form69); if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new Form((Ident2!=null?Ident2.getText():null),formItems); }

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
    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:24:1: formItem returns [List<FormItem> result] : (i= ifStatement |q= question )+ ;
    public final List<FormItem> formItem() throws RecognitionException {
        List<FormItem> result = null;

        int formItem_StartIndex = input.index();

        IfStatement i =null;

        Question q =null;


         List<FormItem> formItems = new ArrayList(); 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:26:3: ( (i= ifStatement |q= question )+ )
            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:26:5: (i= ifStatement |q= question )+
            {
            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:26:5: (i= ifStatement |q= question )+
            int cnt1=0;
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==27) ) {
                    alt1=1;
                }
                else if ( (LA1_0==Ident) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:26:6: i= ifStatement
            	    {
            	    pushFollow(FOLLOW_ifStatement_in_formItem97);
            	    i=ifStatement();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { formItems.add(i); }

            	    }
            	    break;
            	case 2 :
            	    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:26:52: q= question
            	    {
            	    pushFollow(FOLLOW_question_in_formItem105);
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



    // $ANTLR start "ifStatement"
    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:29:1: ifStatement returns [IfStatement result] : 'if' '(' Ident ')' '{' formItem '}' ;
    public final IfStatement ifStatement() throws RecognitionException {
        IfStatement result = null;

        int ifStatement_StartIndex = input.index();

        Token Ident3=null;
        List<FormItem> formItem4 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:30:3: ( 'if' '(' Ident ')' '{' formItem '}' )
            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:30:5: 'if' '(' Ident ')' '{' formItem '}'
            {
            match(input,27,FOLLOW_27_in_ifStatement129); if (state.failed) return result;

            match(input,14,FOLLOW_14_in_ifStatement131); if (state.failed) return result;

            Ident3=(Token)match(input,Ident,FOLLOW_Ident_in_ifStatement133); if (state.failed) return result;

            match(input,15,FOLLOW_15_in_ifStatement135); if (state.failed) return result;

            match(input,28,FOLLOW_28_in_ifStatement137); if (state.failed) return result;

            pushFollow(FOLLOW_formItem_in_ifStatement139);
            formItem4=formItem();

            state._fsp--;
            if (state.failed) return result;

            match(input,30,FOLLOW_30_in_ifStatement141); if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new IfStatement((Ident3!=null?Ident3.getText():null),formItem4); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 3, ifStatement_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "ifStatement"



    // $ANTLR start "question"
    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:33:1: question returns [Question result] : Ident ':' String questionType ;
    public final Question question() throws RecognitionException {
        Question result = null;

        int question_StartIndex = input.index();

        Token Ident5=null;
        Token String6=null;
        QLParser.questionType_return questionType7 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:34:3: ( Ident ':' String questionType )
            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:34:5: Ident ':' String questionType
            {
            Ident5=(Token)match(input,Ident,FOLLOW_Ident_in_question160); if (state.failed) return result;

            match(input,20,FOLLOW_20_in_question162); if (state.failed) return result;

            String6=(Token)match(input,String,FOLLOW_String_in_question164); if (state.failed) return result;

            pushFollow(FOLLOW_questionType_in_question166);
            questionType7=questionType();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) {result = new Question((Ident5!=null?Ident5.getText():null), (String6!=null?String6.getText():null), (questionType7!=null?input.toString(questionType7.start,questionType7.stop):null));}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 4, question_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "question"


    public static class questionType_return extends ParserRuleReturnScope {
    };


    // $ANTLR start "questionType"
    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:37:1: questionType : ( Boolean | Money );
    public final QLParser.questionType_return questionType() throws RecognitionException {
        QLParser.questionType_return retval = new QLParser.questionType_return();
        retval.start = input.LT(1);

        int questionType_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return retval; }

            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:38:3: ( Boolean | Money )
            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:
            {
            if ( input.LA(1)==Boolean||input.LA(1)==Money ) {
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
            if ( state.backtracking>0 ) { memoize(input, 5, questionType_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "questionType"



    // $ANTLR start "primary"
    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:42:1: primary returns [Expr result] : ( Int | Ident | '(' x= orExpr ')' );
    public final Expr primary() throws RecognitionException {
        Expr result = null;

        int primary_StartIndex = input.index();

        Token Int8=null;
        Token Ident9=null;
        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:43:3: ( Int | Ident | '(' x= orExpr ')' )
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
            case 14:
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
                    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:43:5: Int
                    {
                    Int8=(Token)match(input,Int,FOLLOW_Int_in_primary204); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Int(Integer.parseInt((Int8!=null?Int8.getText():null))); }

                    }
                    break;
                case 2 :
                    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:44:5: Ident
                    {
                    Ident9=(Token)match(input,Ident,FOLLOW_Ident_in_primary214); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Ident((Ident9!=null?Ident9.getText():null)); }

                    }
                    break;
                case 3 :
                    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:45:5: '(' x= orExpr ')'
                    {
                    match(input,14,FOLLOW_14_in_primary222); if (state.failed) return result;

                    pushFollow(FOLLOW_orExpr_in_primary226);
                    x=orExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,15,FOLLOW_15_in_primary228); if (state.failed) return result;

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
            if ( state.backtracking>0 ) { memoize(input, 6, primary_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "primary"



    // $ANTLR start "unExpr"
    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:48:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
    public final Expr unExpr() throws RecognitionException {
        Expr result = null;

        int unExpr_StartIndex = input.index();

        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:49:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
            int alt3=4;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt3=1;
                }
                break;
            case 18:
                {
                alt3=2;
                }
                break;
            case 11:
                {
                alt3=3;
                }
                break;
            case Ident:
            case Int:
            case 14:
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
                    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:49:8: '+' x= unExpr
                    {
                    match(input,17,FOLLOW_17_in_unExpr253); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr257);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Pos(x); }

                    }
                    break;
                case 2 :
                    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:50:8: '-' x= unExpr
                    {
                    match(input,18,FOLLOW_18_in_unExpr268); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr272);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Neg(x); }

                    }
                    break;
                case 3 :
                    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:51:8: '!' x= unExpr
                    {
                    match(input,11,FOLLOW_11_in_unExpr283); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr287);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Not(x); }

                    }
                    break;
                case 4 :
                    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:52:8: x= primary
                    {
                    pushFollow(FOLLOW_primary_in_unExpr300);
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
            if ( state.backtracking>0 ) { memoize(input, 7, unExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "unExpr"



    // $ANTLR start "mulExpr"
    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:55:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
    public final Expr mulExpr() throws RecognitionException {
        Expr result = null;

        int mulExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:56:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:56:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
            {
            pushFollow(FOLLOW_unExpr_in_mulExpr338);
            lhs=unExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:56:45: (op= ( '*' | '/' ) rhs= unExpr )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==16||LA4_0==19) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:56:47: op= ( '*' | '/' ) rhs= unExpr
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


            	    pushFollow(FOLLOW_unExpr_in_mulExpr358);
            	    rhs=unExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { 
            	          if ((op!=null?op.getText():null).equals("*")) {
            	            result = new Mul(result, rhs);
            	          }
            	          if ((op!=null?op.getText():null).equals("<=")) {
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
            if ( state.backtracking>0 ) { memoize(input, 8, mulExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "mulExpr"



    // $ANTLR start "addExpr"
    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:68:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
    public final Expr addExpr() throws RecognitionException {
        Expr result = null;

        int addExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:69:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:69:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
            {
            pushFollow(FOLLOW_mulExpr_in_addExpr399);
            lhs=mulExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:69:46: (op= ( '+' | '-' ) rhs= mulExpr )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0 >= 17 && LA5_0 <= 18)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:69:48: op= ( '+' | '-' ) rhs= mulExpr
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


            	    pushFollow(FOLLOW_mulExpr_in_addExpr417);
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
            if ( state.backtracking>0 ) { memoize(input, 9, addExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "addExpr"



    // $ANTLR start "relExpr"
    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:80:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
    public final Expr relExpr() throws RecognitionException {
        Expr result = null;

        int relExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:81:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:81:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            {
            pushFollow(FOLLOW_addExpr_in_relExpr452);
            lhs=addExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:81:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==12||(LA6_0 >= 21 && LA6_0 <= 25)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:81:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( input.LA(1)==12||(input.LA(1) >= 21 && input.LA(1) <= 25) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_addExpr_in_relExpr476);
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
            if ( state.backtracking>0 ) { memoize(input, 10, relExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "relExpr"



    // $ANTLR start "andExpr"
    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:104:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
    public final Expr andExpr() throws RecognitionException {
        Expr result = null;

        int andExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:105:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:105:9: lhs= relExpr ( '&&' rhs= relExpr )*
            {
            pushFollow(FOLLOW_relExpr_in_andExpr514);
            lhs=relExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:105:46: ( '&&' rhs= relExpr )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==13) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:105:48: '&&' rhs= relExpr
            	    {
            	    match(input,13,FOLLOW_13_in_andExpr520); if (state.failed) return result;

            	    pushFollow(FOLLOW_relExpr_in_andExpr524);
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
            if ( state.backtracking>0 ) { memoize(input, 11, andExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "andExpr"



    // $ANTLR start "orExpr"
    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:109:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
    public final Expr orExpr() throws RecognitionException {
        Expr result = null;

        int orExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }

            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:110:5: (lhs= andExpr ( '||' rhs= andExpr )* )
            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:110:9: lhs= andExpr ( '||' rhs= andExpr )*
            {
            pushFollow(FOLLOW_andExpr_in_orExpr559);
            lhs=andExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = lhs; }

            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:110:48: ( '||' rhs= andExpr )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==29) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:110:50: '||' rhs= andExpr
            	    {
            	    match(input,29,FOLLOW_29_in_orExpr565); if (state.failed) return result;

            	    pushFollow(FOLLOW_andExpr_in_orExpr569);
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
            if ( state.backtracking>0 ) { memoize(input, 12, orExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "orExpr"

    // Delegated rules


 

    public static final BitSet FOLLOW_26_in_form51 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_Ident_in_form53 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_form55 = new BitSet(new long[]{0x0000000008000040L});
    public static final BitSet FOLLOW_formItem_in_form61 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_form69 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStatement_in_formItem97 = new BitSet(new long[]{0x0000000008000042L});
    public static final BitSet FOLLOW_question_in_formItem105 = new BitSet(new long[]{0x0000000008000042L});
    public static final BitSet FOLLOW_27_in_ifStatement129 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ifStatement131 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_Ident_in_ifStatement133 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ifStatement135 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ifStatement137 = new BitSet(new long[]{0x0000000008000040L});
    public static final BitSet FOLLOW_formItem_in_ifStatement139 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ifStatement141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_question160 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_question162 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_String_in_question164 = new BitSet(new long[]{0x0000000000000110L});
    public static final BitSet FOLLOW_questionType_in_question166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Int_in_primary204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_primary214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_primary222 = new BitSet(new long[]{0x00000000000648C0L});
    public static final BitSet FOLLOW_orExpr_in_primary226 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_primary228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_unExpr253 = new BitSet(new long[]{0x00000000000648C0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_unExpr268 = new BitSet(new long[]{0x00000000000648C0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_unExpr283 = new BitSet(new long[]{0x00000000000648C0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_unExpr300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr338 = new BitSet(new long[]{0x0000000000090002L});
    public static final BitSet FOLLOW_set_in_mulExpr346 = new BitSet(new long[]{0x00000000000648C0L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr358 = new BitSet(new long[]{0x0000000000090002L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr399 = new BitSet(new long[]{0x0000000000060002L});
    public static final BitSet FOLLOW_set_in_addExpr407 = new BitSet(new long[]{0x00000000000648C0L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr417 = new BitSet(new long[]{0x0000000000060002L});
    public static final BitSet FOLLOW_addExpr_in_relExpr452 = new BitSet(new long[]{0x0000000003E01002L});
    public static final BitSet FOLLOW_set_in_relExpr460 = new BitSet(new long[]{0x00000000000648C0L});
    public static final BitSet FOLLOW_addExpr_in_relExpr476 = new BitSet(new long[]{0x0000000003E01002L});
    public static final BitSet FOLLOW_relExpr_in_andExpr514 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_andExpr520 = new BitSet(new long[]{0x00000000000648C0L});
    public static final BitSet FOLLOW_relExpr_in_andExpr524 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_andExpr_in_orExpr559 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_orExpr565 = new BitSet(new long[]{0x00000000000648C0L});
    public static final BitSet FOLLOW_andExpr_in_orExpr569 = new BitSet(new long[]{0x0000000020000002L});

}