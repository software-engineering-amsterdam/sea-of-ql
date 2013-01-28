// $ANTLR 3.4 src/org/uva/sea/ql/parser/antlr/QL.g 2013-01-23 22:34:18

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Bool", "Comment", "Ident", "Int", "StringLiteral", "WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", "'/'", "':'", "'<'", "'<='", "'=='", "'>'", "'>='", "'Boolean'", "'Integer'", "'StringLiteral'", "'form'", "'if'", "'{'", "'||'", "'}'"
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
    public static final int Bool=4;
    public static final int Comment=5;
    public static final int Ident=6;
    public static final int Int=7;
    public static final int StringLiteral=8;
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
        this.state.ruleMemo = new HashMap[38+1];
         

    }

    public String[] getTokenNames() { return QLParser.tokenNames; }
    public String getGrammarFileName() { return "src/org/uva/sea/ql/parser/antlr/QL.g"; }



    // $ANTLR start "form"
    // src/org/uva/sea/ql/parser/antlr/QL.g:19:1: form : 'form' Ident '{' ( assignment | statement )* '}' ;
    public final void form() throws RecognitionException {
        int form_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return ; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:20:3: ( 'form' Ident '{' ( assignment | statement )* '}' )
            // src/org/uva/sea/ql/parser/antlr/QL.g:20:3: 'form' Ident '{' ( assignment | statement )* '}'
            {
            match(input,28,FOLLOW_28_in_form43); if (state.failed) return ;

            match(input,Ident,FOLLOW_Ident_in_form45); if (state.failed) return ;

            match(input,30,FOLLOW_30_in_form47); if (state.failed) return ;

            // src/org/uva/sea/ql/parser/antlr/QL.g:21:3: ( assignment | statement )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==Ident) ) {
                    alt1=1;
                }
                else if ( (LA1_0==29) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // src/org/uva/sea/ql/parser/antlr/QL.g:21:4: assignment
            	    {
            	    pushFollow(FOLLOW_assignment_in_form54);
            	    assignment();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;
            	case 2 :
            	    // src/org/uva/sea/ql/parser/antlr/QL.g:21:17: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_form58);
            	    statement();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            match(input,32,FOLLOW_32_in_form66); if (state.failed) return ;

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



    // $ANTLR start "variable"
    // src/org/uva/sea/ql/parser/antlr/QL.g:25:1: variable : Ident ;
    public final void variable() throws RecognitionException {
        int variable_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return ; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:26:3: ( Ident )
            // src/org/uva/sea/ql/parser/antlr/QL.g:26:3: Ident
            {
            match(input,Ident,FOLLOW_Ident_in_variable75); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 2, variable_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "variable"



    // $ANTLR start "type"
    // src/org/uva/sea/ql/parser/antlr/QL.g:29:1: type : ( 'Integer' | 'Boolean' | 'StringLiteral' );
    public final void type() throws RecognitionException {
        int type_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return ; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:30:3: ( 'Integer' | 'Boolean' | 'StringLiteral' )
            // src/org/uva/sea/ql/parser/antlr/QL.g:
            {
            if ( (input.LA(1) >= 25 && input.LA(1) <= 27) ) {
                input.consume();
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


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
        return ;
    }
    // $ANTLR end "type"



    // $ANTLR start "term"
    // src/org/uva/sea/ql/parser/antlr/QL.g:35:1: term : ( Ident | Int | StringLiteral | Bool );
    public final void term() throws RecognitionException {
        int term_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return ; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:36:3: ( Ident | Int | StringLiteral | Bool )
            // src/org/uva/sea/ql/parser/antlr/QL.g:
            {
            if ( input.LA(1)==Bool||(input.LA(1) >= Ident && input.LA(1) <= StringLiteral) ) {
                input.consume();
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 4, term_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "term"



    // $ANTLR start "assignment"
    // src/org/uva/sea/ql/parser/antlr/QL.g:42:1: assignment : variable ':' StringLiteral type ;
    public final void assignment() throws RecognitionException {
        int assignment_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return ; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:43:3: ( variable ':' StringLiteral type )
            // src/org/uva/sea/ql/parser/antlr/QL.g:43:3: variable ':' StringLiteral type
            {
            pushFollow(FOLLOW_variable_in_assignment123);
            variable();

            state._fsp--;
            if (state.failed) return ;

            match(input,19,FOLLOW_19_in_assignment125); if (state.failed) return ;

            match(input,StringLiteral,FOLLOW_StringLiteral_in_assignment127); if (state.failed) return ;

            pushFollow(FOLLOW_type_in_assignment129);
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
            if ( state.backtracking>0 ) { memoize(input, 5, assignment_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "assignment"



    // $ANTLR start "statement"
    // src/org/uva/sea/ql/parser/antlr/QL.g:46:1: statement : ifStatement ;
    public final void statement() throws RecognitionException {
        int statement_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return ; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:47:3: ( ifStatement )
            // src/org/uva/sea/ql/parser/antlr/QL.g:47:3: ifStatement
            {
            pushFollow(FOLLOW_ifStatement_in_statement138);
            ifStatement();

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
            if ( state.backtracking>0 ) { memoize(input, 6, statement_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "statement"



    // $ANTLR start "ifStatement"
    // src/org/uva/sea/ql/parser/antlr/QL.g:50:1: ifStatement : 'if' '(' primary ')' '{' ( assignment )+ '}' ;
    public final void ifStatement() throws RecognitionException {
        int ifStatement_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return ; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:51:3: ( 'if' '(' primary ')' '{' ( assignment )+ '}' )
            // src/org/uva/sea/ql/parser/antlr/QL.g:51:3: 'if' '(' primary ')' '{' ( assignment )+ '}'
            {
            match(input,29,FOLLOW_29_in_ifStatement147); if (state.failed) return ;

            match(input,13,FOLLOW_13_in_ifStatement149); if (state.failed) return ;

            pushFollow(FOLLOW_primary_in_ifStatement151);
            primary();

            state._fsp--;
            if (state.failed) return ;

            match(input,14,FOLLOW_14_in_ifStatement153); if (state.failed) return ;

            match(input,30,FOLLOW_30_in_ifStatement157); if (state.failed) return ;

            // src/org/uva/sea/ql/parser/antlr/QL.g:53:5: ( assignment )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==Ident) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // src/org/uva/sea/ql/parser/antlr/QL.g:53:5: assignment
            	    {
            	    pushFollow(FOLLOW_assignment_in_ifStatement163);
            	    assignment();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            match(input,32,FOLLOW_32_in_ifStatement168); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 7, ifStatement_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "ifStatement"



    // $ANTLR start "primary"
    // src/org/uva/sea/ql/parser/antlr/QL.g:57:1: primary returns [Expr result] : ( Int | Ident | '(' x= orExpression ')' );
    public final Expr primary() throws RecognitionException {
        Expr result = null;

        int primary_StartIndex = input.index();

        Token Int1=null;
        Token Ident2=null;
        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:58:3: ( Int | Ident | '(' x= orExpression ')' )
            int alt3=3;
            switch ( input.LA(1) ) {
            case Int:
                {
                alt3=1;
                }
                break;
            case Ident:
                {
                alt3=2;
                }
                break;
            case 13:
                {
                alt3=3;
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
                    // src/org/uva/sea/ql/parser/antlr/QL.g:58:3: Int
                    {
                    Int1=(Token)match(input,Int,FOLLOW_Int_in_primary181); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Int(Integer.parseInt((Int1!=null?Int1.getText():null))); }

                    }
                    break;
                case 2 :
                    // src/org/uva/sea/ql/parser/antlr/QL.g:59:3: Ident
                    {
                    Ident2=(Token)match(input,Ident,FOLLOW_Ident_in_primary190); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Ident((Ident2!=null?Ident2.getText():null)); }

                    }
                    break;
                case 3 :
                    // src/org/uva/sea/ql/parser/antlr/QL.g:60:3: '(' x= orExpression ')'
                    {
                    match(input,13,FOLLOW_13_in_primary197); if (state.failed) return result;

                    pushFollow(FOLLOW_orExpression_in_primary201);
                    x=orExpression();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,14,FOLLOW_14_in_primary203); if (state.failed) return result;

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
            if ( state.backtracking>0 ) { memoize(input, 8, primary_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "primary"



    // $ANTLR start "unaryExpression"
    // src/org/uva/sea/ql/parser/antlr/QL.g:63:1: unaryExpression returns [Expr result] : ( '+' x= unaryExpression | '-' x= unaryExpression | '!' x= unaryExpression |x= primary );
    public final Expr unaryExpression() throws RecognitionException {
        Expr result = null;

        int unaryExpression_StartIndex = input.index();

        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:64:3: ( '+' x= unaryExpression | '-' x= unaryExpression | '!' x= unaryExpression |x= primary )
            int alt4=4;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt4=1;
                }
                break;
            case 17:
                {
                alt4=2;
                }
                break;
            case 10:
                {
                alt4=3;
                }
                break;
            case Ident:
            case Int:
            case 13:
                {
                alt4=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }

            switch (alt4) {
                case 1 :
                    // src/org/uva/sea/ql/parser/antlr/QL.g:64:3: '+' x= unaryExpression
                    {
                    match(input,16,FOLLOW_16_in_unaryExpression222); if (state.failed) return result;

                    pushFollow(FOLLOW_unaryExpression_in_unaryExpression226);
                    x=unaryExpression();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Pos(x); }

                    }
                    break;
                case 2 :
                    // src/org/uva/sea/ql/parser/antlr/QL.g:65:3: '-' x= unaryExpression
                    {
                    match(input,17,FOLLOW_17_in_unaryExpression232); if (state.failed) return result;

                    pushFollow(FOLLOW_unaryExpression_in_unaryExpression236);
                    x=unaryExpression();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Neg(x); }

                    }
                    break;
                case 3 :
                    // src/org/uva/sea/ql/parser/antlr/QL.g:66:3: '!' x= unaryExpression
                    {
                    match(input,10,FOLLOW_10_in_unaryExpression242); if (state.failed) return result;

                    pushFollow(FOLLOW_unaryExpression_in_unaryExpression246);
                    x=unaryExpression();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Not(x); }

                    }
                    break;
                case 4 :
                    // src/org/uva/sea/ql/parser/antlr/QL.g:67:3: x= primary
                    {
                    pushFollow(FOLLOW_primary_in_unaryExpression254);
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
            if ( state.backtracking>0 ) { memoize(input, 9, unaryExpression_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "unaryExpression"



    // $ANTLR start "multiplyExpression"
    // src/org/uva/sea/ql/parser/antlr/QL.g:70:1: multiplyExpression returns [Expr result] : lhs= unaryExpression (op= ( '*' | '/' ) rhs= unaryExpression )* ;
    public final Expr multiplyExpression() throws RecognitionException {
        Expr result = null;

        int multiplyExpression_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:71:3: (lhs= unaryExpression (op= ( '*' | '/' ) rhs= unaryExpression )* )
            // src/org/uva/sea/ql/parser/antlr/QL.g:71:3: lhs= unaryExpression (op= ( '*' | '/' ) rhs= unaryExpression )*
            {
            pushFollow(FOLLOW_unaryExpression_in_multiplyExpression281);
            lhs=unaryExpression();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:71:48: (op= ( '*' | '/' ) rhs= unaryExpression )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==15||LA5_0==18) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // src/org/uva/sea/ql/parser/antlr/QL.g:71:50: op= ( '*' | '/' ) rhs= unaryExpression
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


            	    pushFollow(FOLLOW_unaryExpression_in_multiplyExpression301);
            	    rhs=unaryExpression();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { 
            	      if ((op!=null?op.getText():null).equals("*")) 
            	      {
            	      	result = new Mul(result, rhs);
            	      }
            	      if ((op!=null?op.getText():null).equals("/")) 
            	      {
            	        result = new Div(result, rhs);      
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
            if ( state.backtracking>0 ) { memoize(input, 10, multiplyExpression_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "multiplyExpression"



    // $ANTLR start "addExpression"
    // src/org/uva/sea/ql/parser/antlr/QL.g:85:1: addExpression returns [Expr result] : lhs= multiplyExpression (op= ( '+' | '-' ) rhs= multiplyExpression ) ;
    public final Expr addExpression() throws RecognitionException {
        Expr result = null;

        int addExpression_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:86:3: (lhs= multiplyExpression (op= ( '+' | '-' ) rhs= multiplyExpression ) )
            // src/org/uva/sea/ql/parser/antlr/QL.g:86:3: lhs= multiplyExpression (op= ( '+' | '-' ) rhs= multiplyExpression )
            {
            pushFollow(FOLLOW_multiplyExpression_in_addExpression328);
            lhs=multiplyExpression();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:86:51: (op= ( '+' | '-' ) rhs= multiplyExpression )
            // src/org/uva/sea/ql/parser/antlr/QL.g:86:53: op= ( '+' | '-' ) rhs= multiplyExpression
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


            pushFollow(FOLLOW_multiplyExpression_in_addExpression346);
            rhs=multiplyExpression();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) {
              if ((op!=null?op.getText():null).equals("+")) 
              {
              	result = new Add(result, rhs);
              }
              if ((op!=null?op.getText():null).equals("-")) 
              {
              	result = new Sub(result, rhs);      
              }
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 11, addExpression_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "addExpression"



    // $ANTLR start "relExpression"
    // src/org/uva/sea/ql/parser/antlr/QL.g:99:1: relExpression returns [Expr result] : lhs= addExpression (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpression )* ;
    public final Expr relExpression() throws RecognitionException {
        Expr result = null;

        int relExpression_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:100:3: (lhs= addExpression (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpression )* )
            // src/org/uva/sea/ql/parser/antlr/QL.g:100:3: lhs= addExpression (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpression )*
            {
            pushFollow(FOLLOW_addExpression_in_relExpression366);
            lhs=addExpression();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:100:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpression )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==11||(LA6_0 >= 20 && LA6_0 <= 24)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // src/org/uva/sea/ql/parser/antlr/QL.g:100:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpression
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


            	    pushFollow(FOLLOW_addExpression_in_relExpression390);
            	    rhs=addExpression();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) {
            	      if ((op!=null?op.getText():null).equals("<")) 
            	      {
            	      	result = new LT(result, rhs);
            	      }
            	      if ((op!=null?op.getText():null).equals("<=")) 
            	      {
            	        result = new LEq(result, rhs);      
            	      }
            	      if ((op!=null?op.getText():null).equals(">")) 
            	      {
            	        result = new GT(result, rhs);
            	      }
            	      if ((op!=null?op.getText():null).equals(">=")) 
            	      {
            	        result = new GEq(result, rhs);      
            	      }
            	      if ((op!=null?op.getText():null).equals("==")) 
            	      {
            	        result = new Eq(result, rhs);
            	      }
            	      if ((op!=null?op.getText():null).equals("!=")) 
            	      {
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
            if ( state.backtracking>0 ) { memoize(input, 12, relExpression_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "relExpression"



    // $ANTLR start "andExpression"
    // src/org/uva/sea/ql/parser/antlr/QL.g:129:1: andExpression returns [Expr result] : lhs= relExpression ( '&&' rhs= relExpression )* ;
    public final Expr andExpression() throws RecognitionException {
        Expr result = null;

        int andExpression_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return result; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:130:3: (lhs= relExpression ( '&&' rhs= relExpression )* )
            // src/org/uva/sea/ql/parser/antlr/QL.g:130:3: lhs= relExpression ( '&&' rhs= relExpression )*
            {
            pushFollow(FOLLOW_relExpression_in_andExpression414);
            lhs=relExpression();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:130:46: ( '&&' rhs= relExpression )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==12) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // src/org/uva/sea/ql/parser/antlr/QL.g:130:48: '&&' rhs= relExpression
            	    {
            	    match(input,12,FOLLOW_12_in_andExpression420); if (state.failed) return result;

            	    pushFollow(FOLLOW_relExpression_in_andExpression424);
            	    rhs=relExpression();

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
            if ( state.backtracking>0 ) { memoize(input, 13, andExpression_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "andExpression"



    // $ANTLR start "orExpression"
    // src/org/uva/sea/ql/parser/antlr/QL.g:133:1: orExpression returns [Expr result] : lhs= andExpression ( '||' rhs= andExpression )* ;
    public final Expr orExpression() throws RecognitionException {
        Expr result = null;

        int orExpression_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return result; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:134:3: (lhs= andExpression ( '||' rhs= andExpression )* )
            // src/org/uva/sea/ql/parser/antlr/QL.g:134:3: lhs= andExpression ( '||' rhs= andExpression )*
            {
            pushFollow(FOLLOW_andExpression_in_orExpression444);
            lhs=andExpression();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = lhs; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:134:48: ( '||' rhs= andExpression )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==31) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // src/org/uva/sea/ql/parser/antlr/QL.g:134:50: '||' rhs= andExpression
            	    {
            	    match(input,31,FOLLOW_31_in_orExpression450); if (state.failed) return result;

            	    pushFollow(FOLLOW_andExpression_in_orExpression454);
            	    rhs=andExpression();

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
            if ( state.backtracking>0 ) { memoize(input, 14, orExpression_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "orExpression"

    // Delegated rules


 

    public static final BitSet FOLLOW_28_in_form43 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_Ident_in_form45 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_form47 = new BitSet(new long[]{0x0000000120000040L});
    public static final BitSet FOLLOW_assignment_in_form54 = new BitSet(new long[]{0x0000000120000040L});
    public static final BitSet FOLLOW_statement_in_form58 = new BitSet(new long[]{0x0000000120000040L});
    public static final BitSet FOLLOW_32_in_form66 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_variable75 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_assignment123 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_assignment125 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_StringLiteral_in_assignment127 = new BitSet(new long[]{0x000000000E000000L});
    public static final BitSet FOLLOW_type_in_assignment129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStatement_in_statement138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ifStatement147 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ifStatement149 = new BitSet(new long[]{0x00000000000020C0L});
    public static final BitSet FOLLOW_primary_in_ifStatement151 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ifStatement153 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ifStatement157 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_assignment_in_ifStatement163 = new BitSet(new long[]{0x0000000100000040L});
    public static final BitSet FOLLOW_32_in_ifStatement168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Int_in_primary181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_primary190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_primary197 = new BitSet(new long[]{0x00000000000324C0L});
    public static final BitSet FOLLOW_orExpression_in_primary201 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_primary203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_unaryExpression222 = new BitSet(new long[]{0x00000000000324C0L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpression226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_unaryExpression232 = new BitSet(new long[]{0x00000000000324C0L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpression236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_unaryExpression242 = new BitSet(new long[]{0x00000000000324C0L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpression246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_unaryExpression254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplyExpression281 = new BitSet(new long[]{0x0000000000048002L});
    public static final BitSet FOLLOW_set_in_multiplyExpression289 = new BitSet(new long[]{0x00000000000324C0L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplyExpression301 = new BitSet(new long[]{0x0000000000048002L});
    public static final BitSet FOLLOW_multiplyExpression_in_addExpression328 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_set_in_addExpression336 = new BitSet(new long[]{0x00000000000324C0L});
    public static final BitSet FOLLOW_multiplyExpression_in_addExpression346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_addExpression_in_relExpression366 = new BitSet(new long[]{0x0000000001F00802L});
    public static final BitSet FOLLOW_set_in_relExpression374 = new BitSet(new long[]{0x00000000000324C0L});
    public static final BitSet FOLLOW_addExpression_in_relExpression390 = new BitSet(new long[]{0x0000000001F00802L});
    public static final BitSet FOLLOW_relExpression_in_andExpression414 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_12_in_andExpression420 = new BitSet(new long[]{0x00000000000324C0L});
    public static final BitSet FOLLOW_relExpression_in_andExpression424 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_andExpression_in_orExpression444 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_orExpression450 = new BitSet(new long[]{0x00000000000324C0L});
    public static final BitSet FOLLOW_andExpression_in_orExpression454 = new BitSet(new long[]{0x0000000080000002L});

}