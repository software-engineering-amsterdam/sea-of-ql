// $ANTLR 3.4 C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g 2013-01-21 13:30:00

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expressions.*;
import org.uva.sea.ql.ast.values.*;
import org.uva.sea.ql.ast.types.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class QLParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Bool", "COMMENT", "Ident", "Int", "String", "WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", "'/'", "':'", "'<'", "'<='", "'='", "'=='", "'>'", "'>='", "'boolean'", "'integer'", "'string'", "'||'"
    };

    public static final int EOF=-1;
    public static final int T__10=10;
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
    public static final int Bool=4;
    public static final int COMMENT=5;
    public static final int Ident=6;
    public static final int Int=7;
    public static final int String=8;
    public static final int WS=9;

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
        this.state.ruleMemo = new HashMap[33+1];
         

    }

    public String[] getTokenNames() { return QLParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g"; }



    // $ANTLR start "form"
    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:18:1: form : ( primary )+ ;
    public final void form() throws RecognitionException {
        int form_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return ; }

            // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:18:5: ( ( primary )+ )
            // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:18:7: ( primary )+
            {
            // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:18:7: ( primary )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==Bool||(LA1_0 >= Ident && LA1_0 <= String)||LA1_0==13) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:18:7: primary
            	    {
            	    pushFollow(FOLLOW_primary_in_form39);
            	    primary();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


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



    // $ANTLR start "question"
    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:20:1: question returns [Question result] : String Ident ':' t= type ;
    public final Question question() throws RecognitionException {
        Question result = null;

        int question_StartIndex = input.index();

        Token String1=null;
        Token Ident2=null;
        Type t =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

            // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:21:5: ( String Ident ':' t= type )
            // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:21:9: String Ident ':' t= type
            {
            String1=(Token)match(input,String,FOLLOW_String_in_question58); if (state.failed) return result;

            Ident2=(Token)match(input,Ident,FOLLOW_Ident_in_question60); if (state.failed) return result;

            match(input,19,FOLLOW_19_in_question62); if (state.failed) return result;

            pushFollow(FOLLOW_type_in_question66);
            t=type();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new Question(new org.uva.sea.ql.ast.values.Str((String1!=null?String1.getText():null)), new Ident((Ident2!=null?Ident2.getText():null)), t); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 2, question_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "question"



    // $ANTLR start "computedQuestion"
    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:24:1: computedQuestion returns [ComputedQuestion result] : String Ident '=' e= orExpr ;
    public final ComputedQuestion computedQuestion() throws RecognitionException {
        ComputedQuestion result = null;

        int computedQuestion_StartIndex = input.index();

        Token String3=null;
        Token Ident4=null;
        Expr e =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

            // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:25:5: ( String Ident '=' e= orExpr )
            // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:25:9: String Ident '=' e= orExpr
            {
            String3=(Token)match(input,String,FOLLOW_String_in_computedQuestion93); if (state.failed) return result;

            Ident4=(Token)match(input,Ident,FOLLOW_Ident_in_computedQuestion95); if (state.failed) return result;

            match(input,22,FOLLOW_22_in_computedQuestion97); if (state.failed) return result;

            pushFollow(FOLLOW_orExpr_in_computedQuestion101);
            e=orExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new ComputedQuestion(new org.uva.sea.ql.ast.values.Str((String3!=null?String3.getText():null)), new Ident((Ident4!=null?Ident4.getText():null)), e); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 3, computedQuestion_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "computedQuestion"



    // $ANTLR start "primary"
    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:28:1: primary returns [Expr result] : ( Int | Bool | String | Ident | '(' x= orExpr ')' );
    public final Expr primary() throws RecognitionException {
        Expr result = null;

        int primary_StartIndex = input.index();

        Token Int5=null;
        Token Bool6=null;
        Token String7=null;
        Token Ident8=null;
        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

            // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:29:5: ( Int | Bool | String | Ident | '(' x= orExpr ')' )
            int alt2=5;
            switch ( input.LA(1) ) {
            case Int:
                {
                alt2=1;
                }
                break;
            case Bool:
                {
                alt2=2;
                }
                break;
            case String:
                {
                alt2=3;
                }
                break;
            case Ident:
                {
                alt2=4;
                }
                break;
            case 13:
                {
                alt2=5;
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
                    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:29:9: Int
                    {
                    Int5=(Token)match(input,Int,FOLLOW_Int_in_primary126); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.values.Int(Integer.parseInt((Int5!=null?Int5.getText():null))); }

                    }
                    break;
                case 2 :
                    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:30:9: Bool
                    {
                    Bool6=(Token)match(input,Bool,FOLLOW_Bool_in_primary141); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.values.Bool(Boolean.parseBoolean((Bool6!=null?Bool6.getText():null))); }

                    }
                    break;
                case 3 :
                    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:31:9: String
                    {
                    String7=(Token)match(input,String,FOLLOW_String_in_primary155); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.values.Str((String7!=null?String7.getText():null)); }

                    }
                    break;
                case 4 :
                    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:32:9: Ident
                    {
                    Ident8=(Token)match(input,Ident,FOLLOW_Ident_in_primary167); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Ident((Ident8!=null?Ident8.getText():null)); }

                    }
                    break;
                case 5 :
                    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:33:9: '(' x= orExpr ')'
                    {
                    match(input,13,FOLLOW_13_in_primary180); if (state.failed) return result;

                    pushFollow(FOLLOW_orExpr_in_primary184);
                    x=orExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,14,FOLLOW_14_in_primary186); if (state.failed) return result;

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
            if ( state.backtracking>0 ) { memoize(input, 4, primary_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "primary"



    // $ANTLR start "unExpr"
    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:36:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
    public final Expr unExpr() throws RecognitionException {
        Expr result = null;

        int unExpr_StartIndex = input.index();

        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

            // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:37:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
            int alt3=4;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt3=1;
                }
                break;
            case 17:
                {
                alt3=2;
                }
                break;
            case 10:
                {
                alt3=3;
                }
                break;
            case Bool:
            case Ident:
            case Int:
            case String:
            case 13:
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
                    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:37:9: '+' x= unExpr
                    {
                    match(input,16,FOLLOW_16_in_unExpr214); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr218);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Pos(x); }

                    }
                    break;
                case 2 :
                    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:38:9: '-' x= unExpr
                    {
                    match(input,17,FOLLOW_17_in_unExpr230); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr234);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Neg(x); }

                    }
                    break;
                case 3 :
                    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:39:9: '!' x= unExpr
                    {
                    match(input,10,FOLLOW_10_in_unExpr246); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr250);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Not(x); }

                    }
                    break;
                case 4 :
                    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:40:9: x= primary
                    {
                    pushFollow(FOLLOW_primary_in_unExpr264);
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
            if ( state.backtracking>0 ) { memoize(input, 5, unExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "unExpr"



    // $ANTLR start "mulExpr"
    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:43:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
    public final Expr mulExpr() throws RecognitionException {
        Expr result = null;

        int mulExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

            // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:44:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
            // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:44:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
            {
            pushFollow(FOLLOW_unExpr_in_mulExpr302);
            lhs=unExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:44:45: (op= ( '*' | '/' ) rhs= unExpr )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==15||LA4_0==18) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:44:47: op= ( '*' | '/' ) rhs= unExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( input.LA(1)==15||input.LA(1)==18 ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_unExpr_in_mulExpr322);
            	    rhs=unExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { 
            	            if ((op!=null?op.getText():null).equals("*"))  { result = new Mul(result, rhs); }
            	            if ((op!=null?op.getText():null).equals("<=")) { result = new Div(result, rhs); }
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
            if ( state.backtracking>0 ) { memoize(input, 6, mulExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "mulExpr"



    // $ANTLR start "addExpr"
    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:52:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
    public final Expr addExpr() throws RecognitionException {
        Expr result = null;

        int addExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

            // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:53:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
            // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:53:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
            {
            pushFollow(FOLLOW_mulExpr_in_addExpr363);
            lhs=mulExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:53:46: (op= ( '+' | '-' ) rhs= mulExpr )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0 >= 16 && LA5_0 <= 17)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:53:48: op= ( '+' | '-' ) rhs= mulExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( (input.LA(1) >= 16 && input.LA(1) <= 17) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_mulExpr_in_addExpr381);
            	    rhs=mulExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { 
            	            if ((op!=null?op.getText():null).equals("+")) { result = new Add(result, rhs); }
            	            if ((op!=null?op.getText():null).equals("-")) { result = new Sub(result, rhs); }
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
            if ( state.backtracking>0 ) { memoize(input, 7, addExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "addExpr"



    // $ANTLR start "relExpr"
    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:60:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
    public final Expr relExpr() throws RecognitionException {
        Expr result = null;

        int relExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

            // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:61:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
            // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:61:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            {
            pushFollow(FOLLOW_addExpr_in_relExpr416);
            lhs=addExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:61:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==11||(LA6_0 >= 20 && LA6_0 <= 21)||(LA6_0 >= 23 && LA6_0 <= 25)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:61:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( input.LA(1)==11||(input.LA(1) >= 20 && input.LA(1) <= 21)||(input.LA(1) >= 23 && input.LA(1) <= 25) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_addExpr_in_relExpr440);
            	    rhs=addExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { 
            	            if ((op!=null?op.getText():null).equals("<"))  { result = new LT(result, rhs);  }
            	            if ((op!=null?op.getText():null).equals("<=")) { result = new LEq(result, rhs); }
            	            if ((op!=null?op.getText():null).equals(">"))  { result = new GT(result, rhs);  }
            	            if ((op!=null?op.getText():null).equals(">=")) { result = new GEq(result, rhs); }
            	            if ((op!=null?op.getText():null).equals("==")) { result = new Eq(result, rhs);  }
            	            if ((op!=null?op.getText():null).equals("!=")) { result = new NEq(result, rhs); }
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
            if ( state.backtracking>0 ) { memoize(input, 8, relExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "relExpr"



    // $ANTLR start "andExpr"
    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:72:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
    public final Expr andExpr() throws RecognitionException {
        Expr result = null;

        int andExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

            // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:73:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
            // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:73:9: lhs= relExpr ( '&&' rhs= relExpr )*
            {
            pushFollow(FOLLOW_relExpr_in_andExpr478);
            lhs=relExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:73:46: ( '&&' rhs= relExpr )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==12) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:73:48: '&&' rhs= relExpr
            	    {
            	    match(input,12,FOLLOW_12_in_andExpr484); if (state.failed) return result;

            	    pushFollow(FOLLOW_relExpr_in_andExpr488);
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
            if ( state.backtracking>0 ) { memoize(input, 9, andExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "andExpr"



    // $ANTLR start "orExpr"
    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:77:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
    public final Expr orExpr() throws RecognitionException {
        Expr result = null;

        int orExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

            // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:78:5: (lhs= andExpr ( '||' rhs= andExpr )* )
            // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:78:9: lhs= andExpr ( '||' rhs= andExpr )*
            {
            pushFollow(FOLLOW_andExpr_in_orExpr523);
            lhs=andExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = lhs; }

            // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:78:48: ( '||' rhs= andExpr )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==29) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:78:50: '||' rhs= andExpr
            	    {
            	    match(input,29,FOLLOW_29_in_orExpr529); if (state.failed) return result;

            	    pushFollow(FOLLOW_andExpr_in_orExpr533);
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
            if ( state.backtracking>0 ) { memoize(input, 10, orExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "orExpr"



    // $ANTLR start "type"
    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:81:1: type returns [Type result] : ( 'integer' | 'string' | 'boolean' );
    public final Type type() throws RecognitionException {
        Type result = null;

        int type_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

            // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:82:5: ( 'integer' | 'string' | 'boolean' )
            int alt9=3;
            switch ( input.LA(1) ) {
            case 27:
                {
                alt9=1;
                }
                break;
            case 28:
                {
                alt9=2;
                }
                break;
            case 26:
                {
                alt9=3;
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
                    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:82:9: 'integer'
                    {
                    match(input,27,FOLLOW_27_in_type561); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.types.Int();    }

                    }
                    break;
                case 2 :
                    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:83:9: 'string'
                    {
                    match(input,28,FOLLOW_28_in_type573); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.types.Str(); }

                    }
                    break;
                case 3 :
                    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:84:9: 'boolean'
                    {
                    match(input,26,FOLLOW_26_in_type586); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.types.Bool();   }

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
            if ( state.backtracking>0 ) { memoize(input, 11, type_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "type"

    // Delegated rules


 

    public static final BitSet FOLLOW_primary_in_form39 = new BitSet(new long[]{0x00000000000021D2L});
    public static final BitSet FOLLOW_String_in_question58 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_Ident_in_question60 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_question62 = new BitSet(new long[]{0x000000001C000000L});
    public static final BitSet FOLLOW_type_in_question66 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_String_in_computedQuestion93 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_Ident_in_computedQuestion95 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_computedQuestion97 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_orExpr_in_computedQuestion101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Int_in_primary126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Bool_in_primary141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_String_in_primary155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_primary167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_primary180 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_orExpr_in_primary184 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_primary186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_unExpr214 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_unExpr230 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_unExpr246 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_unExpr264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr302 = new BitSet(new long[]{0x0000000000048002L});
    public static final BitSet FOLLOW_set_in_mulExpr310 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr322 = new BitSet(new long[]{0x0000000000048002L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr363 = new BitSet(new long[]{0x0000000000030002L});
    public static final BitSet FOLLOW_set_in_addExpr371 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr381 = new BitSet(new long[]{0x0000000000030002L});
    public static final BitSet FOLLOW_addExpr_in_relExpr416 = new BitSet(new long[]{0x0000000003B00802L});
    public static final BitSet FOLLOW_set_in_relExpr424 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_addExpr_in_relExpr440 = new BitSet(new long[]{0x0000000003B00802L});
    public static final BitSet FOLLOW_relExpr_in_andExpr478 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_12_in_andExpr484 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_relExpr_in_andExpr488 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_andExpr_in_orExpr523 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_orExpr529 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_andExpr_in_orExpr533 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_27_in_type561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_type573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_type586 = new BitSet(new long[]{0x0000000000000002L});

}