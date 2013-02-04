// $ANTLR 3.4 src/main/org/uva/sea/ql/parser/QL.g 2013-02-04 14:18:20

	package org.uva.sea.ql.parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class QLLexer extends Lexer {
    public static final int EOF=-1;
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
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int ASSIGNMENT=4;
    public static final int BLOCK=5;
    public static final int Boolean=6;
    public static final int Comment=7;
    public static final int Digit=8;
    public static final int EXPRESSION=9;
    public static final int FORM=10;
    public static final int IF=11;
    public static final int Identifier=12;
    public static final int Integer=13;
    public static final int Letter=14;
    public static final int Money=15;
    public static final int MultilineComment=16;
    public static final int NEGATION=17;
    public static final int NOT=18;
    public static final int STATEMENT=19;
    public static final int StringLiteral=20;
    public static final int Whitespace=21;

    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public QLLexer() {} 
    public QLLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public QLLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "src/main/org/uva/sea/ql/parser/QL.g"; }

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/org/uva/sea/ql/parser/QL.g:11:7: ( '!' )
            // src/main/org/uva/sea/ql/parser/QL.g:11:9: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/org/uva/sea/ql/parser/QL.g:12:7: ( '!=' )
            // src/main/org/uva/sea/ql/parser/QL.g:12:9: '!='
            {
            match("!="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/org/uva/sea/ql/parser/QL.g:13:7: ( '&&' )
            // src/main/org/uva/sea/ql/parser/QL.g:13:9: '&&'
            {
            match("&&"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/org/uva/sea/ql/parser/QL.g:14:7: ( '(' )
            // src/main/org/uva/sea/ql/parser/QL.g:14:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/org/uva/sea/ql/parser/QL.g:15:7: ( ')' )
            // src/main/org/uva/sea/ql/parser/QL.g:15:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/org/uva/sea/ql/parser/QL.g:16:7: ( '*' )
            // src/main/org/uva/sea/ql/parser/QL.g:16:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/org/uva/sea/ql/parser/QL.g:17:7: ( '+' )
            // src/main/org/uva/sea/ql/parser/QL.g:17:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/org/uva/sea/ql/parser/QL.g:18:7: ( '-' )
            // src/main/org/uva/sea/ql/parser/QL.g:18:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/org/uva/sea/ql/parser/QL.g:19:7: ( '/' )
            // src/main/org/uva/sea/ql/parser/QL.g:19:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/org/uva/sea/ql/parser/QL.g:20:7: ( ':' )
            // src/main/org/uva/sea/ql/parser/QL.g:20:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/org/uva/sea/ql/parser/QL.g:21:7: ( '<' )
            // src/main/org/uva/sea/ql/parser/QL.g:21:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/org/uva/sea/ql/parser/QL.g:22:7: ( '<=' )
            // src/main/org/uva/sea/ql/parser/QL.g:22:9: '<='
            {
            match("<="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/org/uva/sea/ql/parser/QL.g:23:7: ( '==' )
            // src/main/org/uva/sea/ql/parser/QL.g:23:9: '=='
            {
            match("=="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/org/uva/sea/ql/parser/QL.g:24:7: ( '>' )
            // src/main/org/uva/sea/ql/parser/QL.g:24:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/org/uva/sea/ql/parser/QL.g:25:7: ( '>=' )
            // src/main/org/uva/sea/ql/parser/QL.g:25:9: '>='
            {
            match(">="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/org/uva/sea/ql/parser/QL.g:26:7: ( 'boolean' )
            // src/main/org/uva/sea/ql/parser/QL.g:26:9: 'boolean'
            {
            match("boolean"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/org/uva/sea/ql/parser/QL.g:27:7: ( 'else' )
            // src/main/org/uva/sea/ql/parser/QL.g:27:9: 'else'
            {
            match("else"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/org/uva/sea/ql/parser/QL.g:28:7: ( 'form' )
            // src/main/org/uva/sea/ql/parser/QL.g:28:9: 'form'
            {
            match("form"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/org/uva/sea/ql/parser/QL.g:29:7: ( 'if' )
            // src/main/org/uva/sea/ql/parser/QL.g:29:9: 'if'
            {
            match("if"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/org/uva/sea/ql/parser/QL.g:30:7: ( 'integer' )
            // src/main/org/uva/sea/ql/parser/QL.g:30:9: 'integer'
            {
            match("integer"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/org/uva/sea/ql/parser/QL.g:31:7: ( 'money' )
            // src/main/org/uva/sea/ql/parser/QL.g:31:9: 'money'
            {
            match("money"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/org/uva/sea/ql/parser/QL.g:32:7: ( 'string' )
            // src/main/org/uva/sea/ql/parser/QL.g:32:9: 'string'
            {
            match("string"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/org/uva/sea/ql/parser/QL.g:33:7: ( '{' )
            // src/main/org/uva/sea/ql/parser/QL.g:33:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/org/uva/sea/ql/parser/QL.g:34:7: ( '||' )
            // src/main/org/uva/sea/ql/parser/QL.g:34:9: '||'
            {
            match("||"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/org/uva/sea/ql/parser/QL.g:35:7: ( '}' )
            // src/main/org/uva/sea/ql/parser/QL.g:35:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "StringLiteral"
    public final void mStringLiteral() throws RecognitionException {
        try {
            int _type = StringLiteral;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            int c;

            // src/main/org/uva/sea/ql/parser/QL.g:118:2: ( '\"' ( '\\\\' '\"' |c=~ ( '\"' | '\\r' | '\\n' ) )* '\"' )
            // src/main/org/uva/sea/ql/parser/QL.g:118:4: '\"' ( '\\\\' '\"' |c=~ ( '\"' | '\\r' | '\\n' ) )* '\"'
            {
            match('\"'); 

             StringBuilder b = new StringBuilder(); 

            // src/main/org/uva/sea/ql/parser/QL.g:120:3: ( '\\\\' '\"' |c=~ ( '\"' | '\\r' | '\\n' ) )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='\\') ) {
                    int LA1_2 = input.LA(2);

                    if ( (LA1_2=='\"') ) {
                        int LA1_4 = input.LA(3);

                        if ( ((LA1_4 >= '\u0000' && LA1_4 <= '\t')||(LA1_4 >= '\u000B' && LA1_4 <= '\f')||(LA1_4 >= '\u000E' && LA1_4 <= '\uFFFF')) ) {
                            alt1=1;
                        }

                        else {
                            alt1=2;
                        }


                    }
                    else if ( ((LA1_2 >= '\u0000' && LA1_2 <= '\t')||(LA1_2 >= '\u000B' && LA1_2 <= '\f')||(LA1_2 >= '\u000E' && LA1_2 <= '!')||(LA1_2 >= '#' && LA1_2 <= '\uFFFF')) ) {
                        alt1=2;
                    }


                }
                else if ( ((LA1_0 >= '\u0000' && LA1_0 <= '\t')||(LA1_0 >= '\u000B' && LA1_0 <= '\f')||(LA1_0 >= '\u000E' && LA1_0 <= '!')||(LA1_0 >= '#' && LA1_0 <= '[')||(LA1_0 >= ']' && LA1_0 <= '\uFFFF')) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // src/main/org/uva/sea/ql/parser/QL.g:120:5: '\\\\' '\"'
            	    {
            	    match('\\'); 

            	    match('\"'); 

            	     b.appendCodePoint('"');

            	    }
            	    break;
            	case 2 :
            	    // src/main/org/uva/sea/ql/parser/QL.g:121:5: c=~ ( '\"' | '\\r' | '\\n' )
            	    {
            	    c= input.LA(1);

            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	     b.appendCodePoint(c);

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            match('\"'); 

             setText(b.toString()); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "StringLiteral"

    // $ANTLR start "Boolean"
    public final void mBoolean() throws RecognitionException {
        try {
            int _type = Boolean;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/org/uva/sea/ql/parser/QL.g:128:5: ( 'true' | 'false' )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='t') ) {
                alt2=1;
            }
            else if ( (LA2_0=='f') ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }
            switch (alt2) {
                case 1 :
                    // src/main/org/uva/sea/ql/parser/QL.g:128:9: 'true'
                    {
                    match("true"); 



                    }
                    break;
                case 2 :
                    // src/main/org/uva/sea/ql/parser/QL.g:129:9: 'false'
                    {
                    match("false"); 



                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Boolean"

    // $ANTLR start "Money"
    public final void mMoney() throws RecognitionException {
        try {
            int _type = Money;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/org/uva/sea/ql/parser/QL.g:133:5: ( ( Digit )+ '.' ( Digit )+ )
            // src/main/org/uva/sea/ql/parser/QL.g:133:9: ( Digit )+ '.' ( Digit )+
            {
            // src/main/org/uva/sea/ql/parser/QL.g:133:9: ( Digit )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // src/main/org/uva/sea/ql/parser/QL.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            match('.'); 

            // src/main/org/uva/sea/ql/parser/QL.g:133:20: ( Digit )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= '0' && LA4_0 <= '9')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // src/main/org/uva/sea/ql/parser/QL.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Money"

    // $ANTLR start "Integer"
    public final void mInteger() throws RecognitionException {
        try {
            int _type = Integer;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/org/uva/sea/ql/parser/QL.g:137:5: ( ( Digit )+ )
            // src/main/org/uva/sea/ql/parser/QL.g:137:9: ( Digit )+
            {
            // src/main/org/uva/sea/ql/parser/QL.g:137:9: ( Digit )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0 >= '0' && LA5_0 <= '9')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // src/main/org/uva/sea/ql/parser/QL.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Integer"

    // $ANTLR start "Identifier"
    public final void mIdentifier() throws RecognitionException {
        try {
            int _type = Identifier;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/org/uva/sea/ql/parser/QL.g:141:5: ( Letter ( Letter | Digit | '_' )* )
            // src/main/org/uva/sea/ql/parser/QL.g:141:9: Letter ( Letter | Digit | '_' )*
            {
            mLetter(); 


            // src/main/org/uva/sea/ql/parser/QL.g:141:16: ( Letter | Digit | '_' )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0 >= '0' && LA6_0 <= '9')||(LA6_0 >= 'A' && LA6_0 <= 'Z')||LA6_0=='_'||(LA6_0 >= 'a' && LA6_0 <= 'z')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // src/main/org/uva/sea/ql/parser/QL.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Identifier"

    // $ANTLR start "Whitespace"
    public final void mWhitespace() throws RecognitionException {
        try {
            int _type = Whitespace;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/org/uva/sea/ql/parser/QL.g:145:5: ( ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' )+ )
            // src/main/org/uva/sea/ql/parser/QL.g:145:9: ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' )+
            {
            // src/main/org/uva/sea/ql/parser/QL.g:145:9: ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0 >= '\t' && LA7_0 <= '\n')||(LA7_0 >= '\f' && LA7_0 <= '\r')||LA7_0==' ') ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // src/main/org/uva/sea/ql/parser/QL.g:
            	    {
            	    if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||(input.LA(1) >= '\f' && input.LA(1) <= '\r')||input.LA(1)==' ' ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);


            _channel = HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Whitespace"

    // $ANTLR start "Comment"
    public final void mComment() throws RecognitionException {
        try {
            int _type = Comment;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/org/uva/sea/ql/parser/QL.g:149:5: ( '//' ( . )* ( '\\n' | '\\r' ) )
            // src/main/org/uva/sea/ql/parser/QL.g:149:9: '//' ( . )* ( '\\n' | '\\r' )
            {
            match("//"); 



            // src/main/org/uva/sea/ql/parser/QL.g:149:14: ( . )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0=='\n'||LA8_0=='\r') ) {
                    alt8=2;
                }
                else if ( ((LA8_0 >= '\u0000' && LA8_0 <= '\t')||(LA8_0 >= '\u000B' && LA8_0 <= '\f')||(LA8_0 >= '\u000E' && LA8_0 <= '\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // src/main/org/uva/sea/ql/parser/QL.g:149:14: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            if ( input.LA(1)=='\n'||input.LA(1)=='\r' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            _channel = HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Comment"

    // $ANTLR start "MultilineComment"
    public final void mMultilineComment() throws RecognitionException {
        try {
            int _type = MultilineComment;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/org/uva/sea/ql/parser/QL.g:153:5: ( '/*' ( . )* '*/' )
            // src/main/org/uva/sea/ql/parser/QL.g:153:9: '/*' ( . )* '*/'
            {
            match("/*"); 



            // src/main/org/uva/sea/ql/parser/QL.g:153:14: ( . )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='*') ) {
                    int LA9_1 = input.LA(2);

                    if ( (LA9_1=='/') ) {
                        alt9=2;
                    }
                    else if ( ((LA9_1 >= '\u0000' && LA9_1 <= '.')||(LA9_1 >= '0' && LA9_1 <= '\uFFFF')) ) {
                        alt9=1;
                    }


                }
                else if ( ((LA9_0 >= '\u0000' && LA9_0 <= ')')||(LA9_0 >= '+' && LA9_0 <= '\uFFFF')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // src/main/org/uva/sea/ql/parser/QL.g:153:14: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            match("*/"); 



            _channel = HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MultilineComment"

    // $ANTLR start "Letter"
    public final void mLetter() throws RecognitionException {
        try {
            // src/main/org/uva/sea/ql/parser/QL.g:157:5: ( ( 'a' .. 'z' | 'A' .. 'Z' ) )
            // src/main/org/uva/sea/ql/parser/QL.g:
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Letter"

    // $ANTLR start "Digit"
    public final void mDigit() throws RecognitionException {
        try {
            // src/main/org/uva/sea/ql/parser/QL.g:161:5: ( '0' .. '9' )
            // src/main/org/uva/sea/ql/parser/QL.g:
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Digit"

    public void mTokens() throws RecognitionException {
        // src/main/org/uva/sea/ql/parser/QL.g:1:8: ( T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | StringLiteral | Boolean | Money | Integer | Identifier | Whitespace | Comment | MultilineComment )
        int alt10=33;
        alt10 = dfa10.predict(input);
        switch (alt10) {
            case 1 :
                // src/main/org/uva/sea/ql/parser/QL.g:1:10: T__22
                {
                mT__22(); 


                }
                break;
            case 2 :
                // src/main/org/uva/sea/ql/parser/QL.g:1:16: T__23
                {
                mT__23(); 


                }
                break;
            case 3 :
                // src/main/org/uva/sea/ql/parser/QL.g:1:22: T__24
                {
                mT__24(); 


                }
                break;
            case 4 :
                // src/main/org/uva/sea/ql/parser/QL.g:1:28: T__25
                {
                mT__25(); 


                }
                break;
            case 5 :
                // src/main/org/uva/sea/ql/parser/QL.g:1:34: T__26
                {
                mT__26(); 


                }
                break;
            case 6 :
                // src/main/org/uva/sea/ql/parser/QL.g:1:40: T__27
                {
                mT__27(); 


                }
                break;
            case 7 :
                // src/main/org/uva/sea/ql/parser/QL.g:1:46: T__28
                {
                mT__28(); 


                }
                break;
            case 8 :
                // src/main/org/uva/sea/ql/parser/QL.g:1:52: T__29
                {
                mT__29(); 


                }
                break;
            case 9 :
                // src/main/org/uva/sea/ql/parser/QL.g:1:58: T__30
                {
                mT__30(); 


                }
                break;
            case 10 :
                // src/main/org/uva/sea/ql/parser/QL.g:1:64: T__31
                {
                mT__31(); 


                }
                break;
            case 11 :
                // src/main/org/uva/sea/ql/parser/QL.g:1:70: T__32
                {
                mT__32(); 


                }
                break;
            case 12 :
                // src/main/org/uva/sea/ql/parser/QL.g:1:76: T__33
                {
                mT__33(); 


                }
                break;
            case 13 :
                // src/main/org/uva/sea/ql/parser/QL.g:1:82: T__34
                {
                mT__34(); 


                }
                break;
            case 14 :
                // src/main/org/uva/sea/ql/parser/QL.g:1:88: T__35
                {
                mT__35(); 


                }
                break;
            case 15 :
                // src/main/org/uva/sea/ql/parser/QL.g:1:94: T__36
                {
                mT__36(); 


                }
                break;
            case 16 :
                // src/main/org/uva/sea/ql/parser/QL.g:1:100: T__37
                {
                mT__37(); 


                }
                break;
            case 17 :
                // src/main/org/uva/sea/ql/parser/QL.g:1:106: T__38
                {
                mT__38(); 


                }
                break;
            case 18 :
                // src/main/org/uva/sea/ql/parser/QL.g:1:112: T__39
                {
                mT__39(); 


                }
                break;
            case 19 :
                // src/main/org/uva/sea/ql/parser/QL.g:1:118: T__40
                {
                mT__40(); 


                }
                break;
            case 20 :
                // src/main/org/uva/sea/ql/parser/QL.g:1:124: T__41
                {
                mT__41(); 


                }
                break;
            case 21 :
                // src/main/org/uva/sea/ql/parser/QL.g:1:130: T__42
                {
                mT__42(); 


                }
                break;
            case 22 :
                // src/main/org/uva/sea/ql/parser/QL.g:1:136: T__43
                {
                mT__43(); 


                }
                break;
            case 23 :
                // src/main/org/uva/sea/ql/parser/QL.g:1:142: T__44
                {
                mT__44(); 


                }
                break;
            case 24 :
                // src/main/org/uva/sea/ql/parser/QL.g:1:148: T__45
                {
                mT__45(); 


                }
                break;
            case 25 :
                // src/main/org/uva/sea/ql/parser/QL.g:1:154: T__46
                {
                mT__46(); 


                }
                break;
            case 26 :
                // src/main/org/uva/sea/ql/parser/QL.g:1:160: StringLiteral
                {
                mStringLiteral(); 


                }
                break;
            case 27 :
                // src/main/org/uva/sea/ql/parser/QL.g:1:174: Boolean
                {
                mBoolean(); 


                }
                break;
            case 28 :
                // src/main/org/uva/sea/ql/parser/QL.g:1:182: Money
                {
                mMoney(); 


                }
                break;
            case 29 :
                // src/main/org/uva/sea/ql/parser/QL.g:1:188: Integer
                {
                mInteger(); 


                }
                break;
            case 30 :
                // src/main/org/uva/sea/ql/parser/QL.g:1:196: Identifier
                {
                mIdentifier(); 


                }
                break;
            case 31 :
                // src/main/org/uva/sea/ql/parser/QL.g:1:207: Whitespace
                {
                mWhitespace(); 


                }
                break;
            case 32 :
                // src/main/org/uva/sea/ql/parser/QL.g:1:218: Comment
                {
                mComment(); 


                }
                break;
            case 33 :
                // src/main/org/uva/sea/ql/parser/QL.g:1:226: MultilineComment
                {
                mMultilineComment(); 


                }
                break;

        }

    }


    protected DFA10 dfa10 = new DFA10(this);
    static final String DFA10_eotS =
        "\1\uffff\1\34\6\uffff\1\37\1\uffff\1\41\1\uffff\1\43\6\31\4\uffff"+
        "\1\31\1\56\13\uffff\4\31\1\63\4\31\2\uffff\4\31\1\uffff\5\31\1\101"+
        "\1\102\4\31\1\107\1\31\2\uffff\1\107\1\31\1\112\1\31\1\uffff\2\31"+
        "\1\uffff\1\116\1\117\1\120\3\uffff";
    static final String DFA10_eofS =
        "\121\uffff";
    static final String DFA10_minS =
        "\1\11\1\75\6\uffff\1\52\1\uffff\1\75\1\uffff\1\75\1\157\1\154\1"+
        "\141\1\146\1\157\1\164\4\uffff\1\162\1\56\13\uffff\1\157\1\163\1"+
        "\162\1\154\1\60\1\164\1\156\1\162\1\165\2\uffff\1\154\1\145\1\155"+
        "\1\163\1\uffff\2\145\1\151\2\145\2\60\1\145\1\147\1\171\1\156\1"+
        "\60\1\141\2\uffff\1\60\1\145\1\60\1\147\1\uffff\1\156\1\162\1\uffff"+
        "\3\60\3\uffff";
    static final String DFA10_maxS =
        "\1\175\1\75\6\uffff\1\57\1\uffff\1\75\1\uffff\1\75\1\157\1\154\1"+
        "\157\1\156\1\157\1\164\4\uffff\1\162\1\71\13\uffff\1\157\1\163\1"+
        "\162\1\154\1\172\1\164\1\156\1\162\1\165\2\uffff\1\154\1\145\1\155"+
        "\1\163\1\uffff\2\145\1\151\2\145\2\172\1\145\1\147\1\171\1\156\1"+
        "\172\1\141\2\uffff\1\172\1\145\1\172\1\147\1\uffff\1\156\1\162\1"+
        "\uffff\3\172\3\uffff";
    static final String DFA10_acceptS =
        "\2\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\uffff\1\12\1\uffff\1\15\7\uffff"+
        "\1\27\1\30\1\31\1\32\2\uffff\1\36\1\37\1\2\1\1\1\40\1\41\1\11\1"+
        "\14\1\13\1\17\1\16\11\uffff\1\34\1\35\4\uffff\1\23\15\uffff\1\21"+
        "\1\22\4\uffff\1\33\2\uffff\1\25\3\uffff\1\26\1\20\1\24";
    static final String DFA10_specialS =
        "\121\uffff}>";
    static final String[] DFA10_transitionS = {
            "\2\32\1\uffff\2\32\22\uffff\1\32\1\1\1\26\3\uffff\1\2\1\uffff"+
            "\1\3\1\4\1\5\1\6\1\uffff\1\7\1\uffff\1\10\12\30\1\11\1\uffff"+
            "\1\12\1\13\1\14\2\uffff\32\31\6\uffff\1\31\1\15\2\31\1\16\1"+
            "\17\2\31\1\20\3\31\1\21\5\31\1\22\1\27\6\31\1\23\1\24\1\25",
            "\1\33",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\36\4\uffff\1\35",
            "",
            "\1\40",
            "",
            "\1\42",
            "\1\44",
            "\1\45",
            "\1\47\15\uffff\1\46",
            "\1\50\7\uffff\1\51",
            "\1\52",
            "\1\53",
            "",
            "",
            "",
            "",
            "\1\54",
            "\1\55\1\uffff\12\30",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\57",
            "\1\60",
            "\1\61",
            "\1\62",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\1\64",
            "\1\65",
            "\1\66",
            "\1\67",
            "",
            "",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73",
            "",
            "\1\74",
            "\1\75",
            "\1\76",
            "\1\77",
            "\1\100",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\1\103",
            "\1\104",
            "\1\105",
            "\1\106",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\1\110",
            "",
            "",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\1\111",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\1\113",
            "",
            "\1\114",
            "\1\115",
            "",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "",
            "",
            ""
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | StringLiteral | Boolean | Money | Integer | Identifier | Whitespace | Comment | MultilineComment );";
        }
    }
 

}