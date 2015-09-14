
package littleLanguage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StreamTokenizer;

public class Lexer {

    public static final int INVALID = -1;
    public static final int NO_TOKENS = 0;
    public static final int NUMBER = 1;
    public static final int EXPRESSION = 3;
    public static final int PLUS = 4;
    public static final int EOL = 6;
    public static final int EOF = 7;
    public static final int EQUALS = 9;
    public static final int MULTIPLY = 10;
    public static final int SUBSTRACT = 5;
    public static final int DIVISION = 11;
    public static String tokenAtual = "";
    public String resultado = "";
    public int token = 0;

    private StreamTokenizer input;

    public Lexer(InputStream in) {
        BufferedReader r = new BufferedReader(new InputStreamReader(in));
        input = new StreamTokenizer(r);
        input.resetSyntax();
        input.eolIsSignificant(true);
        input.wordChars('a', 'z');
        input.wordChars('A', 'Z');
        input.wordChars('0', '9');
       
        input.whitespaceChars('\u0000', '\u0020');
        input.ordinaryChar('+');
        input.ordinaryChar('=');
        input.ordinaryChar('*');
        input.ordinaryChar('-');
    }

    public int nextToken() throws Exception {
        int token = 0;
        try {
            switch (input.nextToken()) {
                case StreamTokenizer.TT_EOF:
                    token = EOF;
                    tokenAtual = "fim de arquivo";
                    break;
                case StreamTokenizer.TT_EOL:
                    tokenAtual = "fim de linha";
                    token = EOL;
                    break;
               case StreamTokenizer.TT_WORD://rever essa parte
                     try {
                        Integer.parseInt(input.sval);
                        tokenAtual = input.sval;

                        token = NUMBER;
                    } catch (NumberFormatException nfe) {
                        char[] array = input.sval.toCharArray();
                        String temp = array[0] + "";
                        try {
                            Integer.parseInt(temp);
                            tokenAtual = input.sval;
                        } catch (NumberFormatException nfe2) {
                            if (array.length == 1 || array[1] == '^') {
                                tokenAtual = input.sval;
                            } else {
                                throw new Exception("Você fez alguma merda.");
                            }
                        }
                        token = EXPRESSION;
                    }

                    break;
                case '+':
                    tokenAtual = "+";
                    token = PLUS;
                    break;
                case '=':
                    tokenAtual = "=";
                    token = EQUALS;
                    break;
                case '*':
                    tokenAtual = "*";
                    token = MULTIPLY;
                    break;
                case '-':
                    tokenAtual = "-";
                    token = SUBSTRACT;
                    break;
                case '/':
                    tokenAtual = "/";
                    token = DIVISION;
                    break;
                case StreamTokenizer.TT_NUMBER:
                    System.err.println("entrou no TT_NUMBER");
                    break;
                default:
                    token = INVALID;
                    throw new Exception("ERRO LEXICO: Cadeia de caracteres invalida.");
            }
        } catch (IOException e) {
            token = EOF;
        }
        return token;
    }

    public static String getTokenAtual() {
        return tokenAtual;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public static void main(String[] args) throws Exception {

        Lexer l = new Lexer(System.in);

        System.out.println(l.nextToken());
        System.out.println("token Atual" + l.getTokenAtual());
        System.out.println(l.nextToken());
        System.out.println(l.nextToken());
        System.out.println("token Atual" + l.getTokenAtual());
         System.out.println(l.nextToken());
        System.out.println("Resultado" + l.getResultado());
        System.out.println(l.nextToken());
        
             
    }

}
