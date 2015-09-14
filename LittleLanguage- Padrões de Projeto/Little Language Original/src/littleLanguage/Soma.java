/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package littleLanguage;

/**
 *
 * @author aluno
 */
public class Soma extends Calculo {
	private int n1;
	private int n2;
        private int n3;

	public Soma(int n1, int n2) {
		this.n1 = n1;
		this.n2 = n2;
                
	}

	@Override
	public String resolver() {
		return "" + (n1 + n2 );
	}

   
    
}
