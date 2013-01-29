// $ANTLR 3.4 QL.g 2013-01-29 15:49:30

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMENT", "Ident", "Int", "Str", "WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", "'/'", "':'", "'<'", "'<='", "'=='", "'>'", "'>='", "'form'", "'{'", "'||'", "'}'"
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
        this.state.ruleMemo = new HashMap[28+1];
         

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
            match(input,24,FOLLOW_24_in_form59); if (state.failed) return result;

            Ident1=(Token)match(input,Ident,FOLLOW_Ident_in_form61); if (state.failed) return result;

            match(input,25,FOLLOW_25_in_form63); if (state.failed) return result;

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


            match(input,27,FOLLOW_27_in_form74); if (state.failed) return result;

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
    // QL.g:31:1: ding returns [Ding result] : Ident ':' Str ;
    public final Ding ding() throws RecognitionException {
        Ding result = null;

        int ding_StartIndex = input.index();

        Token Ident2=null;
        Token Str3=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

            // QL.g:32:2: ( Ident ':' Str )
            // QL.g:32:4: Ident ':' Str
            {
            Ident2=(Token)match(input,Ident,FOLLOW_Ident_in_ding94); if (state.failed) return result;

            match(input,18,FOLLOW_18_in_ding96); if (state.failed) return result;

            Str3=(Token)match(input,Str,FOLLOW_Str_in_ding98); if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new Ding(new Ident((Ident2!=null?Ident2.getText():null)), (Str3!=null?Str3.getText():null)); }

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



    // $ANTLR start "primary"
    // QL.g:35:1: primary returns [Expr result] : ( Int | Ident | Str | '(' x= orExpr ')' );
    public final Expr primary() throws RecognitionException {
        Expr result = null;

        int primary_StartIndex = input.index();

        Token Int4=null;
        Token Ident5=null;
        Token Str6=null;
        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

            // QL.g:36:3: ( Int | Ident | Str | '(' x= orExpr ')' )
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
                    // QL.g:36:5: Int
                    {
                    Int4=(Token)match(input,Int,FOLLOW_Int_in_primary116); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Int(Integer.parseInt((Int4!=null?Int4.getText():null))); }

                    }
                    break;
                case 2 :
                    // QL.g:37:5: Ident
                    {
                    Ident5=(Token)match(input,Ident,FOLLOW_Ident_in_primary126); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Ident((Ident5!=null?Ident5.getText():null)); }

                    }
                    break;
                case 3 :
                    // QL.g:38:5: Str
                    {
                    Str6=(Token)match(input,Str,FOLLOW_Str_in_primary134); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Str((Str6!=null?Str6.getText():null)); }

                    }
                    break;
                case 4 :
                    // QL.g:39:5: '(' x= orExpr ')'
                    {
                    match(input,12,FOLLOW_12_in_primary144); if (state.failed) return result;

                    pushFollow(FOLLOW_orExpr_in_primary148);
                    x=orExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,13,FOLLOW_13_in_primary150); if (state.failed) return result;

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
    // QL.g:42:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
    public final Expr unExpr() throws RecognitionException {
        Expr result = null;

        int unExpr_StartIndex = input.index();

        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

            // QL.g:43:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
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
                    // QL.g:43:8: '+' x= unExpr
                    {
                    match(input,15,FOLLOW_15_in_unExpr175); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr179);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Pos(x); }

                    }
                    break;
                case 2 :
                    // QL.g:44:8: '-' x= unExpr
                    {
                    match(input,16,FOLLOW_16_in_unExpr190); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr194);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Neg(x); }

                    }
                    break;
                case 3 :
                    // QL.g:45:8: '!' x= unExpr
                    {
                    match(input,9,FOLLOW_9_in_unExpr205); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr209);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Not(x); }

                    }
                    break;
                case 4 :
                    // QL.g:46:8: x= primary
                    {
                    pushFollow(FOLLOW_primary_in_unExpr222);
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
    // QL.g:49:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
    public final Expr mulExpr() throws RecognitionException {
        Expr result = null;

        int mulExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

            // QL.g:50:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
            // QL.g:50:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
            {
            pushFollow(FOLLOW_unExpr_in_mulExpr260);
            lhs=unExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // QL.g:50:45: (op= ( '*' | '/' ) rhs= unExpr )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==14||LA4_0==17) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // QL.g:50:47: op= ( '*' | '/' ) rhs= unExpr
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


            	    pushFollow(FOLLOW_unExpr_in_mulExpr280);
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
            if ( state.backtracking>0 ) { memoize(input, 5, mulExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "mulExpr"



    // $ANTLR start "addExpr"
    // QL.g:62:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
    public final Expr addExpr() throws RecognitionException {
        Expr result = null;

        int addExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

            // QL.g:63:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
            // QL.g:63:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
            {
            pushFollow(FOLLOW_mulExpr_in_addExpr321);
            lhs=mulExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // QL.g:63:46: (op= ( '+' | '-' ) rhs= mulExpr )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0 >= 15 && LA5_0 <= 16)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // QL.g:63:48: op= ( '+' | '-' ) rhs= mulExpr
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


            	    pushFollow(FOLLOW_mulExpr_in_addExpr339);
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
            if ( state.backtracking>0 ) { memoize(input, 6, addExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "addExpr"



    // $ANTLR start "relExpr"
    // QL.g:74:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
    public final Expr relExpr() throws RecognitionException {
        Expr result = null;

        int relExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

            // QL.g:75:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
            // QL.g:75:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            {
            pushFollow(FOLLOW_addExpr_in_relExpr374);
            lhs=addExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // QL.g:75:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==10||(LA6_0 >= 19 && LA6_0 <= 23)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // QL.g:75:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
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


            	    pushFollow(FOLLOW_addExpr_in_relExpr398);
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
            if ( state.backtracking>0 ) { memoize(input, 7, relExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "relExpr"



    // $ANTLR start "andExpr"
    // QL.g:98:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
    public final Expr andExpr() throws RecognitionException {
        Expr result = null;

        int andExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

            // QL.g:99:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
            // QL.g:99:9: lhs= relExpr ( '&&' rhs= relExpr )*
            {
            pushFollow(FOLLOW_relExpr_in_andExpr436);
            lhs=relExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // QL.g:99:46: ( '&&' rhs= relExpr )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==11) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // QL.g:99:48: '&&' rhs= relExpr
            	    {
            	    match(input,11,FOLLOW_11_in_andExpr442); if (state.failed) return result;

            	    pushFollow(FOLLOW_relExpr_in_andExpr446);
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
            if ( state.backtracking>0 ) { memoize(input, 8, andExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "andExpr"



    // $ANTLR start "orExpr"
    // QL.g:103:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
    public final Expr orExpr() throws RecognitionException {
        Expr result = null;

        int orExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

            // QL.g:104:5: (lhs= andExpr ( '||' rhs= andExpr )* )
            // QL.g:104:9: lhs= andExpr ( '||' rhs= andExpr )*
            {
            pushFollow(FOLLOW_andExpr_in_orExpr481);
            lhs=andExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = lhs; }

            // QL.g:104:48: ( '||' rhs= andExpr )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==26) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // QL.g:104:50: '||' rhs= andExpr
            	    {
            	    match(input,26,FOLLOW_26_in_orExpr487); if (state.failed) return result;

            	    pushFollow(FOLLOW_andExpr_in_orExpr491);
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
            if ( state.backtracking>0 ) { memoize(input, 9, orExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "orExpr"

    // Delegated rules


 

    public static final BitSet FOLLOW_24_in_form59 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_Ident_in_form61 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_form63 = new BitSet(new long[]{0x0000000008000020L});
    public static final BitSet FOLLOW_ding_in_form68 = new BitSet(new long[]{0x0000000008000020L});
    public static final BitSet FOLLOW_27_in_form74 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_form76 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_ding94 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ding96 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_Str_in_ding98 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Int_in_primary116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_primary126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Str_in_primary134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_primary144 = new BitSet(new long[]{0x00000000000192E0L});
    public static final BitSet FOLLOW_orExpr_in_primary148 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_primary150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_unExpr175 = new BitSet(new long[]{0x00000000000192E0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_unExpr190 = new BitSet(new long[]{0x00000000000192E0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_9_in_unExpr205 = new BitSet(new long[]{0x00000000000192E0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_unExpr222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr260 = new BitSet(new long[]{0x0000000000024002L});
    public static final BitSet FOLLOW_set_in_mulExpr268 = new BitSet(new long[]{0x00000000000192E0L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr280 = new BitSet(new long[]{0x0000000000024002L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr321 = new BitSet(new long[]{0x0000000000018002L});
    public static final BitSet FOLLOW_set_in_addExpr329 = new BitSet(new long[]{0x00000000000192E0L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr339 = new BitSet(new long[]{0x0000000000018002L});
    public static final BitSet FOLLOW_addExpr_in_relExpr374 = new BitSet(new long[]{0x0000000000F80402L});
    public static final BitSet FOLLOW_set_in_relExpr382 = new BitSet(new long[]{0x00000000000192E0L});
    public static final BitSet FOLLOW_addExpr_in_relExpr398 = new BitSet(new long[]{0x0000000000F80402L});
    public static final BitSet FOLLOW_relExpr_in_andExpr436 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_11_in_andExpr442 = new BitSet(new long[]{0x00000000000192E0L});
    public static final BitSet FOLLOW_relExpr_in_andExpr446 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_andExpr_in_orExpr481 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_orExpr487 = new BitSet(new long[]{0x00000000000192E0L});
    public static final BitSet FOLLOW_andExpr_in_orExpr491 = new BitSet(new long[]{0x0000000004000002L});

}