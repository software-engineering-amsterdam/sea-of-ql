// $ANTLR 3.4 QL.g 2013-01-31 14:50:48

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.boolexpr.*;
import org.uva.sea.ql.ast.relationalexpr.*;
import org.uva.sea.ql.ast.unaryexpr.*;
import org.uva.sea.ql.ast.binaryexpr.*;
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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMENT", "Ident", "Int", "Str", "WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", "'/'", "':'", "'<'", "'<='", "'=='", "'>'", "'>='", "'boolean'", "'form'", "'{'", "'||'", "'}'"
    };

    public static final int EOF=-1;
    public static final int T__9=9;
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
    public static final int COMMENT=4;
    public static final int Ident=5;
    public static final int Int=6;
    public static final int Str=7;
    public static final int WS=8;

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
        this.state.ruleMemo = new HashMap[29+1];
         

    }

    public String[] getTokenNames() { return QLParser.tokenNames; }
    public String getGrammarFileName() { return "QL.g"; }


        @Override
        public void reportError(RecognitionException e) {
            throw new RuntimeException(e);
        }



    // $ANTLR start "form"
    // QL.g:26:1: form returns [Form result] : 'form' Ident '{' (d= ding )* '}' EOF ;
    public final Form form() throws RecognitionException {
        Form result = null;

        int form_StartIndex = input.index();

        Token Ident1=null;
        Ding d =null;


         List<Ding> list = new ArrayList<Ding>(); 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

            // QL.g:28:2: ( 'form' Ident '{' (d= ding )* '}' EOF )
            // QL.g:28:4: 'form' Ident '{' (d= ding )* '}' EOF
            {
            match(input,25,FOLLOW_25_in_form59); if (state.failed) return result;

            Ident1=(Token)match(input,Ident,FOLLOW_Ident_in_form61); if (state.failed) return result;

            match(input,26,FOLLOW_26_in_form63); if (state.failed) return result;

            // QL.g:28:21: (d= ding )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==Ident) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // QL.g:28:22: d= ding
            	    {
            	    pushFollow(FOLLOW_ding_in_form68);
            	    d=ding();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) {list.add(d);}

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            match(input,28,FOLLOW_28_in_form74); if (state.failed) return result;

            match(input,EOF,FOLLOW_EOF_in_form76); if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new Form(new Ident((Ident1!=null?Ident1.getText():null)), list); }

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



    // $ANTLR start "ding"
    // QL.g:31:1: ding returns [Ding result] : Ident ':' Str type ;
    public final Ding ding() throws RecognitionException {
        Ding result = null;

        int ding_StartIndex = input.index();

        Token Ident2=null;
        Token Str3=null;
        Type type4 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

            // QL.g:32:2: ( Ident ':' Str type )
            // QL.g:32:4: Ident ':' Str type
            {
            Ident2=(Token)match(input,Ident,FOLLOW_Ident_in_ding94); if (state.failed) return result;

            match(input,18,FOLLOW_18_in_ding96); if (state.failed) return result;

            Str3=(Token)match(input,Str,FOLLOW_Str_in_ding98); if (state.failed) return result;

            pushFollow(FOLLOW_type_in_ding100);
            type4=type();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new Ding(new Ident((Ident2!=null?Ident2.getText():null)), new Str((Str3!=null?Str3.getText():null)), type4); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 2, ding_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "ding"



    // $ANTLR start "type"
    // QL.g:35:1: type returns [Type result] : 'boolean' ;
    public final Type type() throws RecognitionException {
        Type result = null;

        int type_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

            // QL.g:36:2: ( 'boolean' )
            // QL.g:36:4: 'boolean'
            {
            match(input,24,FOLLOW_24_in_type117); if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new BoolType(); }

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
    // QL.g:39:1: primary returns [Expr result] : ( Int | Ident | Str | '(' x= orExpr ')' );
    public final Expr primary() throws RecognitionException {
        Expr result = null;

        int primary_StartIndex = input.index();

        Token Int5=null;
        Token Ident6=null;
        Token Str7=null;
        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

            // QL.g:40:3: ( Int | Ident | Str | '(' x= orExpr ')' )
            int alt2=4;
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
            case Str:
                {
                alt2=3;
                }
                break;
            case 12:
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
                    // QL.g:40:5: Int
                    {
                    Int5=(Token)match(input,Int,FOLLOW_Int_in_primary135); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Int(Integer.parseInt((Int5!=null?Int5.getText():null))); }

                    }
                    break;
                case 2 :
                    // QL.g:41:5: Ident
                    {
                    Ident6=(Token)match(input,Ident,FOLLOW_Ident_in_primary145); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Ident((Ident6!=null?Ident6.getText():null)); }

                    }
                    break;
                case 3 :
                    // QL.g:42:5: Str
                    {
                    Str7=(Token)match(input,Str,FOLLOW_Str_in_primary153); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Str((Str7!=null?Str7.getText():null)); }

                    }
                    break;
                case 4 :
                    // QL.g:43:5: '(' x= orExpr ')'
                    {
                    match(input,12,FOLLOW_12_in_primary163); if (state.failed) return result;

                    pushFollow(FOLLOW_orExpr_in_primary167);
                    x=orExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,13,FOLLOW_13_in_primary169); if (state.failed) return result;

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
    // QL.g:46:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
    public final Expr unExpr() throws RecognitionException {
        Expr result = null;

        int unExpr_StartIndex = input.index();

        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

            // QL.g:47:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
            int alt3=4;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt3=1;
                }
                break;
            case 16:
                {
                alt3=2;
                }
                break;
            case 9:
                {
                alt3=3;
                }
                break;
            case Ident:
            case Int:
            case Str:
            case 12:
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
                    // QL.g:47:8: '+' x= unExpr
                    {
                    match(input,15,FOLLOW_15_in_unExpr194); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr198);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Pos(x); }

                    }
                    break;
                case 2 :
                    // QL.g:48:8: '-' x= unExpr
                    {
                    match(input,16,FOLLOW_16_in_unExpr209); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr213);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Neg(x); }

                    }
                    break;
                case 3 :
                    // QL.g:49:8: '!' x= unExpr
                    {
                    match(input,9,FOLLOW_9_in_unExpr224); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr228);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Not(x); }

                    }
                    break;
                case 4 :
                    // QL.g:50:8: x= primary
                    {
                    pushFollow(FOLLOW_primary_in_unExpr241);
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
    // QL.g:53:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
    public final Expr mulExpr() throws RecognitionException {
        Expr result = null;

        int mulExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

            // QL.g:54:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
            // QL.g:54:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
            {
            pushFollow(FOLLOW_unExpr_in_mulExpr279);
            lhs=unExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // QL.g:54:45: (op= ( '*' | '/' ) rhs= unExpr )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==14||LA4_0==17) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // QL.g:54:47: op= ( '*' | '/' ) rhs= unExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( input.LA(1)==14||input.LA(1)==17 ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_unExpr_in_mulExpr299);
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
            if ( state.backtracking>0 ) { memoize(input, 6, mulExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "mulExpr"



    // $ANTLR start "addExpr"
    // QL.g:66:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
    public final Expr addExpr() throws RecognitionException {
        Expr result = null;

        int addExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

            // QL.g:67:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
            // QL.g:67:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
            {
            pushFollow(FOLLOW_mulExpr_in_addExpr340);
            lhs=mulExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // QL.g:67:46: (op= ( '+' | '-' ) rhs= mulExpr )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0 >= 15 && LA5_0 <= 16)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // QL.g:67:48: op= ( '+' | '-' ) rhs= mulExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( (input.LA(1) >= 15 && input.LA(1) <= 16) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_mulExpr_in_addExpr358);
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
    // QL.g:78:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
    public final Expr relExpr() throws RecognitionException {
        Expr result = null;

        int relExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

            // QL.g:79:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
            // QL.g:79:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            {
            pushFollow(FOLLOW_addExpr_in_relExpr393);
            lhs=addExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // QL.g:79:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==10||(LA6_0 >= 19 && LA6_0 <= 23)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // QL.g:79:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( input.LA(1)==10||(input.LA(1) >= 19 && input.LA(1) <= 23) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_addExpr_in_relExpr417);
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
    // QL.g:102:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
    public final Expr andExpr() throws RecognitionException {
        Expr result = null;

        int andExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

            // QL.g:103:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
            // QL.g:103:9: lhs= relExpr ( '&&' rhs= relExpr )*
            {
            pushFollow(FOLLOW_relExpr_in_andExpr455);
            lhs=relExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // QL.g:103:46: ( '&&' rhs= relExpr )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==11) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // QL.g:103:48: '&&' rhs= relExpr
            	    {
            	    match(input,11,FOLLOW_11_in_andExpr461); if (state.failed) return result;

            	    pushFollow(FOLLOW_relExpr_in_andExpr465);
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
    // QL.g:107:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
    public final Expr orExpr() throws RecognitionException {
        Expr result = null;

        int orExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

            // QL.g:108:5: (lhs= andExpr ( '||' rhs= andExpr )* )
            // QL.g:108:9: lhs= andExpr ( '||' rhs= andExpr )*
            {
            pushFollow(FOLLOW_andExpr_in_orExpr500);
            lhs=andExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = lhs; }

            // QL.g:108:48: ( '||' rhs= andExpr )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==27) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // QL.g:108:50: '||' rhs= andExpr
            	    {
            	    match(input,27,FOLLOW_27_in_orExpr506); if (state.failed) return result;

            	    pushFollow(FOLLOW_andExpr_in_orExpr510);
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


 

    public static final BitSet FOLLOW_25_in_form59 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_Ident_in_form61 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_form63 = new BitSet(new long[]{0x0000000010000020L});
    public static final BitSet FOLLOW_ding_in_form68 = new BitSet(new long[]{0x0000000010000020L});
    public static final BitSet FOLLOW_28_in_form74 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_form76 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_ding94 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ding96 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_Str_in_ding98 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_type_in_ding100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_type117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Int_in_primary135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_primary145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Str_in_primary153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_primary163 = new BitSet(new long[]{0x00000000000192E0L});
    public static final BitSet FOLLOW_orExpr_in_primary167 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_primary169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_unExpr194 = new BitSet(new long[]{0x00000000000192E0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_unExpr209 = new BitSet(new long[]{0x00000000000192E0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_9_in_unExpr224 = new BitSet(new long[]{0x00000000000192E0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_unExpr241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr279 = new BitSet(new long[]{0x0000000000024002L});
    public static final BitSet FOLLOW_set_in_mulExpr287 = new BitSet(new long[]{0x00000000000192E0L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr299 = new BitSet(new long[]{0x0000000000024002L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr340 = new BitSet(new long[]{0x0000000000018002L});
    public static final BitSet FOLLOW_set_in_addExpr348 = new BitSet(new long[]{0x00000000000192E0L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr358 = new BitSet(new long[]{0x0000000000018002L});
    public static final BitSet FOLLOW_addExpr_in_relExpr393 = new BitSet(new long[]{0x0000000000F80402L});
    public static final BitSet FOLLOW_set_in_relExpr401 = new BitSet(new long[]{0x00000000000192E0L});
    public static final BitSet FOLLOW_addExpr_in_relExpr417 = new BitSet(new long[]{0x0000000000F80402L});
    public static final BitSet FOLLOW_relExpr_in_andExpr455 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_11_in_andExpr461 = new BitSet(new long[]{0x00000000000192E0L});
    public static final BitSet FOLLOW_relExpr_in_andExpr465 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_andExpr_in_orExpr500 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_orExpr506 = new BitSet(new long[]{0x00000000000192E0L});
    public static final BitSet FOLLOW_andExpr_in_orExpr510 = new BitSet(new long[]{0x0000000008000002L});

}