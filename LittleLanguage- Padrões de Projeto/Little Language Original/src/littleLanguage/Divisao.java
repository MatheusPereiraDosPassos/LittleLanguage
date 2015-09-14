/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package littleLanguage;

/**
 *
 * @author Augusto
 */
public class Divisao extends Calculo {
    private int n1;
    private int n2;

    public Divisao(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    
    @Override
    public String resolver() {
        return ""+ (n1/n2);
    }
}
