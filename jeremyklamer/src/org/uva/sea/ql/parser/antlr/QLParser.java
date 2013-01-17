// $ANTLR 3.4 C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g 2013-01-17 11:34:45

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.type.*;
import org.uva.sea.ql.ast.statement.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class QLParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "BOOL", "COMMENT", "Ident", "Int", "String", "WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", "'/'", "':'", "'<'", "'<='", "'=='", "'>'", "'>='", "'boolean'", "'form'", "'if'", "'money'", "'money('", "'{'", "'||'", "'}'"
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
        this.state.ruleMemo = new HashMap[34+1];
         

    }

    public String[] getTokenNames() { return QLParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g"; }



    // $ANTLR start "primary"
    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:17:1: primary returns [Expr result] : ( Int | Ident | '(' x= orExpr ')' );
    public final Expr primary() throws RecognitionException {
        Expr result = null;

        int primary_StartIndex = input.index();

        Token Int1=null;
        Token Ident2=null;
        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

            // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:18:3: ( Int | Ident | '(' x= orExpr ')' )
            int alt1=3;
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
            case 13:
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
                    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:18:5: Int
                    {
                    Int1=(Token)match(input,Int,FOLLOW_Int_in_primary47); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Int(Integer.parseInt((Int1!=null?Int1.getText():null))); }

                    }
                    break;
                case 2 :
                    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:19:5: Ident
                    {
                    Ident2=(Token)match(input,Ident,FOLLOW_Ident_in_primary57); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Ident((Ident2!=null?Ident2.getText():null)); }

                    }
                    break;
                case 3 :
                    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:20:5: '(' x= orExpr ')'
                    {
                    match(input,13,FOLLOW_13_in_primary65); if (state.failed) return result;

                    pushFollow(FOLLOW_orExpr_in_primary69);
                    x=orExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,14,FOLLOW_14_in_primary71); if (state.failed) return result;

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
    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:23:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
    public final Expr unExpr() throws RecognitionException {
        Expr result = null;

        int unExpr_StartIndex = input.index();

        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

            // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:24:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
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
            case Ident:
            case Int:
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
                    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:24:8: '+' x= unExpr
                    {
                    match(input,16,FOLLOW_16_in_unExpr97); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr101);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Pos(x); }

                    }
                    break;
                case 2 :
                    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:25:8: '-' x= unExpr
                    {
                    match(input,17,FOLLOW_17_in_unExpr112); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr116);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Neg(x); }

                    }
                    break;
                case 3 :
                    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:26:8: '!' x= unExpr
                    {
                    match(input,10,FOLLOW_10_in_unExpr127); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr131);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Not(x); }

                    }
                    break;
                case 4 :
                    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:27:8: x= primary
                    {
                    pushFollow(FOLLOW_primary_in_unExpr144);
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
    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:30:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
    public final Expr mulExpr() throws RecognitionException {
        Expr result = null;

        int mulExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

            // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:31:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
            // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:31:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
            {
            pushFollow(FOLLOW_unExpr_in_mulExpr183);
            lhs=unExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:31:45: (op= ( '*' | '/' ) rhs= unExpr )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==15||LA3_0==18) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:31:47: op= ( '*' | '/' ) rhs= unExpr
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


            	    pushFollow(FOLLOW_unExpr_in_mulExpr203);
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
            if ( state.backtracking>0 ) { memoize(input, 3, mulExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "mulExpr"



    // $ANTLR start "addExpr"
    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:43:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
    public final Expr addExpr() throws RecognitionException {
        Expr result = null;

        int addExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

            // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:44:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
            // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:44:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
            {
            pushFollow(FOLLOW_mulExpr_in_addExpr245);
            lhs=mulExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:44:46: (op= ( '+' | '-' ) rhs= mulExpr )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= 16 && LA4_0 <= 17)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:44:48: op= ( '+' | '-' ) rhs= mulExpr
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


            	    pushFollow(FOLLOW_mulExpr_in_addExpr263);
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
    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:55:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
    public final Expr relExpr() throws RecognitionException {
        Expr result = null;

        int relExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

            // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:56:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
            // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:56:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            {
            pushFollow(FOLLOW_addExpr_in_relExpr299);
            lhs=addExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:56:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==11||(LA5_0 >= 20 && LA5_0 <= 24)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:56:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
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


            	    pushFollow(FOLLOW_addExpr_in_relExpr323);
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
    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:79:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
    public final Expr andExpr() throws RecognitionException {
        Expr result = null;

        int andExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

            // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:80:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
            // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:80:9: lhs= relExpr ( '&&' rhs= relExpr )*
            {
            pushFollow(FOLLOW_relExpr_in_andExpr362);
            lhs=relExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:80:46: ( '&&' rhs= relExpr )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==12) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:80:48: '&&' rhs= relExpr
            	    {
            	    match(input,12,FOLLOW_12_in_andExpr368); if (state.failed) return result;

            	    pushFollow(FOLLOW_relExpr_in_andExpr372);
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
    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:84:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
    public final Expr orExpr() throws RecognitionException {
        Expr result = null;

        int orExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

            // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:85:5: (lhs= andExpr ( '||' rhs= andExpr )* )
            // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:85:9: lhs= andExpr ( '||' rhs= andExpr )*
            {
            pushFollow(FOLLOW_andExpr_in_orExpr408);
            lhs=andExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = lhs; }

            // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:85:48: ( '||' rhs= andExpr )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==31) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:85:50: '||' rhs= andExpr
            	    {
            	    match(input,31,FOLLOW_31_in_orExpr414); if (state.failed) return result;

            	    pushFollow(FOLLOW_andExpr_in_orExpr418);
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
    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:88:1: form returns [Type result] : 'form' Ident '{' ( formPart )+ '}' ;
    public final Type form() throws RecognitionException {
        Type result = null;

        int form_StartIndex = input.index();

        Token Ident4=null;
        Statement formPart3 =null;


         List<Statement> formParts = new ArrayList<Statement>();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

            // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:90:5: ( 'form' Ident '{' ( formPart )+ '}' )
            // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:90:7: 'form' Ident '{' ( formPart )+ '}'
            {
            match(input,26,FOLLOW_26_in_form454); if (state.failed) return result;

            Ident4=(Token)match(input,Ident,FOLLOW_Ident_in_form456); if (state.failed) return result;

            match(input,30,FOLLOW_30_in_form458); if (state.failed) return result;

            // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:90:24: ( formPart )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==Ident||LA8_0==27) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:90:25: formPart
            	    {
            	    pushFollow(FOLLOW_formPart_in_form461);
            	    formPart3=formPart();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) {formParts.add(formPart3);}

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


            match(input,32,FOLLOW_32_in_form467); if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new Form(new Ident((Ident4!=null?Ident4.getText():null)), formParts);}

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
    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:93:1: formPart returns [Statement result] : ( question | ifStatement );
    public final Statement formPart() throws RecognitionException {
        Statement result = null;

        int formPart_StartIndex = input.index();

        Question question5 =null;

        Statement ifStatement6 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

            // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:94:5: ( question | ifStatement )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==Ident) ) {
                alt9=1;
            }
            else if ( (LA9_0==27) ) {
                alt9=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;

            }
            switch (alt9) {
                case 1 :
                    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:94:7: question
                    {
                    pushFollow(FOLLOW_question_in_formPart494);
                    question5=question();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) {result = question5;}

                    }
                    break;
                case 2 :
                    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:95:7: ifStatement
                    {
                    pushFollow(FOLLOW_ifStatement_in_formPart504);
                    ifStatement6=ifStatement();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) {result = ifStatement6;}

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
    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:98:1: ifStatement returns [Statement result] : 'if' '(' Ident ')' '{' ( formPart )+ '}' ;
    public final Statement ifStatement() throws RecognitionException {
        Statement result = null;

        int ifStatement_StartIndex = input.index();

        Token Ident8=null;
        Statement formPart7 =null;


         List<Statement> formParts = new ArrayList<Statement>();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

            // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:100:5: ( 'if' '(' Ident ')' '{' ( formPart )+ '}' )
            // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:100:7: 'if' '(' Ident ')' '{' ( formPart )+ '}'
            {
            match(input,27,FOLLOW_27_in_ifStatement539); if (state.failed) return result;

            match(input,13,FOLLOW_13_in_ifStatement541); if (state.failed) return result;

            Ident8=(Token)match(input,Ident,FOLLOW_Ident_in_ifStatement543); if (state.failed) return result;

            match(input,14,FOLLOW_14_in_ifStatement545); if (state.failed) return result;

            match(input,30,FOLLOW_30_in_ifStatement547); if (state.failed) return result;

            // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:100:30: ( formPart )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==Ident||LA10_0==27) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:100:31: formPart
            	    {
            	    pushFollow(FOLLOW_formPart_in_ifStatement550);
            	    formPart7=formPart();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) {formParts.add(formPart7);}

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


            match(input,32,FOLLOW_32_in_ifStatement556); if (state.failed) return result;

            if ( state.backtracking==0 ) {result = new If(new Ident((Ident8!=null?Ident8.getText():null)), formParts);}

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



    // $ANTLR start "question"
    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:103:1: question returns [Question result] : Ident ':' String returnType ;
    public final Question question() throws RecognitionException {
        Question result = null;

        int question_StartIndex = input.index();

        Token String9=null;
        Type returnType10 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

            // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:104:5: ( Ident ':' String returnType )
            // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:104:7: Ident ':' String returnType
            {
            match(input,Ident,FOLLOW_Ident_in_question582); if (state.failed) return result;

            match(input,19,FOLLOW_19_in_question584); if (state.failed) return result;

            String9=(Token)match(input,String,FOLLOW_String_in_question586); if (state.failed) return result;

            pushFollow(FOLLOW_returnType_in_question588);
            returnType10=returnType();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) {result = new Question((String9!=null?String9.getText():null), returnType10);}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 11, question_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "question"



    // $ANTLR start "returnType"
    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:107:1: returnType returns [Type result] : ( 'boolean' | 'money(' orExpr ')' | 'money' );
    public final Type returnType() throws RecognitionException {
        Type result = null;

        int returnType_StartIndex = input.index();

        Expr orExpr11 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }

            // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:108:5: ( 'boolean' | 'money(' orExpr ')' | 'money' )
            int alt11=3;
            switch ( input.LA(1) ) {
            case 25:
                {
                alt11=1;
                }
                break;
            case 29:
                {
                alt11=2;
                }
                break;
            case 28:
                {
                alt11=3;
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
                    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:108:7: 'boolean'
                    {
                    match(input,25,FOLLOW_25_in_returnType616); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new BoolType(false); }

                    }
                    break;
                case 2 :
                    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:109:7: 'money(' orExpr ')'
                    {
                    match(input,29,FOLLOW_29_in_returnType626); if (state.failed) return result;

                    pushFollow(FOLLOW_orExpr_in_returnType628);
                    orExpr11=orExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,14,FOLLOW_14_in_returnType630); if (state.failed) return result;

                    if ( state.backtracking==0 ) {result = new Money(orExpr11);}

                    }
                    break;
                case 3 :
                    // C:\\Users\\Jeremy\\Documents\\GitHub\\sea-of-ql\\jeremyklamer\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:110:7: 'money'
                    {
                    match(input,28,FOLLOW_28_in_returnType641); if (state.failed) return result;

                    if ( state.backtracking==0 ) {result = new Money();}

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
            if ( state.backtracking>0 ) { memoize(input, 12, returnType_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "returnType"

    // Delegated rules


 

    public static final BitSet FOLLOW_Int_in_primary47 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_primary57 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_primary65 = new BitSet(new long[]{0x00000000000324C0L});
    public static final BitSet FOLLOW_orExpr_in_primary69 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_primary71 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_unExpr97 = new BitSet(new long[]{0x00000000000324C0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_unExpr112 = new BitSet(new long[]{0x00000000000324C0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_unExpr127 = new BitSet(new long[]{0x00000000000324C0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_unExpr144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr183 = new BitSet(new long[]{0x0000000000048002L});
    public static final BitSet FOLLOW_set_in_mulExpr191 = new BitSet(new long[]{0x00000000000324C0L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr203 = new BitSet(new long[]{0x0000000000048002L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr245 = new BitSet(new long[]{0x0000000000030002L});
    public static final BitSet FOLLOW_set_in_addExpr253 = new BitSet(new long[]{0x00000000000324C0L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr263 = new BitSet(new long[]{0x0000000000030002L});
    public static final BitSet FOLLOW_addExpr_in_relExpr299 = new BitSet(new long[]{0x0000000001F00802L});
    public static final BitSet FOLLOW_set_in_relExpr307 = new BitSet(new long[]{0x00000000000324C0L});
    public static final BitSet FOLLOW_addExpr_in_relExpr323 = new BitSet(new long[]{0x0000000001F00802L});
    public static final BitSet FOLLOW_relExpr_in_andExpr362 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_12_in_andExpr368 = new BitSet(new long[]{0x00000000000324C0L});
    public static final BitSet FOLLOW_relExpr_in_andExpr372 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_andExpr_in_orExpr408 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_orExpr414 = new BitSet(new long[]{0x00000000000324C0L});
    public static final BitSet FOLLOW_andExpr_in_orExpr418 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_26_in_form454 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_Ident_in_form456 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_form458 = new BitSet(new long[]{0x0000000008000040L});
    public static final BitSet FOLLOW_formPart_in_form461 = new BitSet(new long[]{0x0000000108000040L});
    public static final BitSet FOLLOW_32_in_form467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_question_in_formPart494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStatement_in_formPart504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ifStatement539 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ifStatement541 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_Ident_in_ifStatement543 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ifStatement545 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ifStatement547 = new BitSet(new long[]{0x0000000008000040L});
    public static final BitSet FOLLOW_formPart_in_ifStatement550 = new BitSet(new long[]{0x0000000108000040L});
    public static final BitSet FOLLOW_32_in_ifStatement556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_question582 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_question584 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_String_in_question586 = new BitSet(new long[]{0x0000000032000000L});
    public static final BitSet FOLLOW_returnType_in_question588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_returnType616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_returnType626 = new BitSet(new long[]{0x00000000000324C0L});
    public static final BitSet FOLLOW_orExpr_in_returnType628 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_returnType630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_returnType641 = new BitSet(new long[]{0x0000000000000002L});

}