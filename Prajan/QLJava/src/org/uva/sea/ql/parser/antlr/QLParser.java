// $ANTLR 3.2 Sep 23, 2009 12:02:23 C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g 2013-03-17 18:47:42

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.alg.*;
import org.uva.sea.ql.ast.form.*;
import org.uva.sea.ql.ast.types.*;
import java.util.Map;
import java.util.HashMap;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class QLParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Ident", "String", "Int", "Bool", "Money", "WS", "Comment", "'form'", "'{'", "'}'", "':'", "'integer'", "'boolean'", "'string'", "'money'", "'if'", "'('", "')'", "'else'", "'='", "'+'", "'-'", "'!'", "'*'", "'/'", "'<'", "'<='", "'>'", "'>='", "'=='", "'!='", "'&&'", "'||'"
    };
    public static final int Bool=7;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int EOF=-1;
    public static final int Int=6;
    public static final int T__30=30;
    public static final int T__19=19;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int WS=9;
    public static final int Money=8;
    public static final int T__33=33;
    public static final int T__16=16;
    public static final int T__34=34;
    public static final int T__15=15;
    public static final int T__35=35;
    public static final int T__18=18;
    public static final int Ident=4;
    public static final int T__36=36;
    public static final int T__17=17;
    public static final int Comment=10;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int String=5;

    // delegates
    // delegators


        public QLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public QLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return QLParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g"; }


        private final Map<String, Ident> variables = new HashMap<String, Ident>();



    // $ANTLR start "form"
    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:26:1: form returns [Form f] : 'form' Ident '{' a= statements '}' ;
    public final Form form() throws RecognitionException {
        Form f = null;
        int form_StartIndex = input.index();
        Token Ident1=null;
        Statements a = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return f; }
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:27:5: ( 'form' Ident '{' a= statements '}' )
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:28:7: 'form' Ident '{' a= statements '}'
            {
            match(input,11,FOLLOW_11_in_form67); 
            Ident1=(Token)match(input,Ident,FOLLOW_Ident_in_form69); 
            f = new Form((Ident1!=null?Ident1.getText():null)); 
            match(input,12,FOLLOW_12_in_form73); 
            pushFollow(FOLLOW_statements_in_form79);
            a=statements();

            state._fsp--;

            f.setStatements(a);
            match(input,13,FOLLOW_13_in_form83); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return f;
    }
    // $ANTLR end "form"


    // $ANTLR start "statements"
    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:32:1: statements returns [Statements a] : (q= question | ce= ifconditionalexpr )* ;
    public final Statements statements() throws RecognitionException {
        Statements a = null;
        int statements_StartIndex = input.index();
        Question q = null;

        IfConditionalExpr ce = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return a; }
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:33:5: ( (q= question | ce= ifconditionalexpr )* )
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:34:7: (q= question | ce= ifconditionalexpr )*
            {
            a = new Statements();
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:34:32: (q= question | ce= ifconditionalexpr )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==String) ) {
                    alt1=1;
                }
                else if ( (LA1_0==19) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:34:34: q= question
            	    {
            	    pushFollow(FOLLOW_question_in_statements119);
            	    q=question();

            	    state._fsp--;

            	     a.addQuestion(q); 

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:35:7: ce= ifconditionalexpr
            	    {
            	    pushFollow(FOLLOW_ifconditionalexpr_in_statements135);
            	    ce=ifconditionalexpr();

            	    state._fsp--;

            	     a.addIfConditionalExpr(ce); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return a;
    }
    // $ANTLR end "statements"


    // $ANTLR start "question"
    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:38:1: question returns [Question q] : ( String ) (d= declaration | c= calculation ) ;
    public final Question question() throws RecognitionException {
        Question q = null;
        int question_StartIndex = input.index();
        Token String2=null;
        Declaration d = null;

        Calculation c = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return q; }
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:39:5: ( ( String ) (d= declaration | c= calculation ) )
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:40:7: ( String ) (d= declaration | c= calculation )
            {
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:40:7: ( String )
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:40:8: String
            {
            String2=(Token)match(input,String,FOLLOW_String_in_question167); 
            q = new Question((String2!=null?String2.getText():null)); 

            }

            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:40:52: (d= declaration | c= calculation )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==Ident) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==14) ) {
                    alt2=1;
                }
                else if ( (LA2_1==23) ) {
                    alt2=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:40:54: d= declaration
                    {
                    pushFollow(FOLLOW_declaration_in_question178);
                    d=declaration();

                    state._fsp--;

                    q.addDeclaration(d); 

                    }
                    break;
                case 2 :
                    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:41:7: c= calculation
                    {
                    pushFollow(FOLLOW_calculation_in_question194);
                    c=calculation();

                    state._fsp--;

                     q.addCalculation(c); 

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
        }
        return q;
    }
    // $ANTLR end "question"


    // $ANTLR start "declaration"
    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:44:1: declaration returns [Declaration d] : d1= Ident ':' d2= type ;
    public final Declaration declaration() throws RecognitionException {
        Declaration d = null;
        int declaration_StartIndex = input.index();
        Token d1=null;
        Type d2 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return d; }
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:45:5: (d1= Ident ':' d2= type )
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:46:7: d1= Ident ':' d2= type
            {
            d1=(Token)match(input,Ident,FOLLOW_Ident_in_declaration233); 
            match(input,14,FOLLOW_14_in_declaration235); 
            pushFollow(FOLLOW_type_in_declaration241);
            d2=type();

            state._fsp--;

             
                     Ident ident = new Ident((d1!=null?d1.getText():null));      
                     d = new Declaration(ident, d2); 
                     this.variables.put((d1!=null?d1.getText():null), ident);
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return d;
    }
    // $ANTLR end "declaration"


    // $ANTLR start "type"
    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:55:1: type returns [Type type] : ( 'integer' | 'boolean' | 'string' | 'money' );
    public final Type type() throws RecognitionException {
        Type type = null;
        int type_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return type; }
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:56:5: ( 'integer' | 'boolean' | 'string' | 'money' )
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
            case 17:
                {
                alt3=3;
                }
                break;
            case 18:
                {
                alt3=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:57:7: 'integer'
                    {
                    match(input,15,FOLLOW_15_in_type278); 
                    type = new IntType();

                    }
                    break;
                case 2 :
                    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:58:7: 'boolean'
                    {
                    match(input,16,FOLLOW_16_in_type288); 
                    type = new BoolType();

                    }
                    break;
                case 3 :
                    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:59:7: 'string'
                    {
                    match(input,17,FOLLOW_17_in_type298); 
                    type = new StrType();

                    }
                    break;
                case 4 :
                    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:60:7: 'money'
                    {
                    match(input,18,FOLLOW_18_in_type309); 
                    type = new MoneyType();

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return type;
    }
    // $ANTLR end "type"


    // $ANTLR start "ifconditionalexpr"
    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:64:1: ifconditionalexpr returns [IfConditionalExpr ifce] : 'if' '(' ce1= orExpr ')' '{' a= statements '}' ( 'else' '{' (ce3= question )* '}' )? ;
    public final IfConditionalExpr ifconditionalexpr() throws RecognitionException {
        IfConditionalExpr ifce = null;
        int ifconditionalexpr_StartIndex = input.index();
        Expr ce1 = null;

        Statements a = null;

        Question ce3 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return ifce; }
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:65:5: ( 'if' '(' ce1= orExpr ')' '{' a= statements '}' ( 'else' '{' (ce3= question )* '}' )? )
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:66:7: 'if' '(' ce1= orExpr ')' '{' a= statements '}' ( 'else' '{' (ce3= question )* '}' )?
            {
            match(input,19,FOLLOW_19_in_ifconditionalexpr341); 
            match(input,20,FOLLOW_20_in_ifconditionalexpr343); 
            pushFollow(FOLLOW_orExpr_in_ifconditionalexpr349);
            ce1=orExpr();

            state._fsp--;

            ifce = new IfConditionalExpr(ce1); 
            match(input,21,FOLLOW_21_in_ifconditionalexpr353); 
            match(input,12,FOLLOW_12_in_ifconditionalexpr355); 
            pushFollow(FOLLOW_statements_in_ifconditionalexpr361);
            a=statements();

            state._fsp--;

             ifce.setStatements(a); 
            match(input,13,FOLLOW_13_in_ifconditionalexpr364); 
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:66:122: ( 'else' '{' (ce3= question )* '}' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==22) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:66:123: 'else' '{' (ce3= question )* '}'
                    {
                    match(input,22,FOLLOW_22_in_ifconditionalexpr367); 
                    match(input,12,FOLLOW_12_in_ifconditionalexpr369); 
                    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:66:134: (ce3= question )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==String) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:66:135: ce3= question
                    	    {
                    	    pushFollow(FOLLOW_question_in_ifconditionalexpr376);
                    	    ce3=question();

                    	    state._fsp--;

                    	    ifce.addElse(ce3); 

                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    match(input,13,FOLLOW_13_in_ifconditionalexpr383); 

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
        }
        return ifce;
    }
    // $ANTLR end "ifconditionalexpr"


    // $ANTLR start "calculation"
    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:69:1: calculation returns [Calculation c] : d1= Ident '=' or1= orExpr ;
    public final Calculation calculation() throws RecognitionException {
        Calculation c = null;
        int calculation_StartIndex = input.index();
        Token d1=null;
        Expr or1 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return c; }
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:70:5: (d1= Ident '=' or1= orExpr )
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:71:7: d1= Ident '=' or1= orExpr
            {
            d1=(Token)match(input,Ident,FOLLOW_Ident_in_calculation417); 
            match(input,23,FOLLOW_23_in_calculation420); 
            pushFollow(FOLLOW_orExpr_in_calculation427);
            or1=orExpr();

            state._fsp--;

            c = new Calculation((d1!=null?d1.getText():null), or1); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return c;
    }
    // $ANTLR end "calculation"


    // $ANTLR start "primary"
    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:74:1: primary returns [Expr result] : ( Int | Ident | Bool | String | Money | '(' x= orExpr ')' );
    public final Expr primary() throws RecognitionException {
        Expr result = null;
        int primary_StartIndex = input.index();
        Token Int3=null;
        Token Ident4=null;
        Token Bool5=null;
        Token String6=null;
        Token Money7=null;
        Expr x = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:75:5: ( Int | Ident | Bool | String | Money | '(' x= orExpr ')' )
            int alt6=6;
            switch ( input.LA(1) ) {
            case Int:
                {
                alt6=1;
                }
                break;
            case Ident:
                {
                alt6=2;
                }
                break;
            case Bool:
                {
                alt6=3;
                }
                break;
            case String:
                {
                alt6=4;
                }
                break;
            case Money:
                {
                alt6=5;
                }
                break;
            case 20:
                {
                alt6=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:75:7: Int
                    {
                    Int3=(Token)match(input,Int,FOLLOW_Int_in_primary454); 
                     result = new Int(Integer.parseInt((Int3!=null?Int3.getText():null))); 

                    }
                    break;
                case 2 :
                    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:76:7: Ident
                    {
                    Ident4=(Token)match(input,Ident,FOLLOW_Ident_in_primary466); 
                     result = new Ident((Ident4!=null?Ident4.getText():null)); 

                    }
                    break;
                case 3 :
                    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:77:7: Bool
                    {
                    Bool5=(Token)match(input,Bool,FOLLOW_Bool_in_primary476); 
                     result = new Bool(Boolean.parseBoolean((Bool5!=null?Bool5.getText():null))); 

                    }
                    break;
                case 4 :
                    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:78:7: String
                    {
                    String6=(Token)match(input,String,FOLLOW_String_in_primary487); 
                     result = new Str((String6!=null?String6.getText():null)); 

                    }
                    break;
                case 5 :
                    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:79:7: Money
                    {
                    Money7=(Token)match(input,Money,FOLLOW_Money_in_primary496); 
                     result = new Money(Double.parseDouble((Money7!=null?Money7.getText():null))); 

                    }
                    break;
                case 6 :
                    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:80:7: '(' x= orExpr ')'
                    {
                    match(input,20,FOLLOW_20_in_primary506); 
                    pushFollow(FOLLOW_orExpr_in_primary510);
                    x=orExpr();

                    state._fsp--;

                    match(input,21,FOLLOW_21_in_primary512); 
                     result = x; 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "primary"


    // $ANTLR start "unExpr"
    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:84:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr | x= primary );
    public final Expr unExpr() throws RecognitionException {
        Expr result = null;
        int unExpr_StartIndex = input.index();
        Expr x = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:85:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr | x= primary )
            int alt7=4;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt7=1;
                }
                break;
            case 25:
                {
                alt7=2;
                }
                break;
            case 26:
                {
                alt7=3;
                }
                break;
            case Ident:
            case String:
            case Int:
            case Bool:
            case Money:
            case 20:
                {
                alt7=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:85:8: '+' x= unExpr
                    {
                    match(input,24,FOLLOW_24_in_unExpr546); 
                    pushFollow(FOLLOW_unExpr_in_unExpr550);
                    x=unExpr();

                    state._fsp--;

                     result = new Pos(x); 

                    }
                    break;
                case 2 :
                    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:86:8: '-' x= unExpr
                    {
                    match(input,25,FOLLOW_25_in_unExpr561); 
                    pushFollow(FOLLOW_unExpr_in_unExpr565);
                    x=unExpr();

                    state._fsp--;

                     result = new Neg(x); 

                    }
                    break;
                case 3 :
                    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:87:8: '!' x= unExpr
                    {
                    match(input,26,FOLLOW_26_in_unExpr576); 
                    pushFollow(FOLLOW_unExpr_in_unExpr580);
                    x=unExpr();

                    state._fsp--;

                     result = new Not(x); 

                    }
                    break;
                case 4 :
                    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:88:8: x= primary
                    {
                    pushFollow(FOLLOW_primary_in_unExpr593);
                    x=primary();

                    state._fsp--;

                     result = x; 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "unExpr"


    // $ANTLR start "mulExpr"
    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:91:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
    public final Expr mulExpr() throws RecognitionException {
        Expr result = null;
        int mulExpr_StartIndex = input.index();
        Token op=null;
        Expr lhs = null;

        Expr rhs = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:92:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:92:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
            {
            pushFollow(FOLLOW_unExpr_in_mulExpr631);
            lhs=unExpr();

            state._fsp--;

             result =lhs; 
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:92:45: (op= ( '*' | '/' ) rhs= unExpr )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=27 && LA8_0<=28)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:92:47: op= ( '*' | '/' ) rhs= unExpr
            	    {
            	    op=(Token)input.LT(1);
            	    if ( (input.LA(1)>=27 && input.LA(1)<=28) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_unExpr_in_mulExpr651);
            	    rhs=unExpr();

            	    state._fsp--;

            	     
            	          if ((op!=null?op.getText():null).equals("*")) {
            	            result = new Mul(result, rhs);
            	          }
            	          if ((op!=null?op.getText():null).equals("/")) {
            	            result = new Div(result, rhs);      
            	          }
            	        

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
        }
        return result;
    }
    // $ANTLR end "mulExpr"


    // $ANTLR start "addExpr"
    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:104:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
    public final Expr addExpr() throws RecognitionException {
        Expr result = null;
        int addExpr_StartIndex = input.index();
        Token op=null;
        Expr lhs = null;

        Expr rhs = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:105:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:105:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
            {
            pushFollow(FOLLOW_mulExpr_in_addExpr692);
            lhs=mulExpr();

            state._fsp--;

             result =lhs; 
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:105:46: (op= ( '+' | '-' ) rhs= mulExpr )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=24 && LA9_0<=25)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:105:48: op= ( '+' | '-' ) rhs= mulExpr
            	    {
            	    op=(Token)input.LT(1);
            	    if ( (input.LA(1)>=24 && input.LA(1)<=25) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_mulExpr_in_addExpr710);
            	    rhs=mulExpr();

            	    state._fsp--;

            	     
            	          if ((op!=null?op.getText():null).equals("+")) {
            	            result = new Add(result, rhs);
            	          }
            	          if ((op!=null?op.getText():null).equals("-")) {
            	            result = new Sub(result, rhs);      
            	          }
            	        

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "addExpr"


    // $ANTLR start "relExpr"
    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:117:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
    public final Expr relExpr() throws RecognitionException {
        Expr result = null;
        int relExpr_StartIndex = input.index();
        Token op=null;
        Expr lhs = null;

        Expr rhs = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:118:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:118:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            {
            pushFollow(FOLLOW_addExpr_in_relExpr748);
            lhs=addExpr();

            state._fsp--;

             result =lhs; 
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:118:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>=29 && LA10_0<=34)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:118:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
            	    {
            	    op=(Token)input.LT(1);
            	    if ( (input.LA(1)>=29 && input.LA(1)<=34) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_addExpr_in_relExpr772);
            	    rhs=addExpr();

            	    state._fsp--;

            	     
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
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "relExpr"


    // $ANTLR start "andExpr"
    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:141:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
    public final Expr andExpr() throws RecognitionException {
        Expr result = null;
        int andExpr_StartIndex = input.index();
        Expr lhs = null;

        Expr rhs = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return result; }
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:142:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:142:9: lhs= relExpr ( '&&' rhs= relExpr )*
            {
            pushFollow(FOLLOW_relExpr_in_andExpr810);
            lhs=relExpr();

            state._fsp--;

             result =lhs; 
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:142:46: ( '&&' rhs= relExpr )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==35) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:142:48: '&&' rhs= relExpr
            	    {
            	    match(input,35,FOLLOW_35_in_andExpr816); 
            	    pushFollow(FOLLOW_relExpr_in_andExpr820);
            	    rhs=relExpr();

            	    state._fsp--;

            	     result = new And(result, rhs); 

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "andExpr"


    // $ANTLR start "orExpr"
    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:146:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
    public final Expr orExpr() throws RecognitionException {
        Expr result = null;
        int orExpr_StartIndex = input.index();
        Expr lhs = null;

        Expr rhs = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return result; }
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:147:5: (lhs= andExpr ( '||' rhs= andExpr )* )
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:147:9: lhs= andExpr ( '||' rhs= andExpr )*
            {
            pushFollow(FOLLOW_andExpr_in_orExpr855);
            lhs=andExpr();

            state._fsp--;

             result = lhs; 
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:147:48: ( '||' rhs= andExpr )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==36) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:147:50: '||' rhs= andExpr
            	    {
            	    match(input,36,FOLLOW_36_in_orExpr861); 
            	    pushFollow(FOLLOW_andExpr_in_orExpr865);
            	    rhs=andExpr();

            	    state._fsp--;

            	     result = new Or(result, rhs); 

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "orExpr"

    // Delegated rules


 

    public static final BitSet FOLLOW_11_in_form67 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Ident_in_form69 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_form73 = new BitSet(new long[]{0x0000000000082020L});
    public static final BitSet FOLLOW_statements_in_form79 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_form83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_question_in_statements119 = new BitSet(new long[]{0x0000000000080022L});
    public static final BitSet FOLLOW_ifconditionalexpr_in_statements135 = new BitSet(new long[]{0x0000000000080022L});
    public static final BitSet FOLLOW_String_in_question167 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_declaration_in_question178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_calculation_in_question194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_declaration233 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_declaration235 = new BitSet(new long[]{0x0000000000078000L});
    public static final BitSet FOLLOW_type_in_declaration241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_type278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_type288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_type298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_type309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ifconditionalexpr341 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ifconditionalexpr343 = new BitSet(new long[]{0x00000000071001F0L});
    public static final BitSet FOLLOW_orExpr_in_ifconditionalexpr349 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ifconditionalexpr353 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ifconditionalexpr355 = new BitSet(new long[]{0x0000000000082020L});
    public static final BitSet FOLLOW_statements_in_ifconditionalexpr361 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ifconditionalexpr364 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_ifconditionalexpr367 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ifconditionalexpr369 = new BitSet(new long[]{0x0000000000002020L});
    public static final BitSet FOLLOW_question_in_ifconditionalexpr376 = new BitSet(new long[]{0x0000000000002020L});
    public static final BitSet FOLLOW_13_in_ifconditionalexpr383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_calculation417 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_calculation420 = new BitSet(new long[]{0x00000000071001F0L});
    public static final BitSet FOLLOW_orExpr_in_calculation427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Int_in_primary454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_primary466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Bool_in_primary476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_String_in_primary487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Money_in_primary496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_primary506 = new BitSet(new long[]{0x00000000071001F0L});
    public static final BitSet FOLLOW_orExpr_in_primary510 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_primary512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_unExpr546 = new BitSet(new long[]{0x00000000071001F0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_unExpr561 = new BitSet(new long[]{0x00000000071001F0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_unExpr576 = new BitSet(new long[]{0x00000000071001F0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_unExpr593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr631 = new BitSet(new long[]{0x0000000018000002L});
    public static final BitSet FOLLOW_set_in_mulExpr639 = new BitSet(new long[]{0x00000000071001F0L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr651 = new BitSet(new long[]{0x0000000018000002L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr692 = new BitSet(new long[]{0x0000000003000002L});
    public static final BitSet FOLLOW_set_in_addExpr700 = new BitSet(new long[]{0x00000000071001F0L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr710 = new BitSet(new long[]{0x0000000003000002L});
    public static final BitSet FOLLOW_addExpr_in_relExpr748 = new BitSet(new long[]{0x00000007E0000002L});
    public static final BitSet FOLLOW_set_in_relExpr756 = new BitSet(new long[]{0x00000000071001F0L});
    public static final BitSet FOLLOW_addExpr_in_relExpr772 = new BitSet(new long[]{0x00000007E0000002L});
    public static final BitSet FOLLOW_relExpr_in_andExpr810 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_andExpr816 = new BitSet(new long[]{0x00000000071001F0L});
    public static final BitSet FOLLOW_relExpr_in_andExpr820 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_andExpr_in_orExpr855 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_36_in_orExpr861 = new BitSet(new long[]{0x00000000071001F0L});
    public static final BitSet FOLLOW_andExpr_in_orExpr865 = new BitSet(new long[]{0x0000001000000002L});

}