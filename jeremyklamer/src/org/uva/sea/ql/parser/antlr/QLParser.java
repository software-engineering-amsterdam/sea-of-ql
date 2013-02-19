// $ANTLR 3.4 C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g 2013-02-19 10:26:04

package org.uva.sea.ql.parser.antlr;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.Parser;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.binary.Add;
import org.uva.sea.ql.ast.expr.binary.And;
import org.uva.sea.ql.ast.expr.binary.Div;
import org.uva.sea.ql.ast.expr.binary.Eq;
import org.uva.sea.ql.ast.expr.binary.GEq;
import org.uva.sea.ql.ast.expr.binary.GT;
import org.uva.sea.ql.ast.expr.binary.LEq;
import org.uva.sea.ql.ast.expr.binary.LT;
import org.uva.sea.ql.ast.expr.binary.Mul;
import org.uva.sea.ql.ast.expr.binary.NEq;
import org.uva.sea.ql.ast.expr.binary.Or;
import org.uva.sea.ql.ast.expr.binary.Sub;
import org.uva.sea.ql.ast.expr.unary.Neg;
import org.uva.sea.ql.ast.expr.unary.Not;
import org.uva.sea.ql.ast.expr.unary.Pos;
import org.uva.sea.ql.ast.expr.value.Bool;
import org.uva.sea.ql.ast.expr.value.Ident;
import org.uva.sea.ql.ast.expr.value.Int;
import org.uva.sea.ql.ast.expr.value.StringNode;
import org.uva.sea.ql.ast.statement.ComputedQuestion;
import org.uva.sea.ql.ast.statement.If;
import org.uva.sea.ql.ast.statement.IfThenElse;
import org.uva.sea.ql.ast.statement.Question;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.ast.type.BoolType;
import org.uva.sea.ql.ast.type.IntType;
import org.uva.sea.ql.ast.type.StringType;
import org.uva.sea.ql.ast.type.Type;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class QLParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "BOOL", "COMMENT", "Ident", "Int", "String", "WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", "'/'", "':'", "'<'", "'<='", "'=='", "'>'", "'>='", "'boolean'", "'else'", "'form'", "'if'", "'integer'", "'string'", "'{'", "'||'", "'}'"
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
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int BOOL=4;
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
        this.state.ruleMemo = new HashMap[41+1];
         

    }

    public String[] getTokenNames() { return QLParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g"; }



    // $ANTLR start "primary"
    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:17:1: primary returns [Expr result] : ( Int | Ident | BOOL | String | '(' x= orExpr ')' );
    public final Expr primary() throws RecognitionException {
        Expr result = null;

        int primary_StartIndex = input.index();

        Token Int1=null;
        Token Ident2=null;
        Token BOOL3=null;
        Token String4=null;
        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

            // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:18:5: ( Int | Ident | BOOL | String | '(' x= orExpr ')' )
            int alt1=5;
            switch ( input.LA(1) ) {
            case Int:
                {
                alt1=1;
                }
                break;
            case Ident:
                {
                alt1=2;
                }
                break;
            case BOOL:
                {
                alt1=3;
                }
                break;
            case String:
                {
                alt1=4;
                }
                break;
            case 13:
                {
                alt1=5;
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
                    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:18:7: Int
                    {
                    Int1=(Token)match(input,Int,FOLLOW_Int_in_primary49); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Int(Integer.parseInt((Int1!=null?Int1.getText():null))); }

                    }
                    break;
                case 2 :
                    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:19:7: Ident
                    {
                    Ident2=(Token)match(input,Ident,FOLLOW_Ident_in_primary61); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Ident((Ident2!=null?Ident2.getText():null)); }

                    }
                    break;
                case 3 :
                    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:20:7: BOOL
                    {
                    BOOL3=(Token)match(input,BOOL,FOLLOW_BOOL_in_primary71); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Bool(Boolean.parseBoolean((BOOL3!=null?BOOL3.getText():null))); }

                    }
                    break;
                case 4 :
                    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:21:7: String
                    {
                    String4=(Token)match(input,String,FOLLOW_String_in_primary82); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new StringNode((String4!=null?String4.getText():null)); }

                    }
                    break;
                case 5 :
                    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:22:7: '(' x= orExpr ')'
                    {
                    match(input,13,FOLLOW_13_in_primary91); if (state.failed) return result;

                    pushFollow(FOLLOW_orExpr_in_primary95);
                    x=orExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,14,FOLLOW_14_in_primary97); if (state.failed) return result;

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
            if ( state.backtracking>0 ) { memoize(input, 1, primary_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "primary"



    // $ANTLR start "unExpr"
    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:25:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
    public final Expr unExpr() throws RecognitionException {
        Expr result = null;

        int unExpr_StartIndex = input.index();

        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

            // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:26:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
            int alt2=4;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt2=1;
                }
                break;
            case 17:
                {
                alt2=2;
                }
                break;
            case 10:
                {
                alt2=3;
                }
                break;
            case BOOL:
            case Ident:
            case Int:
            case String:
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
                    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:26:7: '+' x= unExpr
                    {
                    match(input,16,FOLLOW_16_in_unExpr124); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr128);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Pos(x); }

                    }
                    break;
                case 2 :
                    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:27:7: '-' x= unExpr
                    {
                    match(input,17,FOLLOW_17_in_unExpr138); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr142);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Neg(x); }

                    }
                    break;
                case 3 :
                    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:28:7: '!' x= unExpr
                    {
                    match(input,10,FOLLOW_10_in_unExpr152); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr156);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Not(x); }

                    }
                    break;
                case 4 :
                    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:29:7: x= primary
                    {
                    pushFollow(FOLLOW_primary_in_unExpr168);
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
            if ( state.backtracking>0 ) { memoize(input, 2, unExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "unExpr"



    // $ANTLR start "mulExpr"
    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:32:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
    public final Expr mulExpr() throws RecognitionException {
        Expr result = null;

        int mulExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

            // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:33:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
            // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:33:7: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
            {
            pushFollow(FOLLOW_unExpr_in_mulExpr205);
            lhs=unExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:33:43: (op= ( '*' | '/' ) rhs= unExpr )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==15||LA3_0==18) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:33:45: op= ( '*' | '/' ) rhs= unExpr
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


            	    pushFollow(FOLLOW_unExpr_in_mulExpr225);
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
            if ( state.backtracking>0 ) { memoize(input, 3, mulExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "mulExpr"



    // $ANTLR start "addExpr"
    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:45:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
    public final Expr addExpr() throws RecognitionException {
        Expr result = null;

        int addExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

            // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:46:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
            // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:46:7: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
            {
            pushFollow(FOLLOW_mulExpr_in_addExpr265);
            lhs=mulExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:46:44: (op= ( '+' | '-' ) rhs= mulExpr )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= 16 && LA4_0 <= 17)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:46:46: op= ( '+' | '-' ) rhs= mulExpr
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


            	    pushFollow(FOLLOW_mulExpr_in_addExpr283);
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
            if ( state.backtracking>0 ) { memoize(input, 4, addExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "addExpr"



    // $ANTLR start "relExpr"
    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:57:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
    public final Expr relExpr() throws RecognitionException {
        Expr result = null;

        int relExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

            // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:58:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
            // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:58:7: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            {
            pushFollow(FOLLOW_addExpr_in_relExpr317);
            lhs=addExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:58:44: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==11||(LA5_0 >= 20 && LA5_0 <= 24)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:58:46: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
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


            	    pushFollow(FOLLOW_addExpr_in_relExpr341);
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
            if ( state.backtracking>0 ) { memoize(input, 5, relExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "relExpr"



    // $ANTLR start "andExpr"
    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:81:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
    public final Expr andExpr() throws RecognitionException {
        Expr result = null;

        int andExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

            // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:82:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
            // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:82:7: lhs= relExpr ( '&&' rhs= relExpr )*
            {
            pushFollow(FOLLOW_relExpr_in_andExpr378);
            lhs=relExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:82:44: ( '&&' rhs= relExpr )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==12) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:82:46: '&&' rhs= relExpr
            	    {
            	    match(input,12,FOLLOW_12_in_andExpr384); if (state.failed) return result;

            	    pushFollow(FOLLOW_relExpr_in_andExpr388);
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
            if ( state.backtracking>0 ) { memoize(input, 6, andExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "andExpr"



    // $ANTLR start "orExpr"
    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:86:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
    public final Expr orExpr() throws RecognitionException {
        Expr result = null;

        int orExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

            // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:87:5: (lhs= andExpr ( '||' rhs= andExpr )* )
            // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:87:7: lhs= andExpr ( '||' rhs= andExpr )*
            {
            pushFollow(FOLLOW_andExpr_in_orExpr422);
            lhs=andExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = lhs; }

            // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:87:46: ( '||' rhs= andExpr )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==32) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:87:48: '||' rhs= andExpr
            	    {
            	    match(input,32,FOLLOW_32_in_orExpr428); if (state.failed) return result;

            	    pushFollow(FOLLOW_andExpr_in_orExpr432);
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
            if ( state.backtracking>0 ) { memoize(input, 7, orExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "orExpr"



    // $ANTLR start "form"
    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:90:1: form returns [Form result] : 'form' Ident '{' ( formPart )+ '}' ;
    public final Form form() throws RecognitionException {
        Form result = null;

        int form_StartIndex = input.index();

        Token Ident6=null;
        Statement formPart5 =null;


         List<Statement> formParts = new ArrayList<Statement>();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

            // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:92:5: ( 'form' Ident '{' ( formPart )+ '}' )
            // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:92:7: 'form' Ident '{' ( formPart )+ '}'
            {
            match(input,27,FOLLOW_27_in_form470); if (state.failed) return result;

            Ident6=(Token)match(input,Ident,FOLLOW_Ident_in_form472); if (state.failed) return result;

            match(input,31,FOLLOW_31_in_form474); if (state.failed) return result;

            // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:92:24: ( formPart )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==Ident||LA8_0==28) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:92:25: formPart
            	    {
            	    pushFollow(FOLLOW_formPart_in_form477);
            	    formPart5=formPart();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) {formParts.add(formPart5);}

            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
            	    if (state.backtracking>0) {state.failed=true; return result;}
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);


            match(input,33,FOLLOW_33_in_form483); if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new Form(new Ident((Ident6!=null?Ident6.getText():null)), formParts);}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 8, form_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "form"



    // $ANTLR start "formPart"
    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:95:1: formPart returns [Statement result] : ( question | ifThenStatement | ifStatement );
    public final Statement formPart() throws RecognitionException {
        Statement result = null;

        int formPart_StartIndex = input.index();

        Question question7 =null;

        Statement ifThenStatement8 =null;

        Statement ifStatement9 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

            // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:96:5: ( question | ifThenStatement | ifStatement )
            int alt9=3;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==Ident) ) {
                alt9=1;
            }
            else if ( (LA9_0==28) ) {
                int LA9_2 = input.LA(2);

                if ( (synpred22_QL()) ) {
                    alt9=2;
                }
                else if ( (true) ) {
                    alt9=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return result;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 2, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;

            }
            switch (alt9) {
                case 1 :
                    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:96:7: question
                    {
                    pushFollow(FOLLOW_question_in_formPart510);
                    question7=question();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) {result = question7;}

                    }
                    break;
                case 2 :
                    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:97:7: ifThenStatement
                    {
                    pushFollow(FOLLOW_ifThenStatement_in_formPart520);
                    ifThenStatement8=ifThenStatement();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) {result = ifThenStatement8;}

                    }
                    break;
                case 3 :
                    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:98:7: ifStatement
                    {
                    pushFollow(FOLLOW_ifStatement_in_formPart530);
                    ifStatement9=ifStatement();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) {result = ifStatement9;}

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
            if ( state.backtracking>0 ) { memoize(input, 9, formPart_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "formPart"



    // $ANTLR start "ifStatement"
    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:101:1: ifStatement returns [Statement result] : 'if' '(' orExpr ')' '{' ( formPart )+ '}' ;
    public final Statement ifStatement() throws RecognitionException {
        Statement result = null;

        int ifStatement_StartIndex = input.index();

        Statement formPart10 =null;

        Expr orExpr11 =null;


         List<Statement> formParts = new ArrayList<Statement>();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

            // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:103:5: ( 'if' '(' orExpr ')' '{' ( formPart )+ '}' )
            // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:103:7: 'if' '(' orExpr ')' '{' ( formPart )+ '}'
            {
            match(input,28,FOLLOW_28_in_ifStatement567); if (state.failed) return result;

            match(input,13,FOLLOW_13_in_ifStatement569); if (state.failed) return result;

            pushFollow(FOLLOW_orExpr_in_ifStatement571);
            orExpr11=orExpr();

            state._fsp--;
            if (state.failed) return result;

            match(input,14,FOLLOW_14_in_ifStatement573); if (state.failed) return result;

            match(input,31,FOLLOW_31_in_ifStatement575); if (state.failed) return result;

            // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:103:31: ( formPart )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==Ident||LA10_0==28) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:103:32: formPart
            	    {
            	    pushFollow(FOLLOW_formPart_in_ifStatement578);
            	    formPart10=formPart();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) {formParts.add(formPart10);}

            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
            	    if (state.backtracking>0) {state.failed=true; return result;}
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);


            match(input,33,FOLLOW_33_in_ifStatement584); if (state.failed) return result;

            if ( state.backtracking==0 ) {result = new If(orExpr11, formParts);}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 10, ifStatement_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "ifStatement"



    // $ANTLR start "ifThenStatement"
    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:106:1: ifThenStatement returns [Statement result] : 'if' '(' orExpr ')' '{' (f1= formPart )+ '}' 'else' '{' (f2= formPart )+ '}' ;
    public final Statement ifThenStatement() throws RecognitionException {
        Statement result = null;

        int ifThenStatement_StartIndex = input.index();

        Statement f1 =null;

        Statement f2 =null;

        Expr orExpr12 =null;


         List<Statement> ifFormParts = new ArrayList<Statement>();
                      List<Statement> elseFormParts = new ArrayList<Statement>();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

            // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:109:5: ( 'if' '(' orExpr ')' '{' (f1= formPart )+ '}' 'else' '{' (f2= formPart )+ '}' )
            // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:109:7: 'if' '(' orExpr ')' '{' (f1= formPart )+ '}' 'else' '{' (f2= formPart )+ '}'
            {
            match(input,28,FOLLOW_28_in_ifThenStatement622); if (state.failed) return result;

            match(input,13,FOLLOW_13_in_ifThenStatement624); if (state.failed) return result;

            pushFollow(FOLLOW_orExpr_in_ifThenStatement626);
            orExpr12=orExpr();

            state._fsp--;
            if (state.failed) return result;

            match(input,14,FOLLOW_14_in_ifThenStatement628); if (state.failed) return result;

            match(input,31,FOLLOW_31_in_ifThenStatement630); if (state.failed) return result;

            // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:109:31: (f1= formPart )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==Ident||LA11_0==28) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:109:32: f1= formPart
            	    {
            	    pushFollow(FOLLOW_formPart_in_ifThenStatement635);
            	    f1=formPart();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) {ifFormParts.add(f1);}

            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
            	    if (state.backtracking>0) {state.failed=true; return result;}
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);


            match(input,33,FOLLOW_33_in_ifThenStatement641); if (state.failed) return result;

            match(input,26,FOLLOW_26_in_ifThenStatement643); if (state.failed) return result;

            match(input,31,FOLLOW_31_in_ifThenStatement645); if (state.failed) return result;

            // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:109:92: (f2= formPart )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==Ident||LA12_0==28) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:109:93: f2= formPart
            	    {
            	    pushFollow(FOLLOW_formPart_in_ifThenStatement650);
            	    f2=formPart();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) {elseFormParts.add(f2);}

            	    }
            	    break;

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
            	    if (state.backtracking>0) {state.failed=true; return result;}
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
            } while (true);


            match(input,33,FOLLOW_33_in_ifThenStatement656); if (state.failed) return result;

            if ( state.backtracking==0 ) {result = new IfThenElse(orExpr12, ifFormParts, elseFormParts);}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 11, ifThenStatement_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "ifThenStatement"



    // $ANTLR start "question"
    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:113:1: question returns [Question result] : ( Ident ':' String returnType '(' orExpr ')' | Ident ':' String returnType );
    public final Question question() throws RecognitionException {
        Question result = null;

        int question_StartIndex = input.index();

        Token Ident13=null;
        Token String14=null;
        Token Ident17=null;
        Token String18=null;
        Type returnType15 =null;

        Expr orExpr16 =null;

        Type returnType19 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }

            // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:114:5: ( Ident ':' String returnType '(' orExpr ')' | Ident ':' String returnType )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==Ident) ) {
                int LA13_1 = input.LA(2);

                if ( (LA13_1==19) ) {
                    int LA13_2 = input.LA(3);

                    if ( (LA13_2==String) ) {
                        switch ( input.LA(4) ) {
                        case 25:
                            {
                            int LA13_4 = input.LA(5);

                            if ( (LA13_4==13) ) {
                                alt13=1;
                            }
                            else if ( (LA13_4==EOF||LA13_4==Ident||LA13_4==28||LA13_4==33) ) {
                                alt13=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return result;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 13, 4, input);

                                throw nvae;

                            }
                            }
                            break;
                        case 29:
                            {
                            int LA13_5 = input.LA(5);

                            if ( (LA13_5==13) ) {
                                alt13=1;
                            }
                            else if ( (LA13_5==EOF||LA13_5==Ident||LA13_5==28||LA13_5==33) ) {
                                alt13=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return result;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 13, 5, input);

                                throw nvae;

                            }
                            }
                            break;
                        case 30:
                            {
                            int LA13_6 = input.LA(5);

                            if ( (LA13_6==13) ) {
                                alt13=1;
                            }
                            else if ( (LA13_6==EOF||LA13_6==Ident||LA13_6==28||LA13_6==33) ) {
                                alt13=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return result;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 13, 6, input);

                                throw nvae;

                            }
                            }
                            break;
                        default:
                            if (state.backtracking>0) {state.failed=true; return result;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 13, 3, input);

                            throw nvae;

                        }

                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return result;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 13, 2, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return result;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;

            }
            switch (alt13) {
                case 1 :
                    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:114:7: Ident ':' String returnType '(' orExpr ')'
                    {
                    Ident13=(Token)match(input,Ident,FOLLOW_Ident_in_question690); if (state.failed) return result;

                    match(input,19,FOLLOW_19_in_question692); if (state.failed) return result;

                    String14=(Token)match(input,String,FOLLOW_String_in_question694); if (state.failed) return result;

                    pushFollow(FOLLOW_returnType_in_question696);
                    returnType15=returnType();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,13,FOLLOW_13_in_question698); if (state.failed) return result;

                    pushFollow(FOLLOW_orExpr_in_question700);
                    orExpr16=orExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,14,FOLLOW_14_in_question702); if (state.failed) return result;

                    if ( state.backtracking==0 ) {result = new ComputedQuestion(new Ident((Ident13!=null?Ident13.getText():null)), (String14!=null?String14.getText():null), returnType15, orExpr16);}

                    }
                    break;
                case 2 :
                    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:115:7: Ident ':' String returnType
                    {
                    Ident17=(Token)match(input,Ident,FOLLOW_Ident_in_question713); if (state.failed) return result;

                    match(input,19,FOLLOW_19_in_question715); if (state.failed) return result;

                    String18=(Token)match(input,String,FOLLOW_String_in_question717); if (state.failed) return result;

                    pushFollow(FOLLOW_returnType_in_question719);
                    returnType19=returnType();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) {result = new Question(new Ident((Ident17!=null?Ident17.getText():null)), (String18!=null?String18.getText():null), returnType19);}

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
            if ( state.backtracking>0 ) { memoize(input, 12, question_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "question"



    // $ANTLR start "returnType"
    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:118:1: returnType returns [Type result] : ( 'boolean' | 'integer' | 'string' );
    public final Type returnType() throws RecognitionException {
        Type result = null;

        int returnType_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return result; }

            // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:119:5: ( 'boolean' | 'integer' | 'string' )
            int alt14=3;
            switch ( input.LA(1) ) {
            case 25:
                {
                alt14=1;
                }
                break;
            case 29:
                {
                alt14=2;
                }
                break;
            case 30:
                {
                alt14=3;
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
                    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:119:7: 'boolean'
                    {
                    match(input,25,FOLLOW_25_in_returnType751); if (state.failed) return result;

                    if ( state.backtracking==0 ) {result = new BoolType(); }

                    }
                    break;
                case 2 :
                    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:120:7: 'integer'
                    {
                    match(input,29,FOLLOW_29_in_returnType761); if (state.failed) return result;

                    if ( state.backtracking==0 ) {result = new IntType();}

                    }
                    break;
                case 3 :
                    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:121:7: 'string'
                    {
                    match(input,30,FOLLOW_30_in_returnType772); if (state.failed) return result;

                    if ( state.backtracking==0 ) {result = new StringType();}

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
            if ( state.backtracking>0 ) { memoize(input, 13, returnType_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "returnType"

    // $ANTLR start synpred22_QL
    public final void synpred22_QL_fragment() throws RecognitionException {
        // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:97:7: ( ifThenStatement )
        // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:97:7: ifThenStatement
        {
        pushFollow(FOLLOW_ifThenStatement_in_synpred22_QL520);
        ifThenStatement();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred22_QL

    // Delegated rules

    public final boolean synpred22_QL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred22_QL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_Int_in_primary49 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_primary61 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_in_primary71 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_String_in_primary82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_primary91 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_orExpr_in_primary95 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_primary97 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_unExpr124 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_unExpr138 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_unExpr152 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_unExpr168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr205 = new BitSet(new long[]{0x0000000000048002L});
    public static final BitSet FOLLOW_set_in_mulExpr213 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr225 = new BitSet(new long[]{0x0000000000048002L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr265 = new BitSet(new long[]{0x0000000000030002L});
    public static final BitSet FOLLOW_set_in_addExpr273 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr283 = new BitSet(new long[]{0x0000000000030002L});
    public static final BitSet FOLLOW_addExpr_in_relExpr317 = new BitSet(new long[]{0x0000000001F00802L});
    public static final BitSet FOLLOW_set_in_relExpr325 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_addExpr_in_relExpr341 = new BitSet(new long[]{0x0000000001F00802L});
    public static final BitSet FOLLOW_relExpr_in_andExpr378 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_12_in_andExpr384 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_relExpr_in_andExpr388 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_andExpr_in_orExpr422 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_orExpr428 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_andExpr_in_orExpr432 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_27_in_form470 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_Ident_in_form472 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_form474 = new BitSet(new long[]{0x0000000010000040L});
    public static final BitSet FOLLOW_formPart_in_form477 = new BitSet(new long[]{0x0000000210000040L});
    public static final BitSet FOLLOW_33_in_form483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_question_in_formPart510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifThenStatement_in_formPart520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStatement_in_formPart530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ifStatement567 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ifStatement569 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_orExpr_in_ifStatement571 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ifStatement573 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ifStatement575 = new BitSet(new long[]{0x0000000010000040L});
    public static final BitSet FOLLOW_formPart_in_ifStatement578 = new BitSet(new long[]{0x0000000210000040L});
    public static final BitSet FOLLOW_33_in_ifStatement584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ifThenStatement622 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ifThenStatement624 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_orExpr_in_ifThenStatement626 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ifThenStatement628 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ifThenStatement630 = new BitSet(new long[]{0x0000000010000040L});
    public static final BitSet FOLLOW_formPart_in_ifThenStatement635 = new BitSet(new long[]{0x0000000210000040L});
    public static final BitSet FOLLOW_33_in_ifThenStatement641 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ifThenStatement643 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ifThenStatement645 = new BitSet(new long[]{0x0000000010000040L});
    public static final BitSet FOLLOW_formPart_in_ifThenStatement650 = new BitSet(new long[]{0x0000000210000040L});
    public static final BitSet FOLLOW_33_in_ifThenStatement656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_question690 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_question692 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_String_in_question694 = new BitSet(new long[]{0x0000000062000000L});
    public static final BitSet FOLLOW_returnType_in_question696 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_question698 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_orExpr_in_question700 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_question702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_question713 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_question715 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_String_in_question717 = new BitSet(new long[]{0x0000000062000000L});
    public static final BitSet FOLLOW_returnType_in_question719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_returnType751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_returnType761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_returnType772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifThenStatement_in_synpred22_QL520 = new BitSet(new long[]{0x0000000000000002L});

}