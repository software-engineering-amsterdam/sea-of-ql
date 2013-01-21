// $ANTLR 3.4 C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g 2013-01-21 21:28:34

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expressions.*;
import org.uva.sea.ql.ast.expressions.binaryExpr.*;
import org.uva.sea.ql.ast.expressions.unaryExpr.*;
import org.uva.sea.ql.ast.statements.*;
import org.uva.sea.ql.types.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class QLParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "BOOLEAN", "COMMENT", "IDENT", "INT", "STRING_LITERAL", "WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", "'/'", "':'", "'<'", "'<='", "'=='", "'>'", "'>='", "'boolean'", "'int'", "'string'", "'||'"
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
    public static final int BOOLEAN=4;
    public static final int COMMENT=5;
    public static final int IDENT=6;
    public static final int INT=7;
    public static final int STRING_LITERAL=8;
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
        this.state.ruleMemo = new HashMap[30+1];
         

    }

    public String[] getTokenNames() { return QLParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g"; }



    // $ANTLR start "computedQuestion"
    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:31:1: computedQuestion returns [ComputedQuestion result] : IDENT ':' STRING_LITERAL type '(' x= orExpr ')' ;
    public final ComputedQuestion computedQuestion() throws RecognitionException {
        ComputedQuestion result = null;

        int computedQuestion_StartIndex = input.index();

        Token IDENT1=null;
        Token STRING_LITERAL2=null;
        Expr x =null;

        Type type3 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:32:2: ( IDENT ':' STRING_LITERAL type '(' x= orExpr ')' )
            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:32:4: IDENT ':' STRING_LITERAL type '(' x= orExpr ')'
            {
            IDENT1=(Token)match(input,IDENT,FOLLOW_IDENT_in_computedQuestion47); if (state.failed) return result;

            match(input,19,FOLLOW_19_in_computedQuestion49); if (state.failed) return result;

            STRING_LITERAL2=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_computedQuestion51); if (state.failed) return result;

            pushFollow(FOLLOW_type_in_computedQuestion53);
            type3=type();

            state._fsp--;
            if (state.failed) return result;

            match(input,13,FOLLOW_13_in_computedQuestion55); if (state.failed) return result;

            pushFollow(FOLLOW_orExpr_in_computedQuestion59);
            x=orExpr();

            state._fsp--;
            if (state.failed) return result;

            match(input,14,FOLLOW_14_in_computedQuestion61); if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new ComputedQuestion(new Ident((IDENT1!=null?IDENT1.getText():null)), new StringLiteral((STRING_LITERAL2!=null?STRING_LITERAL2.getText():null)),  type3, x); }

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
    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:37:1: question returns [Question result] : IDENT ':' STRING_LITERAL type ;
    public final Question question() throws RecognitionException {
        Question result = null;

        int question_StartIndex = input.index();

        Token IDENT4=null;
        Token STRING_LITERAL5=null;
        Type type6 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:38:5: ( IDENT ':' STRING_LITERAL type )
            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:38:7: IDENT ':' STRING_LITERAL type
            {
            IDENT4=(Token)match(input,IDENT,FOLLOW_IDENT_in_question83); if (state.failed) return result;

            match(input,19,FOLLOW_19_in_question85); if (state.failed) return result;

            STRING_LITERAL5=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_question87); if (state.failed) return result;

            pushFollow(FOLLOW_type_in_question89);
            type6=type();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new Question(new Ident((IDENT4!=null?IDENT4.getText():null)), new StringLiteral((STRING_LITERAL5!=null?STRING_LITERAL5.getText():null)), type6); }

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



    // $ANTLR start "type"
    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:42:1: type returns [Type result] : ( 'int' | 'boolean' | 'string' );
    public final Type type() throws RecognitionException {
        Type result = null;

        int type_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:43:5: ( 'int' | 'boolean' | 'string' )
            int alt1=3;
            switch ( input.LA(1) ) {
            case 26:
                {
                alt1=1;
                }
                break;
            case 25:
                {
                alt1=2;
                }
                break;
            case 27:
                {
                alt1=3;
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
                    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:43:7: 'int'
                    {
                    match(input,26,FOLLOW_26_in_type116); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new IntType("int"); }

                    }
                    break;
                case 2 :
                    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:44:7: 'boolean'
                    {
                    match(input,25,FOLLOW_25_in_type126); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new IntType("boolean"); }

                    }
                    break;
                case 3 :
                    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:45:7: 'string'
                    {
                    match(input,27,FOLLOW_27_in_type136); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new IntType("string"); }

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
            if ( state.backtracking>0 ) { memoize(input, 3, type_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "type"



    // $ANTLR start "primary"
    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:48:1: primary returns [Expr result] : ( INT | IDENT | BOOLEAN | '(' x= orExpr ')' );
    public final Expr primary() throws RecognitionException {
        Expr result = null;

        int primary_StartIndex = input.index();

        Token INT7=null;
        Token IDENT8=null;
        Token BOOLEAN9=null;
        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:49:5: ( INT | IDENT | BOOLEAN | '(' x= orExpr ')' )
            int alt2=4;
            switch ( input.LA(1) ) {
            case INT:
                {
                alt2=1;
                }
                break;
            case IDENT:
                {
                alt2=2;
                }
                break;
            case BOOLEAN:
                {
                alt2=3;
                }
                break;
            case 13:
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
                    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:49:7: INT
                    {
                    INT7=(Token)match(input,INT,FOLLOW_INT_in_primary159); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Int(Integer.parseInt((INT7!=null?INT7.getText():null))); }

                    }
                    break;
                case 2 :
                    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:50:6: IDENT
                    {
                    IDENT8=(Token)match(input,IDENT,FOLLOW_IDENT_in_primary170); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Ident((IDENT8!=null?IDENT8.getText():null)); }

                    }
                    break;
                case 3 :
                    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:51:6: BOOLEAN
                    {
                    BOOLEAN9=(Token)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_primary179); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Bool(Boolean.parseBoolean((BOOLEAN9!=null?BOOLEAN9.getText():null))); }

                    }
                    break;
                case 4 :
                    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:52:6: '(' x= orExpr ')'
                    {
                    match(input,13,FOLLOW_13_in_primary188); if (state.failed) return result;

                    pushFollow(FOLLOW_orExpr_in_primary192);
                    x=orExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,14,FOLLOW_14_in_primary194); if (state.failed) return result;

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
    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:55:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
    public final Expr unExpr() throws RecognitionException {
        Expr result = null;

        int unExpr_StartIndex = input.index();

        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:56:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
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
            case BOOLEAN:
            case IDENT:
            case INT:
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
                    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:56:8: '+' x= unExpr
                    {
                    match(input,16,FOLLOW_16_in_unExpr220); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr224);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Pos(x); }

                    }
                    break;
                case 2 :
                    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:57:8: '-' x= unExpr
                    {
                    match(input,17,FOLLOW_17_in_unExpr235); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr239);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Neg(x); }

                    }
                    break;
                case 3 :
                    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:58:8: '!' x= unExpr
                    {
                    match(input,10,FOLLOW_10_in_unExpr250); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr254);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Not(x); }

                    }
                    break;
                case 4 :
                    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:59:8: x= primary
                    {
                    pushFollow(FOLLOW_primary_in_unExpr267);
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
    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:62:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
    public final Expr mulExpr() throws RecognitionException {
        Expr result = null;

        int mulExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:63:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:63:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
            {
            pushFollow(FOLLOW_unExpr_in_mulExpr305);
            lhs=unExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:63:45: (op= ( '*' | '/' ) rhs= unExpr )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==15||LA4_0==18) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:63:47: op= ( '*' | '/' ) rhs= unExpr
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


            	    pushFollow(FOLLOW_unExpr_in_mulExpr325);
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
            if ( state.backtracking>0 ) { memoize(input, 6, mulExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "mulExpr"



    // $ANTLR start "addExpr"
    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:75:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
    public final Expr addExpr() throws RecognitionException {
        Expr result = null;

        int addExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:76:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:76:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
            {
            pushFollow(FOLLOW_mulExpr_in_addExpr366);
            lhs=mulExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:76:46: (op= ( '+' | '-' ) rhs= mulExpr )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0 >= 16 && LA5_0 <= 17)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:76:48: op= ( '+' | '-' ) rhs= mulExpr
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


            	    pushFollow(FOLLOW_mulExpr_in_addExpr384);
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
            if ( state.backtracking>0 ) { memoize(input, 7, addExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "addExpr"



    // $ANTLR start "relExpr"
    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:87:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
    public final Expr relExpr() throws RecognitionException {
        Expr result = null;

        int relExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:88:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:88:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            {
            pushFollow(FOLLOW_addExpr_in_relExpr419);
            lhs=addExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:88:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==11||(LA6_0 >= 20 && LA6_0 <= 24)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:88:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( input.LA(1)==11||(input.LA(1) >= 20 && input.LA(1) <= 24) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_addExpr_in_relExpr443);
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
            if ( state.backtracking>0 ) { memoize(input, 8, relExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "relExpr"



    // $ANTLR start "andExpr"
    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:111:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
    public final Expr andExpr() throws RecognitionException {
        Expr result = null;

        int andExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:112:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:112:9: lhs= relExpr ( '&&' rhs= relExpr )*
            {
            pushFollow(FOLLOW_relExpr_in_andExpr481);
            lhs=relExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:112:46: ( '&&' rhs= relExpr )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==12) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:112:48: '&&' rhs= relExpr
            	    {
            	    match(input,12,FOLLOW_12_in_andExpr487); if (state.failed) return result;

            	    pushFollow(FOLLOW_relExpr_in_andExpr491);
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
    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:116:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
    public final Expr orExpr() throws RecognitionException {
        Expr result = null;

        int orExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:117:5: (lhs= andExpr ( '||' rhs= andExpr )* )
            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:117:9: lhs= andExpr ( '||' rhs= andExpr )*
            {
            pushFollow(FOLLOW_andExpr_in_orExpr526);
            lhs=andExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = lhs; }

            // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:117:48: ( '||' rhs= andExpr )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==28) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // C:\\Users\\Theodora\\Documents\\GitHub\\sea-of-ql\\thboudale\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:117:50: '||' rhs= andExpr
            	    {
            	    match(input,28,FOLLOW_28_in_orExpr532); if (state.failed) return result;

            	    pushFollow(FOLLOW_andExpr_in_orExpr536);
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

    // Delegated rules


 

    public static final BitSet FOLLOW_IDENT_in_computedQuestion47 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_computedQuestion49 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_computedQuestion51 = new BitSet(new long[]{0x000000000E000000L});
    public static final BitSet FOLLOW_type_in_computedQuestion53 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_computedQuestion55 = new BitSet(new long[]{0x00000000000324D0L});
    public static final BitSet FOLLOW_orExpr_in_computedQuestion59 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_computedQuestion61 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_question83 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_question85 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_question87 = new BitSet(new long[]{0x000000000E000000L});
    public static final BitSet FOLLOW_type_in_question89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_type116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_type126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_type136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_primary159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_primary170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_primary179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_primary188 = new BitSet(new long[]{0x00000000000324D0L});
    public static final BitSet FOLLOW_orExpr_in_primary192 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_primary194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_unExpr220 = new BitSet(new long[]{0x00000000000324D0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_unExpr235 = new BitSet(new long[]{0x00000000000324D0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_unExpr250 = new BitSet(new long[]{0x00000000000324D0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_unExpr267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr305 = new BitSet(new long[]{0x0000000000048002L});
    public static final BitSet FOLLOW_set_in_mulExpr313 = new BitSet(new long[]{0x00000000000324D0L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr325 = new BitSet(new long[]{0x0000000000048002L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr366 = new BitSet(new long[]{0x0000000000030002L});
    public static final BitSet FOLLOW_set_in_addExpr374 = new BitSet(new long[]{0x00000000000324D0L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr384 = new BitSet(new long[]{0x0000000000030002L});
    public static final BitSet FOLLOW_addExpr_in_relExpr419 = new BitSet(new long[]{0x0000000001F00802L});
    public static final BitSet FOLLOW_set_in_relExpr427 = new BitSet(new long[]{0x00000000000324D0L});
    public static final BitSet FOLLOW_addExpr_in_relExpr443 = new BitSet(new long[]{0x0000000001F00802L});
    public static final BitSet FOLLOW_relExpr_in_andExpr481 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_12_in_andExpr487 = new BitSet(new long[]{0x00000000000324D0L});
    public static final BitSet FOLLOW_relExpr_in_andExpr491 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_andExpr_in_orExpr526 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_orExpr532 = new BitSet(new long[]{0x00000000000324D0L});
    public static final BitSet FOLLOW_andExpr_in_orExpr536 = new BitSet(new long[]{0x0000000010000002L});

}