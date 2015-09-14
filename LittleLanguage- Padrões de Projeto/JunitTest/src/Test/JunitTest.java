package Test;
import org.junit.Test;
import static org.junit.Assert.*;

public class JunitTest {
	public JunitTest(){
		
	}
@Test //@Teste: Esta anotação indica que o código a seguir é um teste.

public void SomaTest(){ //Método criado para teste, foi dado o nome test (indicando que é um teste) e Soma (indicando qual o método está sendo testado)
	 int n1=1;
	 int n2=2;
	int ExpResult = (n1+n2);
	int Result = Calculo.Soma(n1,n2);//Faz uma chamada ao método soma do objeto calculo, passando como parâmetro as variáveis a e b. 
	assertEquals(ExpResult, Result);//O assertEquals compara duas variáveis, neste caso o expResult(Resultado esperado) com a variável result que traz o resultado obtido pelo método soma do objeto calculo.
}

@Test

public void SubtraiTest(){
	 int n1=1;
	 int n2=2;
	int ExpResult = (n1-n2);
	int Result = Calculo.Subtracao(n1,n2);
	assertEquals(ExpResult, Result);
}

@Test

public void DividiTest(){
	 int n1=1;
	 int n2=2;
	int ExpResult = (n1/n2);
	int Result = Calculo.Divisao(n1,n2);
	assertEquals(ExpResult, Result);
}

@Test

public void MultiplicaTest(){
	 int n1=1;
	 int n2=2;
	int ExpResult = (n1*n2);
	int Result = Calculo.Multiplicacao(n1,n2);
	assertEquals(ExpResult, Result);
}

}