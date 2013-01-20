// $ANTLR 3.4 C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g 2013-01-20 16:59:33

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class QLParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "BOOLEAN", "COMMENT", "IDENT", "INT", "STRING_LITERAL", "WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", "'/'", "':'", "'<'", "'<='", "'=='", "'>'", "'>='", "'boolean'", "'money'", "'||'"
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
        this.state.ruleMemo = new HashMap[28+1];
         

    }

    public String[] getTokenNames() { return QLParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g"; }



    // $ANTLR start "question"
    // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:27:1: question : IDENT ':' STRING_LITERAL x= type ;
    public final void question() throws RecognitionException {
        int question_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return ; }

            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:28:2: ( IDENT ':' STRING_LITERAL x= type )
            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:28:4: IDENT ':' STRING_LITERAL x= type
            {
            match(input,IDENT,FOLLOW_IDENT_in_question44); if (state.failed) return ;

            match(input,19,FOLLOW_19_in_question46); if (state.failed) return ;

            match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_question48); if (state.failed) return ;

            pushFollow(FOLLOW_type_in_question52);
            type();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 1, question_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "question"



    // $ANTLR start "type"
    // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:31:1: type : (| 'boolean' | 'money' );
    public final void type() throws RecognitionException {
        int type_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return ; }

            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:32:2: (| 'boolean' | 'money' )
            int alt1=3;
            switch ( input.LA(1) ) {
            case EOF:
                {
                alt1=1;
                }
                break;
            case 25:
                {
                alt1=2;
                }
                break;
            case 26:
                {
                alt1=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;

            }

            switch (alt1) {
                case 1 :
                    // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:33:2: 
                    {
                    }
                    break;
                case 2 :
                    // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:33:4: 'boolean'
                    {
                    match(input,25,FOLLOW_25_in_type67); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:34:4: 'money'
                    {
                    match(input,26,FOLLOW_26_in_type72); if (state.failed) return ;

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
            if ( state.backtracking>0 ) { memoize(input, 2, type_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "type"



    // $ANTLR start "primary"
    // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:37:1: primary returns [Expr result] : ( INT | IDENT | '(' x= orExpr ')' );
    public final Expr primary() throws RecognitionException {
        Expr result = null;

        int primary_StartIndex = input.index();

        Token INT1=null;
        Token IDENT2=null;
        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:38:4: ( INT | IDENT | '(' x= orExpr ')' )
            int alt2=3;
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
            case 13:
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
                    // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:38:6: INT
                    {
                    INT1=(Token)match(input,INT,FOLLOW_INT_in_primary90); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Int(Integer.parseInt((INT1!=null?INT1.getText():null))); }

                    }
                    break;
                case 2 :
                    // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:39:6: IDENT
                    {
                    IDENT2=(Token)match(input,IDENT,FOLLOW_IDENT_in_primary101); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Ident((IDENT2!=null?IDENT2.getText():null)); }

                    }
                    break;
                case 3 :
                    // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:40:6: '(' x= orExpr ')'
                    {
                    match(input,13,FOLLOW_13_in_primary110); if (state.failed) return result;

                    pushFollow(FOLLOW_orExpr_in_primary114);
                    x=orExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,14,FOLLOW_14_in_primary116); if (state.failed) return result;

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
    // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:43:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
    public final Expr unExpr() throws RecognitionException {
        Expr result = null;

        int unExpr_StartIndex = input.index();

        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:44:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
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
                    // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:44:8: '+' x= unExpr
                    {
                    match(input,16,FOLLOW_16_in_unExpr142); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr146);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Pos(x); }

                    }
                    break;
                case 2 :
                    // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:45:8: '-' x= unExpr
                    {
                    match(input,17,FOLLOW_17_in_unExpr157); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr161);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Neg(x); }

                    }
                    break;
                case 3 :
                    // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:46:8: '!' x= unExpr
                    {
                    match(input,10,FOLLOW_10_in_unExpr172); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr176);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Not(x); }

                    }
                    break;
                case 4 :
                    // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:47:8: x= primary
                    {
                    pushFollow(FOLLOW_primary_in_unExpr189);
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
    // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:50:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
    public final Expr mulExpr() throws RecognitionException {
        Expr result = null;

        int mulExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:51:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:51:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
            {
            pushFollow(FOLLOW_unExpr_in_mulExpr227);
            lhs=unExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:51:45: (op= ( '*' | '/' ) rhs= unExpr )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==15||LA4_0==18) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:51:47: op= ( '*' | '/' ) rhs= unExpr
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


            	    pushFollow(FOLLOW_unExpr_in_mulExpr247);
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
            if ( state.backtracking>0 ) { memoize(input, 5, mulExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "mulExpr"



    // $ANTLR start "addExpr"
    // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:63:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
    public final Expr addExpr() throws RecognitionException {
        Expr result = null;

        int addExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:64:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:64:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
            {
            pushFollow(FOLLOW_mulExpr_in_addExpr288);
            lhs=mulExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:64:46: (op= ( '+' | '-' ) rhs= mulExpr )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0 >= 16 && LA5_0 <= 17)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:64:48: op= ( '+' | '-' ) rhs= mulExpr
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


            	    pushFollow(FOLLOW_mulExpr_in_addExpr306);
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
    // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:75:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
    public final Expr relExpr() throws RecognitionException {
        Expr result = null;

        int relExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:76:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:76:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            {
            pushFollow(FOLLOW_addExpr_in_relExpr341);
            lhs=addExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:76:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==11||(LA6_0 >= 20 && LA6_0 <= 24)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:76:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
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


            	    pushFollow(FOLLOW_addExpr_in_relExpr365);
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
    // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:99:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
    public final Expr andExpr() throws RecognitionException {
        Expr result = null;

        int andExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:100:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:100:9: lhs= relExpr ( '&&' rhs= relExpr )*
            {
            pushFollow(FOLLOW_relExpr_in_andExpr403);
            lhs=relExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:100:46: ( '&&' rhs= relExpr )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==12) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:100:48: '&&' rhs= relExpr
            	    {
            	    match(input,12,FOLLOW_12_in_andExpr409); if (state.failed) return result;

            	    pushFollow(FOLLOW_relExpr_in_andExpr413);
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
    // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:104:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
    public final Expr orExpr() throws RecognitionException {
        Expr result = null;

        int orExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:105:5: (lhs= andExpr ( '||' rhs= andExpr )* )
            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:105:9: lhs= andExpr ( '||' rhs= andExpr )*
            {
            pushFollow(FOLLOW_andExpr_in_orExpr448);
            lhs=andExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = lhs; }

            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:105:48: ( '||' rhs= andExpr )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==27) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:105:50: '||' rhs= andExpr
            	    {
            	    match(input,27,FOLLOW_27_in_orExpr454); if (state.failed) return result;

            	    pushFollow(FOLLOW_andExpr_in_orExpr458);
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


 

    public static final BitSet FOLLOW_IDENT_in_question44 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_question46 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_question48 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_type_in_question52 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_type67 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_type72 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_primary90 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_primary101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_primary110 = new BitSet(new long[]{0x00000000000324C0L});
    public static final BitSet FOLLOW_orExpr_in_primary114 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_primary116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_unExpr142 = new BitSet(new long[]{0x00000000000324C0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_unExpr157 = new BitSet(new long[]{0x00000000000324C0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_unExpr172 = new BitSet(new long[]{0x00000000000324C0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_unExpr189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr227 = new BitSet(new long[]{0x0000000000048002L});
    public static final BitSet FOLLOW_set_in_mulExpr235 = new BitSet(new long[]{0x00000000000324C0L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr247 = new BitSet(new long[]{0x0000000000048002L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr288 = new BitSet(new long[]{0x0000000000030002L});
    public static final BitSet FOLLOW_set_in_addExpr296 = new BitSet(new long[]{0x00000000000324C0L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr306 = new BitSet(new long[]{0x0000000000030002L});
    public static final BitSet FOLLOW_addExpr_in_relExpr341 = new BitSet(new long[]{0x0000000001F00802L});
    public static final BitSet FOLLOW_set_in_relExpr349 = new BitSet(new long[]{0x00000000000324C0L});
    public static final BitSet FOLLOW_addExpr_in_relExpr365 = new BitSet(new long[]{0x0000000001F00802L});
    public static final BitSet FOLLOW_relExpr_in_andExpr403 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_12_in_andExpr409 = new BitSet(new long[]{0x00000000000324C0L});
    public static final BitSet FOLLOW_relExpr_in_andExpr413 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_andExpr_in_orExpr448 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_orExpr454 = new BitSet(new long[]{0x00000000000324C0L});
    public static final BitSet FOLLOW_andExpr_in_orExpr458 = new BitSet(new long[]{0x0000000008000002L});

}