package littleLanguage;

import java.io.InputStream;

public class Parser {

    private Lexer lexer = null;
    private String tokenString = "";
    private int token;
    private String temp = "";
    private int aux;
    private boolean flag = false;

    public Parser(InputStream in) {
        this.lexer = new Lexer(in);
    }

    public Calculo parse() throws Exception {
        nextToken();
        Calculo exp = expressao();
        expect(Lexer.EOF, Lexer.EOL);
        return exp;
    }

    private Calculo expressao() throws Exception {
        Calculo exp = null;
        if (token == Lexer.NUMBER) {
            temp = this.tokenString;
            aux = this.token;
            nextToken();
            if (token == Lexer.PLUS) {
                exp = soma(Integer.parseInt(temp));
            } else if (token == Lexer.SUBSTRACT) {
                exp = subtrair(Integer.parseInt(temp));
            } else if (token == Lexer.MULTIPLY) {
                exp = multiplicar(Integer.parseInt(temp));
            } else if (token == Lexer.DIVISION) {
                exp = divisao(Integer.parseInt(temp));
            } 

        }
        return exp;
    }

    private Calculo soma(int n1) throws Exception {

        nextToken();
        
        int n2 = Integer.parseInt(tokenString);
        Calculo exp = new Soma(n1, n2);
        nextToken();
        System.out.println("numero 1=" + n1);
        System.out.println("numero 2=" + n2);
        return exp;
        
    }

    private Calculo subtrair(int n1) throws Exception {

        nextToken();
        
        int n2 = Integer.parseInt(tokenString);
        Calculo exp = new Subtrair(n1, n2);
        nextToken();
        System.out.println("numero 1=" + n1);
        System.out.println("numero 2=" + n2);
        
        

        return exp;
    }

    private Calculo multiplicar(int n1) throws Exception {
        nextToken();
        
        int n2 = Integer.parseInt(tokenString);
        Calculo exp = new Multiplicar(n1, n2);
        nextToken();
        System.out.println("numero 1=" + n1);
        System.out.println("numero 2=" + n2);
        
        

        return exp;
    }

    private Calculo divisao(int n1) throws Exception {
        nextToken();
        
        int n2 = Integer.parseInt(tokenString);
        Calculo exp = new Divisao(n1, n2);
        nextToken();
        System.out.println("numero 1=" + n1);
        System.out.println("numero 2=" + n2);
        
        

        return exp;
    }

    private void nextToken() throws Exception {
        this.token = lexer.nextToken();
        this.tokenString = Lexer.tokenAtual;
        System.out.println("Token atual -> " + this.tokenName(this.token));
    }

    private void expect(Integer... args) throws Exception {
        boolean result = false;
        String msg = "found " + tokenName(this.token) + " when expecting ";
        for (int i = 0; i < args.length; i++) {
            msg += tokenName(args[i]) + " or ";
            if (this.token == args[i]) {
                result = true;
            }
        }
       /* msg = msg.substring(0, msg.length() - 4);
        if (!result) {
            System.err.println("Syntax Error: " + msg);
        }
               */
    }

    private String tokenName(int token2) {
        String token = "";
        switch (token2) {
            case Lexer.EOF:
                token = "FIM DE ARQUIVO";
                break;
            case Lexer.EOL:
                token = "FIM DE LINHA";
                break;
            case Lexer.EXPRESSION:
                token = this.tokenString;
                break;
            case Lexer.NUMBER:
                token = this.tokenString;
                break;
            case Lexer.PLUS:
                token = "MAIS";
                break;
            case Lexer.SUBSTRACT:
                token = "MENOS";
                break;
            case Lexer.MULTIPLY:
                token = "MULTIPLICA";
                break;
            case Lexer.DIVISION:
                token = "DIVIDE";
                break;
            case Lexer.EQUALS:
                token = "IGUAL";
                break;
            default:
                token = "Se não tiver nehuma operação Lexica ";
                break;
        }
        return token;
    }

}
