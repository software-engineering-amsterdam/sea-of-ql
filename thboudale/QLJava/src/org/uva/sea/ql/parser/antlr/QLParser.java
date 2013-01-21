// $ANTLR 3.4 C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g 2013-01-21 01:25:30

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expressions.*;
import org.uva.sea.ql.ast.expressions.binaryExpr.*;
import org.uva.sea.ql.ast.expressions.unaryExpr.*;
import org.uva.sea.ql.ast.statements.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class QLParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "BOOLEAN", "COMMENT", "IDENT", "INT", "STRING_LITERAL", "TYPE", "WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", "'/'", "':'", "'<'", "'<='", "'=='", "'>'", "'>='", "'||'"
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
    public static final int BOOLEAN=4;
    public static final int COMMENT=5;
    public static final int IDENT=6;
    public static final int INT=7;
    public static final int STRING_LITERAL=8;
    public static final int TYPE=9;
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
        this.state.ruleMemo = new HashMap[27+1];
         

    }

    public String[] getTokenNames() { return QLParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g"; }



    // $ANTLR start "computedQuestion"
    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:30:1: computedQuestion returns [ComputedQuestion result] : IDENT ':' STRING_LITERAL TYPE '(' x= orExpr ')' ;
    public final ComputedQuestion computedQuestion() throws RecognitionException {
        ComputedQuestion result = null;

        int computedQuestion_StartIndex = input.index();

        Token IDENT1=null;
        Token STRING_LITERAL2=null;
        Token TYPE3=null;
        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:31:2: ( IDENT ':' STRING_LITERAL TYPE '(' x= orExpr ')' )
            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:31:4: IDENT ':' STRING_LITERAL TYPE '(' x= orExpr ')'
            {
            IDENT1=(Token)match(input,IDENT,FOLLOW_IDENT_in_computedQuestion47); if (state.failed) return result;

            match(input,20,FOLLOW_20_in_computedQuestion49); if (state.failed) return result;

            STRING_LITERAL2=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_computedQuestion51); if (state.failed) return result;

            TYPE3=(Token)match(input,TYPE,FOLLOW_TYPE_in_computedQuestion53); if (state.failed) return result;

            match(input,14,FOLLOW_14_in_computedQuestion55); if (state.failed) return result;

            pushFollow(FOLLOW_orExpr_in_computedQuestion59);
            x=orExpr();

            state._fsp--;
            if (state.failed) return result;

            match(input,15,FOLLOW_15_in_computedQuestion61); if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new ComputedQuestion(new Ident((IDENT1!=null?IDENT1.getText():null)), (STRING_LITERAL2!=null?STRING_LITERAL2.getText():null), (TYPE3!=null?TYPE3.getText():null), x); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 1, computedQuestion_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "computedQuestion"



    // $ANTLR start "question"
    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:35:1: question returns [Question result] : IDENT ':' STRING_LITERAL TYPE ;
    public final Question question() throws RecognitionException {
        Question result = null;

        int question_StartIndex = input.index();

        Token IDENT4=null;
        Token STRING_LITERAL5=null;
        Token TYPE6=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:36:5: ( IDENT ':' STRING_LITERAL TYPE )
            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:36:7: IDENT ':' STRING_LITERAL TYPE
            {
            IDENT4=(Token)match(input,IDENT,FOLLOW_IDENT_in_question82); if (state.failed) return result;

            match(input,20,FOLLOW_20_in_question84); if (state.failed) return result;

            STRING_LITERAL5=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_question86); if (state.failed) return result;

            TYPE6=(Token)match(input,TYPE,FOLLOW_TYPE_in_question88); if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new Question(new Ident((IDENT4!=null?IDENT4.getText():null)), (STRING_LITERAL5!=null?STRING_LITERAL5.getText():null), (TYPE6!=null?TYPE6.getText():null)); }

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



    // $ANTLR start "primary"
    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:40:1: primary returns [Expr result] : ( INT | IDENT | BOOLEAN | '(' x= orExpr ')' );
    public final Expr primary() throws RecognitionException {
        Expr result = null;

        int primary_StartIndex = input.index();

        Token INT7=null;
        Token IDENT8=null;
        Token BOOLEAN9=null;
        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:41:5: ( INT | IDENT | BOOLEAN | '(' x= orExpr ')' )
            int alt1=4;
            switch ( input.LA(1) ) {
            case INT:
                {
                alt1=1;
                }
                break;
            case IDENT:
                {
                alt1=2;
                }
                break;
            case BOOLEAN:
                {
                alt1=3;
                }
                break;
            case 14:
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
                    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:41:7: INT
                    {
                    INT7=(Token)match(input,INT,FOLLOW_INT_in_primary115); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Int(Integer.parseInt((INT7!=null?INT7.getText():null))); }

                    }
                    break;
                case 2 :
                    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:42:6: IDENT
                    {
                    IDENT8=(Token)match(input,IDENT,FOLLOW_IDENT_in_primary126); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Ident((IDENT8!=null?IDENT8.getText():null)); }

                    }
                    break;
                case 3 :
                    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:43:6: BOOLEAN
                    {
                    BOOLEAN9=(Token)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_primary135); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Bool(Boolean.parseBoolean((BOOLEAN9!=null?BOOLEAN9.getText():null))); }

                    }
                    break;
                case 4 :
                    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:44:6: '(' x= orExpr ')'
                    {
                    match(input,14,FOLLOW_14_in_primary144); if (state.failed) return result;

                    pushFollow(FOLLOW_orExpr_in_primary148);
                    x=orExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,15,FOLLOW_15_in_primary150); if (state.failed) return result;

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
            if ( state.backtracking>0 ) { memoize(input, 3, primary_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "primary"



    // $ANTLR start "unExpr"
    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:47:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
    public final Expr unExpr() throws RecognitionException {
        Expr result = null;

        int unExpr_StartIndex = input.index();

        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:48:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
            int alt2=4;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt2=1;
                }
                break;
            case 18:
                {
                alt2=2;
                }
                break;
            case 11:
                {
                alt2=3;
                }
                break;
            case BOOLEAN:
            case IDENT:
            case INT:
            case 14:
                {
                alt2=4;
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
                    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:48:8: '+' x= unExpr
                    {
                    match(input,17,FOLLOW_17_in_unExpr176); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr180);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Pos(x); }

                    }
                    break;
                case 2 :
                    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:49:8: '-' x= unExpr
                    {
                    match(input,18,FOLLOW_18_in_unExpr191); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr195);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Neg(x); }

                    }
                    break;
                case 3 :
                    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:50:8: '!' x= unExpr
                    {
                    match(input,11,FOLLOW_11_in_unExpr206); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr210);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Not(x); }

                    }
                    break;
                case 4 :
                    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:51:8: x= primary
                    {
                    pushFollow(FOLLOW_primary_in_unExpr223);
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
            if ( state.backtracking>0 ) { memoize(input, 4, unExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "unExpr"



    // $ANTLR start "mulExpr"
    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:54:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
    public final Expr mulExpr() throws RecognitionException {
        Expr result = null;

        int mulExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:55:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:55:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
            {
            pushFollow(FOLLOW_unExpr_in_mulExpr261);
            lhs=unExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:55:45: (op= ( '*' | '/' ) rhs= unExpr )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==16||LA3_0==19) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:55:47: op= ( '*' | '/' ) rhs= unExpr
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


            	    pushFollow(FOLLOW_unExpr_in_mulExpr281);
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
            	    break loop3;
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
            if ( state.backtracking>0 ) { memoize(input, 5, mulExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "mulExpr"



    // $ANTLR start "addExpr"
    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:67:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
    public final Expr addExpr() throws RecognitionException {
        Expr result = null;

        int addExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:68:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:68:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
            {
            pushFollow(FOLLOW_mulExpr_in_addExpr322);
            lhs=mulExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:68:46: (op= ( '+' | '-' ) rhs= mulExpr )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= 17 && LA4_0 <= 18)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:68:48: op= ( '+' | '-' ) rhs= mulExpr
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


            	    pushFollow(FOLLOW_mulExpr_in_addExpr340);
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
            if ( state.backtracking>0 ) { memoize(input, 6, addExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "addExpr"



    // $ANTLR start "relExpr"
    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:79:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
    public final Expr relExpr() throws RecognitionException {
        Expr result = null;

        int relExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:80:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:80:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            {
            pushFollow(FOLLOW_addExpr_in_relExpr375);
            lhs=addExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:80:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==12||(LA5_0 >= 21 && LA5_0 <= 25)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:80:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
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


            	    pushFollow(FOLLOW_addExpr_in_relExpr399);
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
            if ( state.backtracking>0 ) { memoize(input, 7, relExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "relExpr"



    // $ANTLR start "andExpr"
    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:103:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
    public final Expr andExpr() throws RecognitionException {
        Expr result = null;

        int andExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:104:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:104:9: lhs= relExpr ( '&&' rhs= relExpr )*
            {
            pushFollow(FOLLOW_relExpr_in_andExpr437);
            lhs=relExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:104:46: ( '&&' rhs= relExpr )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==13) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:104:48: '&&' rhs= relExpr
            	    {
            	    match(input,13,FOLLOW_13_in_andExpr443); if (state.failed) return result;

            	    pushFollow(FOLLOW_relExpr_in_andExpr447);
            	    rhs=relExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { result = new And(result, rhs); }

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
            if ( state.backtracking>0 ) { memoize(input, 8, andExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "andExpr"



    // $ANTLR start "orExpr"
    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:108:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
    public final Expr orExpr() throws RecognitionException {
        Expr result = null;

        int orExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:109:5: (lhs= andExpr ( '||' rhs= andExpr )* )
            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:109:9: lhs= andExpr ( '||' rhs= andExpr )*
            {
            pushFollow(FOLLOW_andExpr_in_orExpr482);
            lhs=andExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = lhs; }

            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:109:48: ( '||' rhs= andExpr )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==26) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:109:50: '||' rhs= andExpr
            	    {
            	    match(input,26,FOLLOW_26_in_orExpr488); if (state.failed) return result;

            	    pushFollow(FOLLOW_andExpr_in_orExpr492);
            	    rhs=andExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { result = new Or(result, rhs); }

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
            if ( state.backtracking>0 ) { memoize(input, 9, orExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "orExpr"

    // Delegated rules


 

    public static final BitSet FOLLOW_IDENT_in_computedQuestion47 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_computedQuestion49 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_computedQuestion51 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_TYPE_in_computedQuestion53 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_computedQuestion55 = new BitSet(new long[]{0x00000000000648D0L});
    public static final BitSet FOLLOW_orExpr_in_computedQuestion59 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_computedQuestion61 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_question82 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_question84 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_question86 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_TYPE_in_question88 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_primary115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_primary126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_primary135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_primary144 = new BitSet(new long[]{0x00000000000648D0L});
    public static final BitSet FOLLOW_orExpr_in_primary148 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_primary150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_unExpr176 = new BitSet(new long[]{0x00000000000648D0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_unExpr191 = new BitSet(new long[]{0x00000000000648D0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_unExpr206 = new BitSet(new long[]{0x00000000000648D0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_unExpr223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr261 = new BitSet(new long[]{0x0000000000090002L});
    public static final BitSet FOLLOW_set_in_mulExpr269 = new BitSet(new long[]{0x00000000000648D0L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr281 = new BitSet(new long[]{0x0000000000090002L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr322 = new BitSet(new long[]{0x0000000000060002L});
    public static final BitSet FOLLOW_set_in_addExpr330 = new BitSet(new long[]{0x00000000000648D0L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr340 = new BitSet(new long[]{0x0000000000060002L});
    public static final BitSet FOLLOW_addExpr_in_relExpr375 = new BitSet(new long[]{0x0000000003E01002L});
    public static final BitSet FOLLOW_set_in_relExpr383 = new BitSet(new long[]{0x00000000000648D0L});
    public static final BitSet FOLLOW_addExpr_in_relExpr399 = new BitSet(new long[]{0x0000000003E01002L});
    public static final BitSet FOLLOW_relExpr_in_andExpr437 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_andExpr443 = new BitSet(new long[]{0x00000000000648D0L});
    public static final BitSet FOLLOW_relExpr_in_andExpr447 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_andExpr_in_orExpr482 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_orExpr488 = new BitSet(new long[]{0x00000000000648D0L});
    public static final BitSet FOLLOW_andExpr_in_orExpr492 = new BitSet(new long[]{0x0000000004000002L});

}