// $ANTLR 3.4 C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g 2013-01-20 16:19:08

	package org.uva.sea.ql.parser.antlr;
	import org.uva.sea.ql.ast.*;
	import org.uva.sea.ql.ast.expressions.*;
	import org.uva.sea.ql.ast.literals.*;
	import org.uva.sea.ql.ast.statements.*;
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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Bool", "COMMENT", "Ident", "Int", "NEWLINE", "String", "WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", "'/'", "':'", "'<'", "'<='", "'=='", "'>'", "'>='", "'bool'", "'else'", "'form'", "'if'", "'int'", "'string'", "'{'", "'||'", "'}'"
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
    public static final int Bool=4;
    public static final int COMMENT=5;
    public static final int Ident=6;
    public static final int Int=7;
    public static final int NEWLINE=8;
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
        this.state.ruleMemo = new HashMap[40+1];
         

    }

    public String[] getTokenNames() { return QLParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g"; }



    // $ANTLR start "primary"
    // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:19:1: primary returns [Expr result] : ( Int | Ident | Bool | '(' x= orExpr ')' );
    public final Expr primary() throws RecognitionException {
        Expr result = null;

        int primary_StartIndex = input.index();

        Token Int1=null;
        Token Ident2=null;
        Token Bool3=null;
        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:20:3: ( Int | Ident | Bool | '(' x= orExpr ')' )
            int alt1=4;
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
            case Bool:
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
                    // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:20:5: Int
                    {
                    Int1=(Token)match(input,Int,FOLLOW_Int_in_primary46); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Int(Integer.parseInt((Int1!=null?Int1.getText():null))); }

                    }
                    break;
                case 2 :
                    // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:21:5: Ident
                    {
                    Ident2=(Token)match(input,Ident,FOLLOW_Ident_in_primary56); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Ident((Ident2!=null?Ident2.getText():null)); }

                    }
                    break;
                case 3 :
                    // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:22:5: Bool
                    {
                    Bool3=(Token)match(input,Bool,FOLLOW_Bool_in_primary64); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new BooleanLiteral((Bool3!=null?Bool3.getText():null)); }

                    }
                    break;
                case 4 :
                    // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:23:5: '(' x= orExpr ')'
                    {
                    match(input,14,FOLLOW_14_in_primary72); if (state.failed) return result;

                    pushFollow(FOLLOW_orExpr_in_primary76);
                    x=orExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,15,FOLLOW_15_in_primary78); if (state.failed) return result;

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
    // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:25:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
    public final Expr unExpr() throws RecognitionException {
        Expr result = null;

        int unExpr_StartIndex = input.index();

        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:26:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
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
            case Bool:
            case Ident:
            case Int:
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
                    // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:26:7: '+' x= unExpr
                    {
                    match(input,17,FOLLOW_17_in_unExpr99); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr103);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Pos(x); }

                    }
                    break;
                case 2 :
                    // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:27:7: '-' x= unExpr
                    {
                    match(input,18,FOLLOW_18_in_unExpr113); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr117);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Neg(x); }

                    }
                    break;
                case 3 :
                    // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:28:7: '!' x= unExpr
                    {
                    match(input,11,FOLLOW_11_in_unExpr127); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr131);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Not(x); }

                    }
                    break;
                case 4 :
                    // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:29:7: x= primary
                    {
                    pushFollow(FOLLOW_primary_in_unExpr143);
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
    // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:31:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
    public final Expr mulExpr() throws RecognitionException {
        Expr result = null;

        int mulExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:32:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:32:7: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
            {
            pushFollow(FOLLOW_unExpr_in_mulExpr174);
            lhs=unExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:32:43: (op= ( '*' | '/' ) rhs= unExpr )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==16||LA3_0==19) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:32:45: op= ( '*' | '/' ) rhs= unExpr
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


            	    pushFollow(FOLLOW_unExpr_in_mulExpr194);
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
    // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:42:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
    public final Expr addExpr() throws RecognitionException {
        Expr result = null;

        int addExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:43:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:43:7: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
            {
            pushFollow(FOLLOW_mulExpr_in_addExpr227);
            lhs=mulExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:43:44: (op= ( '+' | '-' ) rhs= mulExpr )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= 17 && LA4_0 <= 18)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:43:46: op= ( '+' | '-' ) rhs= mulExpr
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


            	    pushFollow(FOLLOW_mulExpr_in_addExpr245);
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
    // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:53:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
    public final Expr relExpr() throws RecognitionException {
        Expr result = null;

        int relExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:54:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:54:7: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            {
            pushFollow(FOLLOW_addExpr_in_relExpr273);
            lhs=addExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:54:44: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==12||(LA5_0 >= 21 && LA5_0 <= 25)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:54:46: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
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


            	    pushFollow(FOLLOW_addExpr_in_relExpr297);
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
    // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:76:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
    public final Expr andExpr() throws RecognitionException {
        Expr result = null;

        int andExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:77:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:77:7: lhs= relExpr ( '&&' rhs= relExpr )*
            {
            pushFollow(FOLLOW_relExpr_in_andExpr328);
            lhs=relExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:77:44: ( '&&' rhs= relExpr )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==13) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:77:46: '&&' rhs= relExpr
            	    {
            	    match(input,13,FOLLOW_13_in_andExpr334); if (state.failed) return result;

            	    pushFollow(FOLLOW_relExpr_in_andExpr338);
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
    // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:79:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
    public final Expr orExpr() throws RecognitionException {
        Expr result = null;

        int orExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:80:5: (lhs= andExpr ( '||' rhs= andExpr )* )
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:80:7: lhs= andExpr ( '||' rhs= andExpr )*
            {
            pushFollow(FOLLOW_andExpr_in_orExpr365);
            lhs=andExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = lhs; }

            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:80:46: ( '||' rhs= andExpr )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==33) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:80:48: '||' rhs= andExpr
            	    {
            	    match(input,33,FOLLOW_33_in_orExpr371); if (state.failed) return result;

            	    pushFollow(FOLLOW_andExpr_in_orExpr375);
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
    // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:82:1: form returns [Form result] : 'form' Ident b= block ;
    public final Form form() throws RecognitionException {
        Form result = null;

        int form_StartIndex = input.index();

        Token Ident4=null;
        Block b =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:83:2: ( 'form' Ident b= block )
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:83:4: 'form' Ident b= block
            {
            match(input,28,FOLLOW_28_in_form393); if (state.failed) return result;

            Ident4=(Token)match(input,Ident,FOLLOW_Ident_in_form395); if (state.failed) return result;

            pushFollow(FOLLOW_block_in_form399);
            b=block();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) {result = new Form(new Ident((Ident4!=null?Ident4.getText():null)), b);}

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



    // $ANTLR start "block"
    // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:85:1: block returns [Block result] : '{' (s= statement )* '}' ;
    public final Block block() throws RecognitionException {
        Block result = null;

        int block_StartIndex = input.index();

        Statement s =null;



        		List<Statement> statements = new ArrayList<Statement>();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:90:2: ( '{' (s= statement )* '}' )
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:90:4: '{' (s= statement )* '}'
            {
            match(input,32,FOLLOW_32_in_block421); if (state.failed) return result;

            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:90:8: (s= statement )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==Ident||LA8_0==29||LA8_0==32) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:90:9: s= statement
            	    {
            	    pushFollow(FOLLOW_statement_in_block426);
            	    s=statement();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) {statements.add(s);}

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            match(input,34,FOLLOW_34_in_block432); if (state.failed) return result;

            if ( state.backtracking==0 ) {result = new Block(statements);}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 9, block_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "block"



    // $ANTLR start "statement"
    // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:92:1: statement returns [Statement result] : (i= ifStatement |b= block |q= question );
    public final Statement statement() throws RecognitionException {
        Statement result = null;

        int statement_StartIndex = input.index();

        IfThenElse i =null;

        Block b =null;

        Question q =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:93:4: (i= ifStatement |b= block |q= question )
            int alt9=3;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt9=1;
                }
                break;
            case 32:
                {
                alt9=2;
                }
                break;
            case Ident:
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
                    // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:93:6: i= ifStatement
                    {
                    pushFollow(FOLLOW_ifStatement_in_statement451);
                    i=ifStatement();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) {result = i;}

                    }
                    break;
                case 2 :
                    // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:94:6: b= block
                    {
                    pushFollow(FOLLOW_block_in_statement462);
                    b=block();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) {result = b;}

                    }
                    break;
                case 3 :
                    // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:95:6: q= question
                    {
                    pushFollow(FOLLOW_question_in_statement473);
                    q=question();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) {result = q;}

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
            if ( state.backtracking>0 ) { memoize(input, 10, statement_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "statement"



    // $ANTLR start "question"
    // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:98:1: question returns [Question result] : (c= computedQuestion |n= normalQuestion ) ;
    public final Question question() throws RecognitionException {
        Question result = null;

        int question_StartIndex = input.index();

        ComputedQuestion c =null;

        Question n =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:99:2: ( (c= computedQuestion |n= normalQuestion ) )
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:99:4: (c= computedQuestion |n= normalQuestion )
            {
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:99:4: (c= computedQuestion |n= normalQuestion )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==Ident) ) {
                int LA10_1 = input.LA(2);

                if ( (LA10_1==20) ) {
                    int LA10_2 = input.LA(3);

                    if ( (LA10_2==String) ) {
                        switch ( input.LA(4) ) {
                        case 30:
                            {
                            int LA10_4 = input.LA(5);

                            if ( (LA10_4==14) ) {
                                alt10=1;
                            }
                            else if ( (LA10_4==EOF||LA10_4==Ident||LA10_4==29||LA10_4==32||LA10_4==34) ) {
                                alt10=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return result;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 10, 4, input);

                                throw nvae;

                            }
                            }
                            break;
                        case 26:
                            {
                            int LA10_5 = input.LA(5);

                            if ( (LA10_5==14) ) {
                                alt10=1;
                            }
                            else if ( (LA10_5==EOF||LA10_5==Ident||LA10_5==29||LA10_5==32||LA10_5==34) ) {
                                alt10=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return result;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 10, 5, input);

                                throw nvae;

                            }
                            }
                            break;
                        case 31:
                            {
                            int LA10_6 = input.LA(5);

                            if ( (LA10_6==14) ) {
                                alt10=1;
                            }
                            else if ( (LA10_6==EOF||LA10_6==Ident||LA10_6==29||LA10_6==32||LA10_6==34) ) {
                                alt10=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return result;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 10, 6, input);

                                throw nvae;

                            }
                            }
                            break;
                        default:
                            if (state.backtracking>0) {state.failed=true; return result;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 10, 3, input);

                            throw nvae;

                        }

                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return result;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 10, 2, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return result;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;

            }
            switch (alt10) {
                case 1 :
                    // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:99:5: c= computedQuestion
                    {
                    pushFollow(FOLLOW_computedQuestion_in_question495);
                    c=computedQuestion();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) {result =c;}

                    }
                    break;
                case 2 :
                    // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:99:39: n= normalQuestion
                    {
                    pushFollow(FOLLOW_normalQuestion_in_question503);
                    n=normalQuestion();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) {result =n;}

                    }
                    break;

            }


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



    // $ANTLR start "normalQuestion"
    // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:101:1: normalQuestion returns [Question result] : Ident ':' String t= type ;
    public final Question normalQuestion() throws RecognitionException {
        Question result = null;

        int normalQuestion_StartIndex = input.index();

        Token Ident5=null;
        Token String6=null;
        Type t =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }

            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:102:2: ( Ident ':' String t= type )
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:102:4: Ident ':' String t= type
            {
            Ident5=(Token)match(input,Ident,FOLLOW_Ident_in_normalQuestion519); if (state.failed) return result;

            match(input,20,FOLLOW_20_in_normalQuestion521); if (state.failed) return result;

            String6=(Token)match(input,String,FOLLOW_String_in_normalQuestion523); if (state.failed) return result;

            pushFollow(FOLLOW_type_in_normalQuestion527);
            t=type();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new Question(new Ident((Ident5!=null?Ident5.getText():null)), new StringLiteral((String6!=null?String6.getText():null)), t); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 12, normalQuestion_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "normalQuestion"



    // $ANTLR start "computedQuestion"
    // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:105:1: computedQuestion returns [ComputedQuestion result] : Ident ':' String t= type '(' exp= orExpr ')' ;
    public final ComputedQuestion computedQuestion() throws RecognitionException {
        ComputedQuestion result = null;

        int computedQuestion_StartIndex = input.index();

        Token Ident7=null;
        Token String8=null;
        Type t =null;

        Expr exp =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return result; }

            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:106:2: ( Ident ':' String t= type '(' exp= orExpr ')' )
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:106:4: Ident ':' String t= type '(' exp= orExpr ')'
            {
            Ident7=(Token)match(input,Ident,FOLLOW_Ident_in_computedQuestion545); if (state.failed) return result;

            match(input,20,FOLLOW_20_in_computedQuestion547); if (state.failed) return result;

            String8=(Token)match(input,String,FOLLOW_String_in_computedQuestion549); if (state.failed) return result;

            pushFollow(FOLLOW_type_in_computedQuestion553);
            t=type();

            state._fsp--;
            if (state.failed) return result;

            match(input,14,FOLLOW_14_in_computedQuestion555); if (state.failed) return result;

            pushFollow(FOLLOW_orExpr_in_computedQuestion559);
            exp=orExpr();

            state._fsp--;
            if (state.failed) return result;

            match(input,15,FOLLOW_15_in_computedQuestion561); if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new ComputedQuestion(new Ident((Ident7!=null?Ident7.getText():null)), new StringLiteral((String8!=null?String8.getText():null)), t, exp);}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 13, computedQuestion_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "computedQuestion"



    // $ANTLR start "type"
    // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:109:1: type returns [Type result] : ( 'int' | 'bool' | 'string' );
    public final Type type() throws RecognitionException {
        Type result = null;

        int type_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return result; }

            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:110:2: ( 'int' | 'bool' | 'string' )
            int alt11=3;
            switch ( input.LA(1) ) {
            case 30:
                {
                alt11=1;
                }
                break;
            case 26:
                {
                alt11=2;
                }
                break;
            case 31:
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
                    // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:110:4: 'int'
                    {
                    match(input,30,FOLLOW_30_in_type579); if (state.failed) return result;

                    if ( state.backtracking==0 ) {result = new IntType();}

                    }
                    break;
                case 2 :
                    // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:111:4: 'bool'
                    {
                    match(input,26,FOLLOW_26_in_type587); if (state.failed) return result;

                    if ( state.backtracking==0 ) {result = new BoolType();}

                    }
                    break;
                case 3 :
                    // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:112:4: 'string'
                    {
                    match(input,31,FOLLOW_31_in_type595); if (state.failed) return result;

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
            if ( state.backtracking>0 ) { memoize(input, 14, type_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "type"



    // $ANTLR start "ifStatement"
    // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:114:1: ifStatement returns [IfThenElse result] : 'if' '(' cond= orExpr ')' body= block ( 'else' elseBody= block )? ;
    public final IfThenElse ifStatement() throws RecognitionException {
        IfThenElse result = null;

        int ifStatement_StartIndex = input.index();

        Expr cond =null;

        Block body =null;

        Block elseBody =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return result; }

            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:115:2: ( 'if' '(' cond= orExpr ')' body= block ( 'else' elseBody= block )? )
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:115:4: 'if' '(' cond= orExpr ')' body= block ( 'else' elseBody= block )?
            {
            match(input,29,FOLLOW_29_in_ifStatement610); if (state.failed) return result;

            match(input,14,FOLLOW_14_in_ifStatement612); if (state.failed) return result;

            pushFollow(FOLLOW_orExpr_in_ifStatement616);
            cond=orExpr();

            state._fsp--;
            if (state.failed) return result;

            match(input,15,FOLLOW_15_in_ifStatement618); if (state.failed) return result;

            pushFollow(FOLLOW_block_in_ifStatement622);
            body=block();

            state._fsp--;
            if (state.failed) return result;

            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:115:40: ( 'else' elseBody= block )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==27) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:115:41: 'else' elseBody= block
                    {
                    match(input,27,FOLLOW_27_in_ifStatement625); if (state.failed) return result;

                    pushFollow(FOLLOW_block_in_ifStatement629);
                    elseBody=block();

                    state._fsp--;
                    if (state.failed) return result;

                    }
                    break;

            }


            if ( state.backtracking==0 ) { result = new IfThenElse(cond, body, elseBody); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 15, ifStatement_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "ifStatement"

    // Delegated rules


 

    public static final BitSet FOLLOW_Int_in_primary46 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_primary56 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Bool_in_primary64 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_primary72 = new BitSet(new long[]{0x00000000000648D0L});
    public static final BitSet FOLLOW_orExpr_in_primary76 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_primary78 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_unExpr99 = new BitSet(new long[]{0x00000000000648D0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_unExpr113 = new BitSet(new long[]{0x00000000000648D0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_unExpr127 = new BitSet(new long[]{0x00000000000648D0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_unExpr143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr174 = new BitSet(new long[]{0x0000000000090002L});
    public static final BitSet FOLLOW_set_in_mulExpr182 = new BitSet(new long[]{0x00000000000648D0L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr194 = new BitSet(new long[]{0x0000000000090002L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr227 = new BitSet(new long[]{0x0000000000060002L});
    public static final BitSet FOLLOW_set_in_addExpr235 = new BitSet(new long[]{0x00000000000648D0L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr245 = new BitSet(new long[]{0x0000000000060002L});
    public static final BitSet FOLLOW_addExpr_in_relExpr273 = new BitSet(new long[]{0x0000000003E01002L});
    public static final BitSet FOLLOW_set_in_relExpr281 = new BitSet(new long[]{0x00000000000648D0L});
    public static final BitSet FOLLOW_addExpr_in_relExpr297 = new BitSet(new long[]{0x0000000003E01002L});
    public static final BitSet FOLLOW_relExpr_in_andExpr328 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_andExpr334 = new BitSet(new long[]{0x00000000000648D0L});
    public static final BitSet FOLLOW_relExpr_in_andExpr338 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_andExpr_in_orExpr365 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_orExpr371 = new BitSet(new long[]{0x00000000000648D0L});
    public static final BitSet FOLLOW_andExpr_in_orExpr375 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_28_in_form393 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_Ident_in_form395 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_block_in_form399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_block421 = new BitSet(new long[]{0x0000000520000040L});
    public static final BitSet FOLLOW_statement_in_block426 = new BitSet(new long[]{0x0000000520000040L});
    public static final BitSet FOLLOW_34_in_block432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStatement_in_statement451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_statement462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_question_in_statement473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_computedQuestion_in_question495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_normalQuestion_in_question503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_normalQuestion519 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_normalQuestion521 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_String_in_normalQuestion523 = new BitSet(new long[]{0x00000000C4000000L});
    public static final BitSet FOLLOW_type_in_normalQuestion527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_computedQuestion545 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_computedQuestion547 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_String_in_computedQuestion549 = new BitSet(new long[]{0x00000000C4000000L});
    public static final BitSet FOLLOW_type_in_computedQuestion553 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_computedQuestion555 = new BitSet(new long[]{0x00000000000648D0L});
    public static final BitSet FOLLOW_orExpr_in_computedQuestion559 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_computedQuestion561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_type579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_type587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_type595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ifStatement610 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ifStatement612 = new BitSet(new long[]{0x00000000000648D0L});
    public static final BitSet FOLLOW_orExpr_in_ifStatement616 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ifStatement618 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_block_in_ifStatement622 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_ifStatement625 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_block_in_ifStatement629 = new BitSet(new long[]{0x0000000000000002L});

}